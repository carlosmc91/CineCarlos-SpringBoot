package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Peliculas;

public interface iPeliculasDao extends CrudRepository<Peliculas, Long> {
	
	@Query("select p from Peliculas p where p.id =?1")
	public Peliculas findByIdSQL(Long id);

}
