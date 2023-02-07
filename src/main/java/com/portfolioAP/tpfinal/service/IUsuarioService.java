
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Usuario;
import java.util.List;


public interface IUsuarioService {
    public List<Usuario> verListaUsuarios();
    public Usuario crearUsuario(Usuario user);
    public void borrarUsuario(Long id);
    public Usuario buscarUsuario(Long id);
    public Usuario  editarUsuario(Usuario user);
}
