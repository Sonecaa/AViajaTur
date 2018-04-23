/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesController.rotas;


import classesBEAN.Linha;
import classesDAOpure.LinhaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class RotaCriarLinha implements RotasPagina {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher  rd = request.getRequestDispatcher("template.jsp?page=inicio");
        Linha lin = new Linha(0, request.getParameter("txtNome"));                
        LinhaDAO linDAO = new LinhaDAO();
        
        try {
            linDAO.create(lin);
        } catch (Exception ex) {
            
        }
        
        rd.forward(request, response);
    }
    
}
