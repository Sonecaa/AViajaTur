/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesController.rotas;

import classesBEAN.Linha;
import classesBEAN.Onibus;
import classesDAOpure.LinhaDAO;
import classesDAOpure.OnibusDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class RotaCriarOnibus implements RotasPagina {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=inicio");

        LinhaDAO linDAO = new LinhaDAO();
        
        Linha linha = linDAO.getSingleLinha(Integer.parseInt(request.getParameter("cmbLinha")));
        
        Onibus oni = new Onibus(0, linha , Integer.parseInt(request.getParameter("txtNumPoltronas")) );
        OnibusDAO oniDAO = new OnibusDAO();

        try {
            oniDAO.create(oni);
        } catch (Exception ex) {

        }

        rd.forward(request, response);
    }

}
