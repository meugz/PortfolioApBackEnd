
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Proyecto;
import java.util.List;


public interface IProyectoService {
    public List<Proyecto> verListaProyectos();
    public Proyecto crearProyecto(Proyecto project);
    public void borrarProyecto(Long id);
    public Proyecto buscarProyecto(Long id);
    public Proyecto  editarProyecto(Proyecto project);
}
