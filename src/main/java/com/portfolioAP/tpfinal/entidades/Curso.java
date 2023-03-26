package com.portfolioAP.tpfinal.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable= false, updatable = false)
	
	/*@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")*/

	private Long id;
	@NotBlank
	private String nombre;
	@NotBlank
	private String institucion;
	@NotBlank
	private String periodo;
	@NotBlank
	private String descripcion;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
}
