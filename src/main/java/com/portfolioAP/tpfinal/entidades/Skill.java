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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable= false, updatable = false)
	
	private Long id;
	private String nombreSkill;
	private String nivel;
        @Enumerated(EnumType.ORDINAL)
        private SkillType tipo;    
	private String descripcionSkill;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPersona")
    @JsonBackReference
    private Persona persona;

    public Skill(Long id, String nombreSkill, String nivel, String descripcionSkill, Persona persona) {
        this.id = id;
        this.nombreSkill = nombreSkill;
        this.nivel = nivel;
        this.descripcionSkill = descripcionSkill;
        this.persona = persona;
    }
    
    
	
	
}
