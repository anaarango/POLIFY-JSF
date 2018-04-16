package com.polify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.polify.controller.utility.DBUtil;
import com.polify.entity.Artista;

public class DaoArtista {

	private Connection conexion;

	public DaoArtista() {
		conexion = DBUtil.getConexion();
	}

	public List<Artista> getAllArtist() throws SQLException {
		List<Artista> artistList = new LinkedList<>();

		Statement stmt = conexion.createStatement();
		String sql = "SELECT * " + " FROM TBL_ARTISTA ORDER BY ID_ARTISTA ASC ";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int id_artista = rs.getInt("ID_ARTISTA");
			String nombre = rs.getString("NOMBRE");
			int id_empresa = rs.getInt("ID_EMPRESA");
			String email = rs.getString("EMAIL");

			Artista a = new Artista(id_artista, nombre, id_empresa, email);
			artistList.add(a);
		}

		return artistList;
	}

	public void delete(int id_artista) throws SQLException {
		String sql = "DELETE FROM TBL_ARTISTA WHERE ID_ARTISTA='" + id_artista + "'";
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.executeUpdate();
	}

	public boolean save(Artista artista) throws SQLException {

	        try {
	            String sql = "INSERT INTO TBL_ARTISTA ( ID_ARTISTA ,NOMBRE, ID_EMPRESA, EMAIL)"
	                    + " VALUES(ARTISTA_ID_SEQUENCE.NEXTVAL,'" + artista.getNombre() + "','" + artista.getId_empresa() + "','" + artista.getEmail() + "')";

	            PreparedStatement ps = conexion.prepareStatement(sql);

	            ps.executeUpdate();
	            System.out.println("artista");

	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}
	
	 public void update(Artista artista) throws SQLException {
	        String sql = "UPDATE TBL_ARTISTA SET NOMBRE ='" + artista.getNombre()+"', "
	        		+ "ID_EMPRESA = '" + artista.getId_empresa()+"', "
	        		+ "EMAIL = '" + artista.getEmail()+"' "
	                + " WHERE ID_ARTISTA = '" + artista.getId_artista() + "'";

	        PreparedStatement ps = conexion.prepareStatement(sql);
	        ps.executeUpdate();
	    }
}
