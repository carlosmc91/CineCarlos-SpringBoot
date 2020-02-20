package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Sesiones;
import com.example.demo.entity.Usuarios;

public interface iSesionesService {
	
	public List<Sesiones> findAll();
	
	public void saveSesiones(Sesiones sesiones);
	
	public List<Sesiones> getSesionCine(Long id);

	public Sesiones checkSesiones(Sesiones sesiones);

	public Sesiones findbyId(Long id);
	
	public Sesiones updateSesion(Sesiones sesion);


}
