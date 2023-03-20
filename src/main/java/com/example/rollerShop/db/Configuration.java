package com.example.rollerShop.db;

import com.example.rollerShop.db.interceptors.LogRequestBodyInterceptor;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public FlywayMigrationStrategy cleanMigrationStrategy() {

        return flyway -> {
            flyway.repair();
            flyway.migrate();
        };
    }

    @Bean
    public FilterRegistrationBean<LogRequestBodyInterceptor> loggingFilter() {
        FilterRegistrationBean<LogRequestBodyInterceptor> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new LogRequestBodyInterceptor());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
