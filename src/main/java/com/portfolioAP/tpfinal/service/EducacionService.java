
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Educacion;
import com.portfolioAP.tpfinal.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {
    
    @Autowired
    private EducacionRepository educServ;

    @Override
    public List<Educacion> verListaEducacion() {
       return educServ.findAll();
    }

    @Override
    public Educacion crearEducacion(Educacion educ) {
        return educServ.save(educ);
    }

    @Override
    public void borrarEducacion(Long id) {
       educServ.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
       return educServ.findById(id).orElse(null);
    }

    @Override
    public Educacion editarEducacion(Educacion educ) {
       return educServ.save(educ);
    } 
}
