<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="classesBEAN.Passagem"%>
<%@page import="classesDAOpure.PassagemDAO"%>
<% 
   int passagem = Integer.parseInt(request.getParameter("passagem"));
   
   PassagemDAO passDAO = new PassagemDAO();
   int numeroDisponiveis = passDAO.GetVagasDisponiveis(passagem);
   
   request.setAttribute("numeroDisponiveis", numeroDisponiveis);
   
%>

<h1>Vagas Disponiveis: <c:out value="${numeroDisponiveis}"></c:out></h1>
<input value="<c:out value="${numeroDisponiveis}"></c:out>" type="hidden" name="numeroDisponiveis" />
