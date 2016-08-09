package com.example;

import com.example.Infrastructure.DatabaseLoader;
import com.example.domain.Teammate;
import com.example.repository.TeammateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class DemoApplication {

	@Autowired
	TeammateRepository teammateRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	DatabaseLoader databaseLoader;
	@PostConstruct
	void seeTheRoster() {
		for (Teammate teammate : teammateRepository.findAll()) {
			System.out.println(teammate.toString());
		}
	}
}
