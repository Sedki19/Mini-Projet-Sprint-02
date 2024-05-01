package com.example.pcs.controllers;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.pcs.entities.Pc;
import com.example.pcs.service.PcService;

@Controller
public class PcController {
	@Autowired
	PcService PcService;

	@RequestMapping("/template")
	public String template() {
		return "template";
	}
	
	@RequestMapping("/myView")
	public String myView() {
		return "myView";
	}

	@RequestMapping("/listePcs")
	public String listePcs(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Pc> ps = PcService.getAllPcsParPage(page, size);
		modelMap.addAttribute("Pcs", ps);
		modelMap.addAttribute("pages", new int[ps.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listePcs";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createPc";
	}

	@RequestMapping("/savePc")
	public String savePc(@ModelAttribute("Pc") Pc Pc, ModelMap modelMap) throws ParseException {

		Pc savePc = PcService.savePc(Pc);
		String msg = "Pc enregistré avec Id " + savePc.getIdPc();
		modelMap.addAttribute("msg", msg);
		return "createPc";
	}

	@RequestMapping("/supprimerPc")
	public String supprimerPc(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		PcService.deletePcById(id);
		Page<Pc> ps = PcService.getAllPcsParPage(page, size);
		modelMap.addAttribute("Pcs", ps);
		modelMap.addAttribute("pages", new int[ps.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listePcs";
	}

	@RequestMapping("/modifierPc")
	public String editerPc(@RequestParam("id") Long id, ModelMap modelMap) {
		Pc p = PcService.getPc(id);
		modelMap.addAttribute("Pc", p);
		return "editerPc";
	}

	@RequestMapping("/updatePc")
	public String updatePc(@ModelAttribute("Pc") Pc Pc, ModelMap modelMap) throws ParseException {

		PcService.updatePc(Pc);
		List<Pc> ps = PcService.getAllPcs();
		modelMap.addAttribute("Pcs", ps);
		return "listePcs";
	}
}