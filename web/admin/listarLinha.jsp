<%-- 
    Document   : listarLinha
    Created on : 18/04/2018, 01:35:21
    Author     : Marcelo
--%>
<%@page import="classesBEAN.Linha"%>
<%@page import="java.util.List"%>
<%@page import="classesDAOpure.LinhaDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Linha</title>
    </head>
    <body>
        <h1>Listar Linha</h1>
          <%
            LinhaDAO linDAO = new LinhaDAO();

            List<Linha> linhas = linDAO.getAllLinhas();
            request.setAttribute("linhas", linhas);
        %>
         <table cellpadding="10"  class="table-bordered  table-striped">
            <tr>
            <th>IdLinha</th>
            <th> Nome da linha</th>            
            </tr>
        <c:forEach items="${linhas}" var="x">
            <tr>
                <td align="center"><c:out value="${x.idLinha}"></c:out></td>              
                <td align="center"><c:out value="${x.nome}"></c:out></td>                
             </tr>
        </c:forEach>
        </table>    
    </body>
</html>
