
package classesController.rotas;


import classesBEAN.Onibus;
import classesBEAN.Passagem;
import classesDAOpure.OnibusDAO;
import classesDAOpure.PassagemDAO;
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



public class RotaCriarPassagem implements RotasPagina{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=inicio");
         
        OnibusDAO oniDAO = new OnibusDAO();
        
        Onibus oni = oniDAO.getSingleOnibus(Integer.parseInt(request.getParameter("cmbOnibus")));
        
       
        DateFormat  dtF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt = new Date();
        try {
            dt = dtF.parse(request.getParameter("txtDataEHora"));
        } catch (ParseException ex) {
            //tando erro e indo a data do Date() na instanciação 
            Logger.getLogger(RotaCriarPassagem.class.getName()).log(Level.SEVERE, null, ex);
        }

       Passagem  pass = new Passagem(0, oni , dt , Double.parseDouble(request.getParameter("txtValor")));
       PassagemDAO passDAO = new PassagemDAO();  
       try {
           passDAO.create(pass);
       } catch (Exception ex) {

        }

        rd.forward(request, response);
    }
    
}
