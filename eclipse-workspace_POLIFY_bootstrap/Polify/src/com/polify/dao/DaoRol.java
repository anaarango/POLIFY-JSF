 package com.polify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.polify.controller.utility.DBUtil;
import com.polify.entity.Rol;


public class DaoRol {

	private Connection conexion;

	public DaoRol() {
		conexion = DBUtil.getConexion();
	}

	public List<Rol> getAllRol() throws SQLException {
		List<Rol> rolList = new LinkedList<>();

		Statement stmt = conexion.createStatement();
		String sql = "SELECT * " + " FROM ROL ";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int id_rol = rs.getInt("ID_ROL");
			String nombre = rs.getString("NOMBRE");

			Rol rol = new Rol(id_rol, nombre);
			rolList.add(rol);
		}

		return rolList;
	}

	public void delete(int id_rol) throws SQLException {
		String sql = "DELETE FROM ROL WHERE ID_ROL='" + id_rol + "'";
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.executeUpdate();
	}

	public boolean save(int id_rol, String nombre) throws SQLException {

	        try {
	            String sql = "INSERT INTO ROL ( ID_ROL ,NOMBRE)"
	                    + " VALUES(USER_SEQUENCE.NEXTVAL,'" + nombre + "')";

	            PreparedStatement ps = conexion.prepareStatement(sql);

	            ps.executeUpdate();
	            System.out.println("rol");

	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}
	
	 public void update(int id_rol, String nombre) throws SQLException {
	        String sql = "UPDATE ROL SET NOMBRE ='" + nombre 
	                + " WHERE ID_ROL = '" + id_rol + "'";

	        PreparedStatement ps = conexion.prepareStatement(sql);
	        ps.executeUpdate();
	    }
}
