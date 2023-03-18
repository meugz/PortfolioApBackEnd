package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Educacion;
import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.service.EducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/educacion")
public class EducacionController {
    
    @Autowired
    private EducacionService educServ;
     
    @PostMapping("/add")
    public ResponseEntity<Educacion> agregarEducacion(@RequestBody Educacion educacion){
        Educacion titulo = educServ.crearEducacion(educacion);
        return new ResponseEntity<>(titulo, HttpStatus.OK);
    }
    
    @GetMapping("/all")
    @ResponseBody
    public List<Educacion> verListaEducacion() {
        return educServ.verListaEducacion();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Educacion verEducacion(@PathVariable Long id) {
        return educServ.buscarEducacion(id);
    }

    @DeleteMapping("/{id}")
    public void borrarCurso(@PathVariable Long id) {
        educServ.borrarEducacion(id);
    }

    @PutMapping("/{idEduc}")
    public ResponseEntity<Educacion> editarEducacion(@PathVariable Long idEduc, @RequestBody Educacion educ) {
        Educacion modifEduc = educServ.editarEducacion(idEduc, educ);
        return new ResponseEntity<>(modifEduc, HttpStatus.OK);
    }
    

}
