package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {
	@Autowired
	private IServicio servicio;

	/**
	 * 
	 * Con este se inyecta por medio del constructor incluso se puede omitir el @Autowired
	 */
//	@Autowired
//	public IndexController(IServicio servicio) {
//		this.servicio = servicio;
//	}


	@GetMapping({"/","","/index"})
	public String index(Model model) {
		model.addAttribute("objeto",servicio.operacion());
		return "index";
	}

	
	/***
	 * Esta es una forma de inyectar con el metodo SET
	 */
//	@Autowired
//	public void setServicio(IServicio servicio) {
//		this.servicio = servicio;
//	}
	
	
}
