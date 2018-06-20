package com.fidelium.schedule;

import com.fidelium.api.BlockCypherApi;
import com.fidelium.dao.BatchMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017-11-09.
 */

@Component("myBean")
public class ScheduledTasks {

    @Autowired
    private BatchMapper batchMapper;

    @Autowired
    private BlockCypherApi blockCypherApi;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    public void fixedDelay(){
        logger.info("[fixedDelay] The time is now <{}>", dateFormat.format(new Date()));
    }

    public void xmlConfigCron(){
        logger.info("[xmlConfigCron] The time is now <{}>", dateFormat.format(new Date()));
    }

//    @Scheduled(cron = "*/3 * * * * *")
    public void scheduledAnnotationCron(){
        logger.info("[scheduledAnnotationCron] The time is now <{}>", dateFormat.format(new Date()));
    }

//    @Scheduled(cron = "0 0/1 * * * ?")
    public void blockCypherUserTradeConfirm(){
        logger.info("blockCypherUserTradeConfirm!!!");
        batchMapper.selectUserTradeHistoryBatch().forEach(
                x -> blockCypherApi.sendUserTradeConfirm(x)
        );
    }

//    @Scheduled(cron = "0 0/1 * * * ?")
    public void blockCypherTradeConfirm(){
        logger.info("blockCypherTradeConfirm!!!");
        batchMapper.selectTradeHistoryBatch().forEach(
                x -> blockCypherApi.sendTradeConfirm(x)
        );
    }

}
