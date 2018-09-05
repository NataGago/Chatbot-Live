<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Buscar Atendimento</title>
    <link href="css/style.css" rel="stylesheet">
</head>

<body>

<section id="areadofuncionario" class="container">
<c:import url="Menu2.jsp"/>

<div id="main" class="container-fluid">
	 <form action="controller.do" method="post">
        <div id="top" class="row">
            <div class="col-md-3">
                <h2>Palavra-Chave</h2>
            </div>
	 		<div class="col-md-6">
            	<div class="input-group h2">
                	<input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Palavra-Chave (deixe vazio para trazer todos)">
                	<span class="input-group-btn">
	 					<button class="btn btn-primary" type="submit" name="command" value="ListarPalavraChaveBuscar"><span class="glyphicon glyphicon-search"></span></button>
                    </span>
                </div>
            </div>
	 		<div class="col-md-2">
            	<a href="CriarPalavraChave.jsp" class="btn btn-primary pull-right h2">Criar</a>
            </div>
    	</div>
     </form>
<!-------------------------------------------------- PALAVRA CHAVE --------------------------------------------------------------->       
<c:if test="${not empty palavraChave}">
	<div id="list" class="row">
    	<div class="table-responsive col-md-12">
        	<table class="table table-striped table-dark" cellspacing="0" cellpadding="0">
        		<thead>
                	<tr>
                    	<th>ID</th>
                        <th>Palavra-Chave</th>
                        <th class="actions">Ações</th>
                    </tr>
                </thead>
                	<tbody>
						<c:forEach var="atendimento" items="${palavraChave }">
                        	<tr>
                            	<td>
                                	${palavraChave.id }
                                </td>
                                <td>
                                	${palavraChave.palavraChave }
                                </td>
                            </tr>             
                        </c:forEach>
					</tbody>
            </table>
        </div>
   </div>

	<div id="bottom" class="row">
    	<div class="col-md-12">
        	<ul class="pagination">
            	<li class="disabled"><a>&lt; Anterior</a></li>
                <li class="disabled"><a>1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
            </ul>

        </div>
    </div>
</c:if>
</div>
<!-- -------------------------------------------------------------------------------------------------------------------------->
<!------------------------------------------------------------Ligacoes--------------------------------------------------------->
<div id="main" class="container-fluid">
	 <form action="controller.do" method="post">
        <div id="top" class="row">
            <div class="col-md-3">
                <h2>Ligações</h2>
            </div>
	 		<div class="col-md-6">
            	<div class="input-group h2">
                	<input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Ligações (deixe vazio para trazer todos)">
                	<span class="input-group-btn">
	 					<button class="btn btn-primary" type="submit" name="command" value="ListarLigacoesBuscar"><span class="glyphicon glyphicon-search"></span></button>
                    </span>
                </div>
            </div>
	 		<div class="col-md-2">
            	<a href="CriarLigacao.jsp" class="btn btn-primary pull-right h2">Criar</a>
            </div>
    	</div>
     </form>
        
<c:if test="${not empty palavraChave}">
	<div id="list" class="row">
    	<div class="table-responsive col-md-12">
        	<table class="table table-striped table-dark" cellspacing="0" cellpadding="0">
        		<thead>
                	<tr>
                    	<th>EXEMPLO</th>
                        <th>EXEMPLO</th>
                       <!--   <th class="actions">Ações</th>  -->
                    </tr>
                </thead>
                	<tbody>
						<c:forEach var="ligacao" items="${ligacao }">
                        	<tr>
                            	<td>
                                	${ligacao.id }
                                </td>
                                <td>
                                	${ligacao.nome }
                                </td>
                            </tr>             
                        </c:forEach>
					</tbody>
            </table>
        </div>
   </div>

	<div id="bottom" class="row">
    	<div class="col-md-12">
        	<ul class="pagination">
            	<li class="disabled"><a>&lt; Anterior</a></li>
                <li class="disabled"><a>1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
            </ul>

        </div>
    </div>
</c:if>
</div>
<!----------------------------------------------------------------------------------------------------------------------------------->
<!---------------------------------------------------------------Respostas----------------------------------------------------------->
<div id="main" class="container-fluid">
	 <form action="controller.do" method="post">
        <div id="top" class="row">
            <div class="col-md-3">
                <h2>Respostas</h2>
            </div>
	 		<div class="col-md-6">
            	<div class="input-group h2">
                	<input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Respostas (deixe vazio para trazer todos)">
                	<span class="input-group-btn">
	 					<button class="btn btn-primary" type="submit" name="command" value="ListarRespostasBuscar"><span class="glyphicon glyphicon-search"></span></button>
                    </span>
                </div>
            </div>
	 		<div class="col-md-2">
            	<a href="CriarRespostas.jsp" class="btn btn-primary pull-right h2">Criar</a>
            </div>
    	</div>
     </form>
        
<c:if test="${not empty respostas}">
	<div id="list" class="row">
    	<div class="table-responsive col-md-12">
        	<table class="table table-striped table-dark" cellspacing="0" cellpadding="0">
        		<thead>
                	<tr>
                    	<th>ID</th>
                        <th>Resposta</th>
                       <!--   <th class="actions">Ações</th>  -->
                    </tr>
                </thead>
                	<tbody>
						<c:forEach var="ligacao" items="${respostas }">
                        	<tr>
                            	<td>
                                	${respostas.id }
                                </td>
                                <td>
                                	${respostas.resposta }
                                </td>
                            </tr>             
                        </c:forEach>
					</tbody>
            </table>
        </div>
   </div>

	<div id="bottom" class="row">
    	<div class="col-md-12">
        	<ul class="pagination">
            	<li class="disabled"><a>&lt; Anterior</a></li>
                <li class="disabled"><a>1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
            </ul>

        </div>
    </div>
</c:if>
</div>
<!----------------------------------------------------------------------------------------------------------------------------------->

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$("#delete-modal").on('show.bs.modal', function(event) {
    var button = $(event.relatedTarget); //botao que disparou a modal
    var recipient = button.data('cliente');
    $("#id_excluir").val(recipient);
    });
</script>
</section>

</body>

<c:import url="Footer.jsp" />
</html>