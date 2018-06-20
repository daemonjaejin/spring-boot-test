package com.fidelium.batch;

import com.fidelium.model.RecordSO;
import com.fidelium.model.WriterSO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Administrator on 2017-11-09.
 */
public class RecordProcessor implements ItemProcessor<RecordSO, WriterSO>{

    private static final Logger logger = LoggerFactory.getLogger(RecordProcessor.class);

    @Override
    public WriterSO process(RecordSO item) throws Exception{
        logger.info("Processing Record : {}", item);
        WriterSO writerSo = new WriterSO();
        writerSo.setId(item.getId());
        writerSo.setFullName(item.getFirstName() + " " + item.getLastName());
        writerSo.setRandomNum(String.valueOf(Math.random()).substring(3, 8));
        logger.info("Processing Writer : {}", writerSo);
        return writerSo;
    }

}
