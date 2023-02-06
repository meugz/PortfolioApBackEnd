
package com.portfolioAP.tpfinal.repository;

import com.portfolioAP.tpfinal.entidades.Interes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresRepository extends JpaRepository<Interes, Long>{
    
}
