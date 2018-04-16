package com.polify.entity;

import java.sql.Date;

public class Artista_empresa {
	
	private int id_artista_empresa;
	private int id_artista;
	private int id_empresa;
	private Date fecha_creacion;
	private Date fecha_modificacion;
	private String estado;
	
	public int getId_artista_empresa() {
		return id_artista_empresa;
	}
	public void setId_artista_empresa(int id_artista_empresa) {
		this.id_artista_empresa = id_artista_empresa;
	}
	public int getId_artista() {
		return id_artista;
	}
	public void setId_artista(int id_artista) {
		this.id_artista = id_artista;
	}
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Artista_empresa(int id_artista_empresa, int id_artista, int id_empresa, Date fecha_creacion,
			Date fecha_modificacion, String estado) {
		super();
		this.id_artista_empresa = id_artista_empresa;
		this.id_artista = id_artista;
		this.id_empresa = id_empresa;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
		this.estado = estado;
	}
	
	

}
