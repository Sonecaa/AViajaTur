<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="classesBEAN.Linha"%>
<%@page import="classesDAOpure.LinhaDAO"%>
<div class="container">
    <h1>Criar Onibus</h1>
    <form method="post" action="home">

        <input type="hidden" name="txtPagina" value="criarOnibus">

        <div class="form-group"> 

            <%
                LinhaDAO linDAO = new LinhaDAO();

                List<Linha> linhas = linDAO.getAllLinhas();
                request.setAttribute("linhas", linhas);
            %>
            <select class="custom-select" id="cmbLinha" name="cmbLinha">
                <option selected>Escolher linha...</option>
                <c:forEach items="${linhas}" var="x">
                    <option value="<c:out value="${x.idLinha}"/>"><c:out value="${x.nome}"/></option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">      
            <input type="text" required class="form-control" name="txtNumPoltronas" placeholder="Numero de poltronas">
        </div>


        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>