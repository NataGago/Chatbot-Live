<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="pt-br">
<link href="css/stylechat.css" rel="stylesheet">
<head>
<title>cartorio.biz - ChatBot</title>
</head>

<body class="animsition">
<c:import url="Menu2.jsp" />

	<div class="page-wrapper"> 
    	<!-- PAGE CONTAINER-->
        <div class="page-container">
		<!-- MAIN CONTENT-->
        <div class="main-content">
                <div id="chat" class="container">
    <div class="row">
        <div class="col-md-12 col-xl-">
            <div class="panel panel-primary">
                <div class="panel-heading" id="accordion">
                    <span class="glyphicon glyphicon-comment"></span> Protocólo de Atendimento ${atendimento.id }
                </div>
            
                <div class="panel-body">
                    <ul class="chat">
                    	<c:forEach var="historico" items="${conversa.exibirConversa(atendimento.id)}">
                    	
                    	<c:if test="${historico.user == 1 }">
                    	<li class="left clearfix"><span class="chat-img pull-left">
                            <img src="images/user-profile.jpg" alt="User Avatar" class="img-circle" />
                            </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <strong class="primary-font">${historico.pessoa } </strong> <small class="pull-right text-muted">
                                        <span class="glyphicon glyphicon-time"></span>${historico.hora }</small>
                                </div>
                                <p>
                                    ${historico.texto }
                                </p>
                            </div>
                        </li>
                        
                        </c:if>
                        
                        
                       <c:if test="${historico.user == 2 }">
                        <li class="right clearfix"><span class="chat-img pull-right">
                            <img src="images/adm-profile.jpg" alt="User Avatar" class="img-circle" />
                             </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <small class=" text-muted"><span class="glyphicon glyphicon-time"></span>${historico.hora }</small>
                                    <strong class="pull-right primary-font">${historico.pessoa }</strong>
                                </div>
                                <p>
                                    ${historico.texto }
                                </p>
                            </div>
                        </li>
                        
                        </c:if>
                        
                        <c:if test="${historico.user == 3 }">
                        <li class="right clearfix"><span class="chat-img pull-right">
                            <img src="images/bot-profile.jpg" alt="User Avatar" class="img-circle" />
                             </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <small class=" text-muted"><span class="glyphicon glyphicon-time"></span>${historico.hora }</small>
                                    <strong class="pull-right primary-font">${historico.pessoa }</strong>
                                </div>
                                <p>
                                    ${historico.texto }
                                </p>
                            </div>
                        </li>
                        
                        </c:if> 
                        </c:forEach>
                    </ul>
                </div>
                <form action="controller.do" method="post">
                <div class="panel-footer">
                    <div id="actions" class="input-group">
                        <input id="btn-input" type="text" name="resposta" id="resposta"class="form-control input-sm" placeholder="Digite sua mensagem aqui..." />
                        <span class="input-group-btn">
                            <button type="submit" style="margin-left: 5px" class="btn btn-primary" name="command" value="ResponderCliente">Enviar</button>
                        </span>
                        <span class="input-group-btn">
                        	<button type="submit" class="btn btn-danger btn-sm" style="margin-left: 5px" name="command" value="FinalizarAtendimentoChatAtendente">Finalizar</button>
                        </span>
                    </div>
                </div>
            	</form>
            </div>
        </div>
    </div>
</div>
            </div>
        </div>
    </div>
</body>

</html>