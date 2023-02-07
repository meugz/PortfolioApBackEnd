package com.portfolioAP.tpfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.service.IPersonaService;
import java.time.LocalDateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private IPersonaService perServ;

    @PostMapping("/persona/new")
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona per) {
        Persona person = perServ.crearPersona(per);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping("/personas/ver")
    @ResponseBody
    public List<Persona> verListaPersonas() {
        return perServ.verPersonas();
    }

    @GetMapping("/persona/ver/{id}")
    @ResponseBody
    public Persona verPersona(@PathVariable Long id) {
        return perServ.buscarPersona(id);
    }

    /*@PostMapping("/persona/editar")
    public Persona editarPersona(@RequestBody Persona per) {
        return perServ.editarPersona(per);
    }*/

    @DeleteMapping("/persona/delete/{id}")
    public void borrarPersona(@PathVariable Long id) {
        perServ.borrarPersona(id);
   }
   
    @PutMapping("/persona/editar/{id}")
    public ResponseEntity<Persona> editarPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("email") String nuevoEmail,
            @RequestParam("ocupacion") String nuevaOcupacion,
            @RequestParam("ciudad") String nuevaCiudad,
            //@RequestParam("fechaNac") LocalDateTime nuevaFechaNac,
            @RequestParam("descripcion") String nuevaDescripcion,
            @RequestParam("foto") String nuevaFoto) {
        Persona modifPersona = perServ.buscarPersona(id);
        modifPersona.setNombre(nuevoNombre);
        modifPersona.setApellido(nuevoApellido);
        modifPersona.setEmail(nuevoEmail);
        modifPersona.setOcupacion(nuevaOcupacion);
        modifPersona.setCiudad(nuevaCiudad);
        //modifPersona.setFechaNac(nuevaFechaNac);
        modifPersona.setDescripcion(nuevaDescripcion);
        modifPersona.setFoto(nuevaFoto);
        perServ.editarPersona(modifPersona);
        
        return new ResponseEntity<>(modifPersona, HttpStatus.OK);
    }
    

}
