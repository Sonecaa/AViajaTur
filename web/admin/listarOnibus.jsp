<%-- 
    Document   : listarOnibus
    Created on : 18/04/2018, 01:49:21
    Author     : Marcelo
--%>
<%@page import="classesBEAN.Onibus"%>
<%@page import="java.util.List"%>
<%@page import="classesDAOpure.OnibusDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Onibus</title>
    </head>
    <body>
        <h1>Listar Onibus</h1>
        <%
            OnibusDAO oniDAO = new OnibusDAO();

            List<Onibus> onibus = oniDAO.getAllOnibus();
            request.setAttribute("onibus", onibus);
        %>
        
        <table cellpadding="10"  class="table-bordered">
            <tr>
            <th>IdOnibus</th>
            <th>Numero de Poltronas</th>
            <th> Nome da linha</th>            
            </tr>
        <c:forEach items="${onibus}" var="x">
            <tr>
                <td align="center"><c:out value="${x.idOnibus}"></c:out></td>              
                <td align="center"><c:out value="${x.numPoltronas}"></c:out></td>                
                <td align="center"> <c:out value="${x.fkLinha.nome}"></c:out></td>  
             </tr>
        </c:forEach>
        </table>    
    </body>
</html>
