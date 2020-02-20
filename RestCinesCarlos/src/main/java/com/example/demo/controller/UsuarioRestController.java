package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuarios;
import com.example.demo.mapper.Mapper;
import com.example.demo.model.MUsuarios;
import com.example.demo.service.iUsuariosService;

@RestController
@RequestMapping("/cines")

public class UsuarioRestController {

	@Autowired
	private iUsuariosService usuarioService;
	
	@GetMapping("/obtenerusuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuarios> getUsuarios(){
		return usuarioService.findAll();
	}
	
	@PostMapping("/crearusuario")
	public ResponseEntity<Void> addUsuario(@RequestBody Usuarios usuario){
		if(usuarioService.findUsuario(usuario)==null) {
			usuarioService.save(usuario);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/actualizarusuario/{id}")
	public ResponseEntity<?> updateUsuario(@PathVariable(value ="id")Long id,@RequestBody Usuarios usuario){
			Usuarios usuarioDb = null;
			usuarioDb = usuarioService.findbyId(id);
			if(usuarioDb != null) {
				usuarioDb.setNombre(usuario.getNombre());
				usuarioDb.setApellido(usuario.getApellido());
				usuarioDb.setTarjeta(usuario.getTarjeta());
				usuarioDb.setTelefono(usuario.getTelefono());
				usuarioService.updateUsuario(usuarioDb);
			return new ResponseEntity<>(usuarioDb, HttpStatus.OK);
			}else {
		    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUsuarios(@RequestBody Usuarios usuario){
		Usuarios usuarioDb = usuarioService.checkUsuariosLogin(usuario);
		if(usuarioDb!= null) {
			List<Usuarios> usuarios = new ArrayList<>();
			usuarios.add(usuarioDb);
			List<MUsuarios> musuarios = new ArrayList<>();
			musuarios = Mapper.convertirLista(usuarios);
			return new ResponseEntity<>(musuarios, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/actualizarusuario")
	public ResponseEntity<?> updateUsuarioSQL(@RequestBody Usuarios usuario){
			Usuarios usuarioDb = null;
			usuarioDb = usuarioService.findByIdSQL(usuario.getId());
			if(usuarioDb != null) {
				usuarioDb.setNombre(usuario.getNombre());
				usuarioDb.setApellido(usuario.getApellido());
				usuarioDb.setTarjeta(usuario.getTarjeta());
				usuarioDb.setTelefono(usuario.getTelefono());
				usuarioService.updateUsuario(usuarioDb);
			return new ResponseEntity<>(usuarioDb, HttpStatus.OK);
			}else {
		    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUsuarios(@PathVariable("id") long id) {
		usuarioService.deleteUsuario(id);
		return new ResponseEntity<Void>(HttpStatus.OK);	
	}
	
}
