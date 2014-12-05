package com.programacionII.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="seguidor")
public class Seguidor {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private int idusuario;
	
	@NotNull
	private int idseguidor;
			
	
	public int getIdUsuario() {
		return idusuario;
	}

	public void setIdUsuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdSeguidor() {
		return idseguidor;
	}

	public void setIdSeguidor(int idseguidor) {
		this.idseguidor = idseguidor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@OneToMany(targetEntity=Usuario.class, mappedBy="id", fetch=FetchType.EAGER)
	private List<Usuario> usuarios;
	
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	} 
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
