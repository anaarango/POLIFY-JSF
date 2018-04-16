package com.polify.entity;

import java.sql.Date;

public class Operaciones {
	
	private int id_operaciones;
	private String operaciones;
	private int id_artista_empresa;
	private Date fecha_creacion;
	
	public int getId_operaciones() {
		return id_operaciones;
	}
	public void setId_operaciones(int id_operaciones) {
		this.id_operaciones = id_operaciones;
	}
	public String getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(String operaciones) {
		this.operaciones = operaciones;
	}
	public int getId_artista_empresa() {
		return id_artista_empresa;
	}
	public void setId_artista_empresa(int id_artista_empresa) {
		this.id_artista_empresa = id_artista_empresa;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Operaciones(int id_operaciones, String operaciones, int id_artista_empresa, Date fecha_creacion) {
		super();
		this.id_operaciones = id_operaciones;
		this.operaciones = operaciones;
		this.id_artista_empresa = id_artista_empresa;
		this.fecha_creacion = fecha_creacion;
	}

	
	
}
