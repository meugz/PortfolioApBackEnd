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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
	private IPersonaService perServ;
	
	@PostMapping("/new/persona")
	public ResponseEntity<Persona> agregarPersona(@RequestBody Persona per) {
            Persona person = perServ.crearPersona(per);
            return new ResponseEntity<>(person, HttpStatus.CREATED);
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
	public Persona editarPersona(@RequestBody Persona per){
            return perServ.editarPersona(per);
	}

	@DeleteMapping ("/delete/persona/{id}")
	public void borrarPersona(@PathVariable Long id){
	    perServ.borrarPersona(id);
	}

}
