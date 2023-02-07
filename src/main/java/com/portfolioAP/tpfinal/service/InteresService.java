
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Interes;
import com.portfolioAP.tpfinal.repository.InteresRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteresService implements IInteresService {

    @Autowired
    private InteresRepository intRep;
            
    @Override
    public List<Interes> verListaInteres() {
        return intRep.findAll();
    }

    @Override
    public Interes crearInteres(Interes interes) {
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
    public Interes editarInteres(Interes interes) {
        return intRep.save(interes);
    }
    
}
