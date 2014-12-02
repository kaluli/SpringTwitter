package com.programacionII.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programacionII.model.Usuario;
import com.programacionII.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario findByLogin(String usuario, String password) {	
		Usuario usu = usuarioRepository.findByUserName(usuario);
		
		if(usu != null && usu.getPassword().equals(password)) {
			return usu;
		} 
		
		return null;		
	}

	public Usuario findByUserName(String usuario) {
		Usuario usu = usuarioRepository.findByUserName(usuario);
		
		if(usu != null) {
			return usu;
		}
		
		return null;
	}

	@Override
	public ArrayList<Usuario> findAll() {
		usuarioRepository.findAll();
		return null;
	}

	@Override
	public Usuario findbyBusqueda(String usuario) {
		Usuario usu = usuarioRepository.findByUserName(usuario);		
		return usu;
	}

}
