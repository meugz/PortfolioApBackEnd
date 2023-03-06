
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Curso;
import com.portfolioAP.tpfinal.exceptions.NotFoundException;
import com.portfolioAP.tpfinal.repository.CursoRepository;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private CursoRepository cursoRep;
    
    @Override
    public List<Curso> verListaCursos() {
        return cursoRep.findAll();  
    }

    @Override
    public Curso crearCurso(Curso curso) {
        return cursoRep.save(curso);
    }

    @Override
    public void borrarCurso(Long id) {
        cursoRep.deleteById(id);
    }

    @Override
    public Curso buscarCurso(Long id) {
       return cursoRep.findById(id).orElseThrow(()-> new NotFoundException("El id no existe, Gonza sabe y te dice que pusiste mal el id"));
    }

    @Override
    public Curso editarCurso(Curso curso) {
        return cursoRep.save(curso);
    }
     
}
