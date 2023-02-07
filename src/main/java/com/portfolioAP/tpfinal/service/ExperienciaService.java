
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.ExperienciaLaboral;
import com.portfolioAP.tpfinal.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    private ExperienciaRepository expRep;
    
    @Override
    public List<ExperienciaLaboral> verListaExperienciaLaboral() {
        return expRep.findAll(); 
    }

    @Override
    public ExperienciaLaboral crearExperienciaLaboral(ExperienciaLaboral experiencia) {
       return expRep.save(experiencia);
    }

    @Override
    public void borrarExperienciaLaboral(Long id) {
        expRep.deleteById(id);
    }

    @Override
    public ExperienciaLaboral buscarExperienciaLaboral(Long id) {
       return expRep.findById(id).orElse(null);
    }

    @Override
    public ExperienciaLaboral editarExperienciaLaboral(ExperienciaLaboral experiencia) {
       return expRep.save(experiencia);
    }

   
}
