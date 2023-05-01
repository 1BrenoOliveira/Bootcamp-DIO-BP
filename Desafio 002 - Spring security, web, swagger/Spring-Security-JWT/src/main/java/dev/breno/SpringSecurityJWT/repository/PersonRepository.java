package dev.breno.SpringSecurityJWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.breno.SpringSecurityJWT.model.Person;

public interface PersonRepository  extends JpaRepository<Person, Long>{

}
