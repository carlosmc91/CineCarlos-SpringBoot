package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Cines;

public interface iCinesService {
	
	public List<Cines> findAll();
	public Cines findById(Long id);
	public void save(Cines cines);
	
	public List<Cines> getCinesPeliculas(Long id);

	
}
