package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Usuarios;

public interface iUsuariosService {
	
	public void save(Usuarios usuario);

	public List<Usuarios> findAll();
	
	public Usuarios findUsuario(Usuarios usuario);
	
	public Usuarios checkUsuariosLogin(Usuarios usuario);
	
	public void deleteUsuario(long id);
	
	public Usuarios updateUsuario(Usuarios usuario);
	
	public Optional<Usuarios> findUsuarioById(Long id);
	
	public void deleleUsuarios(Long id);
	
	public Usuarios findbyId(Long id);
	
	public Usuarios findByIdSQL(Long id);

	void deleteUsuario(Usuarios usuario);
	
	
}
