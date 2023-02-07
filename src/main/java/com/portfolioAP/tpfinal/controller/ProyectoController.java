package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.entidades.Proyecto;
import com.portfolioAP.tpfinal.service.ProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private ProyectoService proServ;
    
     //seteamos con una constante el ID de la Persona a ExperienciaLaboral 
    private final static Long ID_PERSONA = 1L;

    @PostMapping("/proyecto/add")
    public ResponseEntity<Proyecto> agregarProyecto(@RequestBody Proyecto project) {
        //esta Persona se va a setear siempre como nueva?
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        project.setPersona(persona1);
        Proyecto proyectos = proServ.crearProyecto(project);
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }

    @GetMapping("/proyecto/lista")
    @ResponseBody
    public List<Proyecto> verListaProyectos() {
        return proServ.verListaProyectos();
    }

    @GetMapping("/proyecto/ver/{id}")
    @ResponseBody
    public Proyecto verProyecto(@PathVariable Long id) {
        return proServ.buscarProyecto(id);
    }

    @DeleteMapping("/proyecto/delete/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        proServ.borrarProyecto(id);
    }

    @PutMapping("/proyecto/editar/{idProject}")
    public ResponseEntity<Proyecto> editarProyecto(@PathVariable Long idProject, @RequestBody Proyecto project) {
        Proyecto modifProject = proServ.buscarProyecto(idProject);
        modifProject.setNombreProyecto(project.getNombreProyecto());
        modifProject.setFecha(project.getFecha());
        modifProject.setDescripcionProyecto(project.getDescripcionProyecto());
        modifProject.setUrl(project.getUrl());
        proServ.editarProyecto(modifProject);
        return new ResponseEntity<>(modifProject, HttpStatus.OK);
    }

}
