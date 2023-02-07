package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Interes;
import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.service.InteresService;
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
public class InteresController {

    @Autowired
    private InteresService intServ;
    
    //seteamos con una constante el ID de la Persona a ExperienciaLaboral 
    private final static Long ID_PERSONA = 1L;

    @PostMapping("/interes/add")
    public ResponseEntity<Interes> agregarInteres(@RequestBody Interes interes) {

        //esta Persona se va a setear siempre como nueva?
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        interes.setPersona(persona1);
        Interes intereses = intServ.crearInteres(interes);
        return new ResponseEntity<>(intereses, HttpStatus.OK);
    }

    @GetMapping("/interes/lista")
    @ResponseBody
    public List<Interes> verListaInteres() {
        return intServ.verListaInteres();
    }

    @GetMapping("/interes/ver/{id}")
    @ResponseBody
    public Interes verInteres(@PathVariable Long id) {
        return intServ.buscarInteres(id);
    }

    @DeleteMapping("/interes/delete/{id}")
    public void borrarInteres(@PathVariable Long id) {
        intServ.borrarInteres(id);
    }

    @PutMapping("/interes/editar/{idInt}")
    public ResponseEntity<Interes> editarInteres(@PathVariable Long idInt, @RequestBody Interes interes) {
        Interes modifInteres = intServ.buscarInteres(idInt);
        modifInteres.setDescripcionInteres(interes.getDescripcionInteres());
        intServ.editarInteres(modifInteres);
        return new ResponseEntity<>(modifInteres, HttpStatus.OK);
    }
}
