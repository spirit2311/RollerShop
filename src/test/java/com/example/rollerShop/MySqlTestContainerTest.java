package com.example.rollerShop;

import org.junit.ClassRule;
import org.testcontainers.containers.MySQLContainer;

public class MySqlTestContainerTest {

    @ClassRule
    public static MySQLContainer<?> sqlContainer = new MySQLContainer<>("mysql:1.17.5");


}
