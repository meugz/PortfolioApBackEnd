
package com.portfolioAP.tpfinal.seguridad.repository;

import com.portfolioAP.tpfinal.seguridad.entity.Rol;
import com.portfolioAP.tpfinal.seguridad.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RolRepository extends JpaRepository<Rol, Long> {
     Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
