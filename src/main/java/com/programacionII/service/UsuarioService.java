package com.programacionII.service;

import java.util.ArrayList;

import com.programacionII.model.Usuario;

public interface UsuarioService {
	Usuario save(Usuario usuario);
	Usuario findByLogin(String usuario, String password);
	Usuario findByUserName(String usuario);
	Usuario findbyBusqueda(String busqueda);
	ArrayList<Usuario> findAll();
}
