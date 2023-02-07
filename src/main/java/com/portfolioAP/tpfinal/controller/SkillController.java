package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.entidades.Skill;
import com.portfolioAP.tpfinal.service.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api")
public class SkillController {
    
    @Autowired
    private SkillService skillServ;
    
    //seteamos con una constante el ID de la Persona a ExperienciaLaboral 
    private final static Long ID_PERSONA = 1L;

    @PostMapping("/skill/add")
    public ResponseEntity<Skill> agregarInteres(@RequestBody Skill habilidad) {

        //esta Persona se va a setear siempre como nueva?
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        habilidad.setPersona(persona1);
        Skill habilidades = skillServ.crearHabilidad(habilidad);
        return new ResponseEntity<>(habilidades, HttpStatus.OK);
    }

    @GetMapping("/skill/lista")
    @ResponseBody
    public List<Skill> verListaHabilidades() {
        return skillServ.verListaHabilidades();
    }

    @GetMapping("/skill/ver/{id}")
    @ResponseBody
    public Skill verHabilidad(@PathVariable Long id) {
        return skillServ.buscarHabilidad(id);
    }

    @DeleteMapping("/skill/delete/{id}")
    public void borrarHabilidad(@PathVariable Long id) {
        skillServ.borrarHabilidad(id);
    }

    @PutMapping("/skill/editar/{idSkill}")
    public ResponseEntity<Skill> editarHabilidad(@PathVariable Long idSkill, @RequestBody Skill habilidad) {
        Skill modifSkill = skillServ.buscarHabilidad(idSkill);
        modifSkill.setNombreSkill(habilidad.getNombreSkill());
        modifSkill.setNivel(habilidad.getNivel());
        modifSkill.setDescripcionSkill(habilidad.getDescripcionSkill());
        skillServ.editarHabilidad(habilidad);
        return new ResponseEntity<>(modifSkill, HttpStatus.OK);
    }

}
