package br.com.projetocomputador.controller;

import br.com.projetocomputador.dao.ComputadorDAOImpl;
import br.com.projetocomputador.dao.GenericDAO;
import br.com.projetocomputador.dao.ItemComputadorDAOImpl;
import br.com.projetocomputador.dao.ItemDAOImpl;
import br.com.projetocomputador.model.Computador;
import br.com.projetocomputador.model.Item;
import br.com.projetocomputador.model.ItemComputador;
import br.com.projetocomputador.model.TipoComputador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastrarComputador", urlPatterns = {"/CadastrarComputador"})
public class CadastrarComputador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            HttpSession sessao = httpServletRequest.getSession();

            if (sessao.getAttribute("usuario") != null) {

                String fornecedorProduto = request.getParameter("fornecedorProduto");
                Integer precoProduto = Integer.parseInt(request.getParameter("precoProduto"));
                Integer ramComputador = Integer.parseInt(request.getParameter("ramComputador"));
                Integer ssdComputador = Integer.parseInt(request.getParameter("ssdComputador"));
                Integer idTipo = Integer.parseInt(request.getParameter("idTipo"));
                String[] idItem = request.getParameterValues("idItem");
                Integer quantidadeItem = idItem.length;

                String mensagem = null;

                Computador computador = new Computador();

                computador.setFornecedorProduto(fornecedorProduto);
                computador.setPrecoProduto(precoProduto);
                computador.setRamComputador(ramComputador);
                computador.setSsdComputador(ssdComputador);
                computador.setIdTipo(new TipoComputador(idTipo));
                Integer idComputador = null;

                try {
                    ComputadorDAOImpl dao = new ComputadorDAOImpl();
                    idComputador = dao.cadastrarComputador(computador);
                    if (idComputador > 0) {
                        computador.setIdComputador(idComputador);
                        for (int i = 0; i < quantidadeItem; i++) {
                            ItemComputador itemcomputador = new ItemComputador();
                            itemcomputador.setIdItem(new Item(Integer.parseInt(idItem[i])));
                            itemcomputador.setIdComputador(computador);

                            GenericDAO daoItem = new ItemComputadorDAOImpl();
                            if (daoItem.cadastrar(itemcomputador)) {
                                mensagem = "Computador cadastrado com sucesso!";
                            } else {
                                mensagem = "Problemas ao cadastrar Computador. "
                                        + "Verifique os dados informados e tente novamente!";
                            }
                        }
                    } else {
                        mensagem = "Problemas ao cadastrar Computador. "
                                + "Verifique os dados informados e tente novamente!";
                    }
                    request.setAttribute("mensagem", mensagem);
                    request.getRequestDispatcher("CarregarTipoComputador").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Problemas no Servlet ao cadastrar Cliente! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                ((HttpServletResponse) response).sendRedirect("index.html");
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
