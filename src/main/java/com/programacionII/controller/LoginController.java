package com.programacionII.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.programacionII.model.Usuario;
import com.programacionII.model.UsuarioLogin;
import com.programacionII.service.UsuarioService;

@Controller
@SessionAttributes("usuario") //Spring obtiene una instancia de la session
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
		
	@RequestMapping(value="/registro", method=RequestMethod.GET)	
	public String registro(Model model) {
		Usuario usuario= new Usuario();		
		model.addAttribute("usuario", usuario);		
		return "registro";
	}
	
	@RequestMapping(value="/registro", method=RequestMethod.POST)
	public String registro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {		
		if(result.hasErrors()) {
			return "registro";
		} else if(usuarioService.findByUserName(usuario.getUserName())) {
			model.addAttribute("message", "El nombre de usuario existe. Prueba con otro");
			return "registro";
		} else {
			usuarioService.save(usuario);
			model.addAttribute("message", "Se guardaron los datos del usuario");
			return "redirect:login.html";
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		boolean existe = false;
		if (session.getAttribute("usuario") != null){
			String usuario = session.getAttribute("usuario").toString();		
			existe = usuarioService.findByUserName(usuario);			
		}	
		
		if (existe){
			return "logueado";
		}
		else{	
			UsuarioLogin usuarioLogin = new UsuarioLogin();		
			model.addAttribute("usuarioLogin", usuarioLogin);
			return "login";
		}
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin, BindingResult result, HttpSession session ) {
		if (result.hasErrors()) {
			return "error";
		} else {
			boolean existe = usuarioService.findByLogin(usuarioLogin.getUserName(), usuarioLogin.getPassword());
			if (existe) {	
				session.setAttribute("usuario", usuarioLogin.getUserName());
				return "logueado";
			} else {				
				return "error";
			}
		}		
	}
	
}
