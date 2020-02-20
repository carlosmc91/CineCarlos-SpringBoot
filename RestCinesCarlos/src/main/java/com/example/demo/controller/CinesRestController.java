package com.example.demo.controller;

import java.util.Collection;
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


import com.example.demo.entity.Cines;
import com.example.demo.entity.Peliculas;
import com.example.demo.service.iCinesService;
import com.example.demo.service.iPeliculasService;

@RestController
@RequestMapping("/cines")

public class CinesRestController {

	@Autowired
	private iCinesService cinesService;
	
	@Autowired
	private iPeliculasService peliculasService;
	
	@GetMapping("/cines")
	@ResponseStatus(HttpStatus.OK)
	public List<Cines> getCines(){
		return cinesService.findAll();
	}
	
	@GetMapping("/descripcioncine/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cines findById(@PathVariable("id") Long id){
		return cinesService.findById(id);
	}
	
	
	@PostMapping("/peliculas_cines")
	public ResponseEntity<?> listaPeliculasCines(@RequestBody Peliculas peliculas){
		Peliculas peliculasDb = peliculasService.findById(peliculas.getId());
		if(peliculasDb != null) {
			Collection<Cines> listaCines = peliculasDb.getCines();
			if(listaCines != null) {
				return new ResponseEntity<>(listaCines, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	

	
	
}