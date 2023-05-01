package dev.breno.SpringSecurityJWT;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.breno.SpringSecurityJWT.model.Person;
import dev.breno.SpringSecurityJWT.repository.PersonRepository;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(PersonRepository repository) {
		return args -> {
			repository.save(new Person("Joao", "Silva"));
			repository.save(new Person("Juliana","Macaras"));
		};
	};
}
