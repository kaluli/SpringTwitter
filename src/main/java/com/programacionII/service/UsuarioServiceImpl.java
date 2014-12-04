package com.programacionII.service;


import java.util.List;

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
	
	@Override
	public Usuario findByLogin(String usuario, String password) {	
		Usuario usu = usuarioRepository.findByUserName(usuario);
		
		if(usu != null && usu.getPassword().equals(password)) {
			return usu;
		} 
		
		return null;		
	}
	
	@Override
	public Usuario findByUserName(String usuario) {
		Usuario usu = usuarioRepository.findByUserName(usuario);
		
		if(usu != null) {
			return usu;
		}
		
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public List<Usuario> findbyName(String nombre_usuario) {		
		return usuarioRepository.findbyName(nombre_usuario);
	}

	@Override
	public Usuario findById(int id) {
		return usuarioRepository.findbyId(id);
	}

}
