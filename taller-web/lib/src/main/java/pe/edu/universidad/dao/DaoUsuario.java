package pe.edu.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.universidad.entidades.Usuario;

public class DaoUsuario extends DaoGenerico {

	public List<Usuario> consultarUsuarios() {
		List<Usuario> lst = new ArrayList<Usuario>();
		String sql = "select id, nombre, apell_pat, apell_mat, direccion, exp, especialidad, hora_ing, hora_sal, genero from usuarios";
		Connection cnx = getConnection();
		ResultSet rs;
		try {
			PreparedStatement stm = cnx.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApell_pat(rs.getString(3));
				u.setApell_mat(rs.getString(4));
				u.setDireccion(rs.getString(5));
				u.setExp(rs.getInt(6));
				u.setEspecialidad(rs.getString(7));
				u.setHora_ing(rs.getString(8));
				u.setHora_sal(rs.getString(9));
				u.setGenero(rs.getString(10));
				lst.add(u);
			}
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lst;
	}
	
	public void insertarUsuario(int id, String nombre,String apell_pat,String apell_mat,String direccion,int años,String  especialidad,String hora_ing,String  hora_sal, String genero) {
		String sql = "insert into usuarios(id, nombre, apell_mat, apell_pat, direccion, exp, especialidad, hora_ing, hora_sal, genero) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, id);
			stm.setString(2, nombre);
			stm.setString(3, apell_pat);
			stm.setString(4, apell_mat);
			stm.setString(5, direccion);
			stm.setInt(6, años);
			stm.setString(7, especialidad);
			stm.setString(8, hora_ing);
			stm.setString(9, hora_sal);
			stm.setString(10, genero);
			stm.execute();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Usuario> buscar(int id) {
		List<Usuario> lista=new ArrayList<>();
		 String sql="select nombre, apell_pat, apell_mat, direccion, exp, especialidad, hora_ing, hora_sal, genero from usuarios where id=75175899";
		 ResultSet rs;
         try {
        Connection cnx = getConnection();
        PreparedStatement ps=cnx.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
            	Usuario tec=new Usuario();
            	 
            	 tec.setNombre(rs.getString(1));
                 tec.setApell_pat(rs.getString(2));
                 tec.setApell_mat(rs.getString(3));
                 tec.setDireccion(rs.getString(4));
                 tec.setExp(rs.getInt(5));
                 tec.setEspecialidad(rs.getString(6));
                 tec.setHora_ing(rs.getString(7));
                 tec.setHora_sal(rs.getString(8));
                 tec.setGenero(rs.getString(9));
            }
		
	 } catch (Exception e) {
     }
      return lista;
	}


	

	
	//Eliminar
	
	public void eliminarUsuario(int id) {
		String sql = "delete from usuarios where id= ?";
		Connection cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			PreparedStatement stm = cnx.prepareStatement(sql);
			stm.setInt(1, id);
			stm.execute();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//Editar
	public void editarUsuario(int id, String nombre,String apell_pat,String apell_mat,String direccion,int años,String  especialidad,String hora_ing,String  hora_sal, String genero) {
		String sql = "update usuarios set nombre=?, apell_pat=?, apell_mat=?, direccion=?, exp=?, especialidad=?, hora_ing=?, hora_sal=?, genero=? where id=?";
		Connection cnx = getConnection();
		try {
			cnx.setAutoCommit(false);
			PreparedStatement stm = cnx.prepareStatement(sql);
			
			stm.setString(1, nombre);
			stm.setString(2, apell_pat);
			stm.setString(3, apell_mat);
			stm.setString(4, direccion);
			stm.setInt(5, años);
			stm.setString(6, especialidad);
			stm.setString(7, hora_ing);
			stm.setString(8, hora_sal);
			stm.setString(9, genero);
			stm.setInt(10, id);
			stm.execute();
			cnx.commit();
			cnx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
}
