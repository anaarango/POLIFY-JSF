package com.polify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.polify.controller.utility.DBUtil;
import com.polify.entity.Usuario;


public class DaoUsuario {
	
	private Connection conexion;

	public DaoUsuario() {
		conexion = DBUtil.getConexion();
	}

	public List<Usuario> getAllUser() throws SQLException {
		List<Usuario> userList = new LinkedList<>();

		Statement stmt = conexion.createStatement();
		String sql = "SELECT * " + " FROM USUARIO ";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int id_usuario = rs.getInt("ID_USUARIO");
			int id_rol = rs.getInt("ID_ROL");
			String nombre = rs.getString("NOMBRE");

			Usuario u = new Usuario(id_usuario, id_rol, nombre);
			userList.add(u);
		}

		return userList;
	}

	public void delete(int id_usuario) throws SQLException {
		String sql = "DELETE FROM USUARIO WHERE ID_USUARIO='" + id_usuario + "'";
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.executeUpdate();
	}

	public boolean save(int id_usuario, int id_rol, String nombre) throws SQLException {

	        try {
	            String sql = "INSERT INTO USUARIO ( ID_USUARIO, ID_ROL, NOMBRE)"
	                    + " VALUES(USER_SEQUENCE.NEXTVAL,'" + id_rol + "','" + nombre + "')";

	            PreparedStatement ps = conexion.prepareStatement(sql);

	            ps.executeUpdate();
	            System.out.println("usuario");

	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}
	
	 public void update(int id_usuario, int id_rol, String nombre) throws SQLException {
	        String sql = "UPDATE USUARIO SET NOMBRE ='" + nombre
	        		+ "ID_ROL = '" + id_rol
	                + " WHERE ID_USUARIO = '" + id_usuario + "'";

	        PreparedStatement ps = conexion.prepareStatement(sql);
	        ps.executeUpdate();
	    }

}
