package com.fidelium.batch;

import com.fidelium.model.RecordSO;
import com.fidelium.model.WriterSO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Administrator on 2017-11-09.
 */

@Configuration
@EnableBatchProcessing
@Component
public class BatchConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(BatchConfiguration.class);

    @Autowired
    private SimpleJobLauncher jobLauncher;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private JobExecutionListener listener;

    @Autowired
    private Step step1;

    @Autowired
    private JobBuilderFactory jobs;


    @Bean
    public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
        SimpleJobLauncher launcher = new SimpleJobLauncher();
        launcher.setJobRepository(jobRepository);
        return launcher;
    }

    @Bean
    public JobRepository jobRepository(
            MapJobRepositoryFactoryBean factory) throws Exception {
        return factory.getObject();
    }

    @Bean
    public ResourcelessTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }

    @Bean
    public MapJobRepositoryFactoryBean mapJobRepositoryFactory(
            ResourcelessTransactionManager txManager) throws Exception {

        MapJobRepositoryFactoryBean factory = new
                MapJobRepositoryFactoryBean(txManager);

        factory.afterPropertiesSet();

        return factory;
    }

    @Bean
    public ItemReader<RecordSO> reader(DataSource dataSource){
        JdbcCursorItemReader<RecordSO> reader = new JdbcCursorItemReader<>();
        reader.setSql("select id, firstName, lastname, random_num from reader");
        reader.setDataSource(dataSource);
        reader.setRowMapper(new RowMapper<RecordSO>() {
            @Override public RecordSO mapRow(ResultSet rs, int rowNum) throws SQLException {
                if(!rs.isAfterLast() && !(rs.isBeforeFirst())){
                    RecordSO recordSO = new RecordSO();
                    recordSO.setFirstName(rs.getString("firstName"));
                    recordSO.setLastName(rs.getString("lastname"));
                    recordSO.setId(rs.getInt("Id"));
                    recordSO.setRandomNum(rs.getString("random_num"));
                    logger.info("RowMapper record : {}", recordSO.toString());
                    return recordSO;
                }else{
                    logger.info("Returning null from rowMapper");
                    return null;
                }
            }
        });
        return reader;
    }

    @Bean
    public ItemProcessor<RecordSO, WriterSO> processor(){
        return new RecordProcessor();
    }

    @Bean
    public ItemWriter<WriterSO> writer(DataSource dataSource, ItemPreparedStatementSetter<WriterSO> setter){
        JdbcBatchItemWriter<WriterSO> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setItemPreparedStatementSetter(setter);
        writer.setSql("insert into writer (id, full_name, random_num) values (?, ?, ?)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public ItemPreparedStatementSetter<WriterSO> setter(){
        return new ItemPreparedStatementSetter<WriterSO>() {
            @Override public void setValues(WriterSO item, PreparedStatement ps) throws SQLException {
                ps.setLong(1, item.getId());
                ps.setString(2, item.getFullName());
                ps.setString(3, item.getRandomNum());
            }
        };
    }

    @Bean
    public Job job(JobBuilderFactory jobs, Step s1, JobExecutionListener listener){
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<RecordSO> reader,
            ItemWriter<WriterSO> writer, ItemProcessor<RecordSO, WriterSO> processor){
        return stepBuilderFactory.get("step1")
                .<RecordSO, WriterSO>chunk(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    /**
     * batch scheduled
     * */
//    @Scheduled(cron = "*/3 * * * * *")
    public void perform() throws Exception{

        System.out.println("Job Started at : " + new Date());

        JobParameters param = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters();

        JobExecution execution = jobLauncher.run(job(jobs, step1, listener), param);

        System.out.println("Job finished with status :" + execution.getStatus());
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
