package com.example.enterpriseai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EnterpriseAiAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseAiAssistantApplication.class, args);
	}

}
