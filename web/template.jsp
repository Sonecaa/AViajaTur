
<%session = request.getSession();
    Cliente c = new Cliente();
    boolean permissao = false;
    if (request.getAttribute("cliente") != null || session.getAttribute("cSession") != null) {
        if (request.getAttribute("cliente") == null) {
            c = (Cliente) session.getAttribute("cSession");
        } else {
            c = (Cliente) request.getAttribute("cliente");
        }
        if (c.isPermissao()) {
            permissao = true;
        }
    }
%>
<%@page import="classesBEAN.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>A Viaja TUR</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <nav class="navbar navbar-light">
            <div class="container-fluid">
                <div class="navbar-header ">
                    <a class="navbar-brand" href="template.jsp?page=inicio">A Viaja Tur</a>
                </div>

                <ul class="nav navbar-nav">                 
                    <li>
                        <a href="#">
                            <% if (!c.getNome().isEmpty()) {
                                    out.print(c.getNome());
                                }%></a>
                    </li>
                    <li > 
                        <form action="home" method="POST">
                            <input type="hidden" name="txtPagina" value="logout">
                            <button type="submit" class="btn btn-danger">Desconectar</button>
                        </form>
                    </li>
                </ul>
            </div>
        </nav>



        <%-- CONTEUDO --%>
        <div class="container">
            <%  String pagina = request.getParameter("page");

                if (pagina != null) {
                    if (permissao) {
                        pagina = "admin/" + pagina + ".jsp";
                    } else {
                        pagina = "pages/" + pagina + ".jsp";
                    }

            %>
            <jsp:include page="<%= pagina%>"/>
            <%
            } else {
                pagina = (String) request.getAttribute("page");

                if (pagina != null) {
                    if (permissao) {
                        pagina = "admin/" + pagina + ".jsp";
                    } else {
                        pagina = "pages/" + pagina + ".jsp";
                    }
                }

            %>
            <jsp:include page="<%= pagina%>"/>
            <%
                }
            %>

        </div>
    </body>
</html>
