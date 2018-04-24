
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="classesBEAN.Onibus"%>
<%@page import="java.util.List"%>
<%@page import="classesDAOpure.OnibusDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
            <script>
            $(document).ready(function () {
                $("#cmbOnibus").on('change',function() {
                    $.ajax({url: "passagemPorOnibus.jsp", success: function (result) {
                            $("#cmbPassagem").html(result);
                        }});
                });
                
                 $('select').on('change', function() {
                   
                     $.ajax({url: "pages/passagemPorOnibus.jsp?idOnibus=" +  this.value , success: function (result) {
                            $("#cmbPassagem").html(result);
                        }});
                })
            });
            
             
        </script>


        <h1>Comprar Passagem</h1>

        <%
            OnibusDAO oniDao = new OnibusDAO();

            List<Onibus> listaOni = oniDao.getAllOnibus();

            request.setAttribute("listaOni", listaOni);
        %>
        <select name="cmbOnibus" >
            <c:forEach items="${listaOni}" var="x">
                <option value="<c:out value="${x.idOnibus}"></c:out>"><c:out value="${x.idOnibus}"></c:out> - <c:out value="${x.fkLinha.nome}"></c:out>  </option>
            </c:forEach>
        </select>
        <br>
        <select name="cmbPassagem" id="cmbPassagem">

        </select>

