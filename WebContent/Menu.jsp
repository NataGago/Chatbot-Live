<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="css/style.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<nav class="navbar">

  <div class="container-fluid" style="height:130px; background-color: #f4f4f9">
    <div class="navbar-header">
      <img src="imagens/logo.png" width="200">
    </div>
      
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div style="padding-top: 5px" class="collapse navbar-collapse">
    		<ul class="nav navbar-nav navbar-right">
                <li><a href="LoginAtendente.jsp" style="color: #000"><span class="glyphicon glyphicon-log-in"></span> Área do Funcionário</a></li>
            </ul> 
    </div>
  </div>

  	<nav class="navbar navbar-inverse" style="margin-bottom: 0px; border-radius: 0px">
  		<div class="container">
  		<ul class="nav navbar-nav"">
                <li class=""><a href="Home.jsp">HOME <span class="sr-only">(current)</span></a></li>
                <!-- Dropdown Servicos --> 
                <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">SERVIÇOS ONLINE <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">REGISTRO CIVIL DE PESSOAS NATURAIS</a></li>
                        <li><a href="#">REGISTRO CIVIL DE PESSOA JURIDICA</a></li>
                        <li><a href="#">REGISTRO DE IMÓVEIS</a></li>
                        <li><a href="#">REGISTRO DE TITULOS E DOCUMENTOS</a></li>
                    </ul>
                </li>
                <!-- Dropdown Duvidas -->
        <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">PERGUNTAS FREQUENTES <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">REGISTRO CIVIL</a></li>
                        <li><a href="#">DATAS E HORÁRIOS</a></li>
                        <li><a href="#">REGISTRO DE IMÓVEIS</a></li>
                        <li><a href="#">REGISTRO DE TITULOS E DOCUMENTOS</a></li>
                    </ul>
                </li>
                <!-- End Dropdown Produtos -->
                <li><a href="#">CONTATOS</a></li>
                <li><a href="IniciarChatBot.jsp">CHATBOT</a></li>
            </ul>
         </div>   
    </nav>

</nav>
