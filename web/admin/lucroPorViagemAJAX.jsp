<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="classesBEAN.Passagem"%>
<%@page import="classesDAOpure.PassagemDAO"%>
<% 
   int passagem = Integer.parseInt(request.getParameter("passagem"));
   
   PassagemDAO passDAO = new PassagemDAO();
   Double lucroTotal = passDAO.GetLucroPorPassagem(passagem);
   
   request.setAttribute("lucroTotal", lucroTotal);
   
%>
<h1>LucroTotal: <c:out value="${lucroTotal}"></c:out></h1>