<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="br.edu.ifpi.see.model.TempoStatus" %>
<%@ page import="br.edu.ifpi.see.model.Sala" %>
<%@ page import="java.text.DecimalFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tempo de Consumo</title>
</head>
<body>
	
	<h2>Tempo de consumo das salas</h2>
	<h2><%= request.getAttribute("data") != null ? request.getAttribute("data") : "" %></h2>
	<h2><%= request.getAttribute("dataInicial") != null ? "De: "+request.getAttribute("dataInicial") : "" %>
		<%= request.getAttribute("dataFinal") != null ? " a: "+request.getAttribute("dataFinal") : "" %>
	</h2>
	
	<form action="/<%= application.getInitParameter("app-name")%>/ServletConsultaTempoConsumoSala" method="post">
		<label>Data Inicial: </label><input type="text" name="dataInicial" placeholder="Informe a data inicial">
		<label>Data Final: </label><input type="text" name="dataFinal" placeholder="Informe a data final">
		<input type="submit" value="Pesquisar">
	</form>
	<br/>
	
	<table border="1">
		
		<tr>
			<th width="130" height="30" rowspan="1"></th>
			<th width="130" height="30" colspan="5">Tempo de cada status</th>
		</tr>
		
		<tr>
			<th width="130" height="30">Sala</th>
			<th width="130" height="30">Sem consumo</th>
			<th width="130" height="30">Sala livre</th>
			<th width="130" height="30">Consumo normal</th>
			<th width="130" height="30">Desperdício</th>
			<th width="130" height="30">Verifique</th>
		</tr>
		
		<% List<Sala> salas = (List<Sala>) request.getAttribute("salas"); %>
		<% HashMap<String, TempoStatus> times = (HashMap<String, TempoStatus>) request.getAttribute("times"); %>
		<% DecimalFormat df = new DecimalFormat("0.##"); %>
		<%
			for(Sala s : salas){%>
				<tr>
					<th width="130" height="30"><%= s.getNumero() %></th>
					<th width="130" height="30"><%= s.getTempoStatus().get("Sem consumo") != null ? df.format(s.getTempoStatus().get("Sem consumo").getTempoMinutos()) + " min" : "0 min" %></th>
					<th width="130" height="30"><%= s.getTempoStatus().get("Sala livre") != null ? df.format(s.getTempoStatus().get("Sala livre").getTempoMinutos()) + " min" : "0 min" %></th>
					<th width="130" height="30"><%= s.getTempoStatus().get("Consumo normal") != null ? df.format(s.getTempoStatus().get("Consumo normal").getTempoMinutos()) + " min" : "0 min" %></th>
					<th width="130" height="30"><%= s.getTempoStatus().get("Desperdício") != null ? df.format(s.getTempoStatus().get("Desperdício").getTempoMinutos()) + " min" : "0 min" %></th>
					<th width="130" height="30"><%= s.getTempoStatus().get("Verifique!") != null ? df.format(s.getTempoStatus().get("Verifique!").getTempoMinutos()) + " min" : "0 min" %></th>
				</tr>
			<%}
		%>
		
	</table>
	
</body>
</html>