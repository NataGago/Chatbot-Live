<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>cartorio.biz - Relatório Mensal</title>
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
                        <!-- Mensal -->
                        <div class="row">
                            <div class="col-md-12">
                                <div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
                                    <div class="au-card-title" style="background-image:url('images/bg-title-01.jpg');">
                                        <div class="bg-overlay bg-overlay--blue"></div>
                                        <h3>
                                            <i class="zmdi zmdi-account-calendar"></i>Mês</h3>
                                    </div>
                                    <div class="au-task js-list-load">
                                    	<div class="col-md-12" style="padding-top: 15px">
            							</div>
                                         <div class="au-task-list js-scrollbar3">
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
                                    			<a class="btn btn-warning btn-sm" href="controller.do?command=VisualizarAtendimento&id=${atendimento.id }">Visualizar atendimento</a>
                                    		</td>
                            			</tr>             
                        				</c:forEach>
                        				</tbody>
                        				</table>
                                        </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                            <div class="col-md-12">
                                <div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
                                    <div class="au-card-title" style="background-image:url('images/bg-title-01.jpg');">
                                        <div class="bg-overlay bg-overlay--blue"></div>
                                        <h3>
                                            <i class="zmdi zmdi-account-calendar"></i>Mês</h3>
                                    </div>
                                    <div class="au-task js-list-load">
                                    	<div class="col-md-12" style="padding-top: 15px">
            							</div>
                                         <div class="au-task-list js-scrollbar3">
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
                                    			<a class="btn btn-warning btn-sm" href="controller.do?command=VisualizarAtendimento&id=${atendimento.id }">Visualizar atendimento</a>
                                    		</td>
                            			</tr>             
                        				</c:forEach>
                        				</tbody>
                        				</table>
                                        </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                            <div class="col-md-12">
                                <div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
                                    <div class="au-card-title" style="background-image:url('images/bg-title-01.jpg');">
                                        <div class="bg-overlay bg-overlay--blue"></div>
                                        <h3>
                                            <i class="zmdi zmdi-account-calendar"></i>Mês</h3>
                                    </div>
                                    <div class="au-task js-list-load">
                                    	<div class="col-md-12" style="padding-top: 15px">
            							</div>
                                         <div class="au-task-list js-scrollbar3">
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
                                    			<a class="btn btn-warning btn-sm" href="controller.do?command=VisualizarAtendimento&id=${atendimento.id }">Visualizar atendimento</a>
                                    		</td>
                            			</tr>             
                        				</c:forEach>
                        				</tbody>
                        				</table>
                                        </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                            <div class="col-md-12">
                                <div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
                                    <div class="au-card-title" style="background-image:url('images/bg-title-01.jpg');">
                                        <div class="bg-overlay bg-overlay--blue"></div>
                                        <h3>
                                            <i class="zmdi zmdi-account-calendar"></i>Mês</h3>
                                    </div>
                                    <div class="au-task js-list-load">
                                    	<div class="col-md-12" style="padding-top: 15px">
            							</div>
                                         <div class="au-task-list js-scrollbar3">
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
                                    			<a class="btn btn-warning btn-sm" href="controller.do?command=VisualizarAtendimento&id=${atendimento.id }">Visualizar atendimento</a>
                                    		</td>
                            			</tr>             
                        				</c:forEach>
                        				</tbody>
                        				</table>
                                        </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="au-card au-card--no-shadow au-card--no-pad m-b-40">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <!-- END MAIN CONTENT-->
        </div>
        <!-- END PAGE CONTAINER-->   
    </div>
</body>

</html>