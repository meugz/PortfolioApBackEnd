
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Interes;
import java.util.List;


public interface IInteresService {
    public List<Interes> verListaInteres();
    public Interes crearInteres(Interes interes);
    public void borrarInteres(Long id);
    public Interes buscarInteres(Long id);
    public Interes  editarInteres(Interes interes);
}
