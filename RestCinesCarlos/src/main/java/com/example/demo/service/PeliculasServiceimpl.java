package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.iPeliculasDao;
import com.example.demo.entity.Peliculas;

@Service
public class PeliculasServiceimpl implements iPeliculasService {
	
	@Autowired
	private iPeliculasDao peliculasDao;

	@Override
	@Transactional(readOnly = true)
	public List<Peliculas> findAll() {
		return (List<Peliculas>) peliculasDao.findAll();
	}

	@Override
	public void savePeliculas(Peliculas peliculas) {
         peliculasDao.save(peliculas);		
	}

	@Override
	public Peliculas findPeliculaById(Long id) {
		return peliculasDao.findByIdSQL(id);
	}
	
	@Override
	@Transactional(readOnly = true)  
	public Peliculas findById(Long id) {
	return peliculasDao.findById(id).orElse(null);
	}

}
