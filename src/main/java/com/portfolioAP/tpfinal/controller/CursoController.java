package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Curso;
import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.service.ICursoService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api")
public class CursoController {

    @Autowired
    private ICursoService cursoServ;
    private final static Long ID_PERSONA = 1L;

    @PostMapping("/curso/add")
    public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso) {
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        curso.setPersona(persona1);
        Curso cursos = cursoServ.crearCurso(curso);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @GetMapping("/cursos/ver")
    @ResponseBody
    public List<Curso> verListaCursos() {
        return cursoServ.verListaCursos();
    }

    @GetMapping("/curso/ver/{id}")
    @ResponseBody
    public Curso verCurso(@PathVariable Long id) {
        return cursoServ.buscarCurso(id);
    }

    @DeleteMapping("/curso/delete/{id}")
    public void borrarCurso(@PathVariable Long id) {
        cursoServ.borrarCurso(id);
    }

    @PutMapping("/curso/editar/{idCurso}")
    public ResponseEntity<Curso> editarCurso(@PathVariable Long idCurso, @RequestBody Curso curso) {
        Curso modifCurso = cursoServ.buscarCurso(idCurso);
        modifCurso.setNombre(curso.getNombre());
        modifCurso.setInstitucion(curso.getInstitucion());
        modifCurso.setPeriodo(curso.getPeriodo());
        modifCurso.setDescripcion(curso.getDescripcion());
        cursoServ.editarCurso(modifCurso);
        return new ResponseEntity<>(modifCurso, HttpStatus.OK);
    }

    /*@PutMapping("/curso/editar/{idCurso}")
    public ResponseEntity<Curso> editarCurso(@PathVariable Long idCurso,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("institucion") String nuevaInstitucion,
            @RequestParam("periodo") String nuevoPeriodo,
            @RequestParam("descripcion") String nuevaDescripcion) {
        Curso modifCurso = cursoServ.buscarCurso(idCurso);
        modifCurso.setNombre(nuevoNombre);
        modifCurso.setInstitucion(nuevaInstitucion);
        modifCurso.setPeriodo(nuevoPeriodo);
        modifCurso.setDescripcion(nuevaDescripcion);
        cursoServ.editarCurso(modifCurso);

        return new ResponseEntity<>(modifCurso, HttpStatus.OK);
    }*/
}
