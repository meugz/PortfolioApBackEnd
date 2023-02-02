
package com.portfolioAP.tpfinal.repository;

import com.portfolioAP.tpfinal.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository <Curso, Long> {
    
}
