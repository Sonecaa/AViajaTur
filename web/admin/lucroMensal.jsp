<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
    $(document).ready(function () {    
        $('#cmbMes').on('change', function () {

            $.ajax({url: "admin/lucroMensalAJAX.jsp?mes=" + this.value +"&ano=" + document.getElementById('txtAno').value, success: function (result) {
                    $("#resultado").html(result);
                }});
        })

    });
</script>

<select name="cmbMes" id="cmbMes">
    <option>Escolha o mês</option>
    <option value="01">1 - Janeiro</option>
    <option value="02">2 - Fevereiro</option>
    <option value="03">3 - Março</option>
    <option value="04">4 - Abril</option>
    <option value="05">5 - Maio</option>
    <option value="06">6 - Junho</option>
    <option value="07">7 - Julho</option>
    <option value="08">8 - Agosto</option>
    <option value="09">9 - Setembro</option>
    <option value="10">10 - Outubro</option>
    <option value="11">11 - Novembro</option>
    <option value="12">12 - Dezembro</option>
</select>
<input type="number" value="2018" name="txtAno" id="txtAno"/>

<div id="resultado"></div>