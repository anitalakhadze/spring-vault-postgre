package com.example.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CustomerApplication {
	private final TestRepository testRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@PostConstruct
	public void post() {
		List<Test> all = testRepository.findAll();
		all.forEach(System.out::println);
	}
}
