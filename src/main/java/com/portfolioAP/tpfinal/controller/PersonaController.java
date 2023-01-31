package com.portfolioAP.tpfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.service.IPersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	private IPersonaService perServ;
	
	@PostMapping("/new/persona")
	public void agregarPersona(@RequestBody Persona per) {
		perServ.crearPersona(per);
	}
	
	@GetMapping("/ver/personas")
	@ResponseBody
	public List<Persona> verListaPersonas(){
		return perServ.verPersonas();
	}
	
	@GetMapping("/ver/persona/{id}")
	@ResponseBody
	public Persona verPersona(@PathVariable Long id){
	    return perServ.buscarPersona(id);
	}
	
	@PostMapping("/editar/persona")
	public void editarPersona(@RequestBody Persona per){
	    perServ.editarPersona(per);
	}

	@DeleteMapping ("/delete/persona/{id}")
	public void borrarPersona(@PathVariable Long id){
	    perServ.borrarPersona(id);
	}

}
