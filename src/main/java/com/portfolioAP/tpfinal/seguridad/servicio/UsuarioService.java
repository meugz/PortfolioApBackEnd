package com.portfolioAP.tpfinal.seguridad.servicio;

import com.portfolioAP.tpfinal.seguridad.entity.User;
import com.portfolioAP.tpfinal.seguridad.repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository userRepository;

    public Optional<User> getByNombreUsuario(String nombreUsuario) {
        return userRepository.findByNombreUsuario(nombreUsuario);
    }
    
     public boolean existsByNombreUsuario(String nombreUsuario){
        return userRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public User save(User usuario){
        return userRepository.save(usuario);
    }

}
