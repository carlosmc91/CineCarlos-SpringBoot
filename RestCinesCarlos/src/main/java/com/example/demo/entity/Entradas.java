package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entradas")
public class Entradas implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long usuarioId;
	
	private Long peliculaId;
	
	private String fecha;
	
	private String hora;
	
	private String asientos;
	
	private String cine;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getUsuarioId() {
		return usuarioId;
	}



	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}



	public Long getPeliculaId() {
		return peliculaId;
	}



	public void setPeliculaId(Long peliculaId) {
		this.peliculaId = peliculaId;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	public String getAsientos() {
		return asientos;
	}



	public void setAsientos(String asientos) {
		this.asientos = asientos;
	}



	public String getCine() {
		return cine;
	}



	public void setCine(String cine) {
		this.cine = cine;
	}



	private static final long serialVersionUID = 1L;

}
