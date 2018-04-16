package com.polify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.polify.controller.utility.DBUtil;
import com.polify.entity.Empresa;

public class DaoEmpresa {

	private Connection conexion;

	public DaoEmpresa() {
		conexion = DBUtil.getConexion();
	}

	public List<Empresa> getAllEmpresas() throws SQLException {
		List<Empresa> empresaList = new LinkedList<>();

		Statement stmt = conexion.createStatement();
		String sql = "SELECT * " + " FROM EMPRESA ";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int id_empresa = rs.getInt("ID_EMPRESA");
			String nombre = rs.getString("NOMBRE");
			String email =rs.getString("EMAIL");
			int valor_operacion = rs.getInt ("VALOR_OPERACION");

			Empresa em = new Empresa(id_empresa, nombre, email, valor_operacion);
			empresaList.add(em);
		}

		return empresaList;
	}

	public void delete(int id_empresa) throws SQLException {
		String sql = "DELETE FROM EMPRESA WHERE ID_EMPRESA='" + id_empresa + "'";
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.executeUpdate();
	}

	public boolean save(int id_empresa, String nombre, String email, int valor_operacion) throws SQLException {

	        try {
	            String sql = "INSERT INTO EMPRESA ( ID_ARTISTA ,NOMBRE, VALOR_OPERACION)"
	                    + " VALUES(EMPRESA_ID_SEQUENCE.NEXTVAL,'" + nombre + "','" + email + "','" + valor_operacion + "' )";

	            PreparedStatement ps = conexion.prepareStatement(sql);

	            ps.executeUpdate();
	            System.out.println("empresa");

	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}
	
	 public void update(int id_empresa, String nombre, String email, int valor_operacion) throws SQLException {
	        String sql = "UPDATE EMPRESA SET NOMBRE ='" + nombre  + "' , "
	                + "EMAIL = '" + email + "', "
	                 + "VALOR_OPERACION = '" + valor_operacion + "'"
	                + " WHERE ID_EMPRESA = '" + id_empresa + "'";

	        PreparedStatement ps = conexion.prepareStatement(sql);
	        ps.executeUpdate();
	    }
	
	
}
