package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="sesiones")
public class Sesiones implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fecha;
	
	private String hora;
	
	private String asientos;
	
	private String cine;
	
	private Long peliculaId;
	
	public Sesiones() {
		
	}

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
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



	public Long getPeliculaId() {
		return peliculaId;
	}



	public void setPeliculaId(Long peliculaId) {
		this.peliculaId = peliculaId;
	}



	private static final long serialVersionUID = 1L;
	

}
