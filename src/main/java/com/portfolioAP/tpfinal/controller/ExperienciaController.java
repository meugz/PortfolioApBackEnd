package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.ExperienciaLaboral;
import com.portfolioAP.tpfinal.service.ExperienciaService;
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
@RequestMapping("/api/experiencia")
public class ExperienciaController {

    @Autowired
    private ExperienciaService expServ;

    @PostMapping("/add")
    public ResponseEntity<ExperienciaLaboral> agregarExperienciaLaboral(@RequestBody ExperienciaLaboral experiencia) {
        ExperienciaLaboral trabajo = expServ.crearExperienciaLaboral(experiencia);
        return new ResponseEntity<>(trabajo, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<ExperienciaLaboral> verListaExperienciaLaboral() {
        return expServ.verListaExperienciaLaboral();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ExperienciaLaboral verExperienciaLaboral(@PathVariable Long id) {
        return expServ.buscarExperienciaLaboral(id);
    }

    @DeleteMapping("/{id}")
    public void borrarExperienciaLaboral(@PathVariable Long id) {
        expServ.borrarExperienciaLaboral(id);
    }

    @PutMapping("/{idExp}")
    public ResponseEntity<ExperienciaLaboral> editarExperienciaLaboral(@PathVariable Long idExp, @RequestBody ExperienciaLaboral exp) {
        ExperienciaLaboral modifExp = expServ.editarExperienciaLaboral(idExp, exp);
        return new ResponseEntity<>(modifExp, HttpStatus.OK);
    }

}
