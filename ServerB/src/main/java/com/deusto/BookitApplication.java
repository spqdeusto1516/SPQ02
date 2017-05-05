package com.deusto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class BookitApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookitApplication.class, args);
    }
}

