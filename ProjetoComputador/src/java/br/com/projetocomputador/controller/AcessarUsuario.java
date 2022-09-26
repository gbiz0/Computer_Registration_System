package br.com.projetocomputador.controller;

import br.com.projetocomputador.dao.GenericDAO;
import br.com.projetocomputador.dao.UsuarioDAOImpl;
import br.com.projetocomputador.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gbiz0
 */
@WebServlet(name = "AcessarUsuario", urlPatterns = {"/AcessarUsuario"})
public class AcessarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            String emailUsuario = request.getParameter("emailUsuario");
            String senhaUsuario = request.getParameter("senhaUsuario");
            String message = null;

            if (!emailUsuario.equals("") && !senhaUsuario.equals("")) {
                try {
                    UsuarioDAOImpl dao = new UsuarioDAOImpl();
                    Usuario usuario = (Usuario) dao.logarUsuario(emailUsuario, senhaUsuario);
                    if (usuario != null) {
                        HttpSession sessao = request.getSession(true);
                        sessao.setAttribute("usuario", usuario);
                        message = "Seja bem-vindo(a), " + usuario.getNomeUsuario();
                        sessao.setAttribute("message", message);
                        request.getRequestDispatcher("start.jsp").forward(request, response);
                    } else {
                        message = "Login ou senha invalidos!";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("acessarusuario.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    System.out.println("Problemas ao logar! Erro:" + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                message = "É necessário digitar Login e Senha";
                request.setAttribute("message", message);
                request.getRequestDispatcher("acessarusuario.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AcessarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AcessarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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

}
