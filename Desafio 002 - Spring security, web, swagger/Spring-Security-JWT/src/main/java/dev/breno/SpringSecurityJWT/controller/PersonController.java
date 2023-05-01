package dev.breno.SpringSecurityJWT.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.breno.SpringSecurityJWT.model.Person;
import dev.breno.SpringSecurityJWT.repository.PersonRepository;

@RestController
public class PersonController {

	
	private final PersonRepository repositoryPerson;

	public PersonController(PersonRepository repositoryPerson) {
		this.repositoryPerson = repositoryPerson;
	}
	
	
	@GetMapping("persons")
	public List<Person> ConsultAllPerson() {
		return  repositoryPerson.findAll();
	}
	
	@GetMapping("persons/{id}")
	public Optional<Person> consultById(@PathVariable Long id) {
		return repositoryPerson.findById(id);
	}
	
	@GetMapping("/")
	public String helloWorld() {
		return "This is my API Spring Boot ";
	}
	
	
	
}
