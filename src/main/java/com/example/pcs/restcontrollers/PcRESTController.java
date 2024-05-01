package com.example.pcs.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.pcs.entities.Pc;
import com.example.pcs.service.PcService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class PcRESTController {

	@Autowired
	PcService PcService;	
	@RequestMapping(method = RequestMethod.GET)
	public List<Pc> getAllPcs() {
	return PcService.getAllPcs();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Pc getPcById(@PathVariable("id") Long id) {
	return PcService.getPc(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public Pc createPc(@RequestBody Pc Pc) {
	return PcService.savePc(Pc);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Pc updatePc(@RequestBody Pc Pc) {
	return PcService.updatePc(Pc);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePc(@PathVariable("id") Long id)
	{
	PcService.deletePcById(id);
	}
	
	@RequestMapping(value="/prodsMarq/{idMarq}",method = RequestMethod.GET)
	public List<Pc> getPcsByCatId(@PathVariable("idMarq") Long idMarq) {
	return PcService.findByMarqueIdMarq(idMarq);
	}

}
