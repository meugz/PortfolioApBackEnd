package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Educacion;
import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.service.EducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EducacionController {
    
    @Autowired
    private EducacionService educServ;
    //seteamos con una constante el ID de la Persona a Educacion 
    private final static Long ID_PERSONA=1L;
    
    @PostMapping("/educacion/add")
    public ResponseEntity<Educacion> agregarEducacion(@RequestBody Educacion educacion){
        
        //esta Persona se va a setear siempre como nueva?
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        educacion.setPersona(persona1);
        Educacion titulos = educServ.crearEducacion(educacion);
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }
    
    @GetMapping("/educacion/lista")
    @ResponseBody
    public List<Educacion> verListaEducacion() {
        return educServ.verListaEducacion();
    }

    @GetMapping("/educacion/ver/{id}")
    @ResponseBody
    public Educacion verEducacion(@PathVariable Long id) {
        return educServ.buscarEducacion(id);
    }

    @DeleteMapping("/educacion/delete/{id}")
    public void borrarCurso(@PathVariable Long id) {
        educServ.borrarEducacion(id);
    }

    @PutMapping("/educacion/editar/{idEduc}")
    public ResponseEntity<Educacion> editarEducacion(@PathVariable Long idEduc, @RequestBody Educacion educ) {
        Educacion modifEduc = educServ.buscarEducacion(idEduc);
        modifEduc.setNombreEdu(educ.getNombreEdu());
        modifEduc.setInstitucionEdu(educ.getInstitucionEdu());
        modifEduc.setPeriodoEdu(educ.getPeriodoEdu());
        modifEduc.setDescripcionEdu(educ.getDescripcionEdu());
        educServ.editarEducacion(modifEduc);
        return new ResponseEntity<>(modifEduc, HttpStatus.OK);
    }
    

}
