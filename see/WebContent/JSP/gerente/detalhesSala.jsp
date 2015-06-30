<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpi.see.model.Usuario"%>
<%@ page import="br.edu.ifpi.see.model.Sala"%>
<%@ page import="br.edu.ifpi.see.model.MicroControlador"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<title>Detalhes da Sala</title>
<meta name="author" content="Rita Aquino" />
<meta name="description" content="Site Web Efeitos" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style.css" />
</head>
<body>
	<%
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
	%>
	<div id="fundo">
		<div id="corpo">

			<img
				src="/<%=application.getInitParameter("app-name")%>/IMG/topo-site.png"
				id="img_topo" alt="Logo" title="Acompanhe a eficiência energética !">

			<div class="corpo">
				<h4>Parnaiba - PI</h4>
				<p>Bem vindo, <%=u.getNome()%></p>
				<h1>Detalhes da Sala</h1>
			</div>

			<fieldset>
			<legend>Detalhes da Sala</legend>
			<div>
				<% Sala s = (Sala) request.getAttribute("sala"); %>
				<p>Número: <%= s.getNumero() %></p>
				<p>Descrição: <%= s.getDescricao() %></p>
				<p>Pavimento: <%= s.getPavimento() %></p>
				<p>Ativa: <%= s.getAtiva() %></p>
	        
	        <table border=1>
	
						<tr>
							<td width="130" height="30"><b>	Número				</b></td>
							<td width="130" height="30"><b>	Data			</b></td>
							<td width="130" height="30"><b>	IP	</b></td>
							<td width="130" height="30"><b>	Sensor de Porta	</b></td>
							<td width="130" height="30"><b>	Sensor de Presença	</b></td>
							<td width="130" height="30"><b>	Sensor de Lâmpadas	</b></td>
							<td width="130" height="30"><b>	Sensor de Ar	</b></td>
						</tr>
						
						<%

						if(s.getListaMicroControlador() != null){
							for(MicroControlador mc : s.getListaMicroControlador()){
								out.print("<tr>");
								out.print("	   <td width=\"100\">" +  mc.getId()    + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getDtInstalacao()  + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getIp() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorPorta() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorPresenca() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorLampada() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorAr() + "	</td>");
								
							}
						}
					%>
					</table>
					
	        <a href="/<%= application.getInitParameter("app-name") %>/JSP/gerente/gerente.jsp">Voltar</a>
	        
			</div>	
		</fieldset>

		</div>
	</div>

</body>
</html>
