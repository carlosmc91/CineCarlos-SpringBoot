package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Peliculas;

public interface iPeliculasService {
	
	public List<Peliculas> findAll();
	public void savePeliculas(Peliculas peliculas);
	public Peliculas findPeliculaById(Long id);
	public Peliculas findById(Long id);
	

}
