
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Curso;
import com.portfolioAP.tpfinal.entidades.Educacion;
import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {
    
    @Autowired
    private EducacionRepository educRep;
    //seteamos con una constante el ID de la Persona a Educacion 
    private final static Long ID_PERSONA=1L;

    @Override
    public List<Educacion> verListaEducacion() {
       return educRep.findAll();
    }

    @Override
    public Educacion crearEducacion(Educacion educ) {
        //esta Persona se va a setear siempre como nueva?
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        educ.setPersona(persona1);
        return educRep.save(educ);
    }

    @Override
    public void borrarEducacion(Long id) {
       educRep.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
       return educRep.findById(id).orElse(null);
    }

    @Override
    public Educacion editarEducacion(Long id, Educacion educ) {
        Educacion modifEduc = this.buscarEducacion(id);
        if (educ.getNombreEdu()!= null){
            modifEduc.setNombreEdu(educ.getNombreEdu());
        }
        if (educ.getInstitucionEdu()!= null){
            modifEduc.setInstitucionEdu(educ.getInstitucionEdu());
        }
        if (educ.getPeriodoEdu()!= null){
            modifEduc.setPeriodoEdu(educ.getPeriodoEdu());
        }
        if (educ.getDescripcionEdu()!=null){
            modifEduc.setDescripcionEdu(educ.getDescripcionEdu());
        }
       return educRep.save(modifEduc);
    }

}
