
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Skill;
import com.portfolioAP.tpfinal.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {

    @Autowired
    private SkillRepository skillRep;
   
    @Override
    public List<Skill> verListaHabilidades() {
        return skillRep.findAll();
    }

    @Override
    public Skill crearHabilidad(Skill habilidad) {
        return skillRep.save(habilidad);
    }

    @Override
    public void borrarHabilidad(Long id) {
        skillRep.deleteById(id);
    }

    @Override
    public Skill buscarHabilidad(Long id) {
        return skillRep.findById(id).orElse(null);
    }

    @Override
    public Skill editarHabilidad(Skill habilidad) {
        return skillRep.save(habilidad);
    }
    
    
}
