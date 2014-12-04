package com.programacionII.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="mensaje")
public class Mensaje {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private int idorigen;
	
	@NotNull
	private int iddestino;
		
	@NotEmpty
	private String texto;
		
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fecha;
	
	public int getIdOrigen() {
		return idorigen;
	}

	public void setIdOrigen(int idorigen) {
		this.idorigen = idorigen;
	}

	public int getIdDestino() {
		return iddestino;
	}

	public void setIdDestino(int iddestino) {
		this.iddestino = iddestino;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
		
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	
	
}
