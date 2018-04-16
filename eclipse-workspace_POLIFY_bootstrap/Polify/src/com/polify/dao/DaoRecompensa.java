package com.polify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.polify.controller.utility.DBUtil;
import com.polify.entity.Recompensa;

public class DaoRecompensa {
	
	private Connection conexion;

	public DaoRecompensa() {
		conexion = DBUtil.getConexion();
	}

	public List<Recompensa> getAllRecompensa() throws SQLException {
		List<Recompensa> recompensaList = new LinkedList<>();

		Statement stmt = conexion.createStatement();
		String sql = "SELECT * " + " FROM RECOMPENSA ";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int id_recompensa = rs.getInt("ID_RECOMPENSA");
			String nombre = rs.getString("NOMBRE");

			Recompensa re = new Recompensa(id_recompensa, nombre);
			recompensaList.add(re);
		}

		return recompensaList;
	}

	public void delete(int id_recompensa) throws SQLException {
		String sql = "DELETE FROM RECOMPENSA WHERE ID_RECOMPENSA='" + id_recompensa + "'";
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.executeUpdate();
	}

	public boolean save(int id_recompensa, String nombre) throws SQLException {

	        try {
	            String sql = "INSERT INTO RECOMPENSA ( ID_RECOMPENSA ,NOMBRE)"
	                    + " VALUES(USER_SEQUENCE.NEXTVAL,'" + nombre + "')";

	            PreparedStatement ps = conexion.prepareStatement(sql);

	            ps.executeUpdate();
	            System.out.println("recompensa");

	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}
	
	 public void update(int id_recompensa, String nombre) throws SQLException {
	        String sql = "UPDATE RECOMPENSA SET NOMBRE ='" + nombre 
	                + " WHERE ID_RECOMPENSA = '" + id_recompensa + "'";

	        PreparedStatement ps = conexion.prepareStatement(sql);
	        ps.executeUpdate();
	    }

}
