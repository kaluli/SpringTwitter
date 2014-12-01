package com.programacionII.service;

import com.programacionII.model.Usuario;

public interface UsuarioService {
	Usuario save(Usuario usuario);
	boolean findByLogin(String userName, String password);
	boolean findByUserName(String userName);
}
