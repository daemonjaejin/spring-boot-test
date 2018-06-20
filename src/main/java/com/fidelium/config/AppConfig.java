package com.fidelium.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Created by jin on 17. 3. 13.
 */

@Configuration
public class AppConfig {

    /*@Autowired
    private DataSourceProperties dataSourceProperties;*/

//    private DataSource dataSource;

    /*@Bean
    DataSource realDataSource(){
        DataSourceBuilder factory = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword());
        this.dataSource = factory.build();
        return this.dataSource;
    }*/

    /*@Bean
    @Primary
    DataSource dataSource(){
        return new Log4jdbcProxyDataSource(this.dataSource);
    }*/

    // 문자 깨지지 않게 서블릿 필터 설정
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    CharacterEncodingFilter characterEncodingFilter(){
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

}
