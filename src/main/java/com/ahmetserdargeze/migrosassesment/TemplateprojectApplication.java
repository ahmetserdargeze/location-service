package com.ahmetserdargeze.migrosassesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class TemplateprojectApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        SpringApplication.run(TemplateprojectApplication.class, args);
    }

}
