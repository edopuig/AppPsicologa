package com.appweb.psicologa.psicologa.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import com.zaxxer.hikari.*;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private Environment env;

    private String dbUrl = "jdbc:mysql://k5n8rw65ylm4rq8n:sui76j2oa7bbh7o7@j5zntocs2dn6c3fj.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/ceifkuuc035429t8";

    @Bean
    public DataSource getDatasource(){
        
        /*TEST
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUsername(env.getProperty("spring.datasource.name"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        return dataSource;*/

         
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }
    
}
