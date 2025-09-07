package io.github.lucasfrancobn.soap_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SoapApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapApiApplication.class, args);
	}

}
