package com.example.pcs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.pcs.entities.Marque;
import com.example.pcs.entities.Pc;
import com.example.pcs.repos.PcRepository;

@Service
public class PcServiceImpl implements PcService {
	@Autowired
	PcRepository PcRepository;

	@Override
	public Pc savePc(Pc p) {
		return PcRepository.save(p);
	}

	@Override
	public Pc updatePc(Pc p) {
		return PcRepository.save(p);
	}

	@Override
	public void deletePc(Pc p) {
		PcRepository.delete(p);
	}

	@Override
	public void deletePcById(Long id) {
		PcRepository.deleteById(id);
	}

	@Override
	public Pc getPc(Long id) {
		return PcRepository.findById(id).get();
	}

	@Override
	public List<Pc> getAllPcs() {
		return PcRepository.findAll();
	}

	   @Override 
	   public List<Pc> findByNomPc(String nom) { 
	   return PcRepository.findByNomPc(nom); 
	   } 
	   
	   @Override 
	   public List<Pc> findByNomPcContains(String nom) { 
	   return PcRepository.findByNomPcContains(nom); 
	   } 
	   
	   @Override 
	   public List<Pc> findByNomPrix(String nom, Double prix) { 
	   return PcRepository.findByNomPrix(nom, prix); 
	   } 
	   
	   @Override 
	   public List<Pc> findByMarque(Marque Marque) { 
	   return PcRepository.findByMarque(Marque); 
	   } 
	   
	   @Override 
	   public List<Pc> findByMarqueIdMarq(Long id) { 
	   return PcRepository.findByMarqueIdMarq(id); 
	   } 
	   
	   @Override 
	   public List<Pc> findByOrderByNomPcAsc() { 
	   return PcRepository.findByOrderByNomPcAsc(); 
	   } 
	   
	   @Override 
	   public List<Pc> trierPcsNomsPrix() { 
	   return PcRepository.trierPcsNomsPrix(); 
	   } 
	   
	   //for the web page 
	   
	   @Override
		public Page<Pc> getAllPcsParPage(int page, int size) {
			
			return PcRepository.findAll(PageRequest.of(page, size));
			
		}
}