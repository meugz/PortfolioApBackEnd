
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Educacion;
import java.util.List;


public interface IEducacionService {
    public List<Educacion> verListaEducacion();
    public Educacion crearEducacion(Educacion educ);
    public void borrarEducacion(Long id);
    public Educacion buscarEducacion(Long id);
    public Educacion editarEducacion(Long id, Educacion educ);
    
}
