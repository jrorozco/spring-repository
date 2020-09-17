package com.bolsadeideas.springboot.form.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller
public class FormController {

	@RequestMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo","Llenar Formualrio");
		return "form";
	}
	
//	@PostMapping("/form")
//	public String procesarFormulario(Model model,
//			@RequestParam (name="username")String username,// si sellaman igual en el formulario el (name="username") se puede omitir
//			@RequestParam String password,
//			@RequestParam String email
//			) {
//		Usuario usuario= new Usuario();
//		usuario.setUsername(username);
//		usuario.setPassword(password);
//		usuario.setEmail(email);
//		model.addAttribute("usuario", usuario);
		
//		model.addAttribute("password", password);
//		model.addAttribute("email", email);
//		model.addAttribute("titulo","Resultado del Formualrio");
//		return "resultado";
//	}
	@PostMapping("/form")
	public String procesarFormulario(Usuario usuario,Model model) {
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo","Resultado del Formualrio");
		return "resultado";
	}
}
