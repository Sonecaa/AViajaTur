
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="classesBEAN.Cliente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="classesBEAN.Venda"%>
<%@page import="java.util.List"%>
<%@page import="classesDAOpure.VendaDAO"%>
<h1>Visualizar historico</h1>

<%
    VendaDAO venDAO = new VendaDAO();

    Cliente c = new Cliente();
    c = (Cliente) session.getAttribute("cSession");

    List<Venda> vendas = venDAO.getVendasPorCliente(c);
    request.setAttribute("vendas", vendas);
%>
<table cellpadding="10"  class="table-bordered  table-striped">
    <tr>
        <th>IdVenda</th>
        <th>Data e Hora</th>   
        <th>Cliente</th>
        <th>Linha e onibus</th>
        <th>Valor</th>

    </tr>

    <c:forEach items="${vendas}" var="x">
        <fmt:formatDate value="${x.dataEhoraVenda}" pattern="dd/MM/yyyy HH:mm:ss" var="newdatevar" />
        <tr>
            <td align="center"><c:out value="${x.idVenda}"></c:out></td>              
            <td align="center"><c:out value="${newdatevar}"></c:out></td>                
            <td align="center"><c:out value="${x.fkCliente.nome}"></c:out></td>                
            <td align="center"><c:out value="${x.fkPassagem.fkOnibus.fkLinha.nome}"></c:out> - <c:out value="${x.fkPassagem.fkOnibus.idOnibus}"></c:out></td>                
            <td align="center"><c:out value="${x.fkPassagem.valor}"></c:out></td>
            </tr>
    </c:forEach>
</table>    