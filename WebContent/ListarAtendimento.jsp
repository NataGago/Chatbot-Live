<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="pt-br">
<head>
<title>cartorio.biz - Listar Atendimento</title>
</head>

<body class="animsition">
<c:import url="Menu2.jsp" />

<div class="page-wrapper"> 
	<!-- PAGE CONTAINER-->
    <div class="page-container">
	<!-- MAIN CONTENT-->
        <div class="main-content">
        	<div class="section__content section__content--p30">
            	<div class="container-fluid">
                	<form action="controller.do" method="post">
       					<div id="top" class="row">
            				<div class="col-md-3">
                				<h2>Atendimentos</h2>
            				</div>
	 						<div class="col-md-6">
            					<div class="input-group h2">
                					<input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar Atendimento (deixe vazio para trazer todos)">
                					<span class="input-group-btn">
	 									<button class="btn btn-primary" type="submit" name="command" value="ListarAtendimentoBuscar"><span class="fas fa-search"></span></button>
                    				</span>
                				</div>
            				</div>
	 						<div class="col-md-3">
            					<a href="#" class="btn btn-primary pull-right h2">Novo Atendimento</a>
            				</div>
    					</div>
     				</form>
        
					<c:if test="${not empty atendimentos}">
						<div id="list" class="row">
    						<div class="table-responsive col-md-12">
        						<table class="table table-striped">
        							<thead>
                						<tr>
                    						<th>ID</th>
                        					<th>Data de Criação</th>
                        					<th>Aberto</th>
                        				</tr>
                					</thead>
                					<tbody>
										<c:forEach var="atendimento" items="${atendimentos }">
                        				<tr>
                            				<td>
                                				${atendimento.id }
                                			</td>
                                			<td>
                                				${atendimento.dataCriacao }
                                			</td>
                                			<td>
                                				${atendimento.aberto }
                                			</td>
                                			<td class="actions">
                                    			<a class="btn btn-success btn-xs" href="controller.do?command=VisualizarAtendimento&id=${atendimento.id }">Iniciar atendimento</a>
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

				<script src="js/jquery.min.js"></script>
				<script src="js/bootstrap.min.js"></script>
				<script type="text/javascript">
					$("#delete-modal").on('show.bs.modal', function(event) {
    				var button = $(event.relatedTarget); //botao que disparou a modal
   					var recipient = button.data('cliente');
    				$("#id_excluir").val(recipient);});
				</script>    
        	</div>
        </div>
    </div>
	</div>
</body>

</html>