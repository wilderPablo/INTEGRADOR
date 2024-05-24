<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header class="containerHeader">
    <a href="index.jsp" class="logoMenu">
        <!--   <img src="../img/logo.png" alt="Logo"/> Logotipo -->
        <img src="../img/Mgamatrix.png" alt="Logo"/>
    </a>
    <nav class="navegador"> <!-- Barra de navegación -->
        <ul class="menu">
            <li><a href="index.jsp">Inicio</a></li>
            <li>
                <a href="#" id="submenubtn">Ofrecemos  <i class="fas fa-chevron-down"></i></a>
                <!-- Agrega la clase 'fas' para indicar que es un ícono de FontAwesome -->
                <ul class="submenu">
                    <li><a href="VentanaComponente.jsp">Componentes</a></li>
                    <li><a href="VentanaServicio.jsp">Servicios</a></li>
                </ul>
            </li>
            <li><a href="Contactanos.jsp">Contactanos</a></li>
            <li><a href="Nosotros.jsp">Nosotros</a></li>
            <li><a href="VentanaRegistrese.jsp">Registrese</a></li>
            <li><a href="IniciarSesion.jsp">Inicie Sesión</a></li>
            <li><a href="VentanaCompras.jsp">Compras</a></li>
        </ul>
    </nav> <!-- Fin de la barra de navegación --> 
    <script src="../js/menu.js" ></script>
</header>
<link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>