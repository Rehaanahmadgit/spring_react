package com.example.cruid_ract;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CruidRactApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruidRactApplication.class, args);
    }


    @Bean
    public PlatformTransactionManager commandLineRunner(MongodatabaseFactory dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
