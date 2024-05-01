package com.example.pcs.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity
public class Marque {
	@Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idMarq; 
	 private String nomMarq; 
	 
	 @JsonIgnore 
	 @OneToMany(mappedBy = "marque") 
	 private List<Pc> Pcs; 
	 
	
	public Marque(String nomMarq, List<Pc> Pcs) 
	{ 
	 super(); 
	 this.nomMarq = nomMarq; 
	 this.Pcs = Pcs; 
	 } 
	 
	 public Long getidMarq() { 
	 return idMarq; 
	 } 
	 
	 public void setidMarq(Long idMarq) { 
	 this.idMarq = idMarq; 
	 } 
	 
	 public String getnomMarq() { 
	 return nomMarq; 
	 } 
	 
	 public void setnomMarq(String nomMarq) { 
	 this.nomMarq = nomMarq; 
	 } 
	 
	 
	 
	 public List<Pc> getPcs() { 
	 return Pcs; 
	 } 
	 
	 public void setPcs(List<Pc> Pcs) { 
	 this.Pcs = Pcs; 
	 } 
	 
	 
} 

