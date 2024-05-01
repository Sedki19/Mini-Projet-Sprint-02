	package com.example.pcs.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Pc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPc ;
	private String nomPc;
	private Double prixPc;
	private String Specs;
	
	 
	@ManyToOne 
	private Marque marque;
	
	public Pc() {
		super();
	}
	
	public Pc( String nomPc, Double prixPc, String specs) {
		super();
		this.nomPc = nomPc;
		this.prixPc = prixPc;
		Specs = specs;
	}
	public Long getIdPc() {
		return idPc;
	}
	public void setIdPc(Long idPc) {
		this.idPc = idPc;
	}
	public String getNomPc() {
		return nomPc;
	}
	public void setNomPc(String nomPc) {
		this.nomPc = nomPc;
	}
	public Double getPrixPc() {
		return prixPc;
	}
	public void setPrixPc(Double prixPc) {
		this.prixPc = prixPc;
	}
	public String getSpecs() {
		return Specs;
	}
	public void setSpecs(String specs) {
		Specs = specs;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	
	
	
}
