package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Peliculas;
import com.example.demo.entity.Sesiones;
import com.example.demo.entity.Usuarios;
import com.example.demo.service.iSesionesService;

@RestController
@RequestMapping("/cines")
public class SesionesRestController {
	
	 @Autowired
	 private iSesionesService sesionesService;
	 
	 @GetMapping("/sesiones")
	 public ResponseEntity<?> listaSesiones(){
		 List<Sesiones> listaSesiones = sesionesService.findAll();
		 if(listaSesiones !=null) {
			 if(listaSesiones.size() !=0) {
				 return new ResponseEntity<>(listaSesiones, HttpStatus.OK);
			 }else {
				 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			 }
		 }else {
			 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @PostMapping("/crear_sesion")
	 public ResponseEntity<?> agregarSesion(@RequestBody Sesiones sesiones){
		 sesionesService.saveSesiones(sesiones);
		 return new ResponseEntity<Void>(HttpStatus.CREATED);
	 }
	 
	 @PostMapping("/sesiones_peliculas")
	 public ResponseEntity<?> verSesionesPeliculas(@RequestBody Peliculas peliculas){
		 List<Sesiones> listaSesiones = sesionesService.getSesionCine(peliculas.getId());
		 if(listaSesiones !=null) {
			 if(listaSesiones.size() !=0) {
				 return new ResponseEntity<>(listaSesiones, HttpStatus.OK);
			 }else {
				 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			 }
		 }else {
			 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @PostMapping("/comprobarasientos")
	 public ResponseEntity<?> comprobarAsientos(@RequestBody Sesiones sesiones){
		 Sesiones sesionDb= sesionesService.checkSesiones(sesiones);
		 if(sesionDb!= null) {
			 return new ResponseEntity<>(sesionDb, HttpStatus.OK);
		 }else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	@PutMapping("/actualizarsesion/{id}")
	public ResponseEntity<?> updateSesion(@PathVariable(value ="id")Long id,@RequestBody Sesiones sesion){
				Sesiones sesionDb = null;
				sesionDb = sesionesService.findbyId(sesion.getId());
				if(sesionDb != null) {
					sesionDb.setAsientos(sesion.getAsientos());
					sesionesService.updateSesion(sesionDb);
				return new ResponseEntity<>(sesionDb, HttpStatus.OK);
				}else {
			    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
				}		
		}
	 
	 
}
