
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.entidades.Proyecto;
import com.portfolioAP.tpfinal.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  
public class ProyectoService implements IProyectoService {

    @Autowired
    private ProyectoRepository proyRep;
    //seteamos con una constante el ID de la Persona a ExperienciaLaboral 
    private final static Long ID_PERSONA = 1L;
    
    @Override
    public List<Proyecto> verListaProyectos() {
       return proyRep.findAll();
    }

    @Override
    public Proyecto crearProyecto(Proyecto project) {
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        project.setPersona(persona1);
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
    public Proyecto editarProyecto(Long id, Proyecto project) {
        Proyecto modifProject = this.buscarProyecto(id);
        if (project.getNombreProyecto()!=null){
            modifProject.setNombreProyecto(project.getNombreProyecto());
        }
        if (project.getFecha()!=null){
            modifProject.setFecha(project.getFecha());
        }
        if (project.getDescripcionProyecto()!=null){
            modifProject.setDescripcionProyecto(project.getDescripcionProyecto());
        }
        if (project.getUrl()!=null){
            modifProject.setUrl(project.getUrl());
        }
        return proyRep.save(modifProject);
    }
    

}
