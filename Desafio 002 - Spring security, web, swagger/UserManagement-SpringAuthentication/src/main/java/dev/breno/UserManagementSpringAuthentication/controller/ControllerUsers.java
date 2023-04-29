package dev.breno.UserManagementSpringAuthentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerUsers {

	@GetMapping("/users")
	public String principal() {
		return "lista de Usuarios: ...\n USERS autorizado!";
	}
	
	@GetMapping("/manager")
	public String main() {
		return "lista de Usuarios: ...\n MANAGERS autorizado!";
	}
}
