package com.example.springhellolog4j.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@RestController
public class HelloWorldController {

    private static final String LOG_FILE = "src/main/resources/log4j.properties";
     Logger logger = Logger.getLogger(HelloWorldController.class);
     Properties properties = new Properties();

    @GetMapping("/hello")
    public String sendGreetings() throws IOException {

        properties.load(new FileInputStream(LOG_FILE));
        PropertyConfigurator.configure(properties);

        logger.info("This is a sample Spring Boot Hello World Application");
        logger.info("A cron job is scheduled to rotate log files regularly");
        return "Hello, World!";
    }
}
