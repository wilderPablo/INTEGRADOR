<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header class="containerHeader">
    <a href="index.jsp" class="logoMenu">
        <img src="<%=request.getContextPath()%>/img/Mgamatrix.png" alt="Logo"/>
    </a>
    <nav class="navegador">
        <ul class="menu">
            <li><a href="<%=request.getContextPath()%>/vista/index.jsp">Inicio</a></li>
            <li>
                <a href="#">Ofrecemos <i class="fas fa-chevron-down"></i></a>
                <ul class="submenu">
                    <li>
                        <a href="#">Componentes <i class="fas fa-chevron-right"></i></a>
                        <ul class="submenu">
                            <li><a href="<%=request.getContextPath()%>/vista/ComponenteAlmacenamiento.jsp">Almacenamiento</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/ComponenteMonitores.jsp">Monitores</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/ComponenteTeclado.jsp">Teclado</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/ComponenteMouse.jsp">Mouse</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/ComponenteAuriculares,jsp">Auriculares</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/ComponenteCases.jsp">Cases</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/ComponentePlacasMadre.jsp">Placas Madre</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/ComponenteMemoriaRAM.jsp">Memoria RAM</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/Componente.Procesador.jsp">Procesador</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/ComponenteTarjetasDeVideo.jsp">Tarjetas de video</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/ComponenteCooler.jsp.jsp">Cooler</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Servicios <i class="fas fa-chevron-right"></i></a>
                        <ul class="submenu">
                            <li><a href="<%=request.getContextPath()%>/vista/VentanaServicioEnsamblaje.jsp">Ensamblaje</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/VentanaServicio=Mantenimiento.jsp">Mantenimiento</a></li>
                            <li><a href="<%=request.getContextPath()%>/vista/VentanaServicioInstalacionSO.jsp">Instalación de sistema operativo y drivers</a></li>
                        </ul>
                    </li>
                </ul>
            </li>
            <li><a href="<%=request.getContextPath()%>/vista/Contactanos.jsp">Contactanos</a></li>
            <li><a href="<%=request.getContextPath()%>/vista/Nosotros.jsp">Nosotros</a></li>
            <li><a href="<%=request.getContextPath()%>/vista/VentanaRegistrese.jsp">Registrese</a></li>
            <li><a href="<%=request.getContextPath()%>/vista/IniciarSesion.jsp">Inicie Sesión</a></li>
            <li><a href="<%=request.getContextPath()%>/vista/VentanaCompras.jsp">Compras</a></li>
        </ul>
    </nav>
    <script src="../js/menu.js"></script>
</header>
<link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
<link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>

