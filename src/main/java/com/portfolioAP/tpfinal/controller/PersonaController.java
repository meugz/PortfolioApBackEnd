package com.portfolioAP.tpfinal.controller;

import java.io.IOException;
import java.util.List;

import com.portfolioAP.tpfinal.dto.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.service.PersonaService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService perServ;

    @PreAuthorize("hasRole('ADMIN')")
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

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Persona editarPersona(@PathVariable Long id, @RequestBody Persona per) {
        return perServ.editarPersona(id, per);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable Long id) {
        perServ.borrarPersona(id);
   }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/img/perfil/{id}")
    @ResponseBody
    public Persona editarFoto(@PathVariable Long id, @RequestBody ImageDTO nombreImg ){
        return this.perServ.editarFoto(id, nombreImg);
    }

}
