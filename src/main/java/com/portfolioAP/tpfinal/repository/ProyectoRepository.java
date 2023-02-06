
package com.portfolioAP.tpfinal.repository;

import com.portfolioAP.tpfinal.entidades.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Long> {
    
}
