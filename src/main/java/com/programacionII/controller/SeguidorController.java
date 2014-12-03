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
public class SeguidorController {
	
	@Autowired
	private UsuarioService usuarioService;
		

	
}
