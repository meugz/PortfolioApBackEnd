package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Proyecto;
import com.portfolioAP.tpfinal.service.ProyectoService;
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
@RequestMapping("/api/proyecto")
public class ProyectoController {
    
    @Autowired
    private ProyectoService proServ;

    @PostMapping("/add")
    public ResponseEntity<Proyecto> agregarProyecto(@RequestBody Proyecto project) {
        Proyecto proyecto = proServ.crearProyecto(project);
        return new ResponseEntity<>(proyecto, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Proyecto> verListaProyectos() {
        return proServ.verListaProyectos();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Proyecto verProyecto(@PathVariable Long id) {
        return proServ.buscarProyecto(id);
    }

    @DeleteMapping("/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        proServ.borrarProyecto(id);
    }

    @PutMapping("/{idProject}")
    public ResponseEntity<Proyecto> editarProyecto(@PathVariable Long idProject, @RequestBody Proyecto project) {
        Proyecto modifProject = proServ.editarProyecto(idProject, project);
        return new ResponseEntity<>(modifProject, HttpStatus.OK);
    }

}
