
package com.portfolioAP.tpfinal.repository;

import com.portfolioAP.tpfinal.entidades.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<ExperienciaLaboral, Long> {
    
}
