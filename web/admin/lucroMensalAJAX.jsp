<%@page import="classesDAOpure.VendaDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<% 
   int mes = Integer.parseInt(request.getParameter("mes"));
   int ano = Integer.parseInt(request.getParameter("ano"));
  
   VendaDAO venDAO = new VendaDAO();
    Double lucroMensal = venDAO.GetLucroByMes(mes, ano);
   
  
   request.setAttribute("lucroMensal", lucroMensal);
   
%>
<h1>LucroTotal: <c:out value="${lucroMensal}"></c:out></h1>