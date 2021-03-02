package br.com.estudo.oobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication

public class OobankApplication {

	public static void main(String[] args) {
		SpringApplication.run(OobankApplication.class, args);
	}

}
