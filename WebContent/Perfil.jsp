<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html lang="pt-br">

<head>
    <!-- Required meta tags-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Perfil</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
    <link href="vendor/vector-map/jqvmap.min.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- MENU SIDEBAR DESKTOP-->
        <aside class="menu-sidebar2">
            <div class="logo">
                <a href="Home.jsp">
                    <img src="images/icon/logo-white.png" alt="Cool Admin" />
                </a>
            </div>
            <div class="menu-sidebar2__content js-scrollbar1">
                <div class="account2">
                    <div class="image img-cir img-120">
                        <img src="images/icon/avatar-big-01.jpg" alt="John Doe" />
                    </div>
                    <h4 class="name">Lukas Barbosa</h4>
                    <a href="#">Sign out</a>
                </div>
                <nav class="navbar-sidebar2">
                    <ul class="list-unstyled navbar__list">
                        <li class="active has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-desktop"></i>Menu
                            </a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li>
                                    <a href="Atendente.jsp">Home</a>
                                </li>
                                <li>
                                    <a href="Perfil.jsp">Perfil</a>
                                </li>
                                <li>
                                    <a href="#">Calendar</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                        	<form action="controller.do" method="post">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-folder-open"></i>Relatórios
                            </a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li>
                                	<button type="submit" name="command" value="RelatorioMensal">Mensal</button>
                                </li>
                                <li>
                                    <button type="submit" name="command" value="RelatorioSemanal">Semanal</button>
                                </li>
                                <li>
                                    <button type="submit" name="command" value="RelatorioDiario">Diário</button>
                                </li>
                            </ul>
                            </form>
                        </li>
                        <li>
                            <a href="ListarAtendimento.jsp">
                                <i class="fas fa-comment"></i>Atendimentos
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-envelope"></i>E-mails
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-chart-bar"></i>Desempenhos
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-cog"></i>Opções
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR DESKTOP-->
        
        <!-- MENU HAMBURGUE MOBILE-->
        <aside class="menu-sidebar2 js-right-sidebar d-block d-lg-none">
            <div class="logo">
                <a href="Home.jsp">
                    <img src="images/icon/logo-white.png" alt="Cool Admin" />
                </a>
            </div>
                
            <div class="menu-sidebar2__content js-scrollbar2">
                <div class="account2">
                    <div class="image img-cir img-120">
                        <img src="images/icon/avatar-big-01.jpg" alt="Lukas Barbosa" />
                    </div>
                    <h4 class="name">Lukas Barbosa</h4>
                    <a href="#">Sign out</a>
                </div>
                <nav class="navbar-sidebar2">
                    <ul class="list-unstyled navbar__list">
                        <li class="active has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-desktop"></i>Menu
                            </a>
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li>
                                    <a href="Atendente.jsp">Home</a>
                                </li>
                                <li>
                                    <a href="Perfil.jsp">Perfil</a>
                                </li>
                                <li>
                                    <a href="#">Calendar</a>
                                </li>
                            </ul>
                        </li>
                        <li class="active has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-folder-open"></i>Relatórios
                            </a>
                            <form action="controller.do" method="post">
                            <ul class="list-unstyled navbar__sub-list js-sub-list">
                                <li>
                                	<button class=".header-mobile .navbar-mobile .navbar-mobile__list li button" type="submit" name="command" value="RelatorioMensal">Mensal</button>
                                </li>
                                <li>
                                    <button class=".header-mobile .navbar-mobile .navbar-mobile__list li button" type="submit" name="command" value="RelatorioSemanal">Semanal</button>
                                </li>
                                <li>
                                    <button class=".header-mobile .navbar-mobile .navbar-mobile__list li button" type="submit" name="command" value="RelatorioDiario">Diário</button>
                                </li>
                            </ul>
                            </form>
                        </li>
                        <li>
                            <a href="ListarAtendimento.jsp">
                                <i class="fas fa-comment"></i>Atendimentos
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-envelope"></i>E-mails
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-chart-bar"></i>Desempenhos
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fas fa-cog"></i>Opções
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END HAMBURGUER MENU MOBILE-->
	
    	<!-- PAGE CONTAINER-->
    	<div class="page-container2">
    	<!-- HEADER DESKTOP-->
    	<header class="header-desktop2">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap2">
                            <div class="logo d-block d-lg-none">
                                <a href="Home.jsp">
                                    <img src="images/icon/logo-white.png" alt="CoolAdmin" />
                                </a>
                            </div>
                            <div class="header-button2">
                                <div class="header-button-item js-item-menu">
                                    <i class="zmdi zmdi-search"></i>
                                    <div class="search-dropdown js-dropdown">
                                        <form action="">
                                            <input class="au-input au-input--full au-input--h65" type="text" placeholder="Search for datas &amp; reports..." />
                                            <span class="search-dropdown__icon">
                                                <i class="zmdi zmdi-search"></i>
                                            </span>
                                        </form>
                                    </div>
                                </div>
                                <div class="header-button-item has-noti js-item-menu">
                                    <i class="zmdi zmdi-notifications"></i>
                                    <div class="notifi-dropdown js-dropdown">
                                        <div class="notifi__title">
                                            <p>You have 3 Notifications</p>
                                        </div>
                                        <div class="notifi__item">
                                            <div class="bg-c1 img-cir img-40">
                                                <i class="zmdi zmdi-email-open"></i>
                                            </div>
                                            <div class="content">
                                                <p>You got a email notification</p>
                                                <span class="date">April 12, 2018 06:50</span>
                                            </div>
                                        </div>
                                        <div class="notifi__item">
                                            <div class="bg-c2 img-cir img-40">
                                                <i class="zmdi zmdi-account-box"></i>
                                            </div>
                                            <div class="content">
                                                <p>Your account has been blocked</p>
                                                <span class="date">April 12, 2018 06:50</span>
                                            </div>
                                        </div>
                                        <div class="notifi__item">
                                            <div class="bg-c3 img-cir img-40">
                                                <i class="zmdi zmdi-file-text"></i>
                                            </div>
                                            <div class="content">
                                                <p>You got a new file</p>
                                                <span class="date">April 12, 2018 06:50</span>
                                            </div>
                                        </div>
                                        <div class="notifi__footer">
                                            <a href="#">All notifications</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="header-button-item mr-0 js-sidebar-btn">
                                    <i class="zmdi zmdi-menu"></i>
                                </div>
                                <div class="setting-menu js-right-sidebar d-none d-lg-block">
                                    <div class="account-dropdown__body">
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-account"></i>Account</a>
                                        </div>
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-settings"></i>Setting</a>
                                        </div>
                                    </div>
                                    <div class="account-dropdown__body">
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-globe"></i>Language</a>
                                        </div>
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-email"></i>Email</a>
                                        </div>
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-notifications"></i>Notifications</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
    	<!-- END HEADER DESKTOP-->
    	
    	<div class="main-content">
        	<div class="section__content section__content--p30">
            	<div class="container-fluid">
	 				<h3 class="page-header">Nome: ${sessionScope.logado.nome }</h3>
	 				<hr>
                    <div class="row">
                        <div class="col-md-6">
                            <p><strong>Nascimento</strong></p>
                            <p>
                                ${sessionScope.logado.nascimento }
                            </p>
                            <br>
                        </div>
                        <div class="col-md-6">
                            <p><strong>RG</strong></p>
                            <p>
                                ${sessionScope.logado.rg }
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>RA</strong></p>
                            <p>
                                ${sessionScope.logado.ra }
                            </p>
                            <br>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Cidade</strong></p>
                            <p>
                                ${sessionScope.logado.cidade }
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>CEP</strong></p>
                            <p>
                                ${sessionScope.logado.cep }
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>Email</strong></p>
                            <p>
                                ${sessionScope.logado.email }
                            </p>
                        </div>
                    </div>
                </div>
			</div>
        </div>
	</div>
	</div>
    	
    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js"></script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js"></script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/vector-map/jquery.vmap.js"></script>
    <script src="vendor/vector-map/jquery.vmap.min.js"></script>
    <script src="vendor/vector-map/jquery.vmap.sampledata.js"></script>
    <script src="vendor/vector-map/jquery.vmap.world.js"></script>

    <!-- Main JS-->
    <script src="js/main.js"></script>

</body>

</html>