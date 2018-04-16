package com.polify.entity;

public class Artista {
	
	private int id_artista;
	private String nombre;
	private int id_empresa;
	private String email;
	private boolean canEdit;
	
	public boolean isCanEdit() {
		return canEdit;
	}
	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
	public int getId_artista() {
		return id_artista;
	}
	public void setId_artista(int id_artista) {
		this.id_artista = id_artista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Artista(int id_artista, String nombre, int id_empresa, String email) {
		super();
		this.id_artista = id_artista;
		this.nombre = nombre;
		this.id_empresa = id_empresa;
		this.email = email;
		this.canEdit = true;
	}
	public Artista() {
		
		super();
		canEdit = true;
	}
	
	
	
	
}
