package com.portfolioAP.tpfinal.service;

import java.util.List;
import com.portfolioAP.tpfinal.entidades.Persona;

public interface IPersonaService {

	public List<Persona> verPersonas();
	public void crearPersona (Persona person);
	public void borrarPersona (Long id);
	public Persona buscarPersona (Long id);
	public void editarPersona (Persona per);
	
	
}
