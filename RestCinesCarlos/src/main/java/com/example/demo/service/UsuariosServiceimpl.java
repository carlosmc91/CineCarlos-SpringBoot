package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.iUsuarioDao;
import com.example.demo.entity.Usuarios;

@Service
public class UsuariosServiceimpl implements iUsuariosService {

	
	@Autowired
	private iUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> findAll() {
		return (List<Usuarios>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios findUsuario(Usuarios usuario) {
		return (Usuarios) usuarioDao.findByEmail(usuario.getEmail());
	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios checkUsuariosLogin(Usuarios usuario) {
		return (Usuarios) usuarioDao.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
	}

	@Override
	@Transactional
	public void deleteUsuario(Usuarios usuario) {
		usuarioDao.deleteById(usuario.getId());

	}

	@Override
	@Transactional
	public Usuarios updateUsuario(Usuarios usuario) {
		return (Usuarios) usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuarios> findUsuarioById(Long id) {
		return (Optional<Usuarios>) usuarioDao.findById(id);
	}

	@Override
	public void deleleUsuarios(Long id) {
		usuarioDao.deleteById(id);
		
	}

	@Override
	public Usuarios findbyId(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuarios findByIdSQL(Long id) {
		return usuarioDao.findByIdSQL(id);
	}

	@Override
	@Transactional
	public void save(Usuarios usuario) {
		usuarioDao.save(usuario);
		
	}

	@Override
	public void deleteUsuario(long id) {
		// TODO Auto-generated method stub
		
	}



}
