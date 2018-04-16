package com.polify.entity;

public class Recompensa {
	
	private int id_recompensa;
	private String nombre;
	
	
	public int getId_recompensa() {
		return id_recompensa;
	}
	public void setId_recompensa(int id_recompensa) {
		this.id_recompensa = id_recompensa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Recompensa(int id_recompensa, String nombre) {
		super();
		this.id_recompensa = id_recompensa;
		this.nombre = nombre;
	}
	
	

}
