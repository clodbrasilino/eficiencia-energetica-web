<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="br.edu.ifpi.see.model.TempoStatus" %>
<%@ page import="br.edu.ifpi.see.model.Sala" %>
<%@ page import="java.text.DecimalFormat" %>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tempo de Consumo</title>
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style.css" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/tabela.css" />
</head>
<body>
	<div id="fundo">
		<div id="corpo">

			<img
				src="/<%=application.getInitParameter("app-name")%>/IMG/topo-site.png"
				id="img_topo" alt="Logo" title="Acompanhe a efici�ncia energ�tica !">

			<div id="header">
				<h2>Tempo de consumo das salas</h2>
				<h2><%= request.getAttribute("data") != null ? request.getAttribute("data") : "" %></h2>
				<h2><%= request.getAttribute("dataInicial") != null ? "De: "+request.getAttribute("dataInicial") : "" %>
					<%= request.getAttribute("dataFinal") != null ? " a: "+request.getAttribute("dataFinal") : "" %>
				</h2>
			</div>
	
	<form action="/<%= application.getInitParameter("app-name")%>/ServletConsultaTempoConsumoSala" method="post" id="formulario" style="padding: 50px 0 50px 0;">
		<label>Data Inicial: </label><input type="text" name="dataInicial" placeholder="Informe a data inicial"><br/><br/>
		<label>Data Final: </label><input type="text" name="dataFinal" placeholder="Informe a data final">
		<br/><br/>
		<input type="submit" value="Pesquisar">
	</form>
	<br/>
	
	<div class="infor" style="padding-bottom: 50px;">
	<table>
		
		<tr>
			<th width="130" height="30" rowspan="1"></th>
			<th width="130" height="30" colspan="5">Tempo de cada status</th>
		</tr>
		
		<tr>
			<th width="130" height="30">Sala</th>
			<th width="130" height="30">Sem consumo</th>
			<th width="130" height="30">Sala livre</th>
			<th width="130" height="30">Consumo normal</th>
			<th width="130" height="30">Desperd�cio</th>
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
					<th width="130" height="30"><%= s.getTempoStatus().get("Desperd�cio") != null ? df.format(s.getTempoStatus().get("Desperd�cio").getTempoMinutos()) + " min" : "0 min" %></th>
					<th width="130" height="30"><%= s.getTempoStatus().get("Verifique!") != null ? df.format(s.getTempoStatus().get("Verifique!").getTempoMinutos()) + " min" : "0 min" %></th>
				</tr>
			<%}
		%>
		
	</table>
	</div>
	</div>
	</div>
</body>
</html>