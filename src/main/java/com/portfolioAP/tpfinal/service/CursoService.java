
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Curso;
import com.portfolioAP.tpfinal.repository.CursoRepository;
import java.util.List;
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
       return cursoRep.findById(id).orElse(null);
    }

    @Override
    public void editarCurso(Curso curso) {
        cursoRep.save(curso);
    }
    
}