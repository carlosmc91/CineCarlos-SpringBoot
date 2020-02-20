package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.iCinesDao;
import com.example.demo.entity.Cines;

@Service
public class CinesServiceimpl implements iCinesService {
	
	@Autowired
	private iCinesDao cinesDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cines> findAll() {
		return (List<Cines>) cinesDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)  
	public Cines findById(Long id) {
	return cinesDao.findById(id).orElse(null);
	}

	@Override
	public void save(Cines cines) {
		cinesDao.save(cines);
	}
	
	@Override
	public List<Cines> getCinesPeliculas(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}