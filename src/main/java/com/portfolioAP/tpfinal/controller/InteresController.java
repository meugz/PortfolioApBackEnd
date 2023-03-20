package com.portfolioAP.tpfinal.controller;

import com.portfolioAP.tpfinal.entidades.Interes;
import com.portfolioAP.tpfinal.service.InteresService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/interes")
public class InteresController {

    @Autowired
    private InteresService intServ;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Interes> agregarInteres(@RequestBody Interes interes) {
        Interes intereses = intServ.crearInteres(interes);
        return new ResponseEntity<>(intereses, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Interes> verListaInteres() {
        return intServ.verListaInteres();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Interes verInteres(@PathVariable Long id) {
        return intServ.buscarInteres(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void borrarInteres(@PathVariable Long id) {
        intServ.borrarInteres(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{idInt}")
    public ResponseEntity<Interes> editarInteres(@PathVariable Long idInt, @RequestBody Interes interes) {
        Interes modifInteres = intServ.editarInteres(idInt, interes);
        return new ResponseEntity<>(modifInteres, HttpStatus.OK);
    }
}
