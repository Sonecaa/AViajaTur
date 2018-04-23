<%-- 
    Document   : login
    Created on : 20/03/2018, 23:54:35
    Author     : Marcelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>A Viaja TUR - Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <style>
            .caixaLogin{
                width: 450px;
    border: 10px solid #017bff;
    padding: 30px;
    color: white;
    background-color: #353535;
            }
           input.form-control{
                color: white;
    background-color: #353535;
            }
            .caixaLogin h1 {
                    color: #017bff;
                    display:inline-block;
            }
        </style>
    </head>
    <body>
        <br>
        <br>
        <br>
        <div class="container caixaLogin">
            
            <h1> A ViajaTUR</h1> &nbsp;&nbsp;&nbsp;&nbsp;  <img src="images/logo.png" alt="" style="width:90px;display:inline-block;"/>
        <form method="post" action="home">
           
                <div class="form-group">      
                    <input type="text" required class="form-control" name="txtNome" placeholder="Nome">
                </div>
                <div class="form-group">
                    <input type="password" required class="form-control" name="txtSenha" placeholder="Senha">
                </div>
                
                <%
                    if(request.getAttribute("msg") != null){
                        out.print("<br><p>" + request.getAttribute("msg") + "</p>");
                    }
                     if(request.getParameter("msg") != null){
                        out.print("<br><p>" + request.getParameter("msg") + "</p>");
                    }
                %>
                
                
                <button type="submit" class="btn btn-primary">Submit</button>
                <hr>
                        <a href="cadastro.jsp" >Ainda não é cadastrado?</a><br>
            </form>
                
        
</div>

    </body>
</html>
