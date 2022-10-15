package com.example.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DatabaseConfig {
    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Bean
    @Primary
    public DataSource dataSource() {
        log.info("Username: {}", username);
        log.info("Password: {}", password);

        return DataSourceBuilder
                .create()
                .url("jdbc:postgresql://127.0.0.1:5432/postgres")
                .driverClassName("org.postgresql.Driver")
                .username(username)
                .password(password)
                .build();
    }
}
