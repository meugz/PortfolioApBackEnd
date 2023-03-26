package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Curso;
import com.portfolioAP.tpfinal.entidades.ExperienciaLaboral;
import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.repository.ExperienciaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    private ExperienciaRepository expRep;
    //seteamos con una constante el ID de la Persona a ExperienciaLaboral 
    private final static Long ID_PERSONA = 1L;

    @Override
    public List<ExperienciaLaboral> verListaExperienciaLaboral() {
        return expRep.findAll();
    }

    @Override
    public ExperienciaLaboral crearExperienciaLaboral(ExperienciaLaboral experiencia) {
        Persona persona1 = new Persona();
        persona1.setId(ID_PERSONA);
        experiencia.setPersona(persona1);
        return expRep.save(experiencia);
    }

    @Override
    public void borrarExperienciaLaboral(Long id) {
        expRep.deleteById(id);
    }

    @Override
    public ExperienciaLaboral buscarExperienciaLaboral(Long id) {
        return expRep.findById(id).orElse(null);
    }

    @Override
    public ExperienciaLaboral editarExperienciaLaboral(Long id, ExperienciaLaboral exp) {
        ExperienciaLaboral modifExp = this.buscarExperienciaLaboral(id);
        if (exp.getNombrePuesto() != null) {
            modifExp.setNombrePuesto(exp.getNombrePuesto());
        }
        if (exp.getEmpresa()!=null){
            modifExp.setEmpresa(exp.getEmpresa());
        }
        if (exp.getUbicacion()!=null){
            modifExp.setUbicacion(exp.getUbicacion());
        }
        if (exp.getFecha()!=null){
            modifExp.setFecha(exp.getFecha());
        }
        if (exp.getDescripcionExp()!=null){
            modifExp.setDescripcionExp(exp.getDescripcionExp());
        }
        return expRep.save(modifExp);
    }
  
}
