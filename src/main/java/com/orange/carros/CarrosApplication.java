package com.orange.carros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CarrosApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarrosApplication.class, args);
    }

}
