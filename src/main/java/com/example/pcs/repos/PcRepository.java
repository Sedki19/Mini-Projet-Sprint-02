package com.example.pcs.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.pcs.entities.Marque;
import com.example.pcs.entities.Pc;


@RepositoryRestResource(path = "rest")
public interface PcRepository extends JpaRepository<Pc,Long> {
	
	 List<Pc> findByNomPc(String nom); 
	 List<Pc> findByNomPcContains(String nom);   		
	 
	 @Query("select p from Pc p where p.nomPc like %?1 and p.prixPc > ?2") 
	 List<Pc> findByNomPrix (String nom, Double prix);
	 
	 @Query("select p from Pc p where p.marque = ?1") 
	 List<Pc> findByMarque (Marque marque);
	 
	 List<Pc> findByMarqueIdMarq(Long id); 
	 
	 List<Pc> findByOrderByNomPcAsc(); 
	 
	 @Query("select p from Pc p order by p.nomPc ASC, p.prixPc DESC") 
	 List<Pc> trierPcsNomsPrix (); 
}
