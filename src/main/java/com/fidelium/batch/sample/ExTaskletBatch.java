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
 * Created by Administrator on 2017-11-08.
 */

/**
 * 아래 @Component 주석 처리
 * */
//@Component
public class ExTaskletBatch {

    private static final Logger logger = LoggerFactory.getLogger(ExTaskletBatch.class);

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    protected Tasklet firstTasklet(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext context) throws Exception {
                logger.info("<{}>", "#ExtaskletBatch-step1 Tasklet Batch Job");
                return RepeatStatus.FINISHED;
            }
        };
    }

    @Bean
    protected Tasklet secondTasklet(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext context) throws Exception {
                logger.info("<{}>", "#ExtaskletBatch-step2 Tasklet Batch Job");
                return RepeatStatus.FINISHED;
            }
        };
    }

    @Bean
    public Job firstJob() throws Exception{
        return this.jobs.get("#ExTaskletBatch").start(step1()).next(step2()).build();
    }

    @Bean
    protected Step step1() throws Exception{
        return this.steps.get("#ExTaskletBatch-step1").tasklet(firstTasklet()).build();
    }

    @Bean
    protected Step step2() throws Exception{
        return this.steps.get("ExTaskletBatch-step2").tasklet(secondTasklet()).build();
    }

}
