package com.fidelium.batch;

import com.fidelium.dao.BatchMapper;
import com.fidelium.model.WriterSO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017-11-09.
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger logger = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    @Autowired
    private BatchMapper batchMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution){
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            logger.info("!!!! JOB FINISHED! Time to Verify the results");

//            List<WriterSO> results = batchMapper.selectWriterList();

            List<WriterSO> results = jdbcTemplate.query("SELECT id, full_name, random_num FROM writer", (rs, row) -> {
                WriterSO writerSO = new WriterSO();
                writerSO.setId(rs.getLong("id"));
                writerSO.setFullName(rs.getString("full_name"));
                writerSO.setRandomNum(rs.getString("random_num"));
                return writerSO;
            });

            for (WriterSO writerSo: results){
                logger.info("writerSo : <{}>", writerSo.toString());
            }

        }
    }

}
