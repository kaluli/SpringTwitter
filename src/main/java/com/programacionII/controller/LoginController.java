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
@SessionAttributes("usuarioSession") //Spring obtiene una instancia de la session
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
		
	@RequestMapping(value="/registro", method=RequestMethod.GET)	
	public String registro(Model model, HttpSession session) {
		if(session.getAttribute("usuarioSession") != null)
			return "redirect:login.html";
		Usuario usuario= new Usuario();		
		model.addAttribute("usuario", usuario);		
		return "registro";
	}
	
	@RequestMapping(value="/registro", method=RequestMethod.POST)
	public String registro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model, HttpSession session) {		
		if(result.hasErrors()) {
			return "registro";
		} else if(usuarioService.findByUserName(usuario.getUsuario()) != null) {
			model.addAttribute("message", "El nombre de usuario existe. Prueba con otro");
			return "registro";
		} else {
			usuarioService.save(usuario);
			session.setAttribute("usuarioSession", usuario.getUsuario());
			model.addAttribute("message", "Se guardaron los datos del usuario");
			//model.addAttribute("usuario", session.getAttribute("usuario"));
			return "redirect:login.html";
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model, HttpSession session) {	
		if (session.getAttribute("usuarioSession") != null){						
			session.setAttribute("usuarioSession", session.getAttribute("usuarioSession"));
			return "redirect:perfil.html";
		}	
		else{	
			UsuarioLogin usuarioLogin = new UsuarioLogin();		
			model.addAttribute("usuarioLogin", usuarioLogin);
			return "login";
		}
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin, BindingResult result, HttpSession session, Model model ) {
		if (result.hasErrors()) {
			return "error";
		} else {
			if (usuarioService.findByLogin(usuarioLogin.getUsuario(), usuarioLogin.getPassword()) != null) {					
				session.setAttribute("usuarioSession", usuarioLogin.getUsuario());			
				model.addAttribute("usuarioLogin", usuarioLogin);
				return "redirect:perfil.html";
			} else {				
				return "error";
			}
		}		
	}
	
}
