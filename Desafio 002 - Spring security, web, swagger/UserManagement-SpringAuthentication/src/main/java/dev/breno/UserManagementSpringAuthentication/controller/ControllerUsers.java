package dev.breno.UserManagementSpringAuthentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUsers {

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/users")
	public String findAll() {
		return "lista de Usuarios: ...";
	}
}
