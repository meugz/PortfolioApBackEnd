package com.portfolioAP.tpfinal.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable= false, updatable = false)
	
	private Long id;
	private String nombreProyecto;
	private LocalDate fecha;
	private String descripcionProyecto;
	private String url;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;
}
