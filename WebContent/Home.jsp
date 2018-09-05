<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>cartorio.biz - Home</title>
</head>

<body>
<c:import url="Menu.jsp" />

<!-- banner -->	
<div id="banner" class="container">
	<img src="images/banner01.jpg" class="img-responsive" alt="Cartório">
</div>
	<div class="container">
		<div class="row">
        <div class="col-sm-8">
          <h2 class="mt-4">Quem Somos</h2>
          <p>Somos uma rede de cartórios localizado na Universidade São Judas Tadeu,
          com o proposito de ajudar as pessoas disponibilizamos em nosso site uma 
          forma prática de conseguir suas informações sem muitas dificuldades, alem de poder
          contar com o nosso chat automático para retirada de dúvidas e caso não seja o suficiente
          um de nossos atendentes entrará em contato, também podemos ser encontrado em nosso endereço.</p>
          
        </div>
        <div class="col-sm-4">
          <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3657.458960658051!2d-46.59979814915009!3d-23.551954367055604!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9371b05154fa2b95%3A0x6187fb9a20469948!2sUniversidade+S%C3%A3o+Judas+Tadeu!5e0!3m2!1spt-BR!2sbr!4v1529293724386" 
          width="290" height="260" frameborder="0" style="border:0" allowfullscreen></iframe>
        </div>
      </div>
      <div class="row">
        <div class="row text-center">

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="images/natural.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Registro Civil de Pessoa Natural</h4>
              <p class="card-text">Dúvidas sobre certidões de casamento, nascimento e óbito podem ser retiradas aqui, marque sua visita diretamente no site.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Saiba Mais</a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="images/juridica.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Registro Civil de Pessoa Jurídica</h4>
              <p class="card-text">Contate nossos serviços online para certidões, remessa legal, contratos e documentos eletronicos, marque sua consulta direto na página.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Saiba Mais</a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="images/imoveis.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Registro de Imóveis</h4>
              <p class="card-text">Marque seu acompanhamento e realiza sua matrícula registral online através do nosso site e realize seu cadastro de regularização.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Saiba Mais</a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4">
          <div class="card">
            <img class="card-img-top" src="images/trumpzera.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Registro de Fronteiras</h4>
              <p class="card-text">Fuja do Trump! Realize agora a retirada de seus documentos e viaje sem a necessidade de pular o muro</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Saiba Mais</a>
            </div>
          </div>
        </div>

      </div>
      </div>
      </div>
      
	<c:import url="Footer.jsp"/>
</body>

</html>