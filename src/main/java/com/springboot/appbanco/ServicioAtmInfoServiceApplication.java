package com.springboot.appbanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class ServicioAtmInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioAtmInfoServiceApplication.class, args);
	}

}
