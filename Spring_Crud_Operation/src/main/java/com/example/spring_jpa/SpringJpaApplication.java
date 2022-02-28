package com.example.spring_jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
//	@Bean
//	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
//		return args -> {
//			Student shakib = new Student(
//					 "Shovon", 23
//			);
//			studentRepository.save(shakib);
//		};
//	}
}