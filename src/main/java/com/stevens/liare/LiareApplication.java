package com.stevens.liare;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.stevens.liare.repository",
		"com.stevens.liare.repository.impl",
		"com.stevens.liare.security.repository.impl"
})
public class LiareApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LiareApplication.class, args);
	}

}