package com.polify.entity;

public class Usuario {
	
	private int id_usuario;
	private int id_rol;
	private String nombre;
	
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Usuario(int id_usuario, int id_rol, String nombre) {
		super();
		this.id_usuario = id_usuario;
		this.id_rol = id_rol;
		this.nombre = nombre;
	}
	
	
	

}
