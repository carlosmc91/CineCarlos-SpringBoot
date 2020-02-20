package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "peliculas")
public class Peliculas implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;
	private String imagen;
	private String trailer;
	private String tematica;
	
	@ManyToMany
	@JsonBackReference
	@JoinTable(name = "cines_peliculas",
	 joinColumns = @JoinColumn(name="peliculas_id", referencedColumnName = "id"),
	 inverseJoinColumns = @JoinColumn(name="cines_id", referencedColumnName = "id"))
	private Set<Cines>cines = new HashSet<Cines>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "peliculaId", referencedColumnName = "id")
	private List<Sesiones> sesiones = new ArrayList<>();
	
	@OneToMany()
	@JoinColumn(name = "peliculaId", referencedColumnName = "id")
	private List<Entradas> entradas = new ArrayList<>();

	public List<Sesiones> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesiones> sesiones) {
		this.sesiones = sesiones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public Set<Cines> getCines() {
		return cines;
	}

	public void setCines(Set<Cines> cines) {
		this.cines = cines;
	}
	
	private static final long serialVersionUID = 1L;
	
	

}
