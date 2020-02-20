package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Usuarios;

public interface iUsuarioDao extends CrudRepository<Usuarios, Long> {

	
	public Usuarios findByEmail(String email);
	public Usuarios findByEmailAndPassword(String email,String password);
	public Optional<Usuarios> findById(Long id);
	
	@Query("SELECT u FROM Usuarios u where u.id=?1")
	public Usuarios findByIdSQL(Long id);
	
	
}
