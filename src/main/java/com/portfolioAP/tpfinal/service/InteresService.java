
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Interes;
import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.repository.InteresRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteresService implements IInteresService {

    @Autowired
    private InteresRepository intRep;
    //seteamos con una constante el ID de la Persona a ExperienciaLaboral 
    private final static Long ID_PERSONA = 1L;
            
    @Override
    public List<Interes> verListaInteres() {
        return intRep.findAll();
    }

    @Override
    public Interes crearInteres(Interes interes) {
        //esta Persona se va a setear siempre como nueva?
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        interes.setPersona(persona1);
        return intRep.save(interes);
    }

    @Override
    public void borrarInteres(Long id) {
        intRep.deleteById(id);
    }

    @Override
    public Interes buscarInteres(Long id) {
        return intRep.findById(id).orElse(null);
    }

    @Override
    public Interes editarInteres(Long id, Interes interes) {
        Interes modifInteres = this.buscarInteres(id);
        modifInteres.setDescripcionInteres(interes.getDescripcionInteres());
        return intRep.save(modifInteres);
    }
    
}
