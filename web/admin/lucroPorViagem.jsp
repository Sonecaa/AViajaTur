<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="classesBEAN.Passagem"%>
<%@page import="java.util.List"%>
<%@page import="classesDAOpure.PassagemDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
    $(document).ready(function () {
           
         $('#cmbPassagem').on('change', function () {

            $.ajax({url: "admin/lucroPorViagemAJAX.jsp?passagem=" + this.value, success: function (result) {
                    $("#resultado").html(result);
                }});
        })
    });


</script>

<%
    PassagemDAO passDAO = new PassagemDAO();

    List<Passagem> passagens = passDAO.getAllPassagens();
    request.setAttribute("passagens", passagens);
%>

<h4>Passagens/Viagens:</h4>
<select name="cmbPassagem" id="cmbPassagem">
    <option>Escolha a viagem</option>
    <c:forEach items="${passagens}" var="x">
        <fmt:formatDate value="${x.dataEhora}" pattern="dd/MM/yyyy HH:mm:ss" var="newdatevar" />
        <option value="<c:out value="${x.idPassagem}"></c:out>"> <c:out value="${x.fkOnibus.idOnibus}"></c:out> - <c:out value="${x.fkOnibus.fkLinha.nome}"></c:out> ||  <c:out value="${x.valor}"></c:out>  - <c:out value="${newdatevar}"></c:out>  </option>                                                                                      
    </c:forEach>
</select>

<div id="resultado">
    
</div>