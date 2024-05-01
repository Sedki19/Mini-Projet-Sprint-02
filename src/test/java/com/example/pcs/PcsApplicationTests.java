package com.example.pcs;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.pcs.entities.Marque;
import com.example.pcs.entities.Pc;
import com.example.pcs.repos.PcRepository;

@SpringBootTest
class PcsApplicationTests {

	@Autowired
	private PcRepository PcRepository;

	@Test
	void contextLoads() {
		Pc p = new Pc("Dell",2200.500,"i5 6eme gen ..");
		PcRepository.save(p);

	}
	 @Test 
	 public void testFindByNomPc()  { 
	 List<Pc> ps = PcRepository.findByNomPc("Dell"); 
	 for (Pc p : ps)  { 
	 System.out.println(p); 
	 } 
	 }
	 
	 @Test 
	 public void testFindByNomPcContains () 
	 { 
	 List<Pc> ps=PcRepository.findByNomPcContains("ell"); 
	 for (Pc p : ps) 
	 { 
	 System.out.println(p); 
	 } } 
	 
	 @Test 
	 public void testfindByNomPrix() 
	  { 
	  List<Pc> ps = PcRepository.findByNomPrix("Dell", 2200.500); 
	  for (Pc p : ps) 
	  { 
	  System.out.println(p); 
	  } 
	  
	  } 
	 
	 @Test 
	 public void testfindByMarque() 
	 { 
	 Marque marq = new Marque(); 
	 marq.setidMarq(1L); 
	 List<Pc> ps = PcRepository.findByMarque(marq); 
	 for (Pc p : ps) 
	 { 
	 System.out.println(p); 
	 } 
	 } 
	 
	 @Test 
	 public void findByMarqueIdCat() 
	  { 
	  List<Pc> ps = PcRepository.findByMarqueIdMarq(1L); 
	  for (Pc p : ps) 
	  { 
	  System.out.println(p); 
	  } 
	        }
	 
	 public void testfindByOrderByNomPcAsc() 
	 { 
	 List<Pc> ps = 
	PcRepository.findByOrderByNomPcAsc();   
	 for (Pc p : ps) 
	 { 
	 System.out.println(p); 
	 } 
	 } 
	 
	 @Test 
	 public void testTrierPcsNomsPrix() 
	 { 
	 List<Pc> ps = PcRepository.trierPcsNomsPrix();
	 
	 for (Pc p : ps) 
	 { 
	 System.out.println(p); 
	 } 
	 } 
	 
	 

	 }
