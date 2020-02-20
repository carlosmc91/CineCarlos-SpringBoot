package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Entradas;
import com.example.demo.entity.Usuarios;
import com.example.demo.service.iEntradasService;

@RestController
@RequestMapping("/cines")
public class EntradasRestController {
	
	@Autowired
	private iEntradasService entradasService;
	
	@GetMapping("/entradas")
	public ResponseEntity<?> listaEntradas(){
		List<Entradas> listaEntradas = entradasService.findAll();
		if(listaEntradas !=null) {
			if(listaEntradas.size() !=0) {
				return new ResponseEntity<>(listaEntradas, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/crear_entrada")
	public ResponseEntity<?> agregarEntrada(@RequestBody Entradas entradas){
		entradasService.saveEntradas(entradas);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/entradas_usuario")
	public ResponseEntity<?> verEntradasUsuario(@RequestBody Usuarios usuarios){
		List<Entradas> listaEntradas = entradasService.findbyusuarioId(usuarios.getId());
		if(listaEntradas !=null) {
			if(listaEntradas.size() !=0) {
				return new ResponseEntity<>(listaEntradas, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
