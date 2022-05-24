<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %>
<link rel="stylesheet" href="./css/main.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="pe.edu.universidad.dao.*"%>
<%@ page import="pe.edu.universidad.entidades.*"%>
<%@ page import="pe.edu.universidad.servlet.*"%>
	<%@ page import="java.util.List"%>
<%
DaoUsuario dao = new DaoUsuario();
List<Usuario> lst = dao.consultarUsuarios();
%>
	
	<!-- Content page-->
	<section class="full-box dashboard-contentPage">
		<!-- NavBar -->
		<nav class="full-box dashboard-Navbar">
			<ul class="full-box list-unstyled text-right">
				<li class="pull-left">
					<a href="#!" class="btn-menu-dashboard"><i class="zmdi zmdi-more-vert"></i></a>
				</li>
				<li>
					<a href="#!" class="btn-Notifications-area">
						<i class="zmdi zmdi-notifications-none"></i>
						<span class="badge">7</span>
					</a>
				</li>
				<li>
					<a href="#!" class="btn-search">
						<i class="zmdi zmdi-search"></i>
					</a>
				</li>
				<li>
					<a href="#!" class="btn-modal-help">
						<i class="zmdi zmdi-help-outline"></i>
					</a>
				</li>
			</ul>
		</nav>
<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-male-alt zmdi-hc-fw"></i>Usuarios<small>Tecnicos</small></h1>
			</div>
			<p class="lead">Permite Registrar nuevo tecnico y tambien ver la lista de registros para poder editar o eliminar</p>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					  	<li class="active"><a href="#new" data-toggle="tab">Nuevo</a></li>
					  	<li><a href="#list" data-toggle="tab">Lista</a></li>
					</ul>

					<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade active in" id="new">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									    <form action="<%=request.getContextPath() %>/ServletPostUsuarioNuevo" method="post">
									   	 	<div class="form-group label-floating">
											  <label class="control-label">Dni</label>
											  <input class="form-control" type="text" name ="id">
											</div>
									    	<div class="form-group label-floating">
											  <label class="control-label">Nombre</label>
											  <input class="form-control" type="text" name ="nombre">
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Apellido Paterno</label>
											  <input class="form-control" type="text" name ="apell_pat">
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Apellido Materno</label>
											  <input class="form-control" type="text" name ="apell_mat">
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Direccion</label>
											  <input class="form-control" type="text" name ="direccion">
											</div>
											
											<div class="form-group label-floating">
											  <label class="control-label">Años Experiencia</label>
											  <textarea class="form-control" name ="años"></textarea>
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Especialidad</label>
											  <input class="form-control" type="text" name ="especialidad">
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Telefono</label>
											  <input class="form-control" type="text" name ="telefono">
											</div>
											
											<div class="form-group">
											  <label class="control-label">Horario</label>
											  <input class="form-control" type="time" name="hora_ing">
											  <input class="form-control" type="time" name="hora_sal">
											</div>
											<div class="form-group">
										        <label class="control-label">Genero</label>
										        <select class="form-control" name="genero">
										          <option>Masculino</option>
										          <option>Femenino<option>
										        </select>
										    </div>
											
										    <!-- Icono Guardar Tecnico-->
										    <p class="text-center">
										    	<button name="Registrar"  class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Registrar</button>
										    </p>
									    </form>
									</div>
								</div>
							</div>
						</div>
						<!-- Lista de Tecnicos-->
						
						
						
					  	<div class="tab-pane fade" id="list">
							<div class="table-responsive">
								
								<table class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">DNI</th>
											<th class="text-center">Nombre</th>
											<th class="text-center">Apellido Paterno</th>
											<th class="text-center">Apellido Materno</th>
											<th class="text-center">Direccion</th>
											<th class="text-center">Experiencia</th>
											<th class="text-center">Especialidad</th>
											<th class="text-center">Hora Ing</th>
											<th class="text-center">Hora Sal</th>
											<th class="text-center">Genero</th>
											<th class="text-center">Editar</th>
											<th class="text-center">Borrar</th>
										</tr>
									</thead>
									<tbody>

											<%
											for (Usuario u : lst) {
											%>
											
											<tr>
											<td><%=u.getId()%></td>
											<td><%=u.getNombre()%></td>
											<td><%=u.getApell_pat()%></td>
											<td><%=u.getApell_mat()%></td>
											<td><%=u.getDireccion()%></td>
											<td><%=u.getExp()%></td>
											<td><%=u.getEspecialidad()%></td>
											<td><%=u.getHora_ing()%></td>
											<td><%=u.getHora_sal()%></td>
											<td><%=u.getGenero()%></td>
											
											<td><a href="jsp-servlet/servletPostUsuarioEditar.jsp?id=<%=u.getId()%>"  class=" btn-raised btn-xs" ><i class="zmdi zmdi-edit"></i></a></td>
								  			
								  			<td><a href="jsp-servlet/servletPostUsuarioEliminar.jsp?id=<%=u.getId()%>" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a></td>
								  		
											<%
											}
											
											%>
										
											
									</tbody>
								</table>

								
								<ul class="pagination pagination-sm">
								  	<li class="disabled"><a href="#!">«</a></li>
								  	<li class="active"><a href="#!">1</a></li>
								  	<li><a href="#!">2</a></li>
								  	<li><a href="#!">3</a></li>
								  	<li><a href="#!">4</a></li>
								  	<li><a href="#!">5</a></li>
								  	<li><a href="#!">»</a></li>
								</ul>
							</div>
					  	</div>
					  	
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>