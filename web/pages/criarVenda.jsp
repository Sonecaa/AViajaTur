
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="classesBEAN.Onibus"%>
<%@page import="java.util.List"%>
<%@page import="classesDAOpure.OnibusDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
    $(document).ready(function () {
    

        $('#cmbOnibus').on('change', function () {

            $.ajax({url: "pages/passagemPorOnibus.jsp?idOnibus=" + this.value, success: function (result) {
                    $("#cmbPassagem").html(result);
                    $("#numeroDisponiveis").html("");
                }});
        })
        
         $('#cmbPassagem').on('change', function () {

            $.ajax({url: "pages/numeroVagasDiponiveis.jsp?passagem=" + this.value, success: function (result) {
                    $("#numeroDisponiveis").html(result);
                }});
        })
    });


</script>


<h1>Comprar Passagem</h1>

<form action="home" method="post">
    <div class="form-group"> 
        <%
            OnibusDAO oniDao = new OnibusDAO();

            List<Onibus> listaOni = oniDao.getAllOnibus();

            request.setAttribute("listaOni", listaOni);
        %>
        Onibus/Linha:
        <select class="form-control" name="cmbOnibus" id="cmbOnibus" >
            <c:forEach items="${listaOni}" var="x">
                <option value="<c:out value="${x.idOnibus}"></c:out>"><c:out value="${x.idOnibus}"></c:out> - <c:out value="${x.fkLinha.nome}"></c:out>  </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group"> 
        Passagens:
        <select class="form-control" name="cmbPassagem" id="cmbPassagem">
            <option>Escolha o onibus primeiro</option>
        </select>
    </div>
    
    <div class="form-group" id="numeroDisponiveis"> 
     
    </div>    
        
    <input type="hidden" name="txtPagina" value="criarVenda">
    <button type="submit" class="btn btn-success">Comprar</button>    
</form>