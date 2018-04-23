/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesController;

import classesController.rotas.RotaNotFound;
import classesController.rotas.RotaCriarPassagem;
import classesController.rotas.RotaLogout;
import classesController.rotas.RotasPagina;
import classesController.rotas.RotaCriarLinha;
import classesController.rotas.RotaCriarOnibus;
import classesBEAN.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marcelo
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    private static final Map<String, RotasPagina> comandos;

    static {
        comandos = new HashMap<String, RotasPagina>();
        comandos.put("logout", new RotaLogout());
        comandos.put("criarLinha", new RotaCriarLinha());
        comandos.put("criarOnibus", new RotaCriarOnibus());
        comandos.put("criarPassagem", new RotaCriarPassagem());
        comandos.put("AcaoNotFound", new RotaNotFound());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        if (request.getParameter("txtPagina") != null) {
            try {
                comandos.get(request.getParameter("txtPagina")).execute(request, response);
            } catch (NullPointerException e) {
                comandos.get("AcaoNotFound").execute(request, response);
            }
        }

        if (session.getAttribute("cSession") == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
            EntityManager em = emf.createEntityManager();
            String msg = "";
            try {
                Query q = em.createQuery("SELECT c FROM Cliente c where c.nome = :nome AND c.senha = :senha");
                q.setParameter("nome", request.getParameter("txtNome"));
                q.setParameter("senha", request.getParameter("txtSenha"));

                Object cli = null;
                try {
                    cli = q.getSingleResult();
                } catch (Exception e) {
                    cli = new Cliente();
                    cli = (Cliente) q.getSingleResult();
                }

                if (cli == null) {
                    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreta!  " + msg);
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
                    session.setAttribute("cSession", cli);
                    request.setAttribute("cliente", cli);
                    request.setAttribute("page", "inicio");
                    rd.forward(request, response);
                }
            } catch (Exception e) {
                msg = "Senha Errada! " + e.getMessage();
                response.sendRedirect("login.jsp?msg=" + msg);
            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
            Object c = null;
            try {
                c = session.getAttribute("cSession");
            } catch (Exception e) {
                c = (Cliente) session.getAttribute("cSession");
            }
            request.setAttribute("cliente", c);
            session.setAttribute("cSession", c);
            request.setAttribute("page", "inicio");
            rd.forward(request, response);
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
