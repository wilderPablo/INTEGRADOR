
<%@ page import="java.sql.*" %>
<%@ page import="controladores.controlador.SVArranque" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="com.mysql.cj.jdbc.Driver" %>
<%@ page import="org.mindrot.jbcrypt.BCrypt" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/headerCSS.css" />
    <link rel="stylesheet" type="text/css" href="css/registrarseCSS.css">
    <link rel="stylesheet" type="text/css" href="css/footerCSS.css">
    <script src="./js/carritoService.js" defer></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Megamatrix&reg; - Registrarse</title>
    <link rel="icon" href="./img/favicon_2.png" /> <!-- Icono del sitio web -->
</head>

<body>

    <%
    HttpSession session = request.getSession();
    if (session.getAttribute("usuario") != null) {
        response.sendRedirect("index.jsp");
    }

    String mensaje = "";

    if (request.getParameter("registro") != null) {
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        if (nombres == null || nombres.isEmpty() || apellidos == null || apellidos.isEmpty() || correo == null || correo.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            mensaje = "¡¡PORFAVOR RELLENE LOS CAMPOS REQUERIDOS PARA SU REGISTRO!!";
        } else {
            Connection cn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_de_datos", "tu_usuario", "tu_contrasena");

                String consulta_correo = "SELECT id FROM usuarios WHERE correo = ?";
                ps = cn.prepareStatement(consulta_correo);
                ps.setString(1, correo);
                rs = ps.executeQuery();

                if (rs.next()) {
                    mensaje = "Este correo ya está registrado";
                } else {
                    String contrasena_hash = BCrypt.hashpw(contrasena, BCrypt.gensalt());

                    String sql = "INSERT INTO usuarios (nombres, apellidos, correo, contrasena) VALUES (?, ?, ?, ?)";
                    ps = cn.prepareStatement(sql);
                    ps.setString(1, nombres);
                    ps.setString(2, apellidos);
                    ps.setString(3, correo);
                    ps.setString(4, contrasena_hash);

                    int result = ps.executeUpdate();
                    if (result > 0) {
                        mensaje = "Nuevo registro creado exitosamente";
                    } else {
                        mensaje = "Error al crear el registro";
                    }
                }
            } catch (Exception e) {
                mensaje = "Error: " + e.getMessage();
            } finally {
                try { if (rs != null) rs.close(); } catch (Exception e) {}
                try { if (ps != null) ps.close(); } catch (Exception e) {}
                try { if (cn != null) cn.close(); } catch (Exception e) {}
            }
        }
    }
    %>

    <jsp:include page="header.jsp" />

    <form method="post">
        <div class="containerRegistrar">
            <section class="form-register">
                <h4>Formulario Registro</h4>
                <input class="controls" type="text" name="nombres" id="nombres" placeholder="Ingrese su Nombre" value="<%= request.getParameter("nombres") != null ? request.getParameter("nombres") : "" %>">
                <input class="controls" type="text" name="apellidos" id="apellidos" placeholder="Ingrese su Apellido" value="<%= request.getParameter("apellidos") != null ? request.getParameter("apellidos") : "" %>">
                <input class="controls" type="email" name="correo" id="correo" placeholder="Ingrese su Correo" value="<%= request.getParameter("correo") != null ? request.getParameter("correo") : "" %>">
                <input class="controls" type="password" name="contrasena" id="contrasena" placeholder="Ingrese su Contraseña" value="">
                <p>Estoy de acuerdo con <a href="#">Términos y Condiciones</a></p>
                <input class="botons" type="submit" value="Registrar" name="registro">
                <p><a class="buttom" href="Ingresar.jsp">Ya tengo cuenta</a></p>
                <%
                if (!mensaje.isEmpty()) {
                    out.println("<p class='");
                    out.println(mensaje.contains("Nuevo registro creado exitosamente") ? "mensaje-exito" : "mensaje");
                    out.println("'>" + mensaje + "</p>");
                }
                %>
            </section>
        </div>
    </form>

    <jsp:include page="footer.jsp" />

</body>

</html>