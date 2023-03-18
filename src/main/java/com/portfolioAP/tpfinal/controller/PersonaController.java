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
import com.portfolioAP.tpfinal.service.PersonaService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService perServ;

    @PostMapping("/new")
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona per) {
        Persona person = perServ.crearPersona(per);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Persona> verListaPersonas() {
        return perServ.verPersonas();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Persona verPersona(@PathVariable Long id) {
        return perServ.buscarPersona(id);
    }

    @PutMapping("/{id}")
    public Persona editarPersona(@PathVariable Long id, @RequestBody Persona per) {
        return perServ.editarPersona(id, per);
    }

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable Long id) {
        perServ.borrarPersona(id);
   }
   
}
