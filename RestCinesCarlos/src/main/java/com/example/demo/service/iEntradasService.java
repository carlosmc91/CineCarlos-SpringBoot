package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Entradas;



public interface iEntradasService {
	
	public List<Entradas> findAll();
	
	public void saveEntradas(Entradas entradas);
	
	public List<Entradas> findbyusuarioId(Long id);
	

	

}
