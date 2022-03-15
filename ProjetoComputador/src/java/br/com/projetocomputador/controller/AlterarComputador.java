package br.com.projetocomputador.controller;

import br.com.projetocomputador.dao.ComputadorDAOImpl;
import br.com.projetocomputador.dao.GenericDAO;
import br.com.projetocomputador.model.Computador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gbiz0
 */
@WebServlet(name = "AlterarComputador", urlPatterns = {"/AlterarComputador"})
public class AlterarComputador extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Integer idComputador = Integer.parseInt(request.getParameter("idComputador"));
            Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
            String fornecedorProduto = request.getParameter("fornecedorProduto");
            Integer precoProduto = Integer.parseInt(request.getParameter("precoProduto"));
            Integer ramComputador = Integer.parseInt(request.getParameter("ramComputador"));
            Integer ssdComputador = Integer.parseInt(request.getParameter("ssdComputador"));
            
            String mensagem = null;
            
            Computador computador = new Computador();
            computador.setIdComputador(idComputador);
            computador.setIdProduto(idProduto);
            computador.setFornecedorProduto(fornecedorProduto);
            computador.setPrecoProduto(precoProduto);
            computador.setRamComputador(ramComputador);
            computador.setSsdComputador(ssdComputador);
            
            try{
                GenericDAO dao = new ComputadorDAOImpl();
                if (dao.alterar(computador)){
                    mensagem = "Computador alterado com sucesso.";
                } else{
                    mensagem = "Problemas ao alterar computador.";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarComputador").forward(request, response);
            } catch (Exception e) {
                System.out.println("Problemas no Servlet ao alterar computador! Erro:" + e.getMessage());
                e.printStackTrace();
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

}
