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
import com.programacionII.model.Mensaje;
import com.programacionII.model.Usuario;
import com.programacionII.service.MensajeService;
import com.programacionII.service.UsuarioService;


@Controller
@SessionAttributes("usuarioSession") //Spring obtiene una instancia de la session
public class PerfilController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MensajeService mensajeService;

	@RequestMapping(value="/perfil", method=RequestMethod.GET)	
	public String perfil(Model model,  HttpSession session, @RequestParam(value="id", required=false) Integer id, @RequestParam(value="idmensaje", required=false) Integer idmensaje) {
		
		if(session.getAttribute("usuarioSession") == null)
			return "redirect:login.html";
		
		if (idmensaje != null){ //validacion para que no pueda eliminar mensajes de otros..
			Mensaje mensaje = new Mensaje();
			mensaje.setId(idmensaje);
			mensajeService.delete(mensaje);			
		}
		
		Usuario usu = new Usuario();
		if(id == null){ //Mi perfil
			String nombre_usuario = session.getAttribute("usuarioSession").toString();
			usu = usuarioService.findByUserName(nombre_usuario);
			model.addAttribute("yomismo", true);		
			//Uso relacion entre Usuario -> Seguidores
			
		}
		else{ //Perfil de otro usuario
			usu = usuarioService.findById(id);
			model.addAttribute("yomismo", false);		
		}
		
		model.addAttribute("siguiendo", usu.getSiguiendo().size());
		model.addAttribute("seguidores", usu.getSeguidores().size());
		model.addAttribute("mensajes", usu.getMensajes().size());
		
		if (usu != null){ 
			model.addAttribute("usuario", usu);				
		}				
		return "perfil";
	}
	
	@RequestMapping(value="/perfil", method=RequestMethod.POST)
	public String perfil(@RequestParam("texto") String texto, @RequestParam(value="id", required=false) Integer id, @Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model, HttpSession session) {
		if (texto == null){
			session.setAttribute("usuarioSession", usuario.getUsuario());
			Usuario usu = usuarioService.findByUserName(usuario.getUsuario());					
			model.addAttribute("message", "Se guardaron los datos del usuario");	
			model.addAttribute("usuario", usu);
		}
		else{
			Usuario usu = new Usuario();
			usu = usuarioService.findByUserName(session.getAttribute("usuarioSession").toString());						
			Mensaje mensaje = new Mensaje();
			mensaje.setIdOrigen(usu.getId()); //Siempre es el de la sesion
			if (id == null){
				id = usu.getId();
				model.addAttribute("yomismo", true);
			}
			if (id != usu.getId()){
				texto = texto + "@" + usu.getUsuario(); 
			}
			mensaje.setIdDestino(id);
			if (texto.length() > 0){
				mensaje.setTexto(texto);
				mensajeService.save(mensaje);
				usu = usuarioService.findById(id);
				session.setAttribute("usuarioSession", usu.getUsuario());	
				model.addAttribute("message", "Se guardaron los datos del usuario");
			}
			else
				model.addAttribute("error", "Mensaje no puede estar en blanco");

			model.addAttribute("usuario", usu);
			model.addAttribute("mensajes", usu.getMensajes().size());
			model.addAttribute("siguiendo", usu.getSiguiendo().size());
			model.addAttribute("seguidores", usu.getSeguidores().size());
		}

		return "perfil";
	}
	
	//RequestParam va a ser requerido
	@RequestMapping(value="/buscar", method=RequestMethod.GET)
	public @ResponseBody Model buscar(Model model, @RequestParam("buscar") String buscar, HttpSession session) {
		boolean logueado;
		if(session.getAttribute("usuarioSession") == null)
			logueado = false;
		else
			logueado= true;
		
		if(session.getAttribute("usuarioSession") != null){
			session.setAttribute("usuarioSession",session.getAttribute("usuarioSession"));
			String nombre_usuario = session.getAttribute("usuarioSession").toString();
			Usuario usu = usuarioService.findByUserName(nombre_usuario);
			model.addAttribute("seguidores", usu.getSeguidores());		
			}
			//VER
		List<Usuario> usuarios = usuarioService.findbyName(buscar);				
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("logueado", logueado);	
		model.addAttribute("yomismo", session.getAttribute("usuarioSession"));		
	    return model;
	}
	
	@RequestMapping(params="buscar", method=RequestMethod.POST)
	public String buscaFormulario(@ModelAttribute Usuario usuario, BindingResult resultado, Model model, HttpSession session) throws Exception{
		if(session.getAttribute("usuarioSession") == null)
			return "redirect:login.html";
		else
			return "buscar";
	}
			
	@ModelAttribute("mensaje")
	public Mensaje createModel() {
	    return new Mensaje();
	}
	
}
