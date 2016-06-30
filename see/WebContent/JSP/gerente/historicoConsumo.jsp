<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifpi.see.model.HistoricoSala"%>
<%@ page import="br.edu.ifpi.see.dao.HistoricoSalaDAO"%>
<%@ page import="javax.persistence.EntityManager"%>
<%@ page import="javax.persistence.EntityTransaction"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Histórcio de consumo</title>
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style.css" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/tabela.css" />
</head>
<body>
	<div id="fundo">
			<div id="corpo">

			<img
				src="/<%=application.getInitParameter("app-name")%>/IMG/topo-site.png"
				id="img_topo" alt="Logo" title="Acompanhe a eficiência energética !">

			<div id="header">
				<h2>Histórico de consumo das salas</h2>
				<h2><%= request.getAttribute("data") != null ? request.getAttribute("data") : "" %></h2>
				<h2><%= request.getAttribute("dataInicial") != null ? "De: "+request.getAttribute("dataInicial") : "" %>
					<%= request.getAttribute("dataFinal") != null ? " a: "+request.getAttribute("dataFinal") : "" %>
				</h2>
			</div>
	
	<form action="/<%= application.getInitParameter("app-name")%>/ServletConsultaHistoricoSala" method="post" id="formulario" style="padding: 50px 0 50px 0;"> 
		<label>Data Inicial: </label><input type="text" name="dataInicial" placeholder="Informe a data inicial"><br/><br/>
		<label>Data Final: </label><input type="text" name="dataFinal" placeholder="Informe a data final"><br/><br/>
		<input type="submit" value="Pesquisar">
	</form>
	<br/>
	
	<% 	List<HistoricoSala> historicos = (List<HistoricoSala>) request.getAttribute("historicos");
		
		if(historicos.size() == 0){
			out.print("<h2>Não há registros para o período informado!</h2>");
		}else{
	%>
		<div class="infor">
		<table>
	
			<tr>
				<th width="130" height="30">Sala</th>
				<th width="130" height="30">Status</th>
				<th width="130" height="30">Hora</th>
			</tr>
	
			<%	
				DateFormat hf = new SimpleDateFormat("HH:mm:ss");
				
				for(HistoricoSala hs : historicos){
					out.print("<tr>");
					out.print("	   <td width=\"100\">" +  hs.getSala().getNumero()    + "	</td>");
					out.print("		<td width=\"100\">"     +  hs.getStatus()  + "	</td>");
					out.print("		<td width=\"100\">"     +  hf.format(hs.getHora().getTime()) + "	</td>");
					out.print("</tr>");
				}
			}
			%>
		</table>
		</div>
	</div>
	</div>
</body>
</html>