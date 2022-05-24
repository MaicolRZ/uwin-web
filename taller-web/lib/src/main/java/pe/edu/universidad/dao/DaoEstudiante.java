package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.dto.DtoEstudianteConsulta;
import pe.edu.universidad.dto.DtoEstudianteMatricula;


public class DaoEstudiante extends DaoGenerico {

	public List<DtoEstudianteConsulta> consultarEstudiantePorNombre(String cadena) {
		List<DtoEstudianteConsulta> lst = new ArrayList<DtoEstudianteConsulta>();
		DtoEstudianteConsulta c = null;
		String sql = "select id, nombres || ' ' || apellido_paterno || ' ' || apellido_materno from estudiantes where (nombres || ' ' || apellido_paterno || ' ' || apellido_materno) like ?";
		Connection cnx = getConnection();
		ResultSet rs;
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setString(1, cadena);
			rs = stm.executeQuery();
			while (rs.next()) {
				c = new DtoEstudianteConsulta();
				c.setId(rs.getInt(1));
				c.setNombreCompleto(rs.getString(2));
				lst.add(c);
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}

	public DtoEstudianteMatricula consultarEstudiantePorId(int idestudiante) {
		DtoEstudianteMatricula dto = null;
		String sql = "select id, nombres || ' ' || apellido_paterno || ' ' || apellido_materno, email from estudiantes where id = ?";
		Connection cnx = getConnection();
		ResultSet rs;
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, idestudiante);
			rs = stm.executeQuery();
			if (rs.next()) {
				dto = new DtoEstudianteMatricula();
				dto.setId(rs.getInt(1));
				dto.setNombreCompleto(rs.getString(2));
				dto.setEmail(rs.getString(3));
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return dto;
	}
	
		
}
