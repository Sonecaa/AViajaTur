 
<%@page import="classesBEAN.Venda"%>
<%@page import="classesDAOpure.VendaDAO"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Listar Vendas</h1>
               <%
            VendaDAO venDAO = new VendaDAO();

            List<Venda> vendas = venDAO.getAllVendas();
            request.setAttribute("vendas", vendas);
        %>
         <table cellpadding="10"  class="table-bordered table-striped">
            <tr>
            <th>idVenda</th>
            <th>Data e Hora</th>   
            <th>Cliente</th>
            <th>IdPassagem</th>
            
            </tr>
        <c:forEach items="${vendas}" var="x">
            <fmt:formatDate value="${x.dataEhoraVenda}" pattern="dd/MM/yyyy HH:mm:ss" var="newdatevar" />
            <tr>
                <td align="center"><c:out value="${x.idVenda}"></c:out></td>              
                <td align="center"><c:out value="${newdatevar}"></c:out></td>                
                <td align="center"><c:out value="${x.fkCliente.nome}"></c:out></td>                
                <td align="center"><c:out value="${x.fkPassagem.idPassagem}"></c:out> - <c:out value="${x.fkPassagem.fkOnibus.fkLinha.nome}"></c:out></td>                
             </tr>
        </c:forEach>
        </table>    