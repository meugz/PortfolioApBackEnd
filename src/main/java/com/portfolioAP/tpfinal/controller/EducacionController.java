package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Educacion;
import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.service.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EducacionController {
    
    @Autowired
    private EducacionService educServ;
    //seteamos con una constante el ID de la Persona a Educacion 
    private final static Long ID_PERSONA=1L;
    
    @PostMapping("/add/educacion")
    public ResponseEntity<Educacion> agregarEducacion(@RequestBody Educacion educacion){
        
        //esta Persona se va a setear siempre como nueva?
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        educacion.setPersona(persona1);
        Educacion titulos = educServ.crearEducacion(educacion);
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
    
    

}
