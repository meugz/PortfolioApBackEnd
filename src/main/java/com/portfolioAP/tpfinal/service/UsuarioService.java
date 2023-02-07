
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Usuario;
import com.portfolioAP.tpfinal.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository userRep;
    
    @Override
    public List<Usuario> verListaUsuarios() {
        return userRep.findAll();
    }

    @Override
    public Usuario crearUsuario(Usuario user) {
        return userRep.save(user);
    }

    @Override
    public void borrarUsuario(Long id) {
        userRep.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return userRep.findById(id).orElse(null);
    }

    @Override
    public Usuario editarUsuario(Usuario user) {
        return userRep.save(user);
    }
    
    
}
