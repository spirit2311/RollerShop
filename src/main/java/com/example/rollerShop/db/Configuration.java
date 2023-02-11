package com.example.rollerShop.db;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
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
}
