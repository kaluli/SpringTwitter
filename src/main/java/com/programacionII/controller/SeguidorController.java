package com.programacionII.controller;


import javax.servlet.http.HttpSession;

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

import com.programacionII.model.Seguidor;
import com.programacionII.model.Usuario;
import com.programacionII.service.SeguidorService;
import com.programacionII.service.UsuarioService;



@Controller
@SessionAttributes("usuario") //Spring obtiene una instancia de la session
public class SeguidorController {
	
	@Autowired
	private SeguidorService seguidorService;
	@Autowired
	private UsuarioService usuarioService;
	
	//RequestParam va a ser requerido
		@RequestMapping(value="/seguir", method=RequestMethod.GET)
		public @ResponseBody Model buscar(Model model, @RequestParam("id") int idseguidor, HttpSession session) {
			Seguidor seguidor = new Seguidor();
			Usuario usu = new Usuario();
			usu = usuarioService.findByUserName(session.getAttribute("usuarioSession").toString());						
			if ((seguidor = seguidorService.findById(usu.getId(), idseguidor)) == null){
				seguidor = new Seguidor();
				seguidor.setIdUsuario(usu.getId());
				seguidor.setIdSeguidor(idseguidor);
				seguidorService.save(seguidor);
				model.addAttribute("mensaje", "Ahora sigues a este usuario");				
			}
			else
				model.addAttribute("mensaje", "Ya sigues a este usuario");			
			return model;
		}
		
		@RequestMapping(params="seguir", method=RequestMethod.POST)
		public String buscaFormulario(@ModelAttribute Usuario usuario, BindingResult resultado, Model model) throws Exception{
				if(!resultado.hasErrors()){					
					model.addAttribute("usuarios", "bla");
			}
			return "perfil";
		}
		
	
}
