package com.portfolioAP.tpfinal.service;

import java.io.IOException;
import java.util.List;

import com.portfolioAP.tpfinal.dto.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.repository.PersonaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository perRepo;

    @Autowired
    private ImageService imageService;

    @Override
    public List<Persona> verPersonas() {
        return perRepo.findAll();
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return perRepo.save(persona);
    }

    @Override
    public void borrarPersona(Long id) {
        perRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return perRepo.findById(id).orElse(null);
    }

    @Override
    public Persona editarPersona(Long id, Persona per) {

        Persona modifPersona = this.buscarPersona(id);
        if (per.getNombre() != null) {
            modifPersona.setNombre(per.getNombre());
        }
        if (per.getApellido() != null) {
            modifPersona.setApellido(per.getApellido());
        }
        if (per.getCiudad() != null) {
            modifPersona.setCiudad(per.getCiudad());
        }
        if (per.getEmail() != null) {
            modifPersona.setEmail(per.getEmail());
        }
        if (per.getFechaNac() != null) {
            modifPersona.setFechaNac(per.getFechaNac());
        }
        if (per.getOcupacion() != null) {
            modifPersona.setOcupacion(per.getOcupacion());
        }
        if (per.getDescripcion() != null) {
            modifPersona.setDescripcion(per.getDescripcion());
        }
        if (per.getFoto() != null) {
            modifPersona.setFoto(per.getFoto());
        }
        return perRepo.save(modifPersona);
    }

    public Persona editarFoto(Long id, ImageDTO nombreImage){
        Persona personaFound = this.buscarPersona(id);
        personaFound.setFoto(nombreImage.getNombreImg());
        this.perRepo.save(personaFound);
        return personaFound;
    }
}
