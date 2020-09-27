package com.bolsadeideas.springboot.form.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario") // session de spring cap 56
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;
	
	/**
	 * Con este metodo se inyecta de forma trasnparente el validador personalizado
	 * @param binder
	 */
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		
		binder.addValidators(validador);
	}
	

	@RequestMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();// se manda un nuevo usuario para evitar que mande errores la primera vez que ingresa!!
		usuario.setNombre("John"); // con esto enviamos valores por defecto al formulario
		usuario.setApellido("Doe");// con esto enviamos valores por defecto al formulario
		usuario.setIdentificador("123.456.789-k");    // para poder pasar este identificador al resultado usarresmo sessiones @SessionAttributes("usuario")   esto es muy bueno para pasar los ID                                 
		model.addAttribute("titulo","Llenar Formualrio");
		model.addAttribute("usuario",usuario);
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
	
	/**
	 * importante para validar los campos del formulario primero el objeto que a llegar -- @Valid Usuario usuario,BindingResult result
	 * justo despues el BindingResult result, importante!! respetar ese orden
	 * @param usuario
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/form")
	public String procesarFormulario(@Valid Usuario usuario,BindingResult result,Model model, SessionStatus status) { // para poner un nombre distinto al de usuario  podemos usar la anotacion @ModelAttribute("user") por ejemplo y usarlo
		
		//validador.validate(usuario, result); se ocupá con el data binder
		
		model.addAttribute("titulo","Resultado del Formualrio");
		/**
		 * En esta parte se hace la validacion para los campos del formulario...
		 */
		if(result.hasErrors()) {
//			Map<String, String> errores = new HashMap<>();
//			result.getFieldErrors().forEach(e -> {
//				errores.put(e.getField(), "El campo ".concat(e.getField()).concat(" ").concat(e.getDefaultMessage()));
//			});
//			model.addAttribute("error", errores);
			/**
			 * Vamos a trabajarlo de forma explicita
			 * al declarar object  en el form esto se automatiza
			 */
			return "form";
		}
		
		model.addAttribute("result",result);
		model.addAttribute("usuario", usuario);
		status.setComplete();// con esta sentencia cerramos la session cap 56 spring curso
		return "resultado";
	}
}
