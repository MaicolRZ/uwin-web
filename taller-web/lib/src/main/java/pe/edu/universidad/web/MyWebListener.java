package pe.edu.universidad.web;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import pe.edu.universidad.dao.DaoUsuario;
import pe.edu.universidad.entidades.Usuario;

@WebListener
public class MyWebListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		System.out.println("OJO: contextInitialized");
		DaoUsuario dao = new DaoUsuario();
		List<Usuario> lst = dao.consultarUsuarios();
		sce.getServletContext().setAttribute("lstUsuarios", lst);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("OJO: contextDestroyed");
	}
}
