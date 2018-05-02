
package classesController.rotas;

import classesBEAN.Cliente;
import classesBEAN.Passagem;
import classesBEAN.Venda;
import classesDAOpure.PassagemDAO;
import classesDAOpure.VendaDAO;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RotaCriarVenda implements RotasPagina{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=inicio");
       
       if(Integer.parseInt(request.getParameter("numeroDisponiveis")) < 0){
           rd.forward(request, response);
       }
       
       
       DateFormat  dtF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt = new Date();
        
        HttpSession session = request.getSession();
        Cliente c = new Cliente();
        c = (Cliente) session.getAttribute("cSession");
        
        Passagem pass = new Passagem();
        PassagemDAO passDAO = new PassagemDAO();
        pass = passDAO.getSinglePassagem(Integer.parseInt(request.getParameter("cmbPassagem")));
        
        VendaDAO venDAO = new VendaDAO();       
        Venda venda = new Venda(0, c , pass , dt);
        
              
       
       try {
           venDAO.create(venda);
       } catch (Exception ex) {

        }

        rd.forward(request, response);
    }
    
}
