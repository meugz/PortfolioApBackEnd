package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Curso;
import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CursoController {
    
    @Autowired
    private ICursoService cursoServ;
    private final static Long ID_PERSONA=1L;
    
    @PostMapping("/add/curso")
    public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso){
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        curso.setPersona(persona1);
        Curso cursos = cursoServ.crearCurso(curso);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }
        
}
