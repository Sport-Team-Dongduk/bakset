package com.mysite.basketproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BasketprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasketprojectApplication.class, args);
    }

}
