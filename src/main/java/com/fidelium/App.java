package com.fidelium;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by jin on 17. 3. 13.
 */

@ImportResource("classpath:batch-config.xml")
@EnableScheduling
@EnableBatchProcessing
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@Configuration
public class App extends SpringBootServletInitializer implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

    @PostConstruct
    public void onInit(){
        logger.info("<{}>", "onInit");
    }

    @PreDestroy
    public void onDestory(){
        logger.info("<{}>", "onDestory");
    }

    public void run(java.lang.String... strings) throws Exception{

    }

    public static void main(String [] args){
        SpringApplication.run(App.class, args);
    }

}
