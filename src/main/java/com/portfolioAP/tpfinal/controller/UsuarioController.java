package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.entidades.Usuario;
import com.portfolioAP.tpfinal.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    
    @Autowired
    private UsuarioService userServ;
    
    //seteamos con una constante el ID de la Persona a ExperienciaLaboral 
    private final static Long ID_PERSONA = 1L;

    @PostMapping("/user/add")
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody Usuario usuario) {

        //esta Persona se va a setear siempre como nueva?
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        usuario.setPersona(persona1);
        Usuario user = userServ.crearUsuario(usuario);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user/lista")
    @ResponseBody
    public List<Usuario> verListaUsuarios() {
        return userServ.verListaUsuarios();
    }

    @GetMapping("/user/ver/{id}")
    @ResponseBody
    public Usuario verUsuario(@PathVariable Long id) {
        return userServ.buscarUsuario(id);
    }

    @DeleteMapping("/user/delete/{id}")
    public void borrarUsuario(@PathVariable Long id) {
        userServ.borrarUsuario(id);
    }

    @PutMapping("/user/editar/{idUser}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Long idUser, @RequestBody Usuario user) {
        Usuario modifUser = userServ.buscarUsuario(idUser);
        modifUser.setEmail(user.getEmail());
        modifUser.setPassword(user.getPassword());
        userServ.editarUsuario(modifUser);
        return new ResponseEntity<>(modifUser, HttpStatus.OK);
    }

}
