package com.polify.entity;

public class Empresa {
	
	private int id_empresa;
	private String nombre;
	private String email;
	private int valor_operacion;
	private boolean canEdit;
	
	public boolean isCanEdit() {
		return canEdit;
	}
	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getValor_operacion() {
		return valor_operacion;
	}
	public void setValor_operacion(int valor_operacion) {
		this.valor_operacion = valor_operacion;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Empresa(int id_empresa, String nombre, int valor_operacion) {
		super();
		this.id_empresa = id_empresa;
		this.nombre = nombre;
		this.email = email;
		this.valor_operacion = valor_operacion;
		this.canEdit = true;
	}
	public Empresa() {
		super();
	}
	
	

}
