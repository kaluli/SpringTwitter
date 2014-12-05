package com.programacionII.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty
	@Size(min=4, max=20)
	private String usuario;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Size(min=4, max=8)
	private String password;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date nacimiento;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}	
	
	@OneToMany(targetEntity=Seguidor.class, mappedBy="idseguidor", fetch=FetchType.EAGER)
	private List<Seguidor> siguiendo;   
	
	@OneToMany(targetEntity=Seguidor.class, mappedBy="idusuario", fetch=FetchType.EAGER)
	private List<Seguidor> seguidores;   
		
	public List<Seguidor> getSeguidores() {
		return this.seguidores;
	} 
	public void setSeguidores(List<Seguidor> seguidores) {
		this.seguidores = seguidores;
	}
	
	public List<Seguidor> getSiguiendo() {
		return this.siguiendo;
	} 
	public void setSiguiendo(List<Seguidor> siguiendo) {
		this.siguiendo = siguiendo;
	}
	
	@OneToMany(targetEntity=Mensaje.class, mappedBy="idorigen", fetch=FetchType.EAGER)
	@OrderBy("fecha DESC") 
	private List<Mensaje> mensajes;   
		
	public List<Mensaje> getMensajes() {
		return this.mensajes;
	} 
	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	
}
