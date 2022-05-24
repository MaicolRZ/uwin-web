<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/main.css">
</head>
<body class="cover" style="background-image: url(./assets/img/fondo.jpg);">
	</br></br>
	<h2>BIENVENIDOS A TALLER UTP</h2>

	<form action="home.jsp" method="" autocomplete="off" class="full-box logInForm">
		<p class="text-center text-muted"><i class="zmdi zmdi-account-circle zmdi-hc-5x"></i></p>
		<p class="text-center text-muted text-uppercase">Inicia sesi�n con tu cuenta</p>
		<div class="form-group label-floating">
		  <label class="control-label" for="UserEmail">E-mail</label>
		  <input style="color:white; " class="form-control" id="UserEmail" type="email">
		  <p class="help-block">Escribe t� E-mail</p>
		</div>
		<div class="form-group label-floating">
		  <label class="control-label" for="UserPass">Contrase�a</label>
		  <input style="color:white; " class="form-control" id="UserPass" type="text">
		  <p class="help-block">Escribe t� contrase�a</p>
		</div>
		<div class="form-group text-center">
			<input type="submit" value="Iniciar sesi�n" class="btn btn-raised btn-danger">
		</div>
		<div class="form-group text-center">
		<input type="radio" name="cliente" id="cliente">
		<label for="cliente">Cliente</label>
		<input type="radio" name="cliente" id="cliente">
		<label for="cliente">Administrador</label>
		</div>

		</div>
		<div class="form-group text-center">
		<p class="text-center text-muted text-uppercase">No tienes cuenta? Registrate</p>
		<input type="registrar" value="Registrarme" class="btn btn-raised btn-danger">
		</div>
	</form>
	<!--====== Scripts -->
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/material.min.js"></script>
	<script src="./js/ripples.min.js"></script>
	<script src="./js/sweetalert2.min.js"></script>
	<script src="./js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="./js/main.js"></script>
	<script>
		$.material.init();
	</script>
</body>
</html>