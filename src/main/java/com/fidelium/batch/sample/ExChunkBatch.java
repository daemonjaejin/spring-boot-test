package com.fidelium.batch.sample;

import com.fidelium.repository.StringDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2017-11-08.
 */

/**
 * 아래 @Component 주석 처리
 * */
//@Component
public class ExChunkBatch {

    private static final Logger logger = LoggerFactory.getLogger(ExChunkBatch.class);

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    @Qualifier("alphabetRepository")
    private StringDB alphabetRepository;

    @Bean
    public Job getChunkBatchJob() throws Exception{
        return this.jobs.get("#ExChunkBatch").start(step1()).build();
    }

    @Bean
    public Step step1() throws Exception{
        CustomItemReader cr = new CustomItemReader();
        cr.setList(alphabetRepository);
        CustomItemProcessor processor = new CustomItemProcessor();
        CustomItemWriter writer = new CustomItemWriter();

        return this.steps.get("#ExChunkBatch-step1").<String, String>chunk(3)
                .reader(cr)
                .processor(processor)
                .writer(writer)
                .build();
    }

    public class CustomItemReader implements ItemReader<String>{

        private List<String> alphabetRepository;
        private int fetchCount = 0;

        @Override
        public String read() throws Exception, UnexpectedInputException, ParseException{
            if(fetchCount < this.alphabetRepository.size()){
                return this.alphabetRepository.get(fetchCount++);
            }else{
                return null;
            }
        }
        public void setList(List<String> _alphabetRepository){
            this.alphabetRepository = _alphabetRepository;
        }
    }

    public class CustomItemWriter implements ItemWriter<String>{
        @Override
        public void write(List<? extends String> _alphabet) throws Exception{
            for (String s : _alphabet){
                logger.info("<{}>", s);
            }
        }
    }

    public class CustomItemProcessor implements ItemProcessor<String, String>{
        @Override
        public String process(String _alphabet) throws Exception{
            // 소문자를 대문자로 변환시키는 심플한 배치 작업
            return _alphabet.toUpperCase();
        }
    }


}



