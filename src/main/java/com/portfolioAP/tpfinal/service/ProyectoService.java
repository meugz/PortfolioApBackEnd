
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Proyecto;
import com.portfolioAP.tpfinal.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  
public class ProyectoService implements IProyectoService {

    @Autowired
    private ProyectoRepository proyRep;
    
    @Override
    public List<Proyecto> verListaProyectos() {
       return proyRep.findAll();
    }

    @Override
    public Proyecto crearProyecto(Proyecto project) {
        return proyRep.save(project);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyRep.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proyRep.findById(id).orElse(null);
    }

    @Override
    public Proyecto editarProyecto(Proyecto project) {
        return proyRep.save(project);
    }
    

}
