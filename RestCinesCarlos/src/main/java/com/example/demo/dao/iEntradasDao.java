package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Entradas;

public interface iEntradasDao extends CrudRepository<Entradas, Long> {
	public List<Entradas> findByusuarioId(Long id);
}
