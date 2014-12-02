package com.programacionII.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UsuarioLogin {

	@NotEmpty
	@Size(min=4, max=20)
	private String usuario;
		
	@NotEmpty
	@Size(min=4, max=8)
	private String password;

	public String getPassword() {
		return password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}	
}
