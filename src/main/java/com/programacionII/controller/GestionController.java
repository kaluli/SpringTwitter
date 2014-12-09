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
public class GestionController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/micuenta", method=RequestMethod.GET)
	public String mostrar(Model model, HttpSession session) {		
		if(session.getAttribute("usuarioSession") == null)
			return "redirect:login.html";
		
			String nombre_usuario = session.getAttribute("usuarioSession").toString();
			Usuario usu = usuarioService.findByUserName(nombre_usuario);
			model.addAttribute("usuario", usu);
			model.addAttribute("logueado", true);	
			return "micuenta";
		}
					
	@RequestMapping(value="/micuenta", method=RequestMethod.POST)
	public String micuenta(@Valid @ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin, BindingResult result, HttpSession session, Model model ) {
		if (result.hasErrors()) {
			model.addAttribute("error");			
			return "redirect:login.html";
		} else {
			if (usuarioService.findByLogin(usuarioLogin.getUsuario(), usuarioLogin.getPassword()) != null) {
				model.addAttribute("logueado", true);					
				session.setAttribute("usuarioSession", usuarioLogin.getUsuario());			
				model.addAttribute("usuarioLogin", usuarioLogin);
				return "redirect:micuenta.html";
			} else {		
				model.addAttribute("error");							
				return "redirect:login.html";
			}
		}		
	}	
	
	@RequestMapping(value="/notificaciones", method=RequestMethod.GET)
	public String notifica(Model model, HttpSession session) {		
		if(session.getAttribute("usuarioSession") == null)
			return "redirect:login.html";
			
			model.addAttribute("logueado", true);			
			Usuario usuario= new Usuario();		
			model.addAttribute("usuario", usuario);		
			return "notificaciones";
		}
					
	@RequestMapping(value="/notificaciones", method=RequestMethod.POST)
	public String notificar(@Valid @ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin, BindingResult result, HttpSession session, Model model ) {
		if (result.hasErrors()) {
			model.addAttribute("error");			
			return "redirect:login.html";
		} else {
			if (usuarioService.findByLogin(usuarioLogin.getUsuario(), usuarioLogin.getPassword()) != null) {
				model.addAttribute("logueado", true);					
				session.setAttribute("usuarioSession", usuarioLogin.getUsuario());			
				model.addAttribute("usuarioLogin", usuarioLogin);
				return "redirect:notificaciones.html";
			} else {		
				model.addAttribute("error");							
				return "redirect:login.html";
			}
		}		
	}	
	
	@RequestMapping(value="/recuperar_password", method=RequestMethod.GET)
	public String recuperar_password(Model model, HttpSession session) {
		if(session.getAttribute("usuarioSession") == null)
			return "redirect:login.html";
		
			String nombre_usuario = session.getAttribute("usuarioSession").toString();
			Usuario usu = usuarioService.findByUserName(nombre_usuario);
		return "recuperar_password";
		
	}
	
	@RequestMapping(value="/recuperar_password", method=RequestMethod.POST)
	public String recuperar_password(@Valid @ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin, BindingResult result, HttpSession session, Model model ) {
		if (result.hasErrors()) {
			model.addAttribute("error");			
			return "recuperar_password";

		} else {
			if (usuarioService.findByLogin(usuarioLogin.getUsuario(), usuarioLogin.getPassword()) != null) {					
				session.setAttribute("usuarioSession", usuarioLogin.getUsuario());			
				model.addAttribute("usuarioLogin", usuarioLogin);
				return "redirect:perfil.html";
			} else {		
				model.addAttribute("error");							
				return "recuperar_password";
			}
		}		
	}
	
	@RequestMapping(value="/cambiarpassword", method=RequestMethod.GET)	
	public String cambiarpassword(Model model, HttpSession session) {
		Usuario usuario= new Usuario();		
		model.addAttribute("usuario", usuario);		
		return "cambiarpassword";
	}
	
	@RequestMapping(value="/cambiarpassword", method=RequestMethod.POST)
	public String cambiarpassword(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model, HttpSession session) {		
		if(result.hasErrors()) {
			return "cambiarpassword";
		} else if(usuarioService.findByUserName(usuario.getUsuario()) != null) {
			model.addAttribute("message", "El nombre de usuario existe. Prueba con otro");
			return "cambiarpassword";
		} else {
		/*	String pass = usuario.getPassword();
			MD5Encoder encoder = new MD5Encoder;
			String hashedPass = encoder.encode(pass.getBytes());
			usuario.setPassword(hashedPass);*/	       
			usuarioService.save(usuario);
			session.setAttribute("usuarioSession", usuario.getUsuario());
			model.addAttribute("message", "Se guardaron los datos del usuario");
			//model.addAttribute("usuario", session.getAttribute("usuario"));
			return "redirect:login.html";
		}
	}
}
