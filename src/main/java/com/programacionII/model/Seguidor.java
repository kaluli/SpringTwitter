package com.programacionII.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="seguidor")
public class Seguidor {

	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty
	private int idusuario;
	
	@NotEmpty
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
	
}
