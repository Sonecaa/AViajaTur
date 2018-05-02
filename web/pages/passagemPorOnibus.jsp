
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="classesBEAN.Passagem"%>
<%@page import="classesDAOpure.PassagemDAO"%>
<% 
   int idOnibus = Integer.parseInt(request.getParameter("idOnibus"));
   
   PassagemDAO passDAO = new PassagemDAO();
   List<Passagem> lista = passDAO.getPassagemPorOnibus(idOnibus);
   
   request.setAttribute("lista", lista);
%>
<option>Escolha a passagem agora</option>
<c:forEach items="${lista}" var="x">
    <fmt:formatDate value="${x.dataEhora}" pattern="dd/MM/yyyy HH:mm:ss" var="newdatevar" />
    <option value="<c:out value="${x.idPassagem}"></c:out>" >    <c:out value="${newdatevar}"></c:out> - <c:out value="${x.valor}"></c:out></option>
</c:forEach>