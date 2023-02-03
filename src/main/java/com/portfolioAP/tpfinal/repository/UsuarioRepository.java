
package com.portfolioAP.tpfinal.repository;

import com.portfolioAP.tpfinal.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
