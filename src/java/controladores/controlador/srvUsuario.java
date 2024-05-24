/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servicios.conexiones.DaoUsuario;
import servicios.conexiones.usuario;


@WebServlet(name ="srvUsuario",urlPatterns={"/srvUsuario"})

public class srvUsuario extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse responde)
            throws ServletException, IOException {
        responde.setContentType("text/html;charset=UTF-8");
        String accion= request.getParameter("accion");        
        try {
          if(accion != null){
              switch (accion) {
                  case "verificar":
                      verificar(request,responde);
                      break;
                  case "cerrar":
                      cerarSesion(request,responde);                    
                  default:
                      responde.sendRedirect("IniciarSesion.jsp");
              }
          }
        }catch(Exception e){
            try {
                this.getServletConfig().getServletContext().getRequestDispatcher("/footer.jsp").forward(request, responde);
            } catch (Exception ex) {
                System.out.println("Error"+ex.getMessage());
                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session;
        DaoUsuario dao;
        usuario usuario;
        usuario= this.obtenerUsuario(request);
        dao = new DaoUsuario();
        usuario=dao.identificar(usuario);
        if (usuario != null && usuario.getCargo().getNombreCargo().equals("TRABAJADOR")) {
            session=request.getSession();
            session.setAttribute("usuario", usuario);
            request.setAttribute("msje", "Bienvenido");
            this.getServletConfig().getServletContext().getRequestDispatcher("/vista/footer.jsp").forward(request, response);
        } else if (usuario!= null && usuario.getCargo().getNombreCargo().equals("USUARIO"))  {
         session=request.getSession();
            session.setAttribute("usuario", usuario);
            request.setAttribute("msje", "Bienvenido");
            this.getServletConfig().getServletContext().getRequestDispatcher("/vista/index.jsp").forward(request, response);
        }else{
        request.setAttribute("msje","Credenciales Incorrectas ");
            request.getRequestDispatcher("IniciarSesion.jsp");
        }
    
    }

    private void cerarSesion(HttpServletRequest request, HttpServletResponse responde) throws Exception {
       HttpSession session = request.getSession();
       session.setAttribute("usuario",null);
       session.invalidate();
       responde.sendRedirect("IniciarSesion.jsp");
    }

    private usuario obtenerUsuario(HttpServletRequest request) {
    usuario u =new usuario();
    u.setNombres(request.getParameter("username"));
    u.setContraseña(request.getParameter("password"));
    return u;
    }

}
