package com.deusto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*!
 * Running class of the server application.
 */
@SpringBootApplication
//TODO this disable basic-error-controller
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class BookitApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookitApplication.class, args);
    }
}