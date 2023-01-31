package com.portfolioAP.tpfinal.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/hola/{nombre}")
	public String decirHola(@PathVariable String nombre) {
		return "Hola mundo " + nombre;
	}
	
	

}
