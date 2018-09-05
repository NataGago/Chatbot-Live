<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>cartorio.biz - ChatBot</title>
 	<meta http-equiv="refresh" content="50" >
</head>

<body>
<c:import url="Menu.jsp"/>

<div id="chat" class="container">
    <div class="row">
        <div class="col-md-12 col-xl-">
            <div class="panel panel-primary">
                <div class="panel-heading" id="accordion">
                    <span class="glyphicon glyphicon-comment"></span> Protocólo de Atendimento ${atendimento.id }
                </div>
            
                <div class="panel-body" style="min-height: 150px">
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
                        <input id="btn-input" type="text" name="pergunta" id="pergunta"class="form-control input-sm" placeholder="Type your message here..." />
                        <span class="input-group-btn">
                            <button type="submit" class="btn btn-primary" name="command" value="ResponderPergunta">Enviar</button> 
                        </span>
                         <span class="input-group-btn">
                            <button type="submit" class="btn btn-danger" name="command" value="FinalizarAtendimento">Finalizar</button>
                        </span>
                    </div>
                </div>
            	</form>
            </div>
        </div>
    </div>
</div>

	<c:import url="Footer.jsp"/>
</body>

</html>