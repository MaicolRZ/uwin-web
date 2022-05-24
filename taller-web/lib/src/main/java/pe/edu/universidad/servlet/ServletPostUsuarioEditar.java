package pe.edu.universidad.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.universidad.dao.DaoUsuario;

@WebServlet("/ServletPostUsuarioEditar")
public class ServletPostUsuarioEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletPostUsuarioEditar() {
        super();
    }
// crear nuevo usuario tecnico
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apell_pat=request.getParameter("apell_pat");
		String apell_mat=request.getParameter("apell_mat");
		String direccion=request.getParameter("direccion");
		String a�os=request.getParameter("a�os");
		String especialidad=request.getParameter("especialidad");
		String hora_ing=request.getParameter("hora_ing");
		String hora_sal=request.getParameter("hora_sal");
		String genero=request.getParameter("genero");
		DaoUsuario dao = new DaoUsuario();
		dao.editarUsuario(Integer.parseInt(id), nombre, apell_pat, apell_mat,direccion,Integer.parseInt(a�os), especialidad, hora_ing, hora_sal, genero);
		
		RequestDispatcher rd;
		rd=request.getRequestDispatcher("tecnico.jsp");
		rd.forward(request, response);
		
	}
	

}
