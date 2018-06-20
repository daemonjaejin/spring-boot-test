package com.fidelium.batch.sample;

import com.fidelium.repository.StringDB;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017-11-09.
 */

/**
 * 아래 @Component 주석 처리
 * */
//@Configuration
public class MyConfig {

    @Bean(name = "alphabetRepository", autowire = Autowire.BY_NAME)
    public StringDB getAlphabetRepository(){


        StringDB s = new StringDB();

        s.add("aaa");
        s.add("bbb");
        s.add("ccc");
        s.add("ddd");
        s.add("eee");

        return s;
    }

}
