package com.example.runningApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.runningApp.domain.Run;
import com.example.runningApp.domain.RunRepository;
import com.example.runningApp.domain.User;
import com.example.runningApp.domain.UserRepository;

@SpringBootApplication
public class RunningAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunningAppApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner demo(RunRepository rRepository, UserRepository uRepository) {
		return (args) -> {
			
			uRepository.deleteAll();
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			
			
			uRepository.save(user1);
			uRepository.save(user2);
			
			Run run1 = new Run(5.0, 100, user1);
			Run run2 = new Run(5.1, 101, user1);
			Run run3 = new Run(5.2, 102, user1);
			Run run4 = new Run(5.3, 103, user1);
			Run run5 = new Run(5.4, 104, user1);
			
			Run run6 = new Run(10.0, 200, user2);
			Run run7 = new Run(10.1, 201, user2);
			Run run8 = new Run(10.2, 202, user2);
			Run run9 = new Run(10.3, 203, user2);
			Run run10 = new Run(10.4, 204, user2);
			
			rRepository.save(run1);
			rRepository.save(run2);
			rRepository.save(run3);
			rRepository.save(run4);
			rRepository.save(run5);
			rRepository.save(run6);
			rRepository.save(run7);
			rRepository.save(run8);
			rRepository.save(run9);
			rRepository.save(run10);
			
			
		};
	}

}
