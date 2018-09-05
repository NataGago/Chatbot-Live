<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="pt-br">

<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cartorio.biz - Iniciar ChatBot</title>
</head>

<body>
<c:import url="Menu.jsp" />
	
<section id="matendente" class="container">
	<div id="main" class="container">
		<h3 class="page-header">Iniciar ChatBot</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-4">
					<label for="nome">Nome</label><input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="Nome Completo">
				</div>
				<div class="form-group col-md-4">
					<label for="email">E-mail</label><input type="email" class="form-control" name="email" id="email" maxlength="100" placeholder="E-mail">
				</div>
			</div>
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command" value="IniciarChat">Iniciar</button>
					<a href="Home.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
</section>
</body>

	<c:import url="Footer.jsp"/>
</html>