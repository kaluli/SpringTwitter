package com.programacionII.service;

import java.util.List;

import com.programacionII.model.Usuario;

public interface UsuarioService {
	public Usuario save(Usuario usuario);
	public Usuario findByLogin(String usuario, String password);
	public Usuario findByUserName(String usuario);
	public Usuario findById(int id);
	public List<Usuario> findbyName(String nombre);
	public List<Usuario> findAll();
}
