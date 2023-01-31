package com.portfolioAP.tpfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portfolioAP.tpfinal.entidades.Persona;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long>{

}
