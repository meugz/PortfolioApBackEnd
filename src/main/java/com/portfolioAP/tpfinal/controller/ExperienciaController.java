package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Educacion;
import com.portfolioAP.tpfinal.entidades.ExperienciaLaboral;
import com.portfolioAP.tpfinal.entidades.Persona;
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
@RequestMapping("/api")
public class ExperienciaController {

    @Autowired
    private ExperienciaService expServ;
    //seteamos con una constante el ID de la Persona a ExperienciaLaboral 
    private final static Long ID_PERSONA = 1L;

    @PostMapping("/experiencia/add")
    public ResponseEntity<ExperienciaLaboral> agregarExperienciaLaboral(@RequestBody ExperienciaLaboral experiencia) {

        //esta Persona se va a setear siempre como nueva?
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        experiencia.setPersona(persona1);
        ExperienciaLaboral trabajos = expServ.crearExperienciaLaboral(experiencia);
        return new ResponseEntity<>(trabajos, HttpStatus.OK);
    }

    @GetMapping("/experiencia/lista")
    @ResponseBody
    public List<ExperienciaLaboral> verListaExperienciaLaboral() {
        return expServ.verListaExperienciaLaboral();
    }

    @GetMapping("/experiencia/ver/{id}")
    @ResponseBody
    public ExperienciaLaboral verExperienciaLaboral(@PathVariable Long id) {
        return expServ.buscarExperienciaLaboral(id);
    }

    @DeleteMapping("/experiencia/delete/{id}")
    public void borrarExperienciaLaboral(@PathVariable Long id) {
        expServ.borrarExperienciaLaboral(id);
    }

    @PutMapping("/experiencia/editar/{idExp}")
    public ResponseEntity<ExperienciaLaboral> editarExperienciaLaboral(@PathVariable Long idExp, @RequestBody ExperienciaLaboral exp) {
        ExperienciaLaboral modifExp = expServ.buscarExperienciaLaboral(idExp);
        modifExp.setNombrePuesto(exp.getNombrePuesto());
        modifExp.setEmpresa(exp.getEmpresa());
        modifExp.setUbicacion(exp.getUbicacion());
        modifExp.setFecha(exp.getFecha());
        modifExp.setDescripcionExp(exp.getDescripcionExp());
        expServ.editarExperienciaLaboral(modifExp);
        return new ResponseEntity<>(modifExp, HttpStatus.OK);
    }

}
