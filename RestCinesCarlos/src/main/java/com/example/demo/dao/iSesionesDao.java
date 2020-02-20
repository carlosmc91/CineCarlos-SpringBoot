package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Sesiones;


public interface iSesionesDao extends CrudRepository<Sesiones, Long> {
		public List<Sesiones> findBypeliculaId(Long id);
		public Sesiones findByCineAndFechaAndHoraAndPeliculaId(String cine, String fecha, String hora, Long peliculaId);
		

}
