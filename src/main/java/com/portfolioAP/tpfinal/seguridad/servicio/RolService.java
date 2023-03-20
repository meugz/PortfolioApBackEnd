
package com.portfolioAP.tpfinal.seguridad.servicio;

import com.portfolioAP.tpfinal.seguridad.entity.Rol;
import com.portfolioAP.tpfinal.seguridad.enums.RolNombre;
import com.portfolioAP.tpfinal.seguridad.repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){

        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){

        rolRepository.save(rol);
    }
}
