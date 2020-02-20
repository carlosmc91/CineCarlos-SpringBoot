package com.example.demo.model;


import com.example.demo.entity.Usuarios;

public class MUsuarios {
	
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String tarjeta;
	
	private int Telefono;
	
	public MUsuarios() {
		
	}

	public MUsuarios(Long id, String nombre, String apellido, String email, String tarjeta, int telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.tarjeta = tarjeta;
		Telefono = telefono;
	}
	
	public MUsuarios(Usuarios usuario) {
		this.id = usuario.getId();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.email = usuario.getEmail();
		this.tarjeta = usuario.getTarjeta();
		Telefono = usuario.getTelefono();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	
	

}
