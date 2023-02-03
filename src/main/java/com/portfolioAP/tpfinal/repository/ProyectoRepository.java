
package com.portfolioAP.tpfinal.repository;

import com.portfolioAP.tpfinal.entidades.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProyectoRepository extends JpaRepository <Proyecto, Long> {
    
}
