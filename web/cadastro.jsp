<%-- 
    Document   : cadastro
    Created on : 05/04/2018, 17:55:40
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
            form{
                width:300px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Cadastro</h1>
            <form method="post" action="cadastro">

                <div class="form-group">      
                    <input type="text" required class="form-control" name="txtNome" placeholder="Nome">
                </div>
                <div class="form-group">
                    <input type="password" required class="form-control" name="txtSenha" placeholder="Senha">
                </div>


                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </body>
</html>
