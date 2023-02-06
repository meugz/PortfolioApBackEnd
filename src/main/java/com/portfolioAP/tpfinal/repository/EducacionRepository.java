
package com.portfolioAP.tpfinal.repository;

import com.portfolioAP.tpfinal.entidades.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long>{
    
}
