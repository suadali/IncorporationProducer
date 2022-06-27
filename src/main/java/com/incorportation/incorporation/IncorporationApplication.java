package com.incorportation.incorporation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class IncorporationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncorporationApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(StudentRepository repository) {
//		return args -> {
//			Student suad = new Student("Suad", "Ali", "Suadali97@hotmail.com", 12);
//			Student alex = new Student("alex", "Alex", "Alexxa", 14);
//			repository.saveAll(List.of(suad, alex));
//		};
//
//	}

}
