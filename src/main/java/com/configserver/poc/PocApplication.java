package com.configserver.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication

public class PocApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocApplication.class, args);
    }

}
