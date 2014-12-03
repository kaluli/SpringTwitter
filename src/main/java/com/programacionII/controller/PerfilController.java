package com.programacionII.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.programacionII.model.Usuario;
import com.programacionII.service.UsuarioService;


@Controller
@SessionAttributes("usuario") //Spring obtiene una instancia de la session
public class PerfilController {
	
	@Autowired
	private UsuarioService usuarioService;
		
	@RequestMapping(value="/perfil", method=RequestMethod.GET)	
	public String perfil(Model model,  HttpSession session) {
		String nombre_usuario = session.getAttribute("usuario").toString();
		Usuario usu = usuarioService.findByUserName(nombre_usuario);
		if (usu != null){ //viene desde login
			model.addAttribute("nombre", usu.getNombre());		
			model.addAttribute("apellido", usu.getApellido());		
			model.addAttribute("username", usu.getUsuario());
		}		
		return "perfil";
	}
	
	@RequestMapping(value="/perfil", method=RequestMethod.POST)
	public String perfil(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {
		Usuario usu = usuarioService.findByUserName(usuario.getUsuario());
		model.addAttribute("nombre", usu.getNombre());		
		model.addAttribute("apellido", usu.getApellido());		
		model.addAttribute("username", usu.getUsuario());		
		
		return "perfil";
	}
	
	//RequestParam va a ser requerido
	@RequestMapping(value="/buscar", method=RequestMethod.GET)
	public @ResponseBody Model buscar(Model model, @RequestParam("buscar") String buscar) {
		List<Usuario> usuarios = usuarioService.findbyName(buscar);		
		model.addAttribute("usuarios", usuarios);		
	    return model;
	}
	
	@RequestMapping(params="buscar", method=RequestMethod.POST)
	public String buscaFormulario(@ModelAttribute Usuario usuario, BindingResult resultado, Model model) throws Exception{
			if(!resultado.hasErrors()){
				List<Usuario> usuarios = usuarioService.findbyName("karina");			
				model.addAttribute("usuarios", usuarios);
		}
		return "buscar";
	}
	
	
	
	
	
}
