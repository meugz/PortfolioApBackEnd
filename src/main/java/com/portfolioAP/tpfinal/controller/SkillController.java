package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.entidades.Skill;
import com.portfolioAP.tpfinal.service.SkillService;
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
@RequestMapping("/api/skill")
public class SkillController {
    
    @Autowired
    private SkillService skillServ;
    
    //seteamos con una constante el ID de la Persona a ExperienciaLaboral 
    

    @PostMapping("/add")
    public ResponseEntity<Skill> agregarHabilidad(@RequestBody Skill habilidad) {
        Skill nuevaHabilidad = skillServ.crearHabilidad(habilidad);
        return new ResponseEntity<>(nuevaHabilidad, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Skill> verListaHabilidades() {
        return skillServ.verListaHabilidades();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Skill verHabilidad(@PathVariable Long id) {
        return skillServ.buscarHabilidad(id);
    }

    @DeleteMapping("/{id}")
    public void borrarHabilidad(@PathVariable Long id) {
        skillServ.borrarHabilidad(id);
    }

    @PutMapping("/{idSkill}")
    public ResponseEntity<Skill> editarHabilidad(@PathVariable Long idSkill, @RequestBody Skill nuevaHabilidad) {    
        Skill modifSkill = skillServ.editarHabilidad(idSkill, nuevaHabilidad);
        return new ResponseEntity<>(modifSkill, HttpStatus.OK);
    }
    
   

}
