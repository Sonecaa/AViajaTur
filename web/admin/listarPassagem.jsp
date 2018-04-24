<%-- 
    Document   : listarPassagem
    Created on : 18/04/2018, 01:49:53
    Author     : Marcelo
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="classesBEAN.Passagem"%>
<%@page import="java.util.List"%>
<%@page import="classesDAOpure.PassagemDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Passagem</title>
    </head>
    <body>
        <h1>Listar Passagem</h1>
               <%
            PassagemDAO passDAO = new PassagemDAO();

            List<Passagem> passagens = passDAO.getAllPassagens();
            request.setAttribute("passagens", passagens);
        %>
         <table cellpadding="10"  class="table-bordered table-striped">
            <tr>
            <th>IdPassagem</th>
            <th>Data e Hora</th>   
            <th>Valor</th>
            <th>IdOnibus</th>
            
            </tr>
        <c:forEach items="${passagens}" var="x">
            <fmt:formatDate value="${x.dataEhora}" pattern="dd/MM/yyyy HH:mm:ss" var="newdatevar" />
            <tr>
                <td align="center"><c:out value="${x.idPassagem}"></c:out></td>              
                <td align="center"><c:out value="${newdatevar}"></c:out></td>                
                <td align="center"><c:out value="${x.valor}"></c:out></td>                
                <td align="center"><c:out value="${x.fkOnibus.idOnibus}"></c:out> - <c:out value="${x.fkOnibus.fkLinha.nome}"></c:out></td>                
             </tr>
        </c:forEach>
        </table>    
    </body>
</html>
