<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>Glucomed</title>
		<meta name="viewport" content="width=device-width; initial-scale=1.0; user-scalable=no" />
		<link rel="stylesheet" type="text/css" href="css/login-register.css" />
		<link rel='stylesheet' href='css/dashboardStyle.css' media='none'/>
	</head>

	<body>

		<section class="container">
		
			<div class="login">
			
				<h1>GLUCOMED</h1>
				<h2>Sistema de medición de glucosa</h2>
				<h3>Credenciales</h3>
				
				<form method="post" action="login">
				
					<p class="input-titulo"><input type="text" name="email" value="" placeholder="E-Mail"></p>
					<p class="input-titulo"><input type="password" name="password" value="" placeholder="Contraseña"></p>
					<p class="login-forgot">
					<label><input type="checkbox" name="recordar" id="remember_me">Recordar mis datos en este navegador</label>
					</p>
						
						<p class="login-forgot" style="font-size:18px; font-family:Arial; font-weight:bold; color:#ff0000;"> 
						<c:out value = "${error_code_login}" /> 
						</p>
					
					<p class="submit"><input type="submit" name="commit" value="Aceptar"></p>
					<p class="registro"><input type="button" name="registro" value="Registro" onClick="location.href='/registro'" ></p>
					<p class="login-forgot"> <a href="">He olvidado la contraseña</a> </p>
				</form>
				
			</div>
		
			
		</section>
		
		
		
		<section class="about">
			<p class="about-author">
			&copy; 2015&ndash;2016 <a>ISST-Grupo 14</a>
		</section>
		
	</body>

</html>
