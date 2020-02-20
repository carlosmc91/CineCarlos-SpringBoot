package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.iEntradasDao;
import com.example.demo.entity.Entradas;

@Service
public class EntradasServiceimpl implements iEntradasService {
	
	@Autowired
	private iEntradasDao entradasDao;

	@Override
	@Transactional(readOnly=true)
	public List<Entradas> findAll() {
		return (List<Entradas>) entradasDao.findAll();
	}

	@Override
	public void saveEntradas(Entradas entradas) {
		entradasDao.save(entradas);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Entradas> findbyusuarioId(Long id) {
		return (List<Entradas>) entradasDao.findByusuarioId(id);
	}
	
	

}
