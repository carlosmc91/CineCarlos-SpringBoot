package com.example.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name="cines")
public class Cines implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="Nombre")
	private String nombre;
	
	private String Horario;
	
	private String Imagen;
	
	private float latitud;
	
	private float longitud;
	
	private int Telefono;
	
	@ManyToMany
	@JoinTable(name = "cines_peliculas",
	joinColumns = @JoinColumn(name="cines_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="peliculas_id", referencedColumnName = "id"))
	private Set<Peliculas> peliculas = new HashSet<Peliculas>();
	
	
	public Set<Peliculas> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<Peliculas> peliculas) {
		this.peliculas = peliculas;
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

	public String getHorario() {
		return Horario;
	}

	public void setHorario(String horario) {
		Horario = horario;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	
	public void addPelicula(Peliculas peliculas) {
		this.peliculas.add(peliculas);
	}
	

	private static final long serialVersionUID = 1L;

}
