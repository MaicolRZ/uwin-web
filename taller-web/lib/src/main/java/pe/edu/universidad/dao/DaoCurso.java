package pe.edu.universidad.dao;

import java.sql.Connection;   
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.dto.DtoCursoConsulta;
import pe.edu.universidad.entidades.Curso;


public class DaoCurso extends DaoGenerico {

	public List<Curso> consultarCursosPorNombre(String cadena) {
		List<Curso> lst = new ArrayList<Curso>();
		Curso c = null;
		String sql = "select id, nombre, creditos, horas_teoria, horas_practica, horas_lab from cursos where nombre like ?";
		Connection cnx = getConnection();
		ResultSet rs;
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setString(1, cadena);
			rs = stm.executeQuery();
			while (rs.next()) {
				c = new Curso();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setCreditos(rs.getInt(3));
				c.setHorasTeoria(rs.getInt(4));
				c.setHorasPractica(rs.getInt(5));
				c.setHorasLaboratorio(rs.getInt(6));
				lst.add(c);
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	public Curso consultarCursoPorId(int id) {
		Curso c = null;
		String sql = "select id, nombre, creditos, horas_teoria, horas_practica, horas_lab from cursos where id = ?";
		Connection cnx = getConnection();
		ResultSet rs;
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			if (rs.next()) {
				c = new Curso();
				c.setId(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setCreditos(rs.getInt(3));
				c.setHorasTeoria(rs.getInt(4));
				c.setHorasPractica(rs.getInt(5));
				c.setHorasLaboratorio(rs.getInt(6));
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return c;
	}
	
	public List<Curso> consultarCursos() {
		List<Curso> lst = new ArrayList<>();
		String sql = "select id, nombre, creditos, horas_teoria, horas_practica, horas_lab from cursos";
		Connection cnx = getConnection();
		ResultSet rs;
		PreparedStatement stm = null;
		try {
			stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Curso u = new Curso();
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setCreditos(rs.getInt(3));
				u.setHorasTeoria(rs.getInt(4));
				u.setHorasPractica(rs.getInt(5));
				u.setHorasLaboratorio(rs.getInt(6));
				lst.add(u);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				stm.close();
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
	public void insertarCurso(Curso cursoNuevo) {
		String sql = "insert into cursos(id, nombre, creditos, horas_teoria, horas_practica, horas_lab) values (?, ?, ?, ?, ?, ?)";
		Connection cnx = getConnection();
		try {
			//cnx.setAutoCommit(false);
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, cursoNuevo.getId());
			stm.setString(2, cursoNuevo.getNombre());
			stm.setInt(3, cursoNuevo.getCreditos());
			stm.setInt(4, cursoNuevo.getHorasTeoria());
			stm.setInt(5, cursoNuevo.getHorasPractica());
			stm.setInt(6, cursoNuevo.getHorasLaboratorio());
			stm.execute();
			//cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<DtoCursoConsulta> consultarCursoConsultaPorNombre(String cadena) {
		List<DtoCursoConsulta> lst = new ArrayList<>();
		String sql = "select id, nombre, horas_teoria+horas_practica+horas_lab from cursos where nombre like ?";
		Connection cnx = getConnection();
		ResultSet rs;
		PreparedStatement stm = null;
		try {
			stm = cnx.prepareStatement(sql);
			stm.setString(1, cadena);
			rs = stm.executeQuery();
			while (rs.next()) {
				DtoCursoConsulta u = new DtoCursoConsulta();
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setCantidadHoras(rs.getInt(3));
				lst.add(u);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				stm.close();
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
}
