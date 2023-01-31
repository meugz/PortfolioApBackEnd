package com.portfolioAP.tpfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioAP.tpfinal.entidades.Persona;
import com.portfolioAP.tpfinal.repository.PersonaRepository;

@Service
public class PersonaService implements IPersonaService {
	
	@Autowired
	public PersonaRepository perRepo; 

	@Override
	public List<Persona> verPersonas() {
		return perRepo.findAll();
	}

	@Override
	public void crearPersona(Persona persona) {
		perRepo.save(persona);
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
	public void editarPersona(Persona per) {
		perRepo.save(per);
	}

	
}
