package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Curso;
import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.service.CursoService;
import com.portfolioAP.tpfinal.service.ICursoService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso) {
        Curso cursos = cursoServ.crearCurso(curso);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Curso> verListaCursos() {
        return cursoServ.verListaCursos();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Curso verCurso(@PathVariable Long id) {
        return cursoServ.buscarCurso(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void borrarCurso(@PathVariable Long id) {
        cursoServ.borrarCurso(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{idCurso}")
    public ResponseEntity<Curso> editarCurso(@PathVariable Long idCurso, @RequestBody Curso curso) {
        Curso modifCurso = cursoServ.editarCurso(idCurso, curso);
        return new ResponseEntity<>(modifCurso, HttpStatus.OK);
    }
}
