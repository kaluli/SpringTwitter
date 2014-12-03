package com.programacionII.service;

import java.util.List;

import com.programacionII.model.Usuario;

public interface UsuarioService {
	Usuario save(Usuario usuario);
	Usuario findByLogin(String usuario, String password);
	Usuario findByUserName(String usuario);
	List<Usuario> findbyName(String nombre);
	List<Usuario> findAll();
}
