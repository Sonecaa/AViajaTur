<%-- 
    Document   : criarVenda
    Created on : 20/04/2018, 21:50:13
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="classesBEAN.Onibus"%>
<%@page import="java.util.List"%>
<%@page import="classesDAOpure.OnibusDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar historico</title>
    </head>
    <body>
        <h1>Comprar Passagem</h1>

        <%
            OnibusDAO oniDao = new OnibusDAO();

            List<Onibus> listaOni = oniDao.getAllOnibus();

            request.setAttribute("listaOni", listaOni);
        %>
        <select name="cmbOnibus">
            <c:forEach items="${listaOni}" var="x">
                <option value="<c:out value="${x.idOnibus}"></c:out>"><c:out value="${x.idOnibus}"></c:out> - <c:out value="${x.fkLinha.nome}"></c:out>  </option>
            </c:forEach>
        </select>
        <br>
        <select name="cmbPassagem" id="cmbPassagem">

        </select>


        <script>
            $(document).ready(function () {
                $("#cmbPassagem").select(function () {
                    $.ajax({url: "passagemPorOnibus.jsp", success: function (result) {
                            $("#cmbPassagem").html(result);
                        }});
                });
            });
        </script>
    </body>
</html>
