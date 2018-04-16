package com.polify.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.polify.controller.utility.DBUtil;
import com.polify.entity.Artista_empresa;


public class DaoArtista_Empresa {

	private Connection conexion;

	public DaoArtista_Empresa() {
		conexion = DBUtil.getConexion();
	}

	public List<Artista_empresa> getAllArtist() throws SQLException {
		List<Artista_empresa> artist_empresaList = new LinkedList<>();

		Statement stmt = conexion.createStatement();
		String sql = "SELECT * " + " FROM ARTISTA_EMPRESA ";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int id_artista_empresa = rs.getInt("ID_ARTISTA_EMPRESA");
			int id_artista = rs.getInt("ID_ARTISTA");
			int id_empresa = rs.getInt("ID_EMPRESA");
			Date fecha_creacion = rs.getDate("FECHA_CREACION");
			Date fecha_modificacion = rs.getDate("FECHA_MODIFICACION");
			String estado = rs.getString("ESTADO");

			Artista_empresa aem = new Artista_empresa(id_artista_empresa, id_artista, id_empresa, fecha_creacion, fecha_modificacion, estado);
			artist_empresaList.add(aem);
		}

		return artist_empresaList;
	}

	public void delete(int id_artista_empresa) throws SQLException {
		String sql = "DELETE FROM ARTISTA_EMPRESA WHERE ID_ARTISTA_EMPRESA='" + id_artista_empresa + "'";
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.executeUpdate();
	}

	public boolean save(int id_artista_empresa, int id_artista, int id_empresa, Date fecha_creacion, Date fecha_modificacion, String estado) throws SQLException {

	        try {
	            String sql = "INSERT INTO ARTISTA_EMPRESA ( ID_ARTISTA_EMPRESA, ID_ARTISTA, ID_EMPRESA, FECHA_CREACION, FECHA_MODIFICACION, ESTADO)"
	                    + " VALUES(USER_SEQUENCE.NEXTVAL,'" + id_artista + "','" + id_empresa + "','" + fecha_creacion + "','" + fecha_modificacion + "','" + estado + "')";

	            PreparedStatement ps = conexion.prepareStatement(sql);

	            ps.executeUpdate();
	            System.out.println("artista y empresa");

	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}
	
	 public void update(int id_artista_empresa, int id_artista, int id_empresa, Date fecha_creacion, Date fecha_modificacion, String estado) throws SQLException {
	        String sql = "UPDATE ARTISTA_EMPRESA SET ID_ARTISTA ='" + id_artista
	        		+ "ID_EMPRESA = '" + id_empresa
	        		+ "FECHA_CREACION = '" + fecha_creacion
	        		+ "FECHA_MODIFICACION = '" + fecha_modificacion
	        		+ "ESTADO = '" + estado
	                + " WHERE ID_ARTISTA_EMPRESA = '" + id_artista_empresa + "'";

	        PreparedStatement ps = conexion.prepareStatement(sql);
	        ps.executeUpdate();
	    }
}
