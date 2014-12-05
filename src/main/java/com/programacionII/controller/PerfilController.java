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
import com.programacionII.model.Seguidor;
import com.programacionII.model.Usuario;
import com.programacionII.service.MensajeService;
import com.programacionII.service.SeguidorService;
import com.programacionII.service.UsuarioService;


@Controller
@SessionAttributes("usuarioSession") //Spring obtiene una instancia de la session
public class PerfilController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MensajeService mensajeService;
	@Autowired
	private SeguidorService seguidorService;
	
	@RequestMapping(value="/perfil", method=RequestMethod.GET)	
	public String perfil(Model model,  HttpSession session, @RequestParam(value="id", required=false) Integer id, @RequestParam(value="action", required=false) String action, @RequestParam(value="idmensaje", required=false) Integer idmensaje) {
		if(session.getAttribute("usuarioSession") == null)
			return "redirect:login.html";

		if (action != null){
			if(action.equals("retwittear") && (id != null) && (idmensaje != null)){
				Usuario usu = usuarioService.findByUserName(session.getAttribute("usuarioSession").toString());					
				Usuario origen = usuarioService.findById(id);					
				Mensaje mensaje = mensajeService.findById(idmensaje);
				Mensaje mensajeRT = new Mensaje();
				mensajeRT.setTexto("RT @" + origen.getUsuario() + " - " + mensaje.getTexto());
				mensajeRT.setIdDestino(usu.getId());
				mensajeRT.setIdOrigen(usu.getId());
				mensajeService.save(mensajeRT);	
				return "redirect:perfil.html";
			}
				
			
			if(action.equals("dejarseguir") && (id != null)){
				Usuario usu = usuarioService.findByUserName(session.getAttribute("usuarioSession").toString());		
				Seguidor seguidor = seguidorService.findById(id,usu.getId());
				if (seguidor != null)
					seguidorService.delete(seguidor);
				return "redirect:perfil.html";
			}
				
			//Borrar mensaje
			if (action.equals("delete") && idmensaje != null){ //validacion para que no pueda eliminar mensajes de otros..
				Mensaje mensaje = new Mensaje();
				mensaje.setId(idmensaje);
				mensajeService.delete(mensaje);			
			}
		}	
		Usuario usu = new Usuario();		
		String nombre_usuario = session.getAttribute("usuarioSession").toString();
		usu = usuarioService.findByUserName(nombre_usuario);
		int idlogueado = usu.getId();
		
		if(id == null){ //Mi perfil
			model.addAttribute("yomismo", true);		
			
		}
		else{ //Perfil de otro usuario
			usu = usuarioService.findById(id);
			model.addAttribute("yomismo", false);
			if ((seguidorService.findById(id, idlogueado)) == null){
				model.addAttribute("losigues", false);					
			}
			else
				model.addAttribute("losigues", true);					
			
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
			Usuario usu = usuarioService.findByUserName(session.getAttribute("usuarioSession").toString());						
			Mensaje mensaje = new Mensaje();
			mensaje.setIdOrigen(usu.getId()); //Siempre es el de la sesion
			if (id == null){
				id = usu.getId();
				model.addAttribute("yomismo", true);
			}
			if (id != usu.getId()){
				Usuario destinatario = usuarioService.findById(id);										
				model.addAttribute("destinatario", destinatario); 
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
	public @ResponseBody Model buscar(Model model, @RequestParam(value="buscar", required=false) String buscar, HttpSession session) {
		boolean logueado;
		if(session.getAttribute("usuarioSession") == null)
			logueado = false;
		else
			logueado= true;
		
		//Seguidores del usuario que inició sesión
		if(session.getAttribute("usuarioSession") != null){
			session.setAttribute("usuarioSession",session.getAttribute("usuarioSession"));
			String nombre_usuario = session.getAttribute("usuarioSession").toString();
			Usuario usu = usuarioService.findByUserName(nombre_usuario);
			model.addAttribute("siguiendo", usu.getSiguiendo());
/*			 for(int i = 0; i < usu.getSeguidores().size(); i++) {
		            System.out.println(usu.getSeguidores().get(i).getIdSeguidor());

		        }*/
			if ((buscar != null)){
				//Todos los usuarios que matchean con la búsqueda
				List<Usuario> usuarios = usuarioService.findbyName(buscar);				
				model.addAttribute("usuarios", usuarios);
				//Seguidores del usuario que inició sesión
				/*Usuario usu = usuarioService.findByUserName();
				 for(int i = 0; i < usu.getSeguidores().size(); i++) {
			            System.out.println(usu.getSeguidores().get(i).getIdUsuario());
			        }
				model.addAttribute("seguidores", usu.getSeguidores());*/		
				model.addAttribute("logueado", logueado);	
				model.addAttribute("yomismo", session.getAttribute("usuarioSession"));
			}
		}
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
