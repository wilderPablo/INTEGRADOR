package controladores.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PortalSugerencias", urlPatterns = {"/PortalSugerencias"}, loadOnStartup = 1)
public class PortalSugerencias extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Aquí puedes realizar cualquier procesamiento adicional necesario antes de la redirección

        // Redirige al mismo formulario
        request.getRequestDispatcher("./vista/PortalSugerencias.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para controlar el formulario del portal de sugerencias";
    }
}
