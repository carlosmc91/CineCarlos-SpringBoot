package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.iSesionesDao;
import com.example.demo.entity.Sesiones;
import com.example.demo.entity.Usuarios;

@Service
public class SesionesServiceimpl implements iSesionesService {
	
	@Autowired
	private iSesionesDao sesionesDao;

	@Override
	@Transactional(readOnly=true)
	public List<Sesiones> findAll() {
		return (List<Sesiones>) sesionesDao.findAll();
	}

	@Override
	public void saveSesiones(Sesiones sesiones) {
		sesionesDao.save(sesiones);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Sesiones> getSesionCine(Long id) {
		return (List<Sesiones>) sesionesDao.findBypeliculaId(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Sesiones checkSesiones(Sesiones sesiones) {
		return (Sesiones) sesionesDao.findByCineAndFechaAndHoraAndPeliculaId(sesiones.getCine(), sesiones.getFecha(), sesiones.getHora(), sesiones.getPeliculaId());
	}

	@Override
	public Sesiones findbyId(Long id) {
		return sesionesDao.findById(id).orElse(null);
	}


	@Override
	public Sesiones updateSesion(Sesiones sesion) {
		return (Sesiones) sesionesDao.save(sesion);
	}
	

}
