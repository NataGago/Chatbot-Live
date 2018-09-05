<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>cartorio.biz - Atendimentos</title>
</head>

<body>
<c:import url="Menu.jsp" />

<section id="chatbot" class="container">
    <div class="row">
        <div class="panel panel-default">
          <div class="panel-body">
            <div class="container">
           <h2>Protocolo de atendimento# ${atendimento.id}</h2>
           <c:forEach var="pergunta" items="${perguntas}">
                <div class="row message-bubble">
                <p class="text-muted">Cliente</p>
                    <p>${pergunta.pergunta}</p>
                </div>
                </c:forEach>
                 <c:forEach var="resposta" items="${respostas}">
                <div class="row message-bubble">
                <p class="text-muted">Chatbot</p>
                    <p>${resposta.resposta}</p>
                </div>
                </c:forEach>
            </div>
            <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="per"></label>
                    <input type="text" class="form-control" name="resposta" id="resposta" required maxlength="130" placeholder="Digite sua resposta">
                    <br>
                </div>
            </div>
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="ResponderCliente">Enviar</button>
                    <a href="Home.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
          </div>
        </div>
    </div>
</section>
</body>

<c:import url="Footer.jsp" />
</html>