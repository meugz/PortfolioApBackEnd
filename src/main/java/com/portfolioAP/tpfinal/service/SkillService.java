
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.entidades.Skill;
import com.portfolioAP.tpfinal.entidades.SkillType;
import com.portfolioAP.tpfinal.repository.SkillRepository;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {

    @Autowired
    private SkillRepository skillRep;
    private final static Long ID_PERSONA = 1L;
   
    @Override
    public List<Skill> verListaHabilidades() {
        return skillRep.findAll();
    }

    @Override
    public Skill crearHabilidad(Skill habilidad) {
         //esta Persona se va a setear siempre como nueva?
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        habilidad.setPersona(persona1);
        //seteo porcentaje del nivel de habilidad
        habilidad.setPercentNivel(this.nivelarSkill(habilidad.getNivel(), habilidad.getTipo()));
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
    public Skill editarHabilidad(Long id, Skill habilidad) {
        Skill modifSkill = this.buscarHabilidad(id);
        modifSkill.setNombreSkill(habilidad.getNombreSkill());
        modifSkill.setNivel(habilidad.getNivel());
        modifSkill.setPercentNivel(this.nivelarSkill(habilidad.getNivel(), habilidad.getTipo()));       
        modifSkill.setTipo(habilidad.getTipo());
        modifSkill.setDescripcionSkill(habilidad.getDescripcionSkill());
        return skillRep.save(modifSkill);
    }
    
    public Integer nivelarSkill(String nivel, SkillType tipoSkill){
        HashMap<String, Integer> niveles = new HashMap<>();
        
        if(tipoSkill.equals(SkillType.IDIOMAS)){
            niveles.put("A1", 15);
            niveles.put("A2", 30);
            niveles.put("B1", 45);
            niveles.put("B2", 60);
            niveles.put("C1", 75);
            niveles.put("C2", 100);
        }

        if(tipoSkill.equals(SkillType.HARD_SKILL) || tipoSkill.equals(SkillType.SOFT_SKILL)){
            niveles.put("Principiante", 25);
            niveles.put("Intermedio", 50);
            niveles.put("Avanzado", 75);
            niveles.put("Experto", 100);
        }

        Integer porcentaje = niveles.get(nivel);
        
        return porcentaje;
    }
 

    
}
