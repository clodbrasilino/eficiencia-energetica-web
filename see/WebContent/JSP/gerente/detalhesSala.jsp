<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpi.see.model.Usuario"%>
<%@ page import="br.edu.ifpi.see.model.Sala"%>
<%@ page import="br.edu.ifpi.see.model.MicroControlador"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<title>Detalhes da Sala</title>
<meta name="author" content="Rita Aquino" />
<meta name="description" content="Site Web Efeitos" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style.css" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/tabela.css" />
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

			<div id="header">
				<h4>Parnaiba - PI</h4>
				<p>Bem vindo, <%=u.getNome()%></p>
				<h1>Detalhes da Sala</h1>
			</div>
			<% Sala s = (Sala) request.getAttribute("sala"); %>
			<br/><br/>
			<div class="infor" style="border: 1px solid black; ">
				<table>
					<tr>
						<td width="130" height="30"><b>	Número				</b></td>
						<td width="130" height="30"><b>			</b></td>
						<td width="130" height="30"><b>	Descrição				</b></td>
						<td width="130" height="30"><b>			</b></td>
						<td width="130" height="30"><b>	Pavimento					</b></td>
						<td width="130" height="30"><b>			</b></td>
						<td width="130" height="30"><b>	Ativa		</b></td>
					</tr>
					
					<tr>
						<td width="130" height="30"><b>	<%= s.getNumero() %>				</b></td>
						<td width="130" height="30"><b>			</b></td>
						<td width="130" height="30"><b>	<%= s.getDescricao() %>				</b></td>
						<td width="130" height="30"><b>			</b></td>
						<td width="130" height="30"><b>	<%= s.getPavimento() %>					</b></td>
						<td width="130" height="30"><b>			</b></td>
						<td width="130" height="30"><b>	<%= s.getAtiva() %>		</b></td>
					</tr>
				</table>
			</div>

			
			
			<div class="infor" style="padding-top: 50px;">
	        <table border=0>
	
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
								out.print("		<td width=\"100\">"     +  SimpleDateFormat.getDateInstance(DateFormat.MEDIUM).format(mc.getDtInstalacao().getTimeInMillis())  + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getIp() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorPorta() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorPresenca() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorLampada() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorAr() + "	</td>");
								
							}
						}
					%>
					</table>
					
					<br/>
					<a href="/<%= application.getInitParameter("app-name") %>/JSP/gerente/gerente.jsp">Voltar</a>
				</div>
					
	        
				
		

		</div>
	</div>

</body>
</html>
