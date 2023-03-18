
package com.portfolioAP.tpfinal.service;

import com.portfolioAP.tpfinal.entidades.Curso;
import java.util.List;

public interface ICursoService {
        public List<Curso> verListaCursos();
	public Curso crearCurso (Curso curso);
	public void borrarCurso (Long id);
	public Curso buscarCurso (Long id);
	public Curso editarCurso (Long id, Curso curso);
}
