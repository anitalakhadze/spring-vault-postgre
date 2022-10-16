package com.example.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@EnableScheduling
@SpringBootApplication
@RequiredArgsConstructor
public class CustomerApplication {
	private final TestRepository testRepository;

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

//	@PostConstruct
//	public void post() {
//		List<Test> all = testRepository.findAll();
//		all.forEach(System.out::println);
//	}

	@Scheduled(fixedDelay = 30000)
	public void checkVaultCredentials() {
		String username = env.getProperty("spring.datasource.username");
		String password = env.getProperty("spring.datasource.password");
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Tbilisi"));
		System.out.println(now + " ---> username: " + username + ", password: " + password);

		List<Test> all = testRepository.findAll();
		all.forEach(System.out::println);
	}
}
