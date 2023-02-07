
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Skill;
import java.util.List;


public interface ISkillService {
    public List<Skill> verListaHabilidades();
    public Skill crearHabilidad(Skill habilidad);
    public void borrarHabilidad(Long id);
    public Skill buscarHabilidad(Long id);
    public Skill  editarHabilidad(Skill habilidad);
    
}
