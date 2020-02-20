package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Peliculas;
import com.example.demo.service.iPeliculasService;

@RestController
@RequestMapping("/cines")
public class PeliculasRestController {
	
	@Autowired
	private iPeliculasService peliculasService;
	
	@GetMapping("/peliculas")
	public ResponseEntity<?> listaPeliculas(){
		List<Peliculas> listaPeliculas = peliculasService.findAll();
		if(listaPeliculas != null) {
			if(listaPeliculas.size() !=0) {
				return new ResponseEntity<>(listaPeliculas, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/crearpelicula")
	public ResponseEntity<?> agregarPelicula(@RequestBody Peliculas peliculas){
		peliculasService.savePeliculas(peliculas);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@GetMapping("/descripcionpelicula/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Peliculas findById(@PathVariable("id") Long id){
		return peliculasService.findById(id);
	}
	

}
