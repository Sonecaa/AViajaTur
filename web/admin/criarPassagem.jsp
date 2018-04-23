
<%@page import="java.util.Date"%>
<%@page import="classesDAOpure.LinhaDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="classesBEAN.Onibus"%>
<%@page import="java.util.List"%>
<%@page import="classesDAOpure.OnibusDAO"%>
   
<div class="container">
    <h1>Criar passagem</h1>
    <form method="post" action="home">

        <input type="hidden" name="txtPagina" value="criarPassagem">

        <div class="form-group"> 

            <%
                OnibusDAO oniDAO = new OnibusDAO();

                List<Onibus> onibus = oniDAO.getAllOnibus();
                request.setAttribute("onibus", onibus);
            %>
            <select class="custom-select" id="cmbLinha" name="cmbOnibus">
                <option selected>Escolher onibus...</option>
                <c:forEach items="${onibus}" var="x">
                    <option value="<c:out value="${x.idOnibus}"/>"> <c:out value="${x.idOnibus}"/> - <c:out value="${x.fkLinha.nome}"/></option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">      
            <input type="datetime-local" required class="form-control" name="txtDataEHora">
        </div>
        <div class="form-group">      
            <input type="number" name="txtValor" min="0.99" step="1.00" max="2500" value="49.99" />
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
 
</div>