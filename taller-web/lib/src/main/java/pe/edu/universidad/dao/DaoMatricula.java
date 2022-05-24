package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import pe.edu.universidad.dto.DtoCursoConsulta;
import pe.edu.universidad.dto.DtoEstudianteMatricula;

public class DaoMatricula extends DaoGenerico {

	public void insertarMatriculas(DtoEstudianteMatricula dto, List<DtoCursoConsulta> lst) {
		String sql = "insert into matriculas(estudiante_id, curso_id) values (?, ?)";
		Connection cnx = getConnection();
		try {
			for (DtoCursoConsulta dtoCursoConsulta : lst) {
				PreparedStatement stm = cnx.prepareStatement(sql);
				stm.setInt(1, dto.getId());
				stm.setInt(2, dtoCursoConsulta.getId());
				stm.execute();
			}
			cnx.close(); 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
