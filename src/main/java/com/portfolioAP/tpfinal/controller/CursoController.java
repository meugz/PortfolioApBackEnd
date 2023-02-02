package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Curso;
import com.portfolioAP.tpfinal.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CursoController {
    
    @Autowired
    private ICursoService cursoServ;
    
    /*@PostMapping("/add/curso")
   private ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso){
        Curso curso = cursoServ. 
        return 
    }*/
        
}
