
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.ExperienciaLaboral;
import java.util.List;

public interface IExperienciaService {
    public List<ExperienciaLaboral> verListaExperienciaLaboral();
    public ExperienciaLaboral crearExperienciaLaboral(ExperienciaLaboral experiencia);
    public void borrarExperienciaLaboral(Long id);
    public ExperienciaLaboral buscarExperienciaLaboral(Long id);
    public ExperienciaLaboral editarExperienciaLaboral(ExperienciaLaboral experiencia);
    
}
