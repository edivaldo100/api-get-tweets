package com.edivaldo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiApplication implements CommandLineRunner {

	@Autowired
	Config config;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("-------------conexão de banco de dados--------------->>>>>>>>>");
		System.out.println(config.getDb_url());
		System.out.println("---------------------------------------------------->>>>>>>>>>");
	}
}
