package com.programacionII.controller;


import java.util.ArrayList;
import java.util.List;

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
@SessionAttributes("usuarioSession") //Spring obtiene una instancia de la session
public class SeguidorController {
	
	@Autowired
	private SeguidorService seguidorService;
	@Autowired
	private UsuarioService usuarioService;
	private Seguidor seguidor;
	
	//RequestParam va a ser requerido
		@RequestMapping(value="/seguir", method=RequestMethod.GET)
		public @ResponseBody Model buscar(Model model, @RequestParam("id") int idseguidor, HttpSession session) {
			seguidor = new Seguidor();	
			Usuario usu = new Usuario();
			usu = usuarioService.findByUserName(session.getAttribute("usuarioSession").toString());
			session.setAttribute("usuarioSession",session.getAttribute("usuarioSession"));
			if ((seguidor = seguidorService.findById(idseguidor,usu.getId())) == null){
				seguidor = new Seguidor();
				seguidor.setIdUsuario(idseguidor);
				seguidor.setIdSeguidor(usu.getId());				
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
		
		@RequestMapping(value="/seguidores", method=RequestMethod.GET)
		public @ResponseBody Model mostrar(@RequestParam(value="idusuario", required=false) Integer idusuario, Model model, HttpSession session) {			
			boolean logueado;
			if(session.getAttribute("usuarioSession") == null)
				logueado = false;
			else
				logueado= true;
			
			model.addAttribute("logueado", logueado);	
			seguidor = new Seguidor();
			Usuario usu = new Usuario();
			if (idusuario == null){
				idusuario = usu.getId();
				model.addAttribute("yomismo", true);
			}			
				
			usu = usuarioService.findById(idusuario);
			model.addAttribute("yomismo", session.getAttribute("usuarioSession"));				    
			model.addAttribute("usuario", usu);
			session.setAttribute("usuarioSession",session.getAttribute("usuarioSession"));
			List <Seguidor> seguidores = seguidorService.findByIdUsuario(idusuario);			
			List <Usuario> seguidores_usuario = new ArrayList<Usuario>();
			for(int i = 0; i < seguidores.size(); i++) {
				int idseguidor = seguidores.get(i).getIdSeguidor();
				Usuario usuario_seguidor = new Usuario();					
				usuario_seguidor = usuarioService.findById(idseguidor);
				seguidores_usuario.add(usuario_seguidor);
	        }
			model.addAttribute("seguidores", seguidores_usuario);

			return model;
		}
		
		@RequestMapping(params="seguidores", method=RequestMethod.POST)
		public String mostrarSeguidores(@ModelAttribute Usuario usuario, BindingResult resultado, Model model) throws Exception{
				if(!resultado.hasErrors()){					
					model.addAttribute("usuarios", "bla");
			}
			return "seguidores";
		}
		
		@RequestMapping(value="/siguiendo", method=RequestMethod.GET)
		public @ResponseBody Model mostrarSiguiendo(@RequestParam(value="idusuario", required=false) Integer idusuario, Model model, HttpSession session) {			
			boolean logueado;
			if(session.getAttribute("usuarioSession") == null)
				logueado = false;
			else
				logueado= true;
			
			model.addAttribute("logueado", logueado);	
			seguidor = new Seguidor();
			Usuario usu = new Usuario();
			if (idusuario == null){
				idusuario = usu.getId();
				model.addAttribute("yomismo", true);
			}			
			session.setAttribute("usuarioSession",session.getAttribute("usuarioSession"));
			usu = usuarioService.findById(idusuario);
			model.addAttribute("yomismo", session.getAttribute("usuarioSession"));				    
			model.addAttribute("usuario", usu);
			List <Seguidor> siguiendo = seguidorService.findByIdSeguidor(idusuario);			
			List <Usuario> seguidores_usuario = new ArrayList<Usuario>();
			for(int i = 0; i < siguiendo.size(); i++) {
				int idseguidor = siguiendo.get(i).getIdUsuario();
				Usuario usuario_seguidor = new Usuario();					
				usuario_seguidor = usuarioService.findById(idseguidor);
				seguidores_usuario.add(usuario_seguidor);
	        }
			model.addAttribute("seguidores", seguidores_usuario);

			return model;
		}
		
		@RequestMapping(params="siguiendo", method=RequestMethod.POST)
		public String mostrarSiguiendo(@ModelAttribute Usuario usuario, BindingResult resultado, Model model) throws Exception{
				if(!resultado.hasErrors()){					
					model.addAttribute("usuarios", "bla");
			}
			return "seguidores";
		}
			
}
