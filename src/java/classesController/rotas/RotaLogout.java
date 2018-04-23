
package classesController.rotas;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aluno
 */
public class RotaLogout implements RotasPagina {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //falta limpar as sessoes
        HttpSession session = request.getSession();
        session.invalidate();
        RequestDispatcher  rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
    
}


    

