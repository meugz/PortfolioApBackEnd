package com.portfolioAP.tpfinal.entidades;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Persona {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable= false, updatable = false)
	
	/*@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")*/

	private Long id;
	
	private String nombre;

	private String apellido;

	private String email;
	
	private String ocupacion;
	
	private String ciudad;
	
	private LocalDateTime fechaNac;
	
	private String descripcion;

	private String foto;
	
	@OneToOne(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonManagedReference
	private Usuario user;
	
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonManagedReference
	private List<Curso> cursos;
	
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonManagedReference
	private List<Educacion> titulos;
	
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonManagedReference
	private List<ExperienciaLaboral> trabajos;
	
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonManagedReference
	private List<Skill> habilidades;
	
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonManagedReference
	private List<Interes> intereses;
	
	@OneToMany(mappedBy="persona", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JsonManagedReference
	private List<Proyecto> proyectos;
	

}
