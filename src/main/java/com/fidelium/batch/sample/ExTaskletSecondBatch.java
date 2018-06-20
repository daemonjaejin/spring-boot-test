package com.fidelium.batch.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017-11-09.
 */

/**
 * 아래 @Component 주석 처리
 * */
//@Component
public class ExTaskletSecondBatch {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    private static final Logger logger = LoggerFactory.getLogger(ExTaskletSecondBatch.class);

    @Bean
    protected Tasklet getTasklet(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                logger.info("<{}>", "#ExtaskletSecondBatch-step-1 Tasklet Batch Job");
                return RepeatStatus.FINISHED;
            }
        };
    }

    @Bean
    public Job secondJob() throws Exception{
        return this.jobs.get("#ExTaskletSecondBatch").start(step1()).build();
    }

    @Bean
    protected Step step1() throws Exception{
        return this.steps.get("#ExTaskletSecondBatch-step1").tasklet(getTasklet()).build();
    }

}
