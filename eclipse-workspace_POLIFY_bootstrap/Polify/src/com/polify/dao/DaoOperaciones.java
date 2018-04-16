 package com.polify.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import com.polify.controller.utility.DBUtil;
import com.polify.entity.Operaciones;


public class DaoOperaciones {
	
	private Connection conexion;

	public DaoOperaciones() {
		conexion = DBUtil.getConexion();
	}

	public List<Operaciones> getAllOperaciones() throws SQLException {
		List<Operaciones> operacionesList = new LinkedList<>();

		Statement stmt = conexion.createStatement();
		String sql = "SELECT * " + " FROM OPERACIONES ";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			int id_operaciones = rs.getInt("ID_OPERACIONES");
			String operaciones = rs.getString("OPERACIONES");
			int id_artista_empresa = rs.getInt ("ID_ARTISTA_EMPRESA");
			Date fecha_creacion = rs.getDate("FECHA_CREACION");

			Operaciones op = new Operaciones(id_operaciones, operaciones, id_artista_empresa, fecha_creacion);
			operacionesList.add(op);
		}

		return operacionesList;
	}

	public void delete(int id_operaciones) throws SQLException {
		String sql = "DELETE FROM OPERACIONES WHERE ID_OPERACIONES='" + id_operaciones + "'";
		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.executeUpdate();
	}

	public boolean save(int id_operaciones, String operaciones, int id_artista_empresa, Date fecha_creacion) throws SQLException {

	        try {
	            String sql = "INSERT INTO OPERACIONES ( ID_OPERACIONES ,OPERACIONES, ID_ARTISTA_EMPRESA, FECHA_CREACION)"
	                    + " VALUES(USER_SEQUENCE.NEXTVAL,'" + operaciones + "','" + id_artista_empresa + "','" + fecha_creacion + "')";

	            PreparedStatement ps = conexion.prepareStatement(sql);

	            ps.executeUpdate();
	            System.out.println("operaciones");

	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}
	
	 public void update(int id_operaciones, String operaciones, int id_artista_empresa, Date fecha_creacion) throws SQLException {
	        String sql = "UPDATE OPERACIONES SET OPERACIONES ='" + operaciones +  "', "
	        		+ "ID_ARTISTA_EMPRESA = '"+ id_artista_empresa + "',"
	        		+ "FECHA_CREACION = '" + fecha_creacion + "',"
	                + " WHERE ID_OPERACIONES = '" + id_operaciones + "'";

	        PreparedStatement ps = conexion.prepareStatement(sql);
	        ps.executeUpdate();
	    }

}
