package com.arcticfox.algorank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AlgorankApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgorankApplication.class, args);
    }

}
