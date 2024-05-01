package com.example.pcs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.pcs.entities.Marque;
import com.example.pcs.entities.Pc;


public interface PcService {

	 Pc savePc(Pc p); 
	 Pc updatePc(Pc p); 
	 void deletePc(Pc p); 
	 void deletePcById(Long id); 
	 Pc getPc(Long id); 
	 List<Pc> getAllPcs(); 
	 List<Pc> findByNomPc(String nom); 
	 List<Pc> findByNomPcContains(String nom); 
	 List<Pc> findByNomPrix (String nom, Double prix); 
	 List<Pc> findByMarque (Marque marque); 
	 List<Pc> findByMarqueIdMarq(Long id); 
	 List<Pc> findByOrderByNomPcAsc(); 
	 List<Pc> trierPcsNomsPrix(); 
	 //for the web page
	 Page<Pc> getAllPcsParPage(int page, int size);

	
}
