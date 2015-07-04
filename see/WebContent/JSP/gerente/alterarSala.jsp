<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpi.see.model.Usuario" %>
<%@ page import="br.edu.ifpi.see.model.Sala" %>
<%@ page import="br.edu.ifpi.see.model.MicroControlador" %>
<%@ page import="br.edu.ifpi.see.dao.SalaDAO" %>
<%@ page import="javax.persistence.EntityTransaction" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>

<html lang="pt-br">
    <head>
    	<title>Atualizando Sala</title>
        <meta name="author" content="Rita Aquino" />
        <meta name="description" content="Site Web Efeitos" />
		<link rel="stylesheet" href="/<%= application.getInitParameter("app-name") %>/CSS/style.css"/>
	</head>
 <body>
	<div id="fundo">
		<div id="corpo">
		
		<img src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png" id="img_topo" alt="Logo" title="Acompanhe a eficiência energética !">
			
	<%
		HttpSession s = request.getSession();
		Usuario u = (Usuario) s.getAttribute("usuario");
		Sala sala = (Sala) request.getAttribute("sala");
		
		EntityManager em = (EntityManager) getServletContext().getAttribute("em");
		SalaDAO dao = new SalaDAO();
		
	%>	
	<div class="corpo">
		<h4>			Parnaiba - PI		</h4>
		<p>				Bem vindo <%= u.getNome() %>	</p>
		<h1>        	Atualizando Sala 	</h1>
	</div>	
		
	<div class="form">
		<form method="POST" action="/<%= application.getInitParameter("app-name") %>/ServletAlterarSala">
					<label>Número:</label><input type="text" name="numero" value="<%=sala.getNumero()%>"/><br></br>
					<label>Descrição:</label><input type="text" name="descricao" value="<%=sala.getDescricao()%>"/><br></br>
					<label>Pavimento:</label>
					<select name="pavimento">
						<option value="0"><%=sala.getPavimento()%></option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select><br></br>
					
					<input type="hidden" name="id" value="<%=sala.getId()%>"/>
					
					<input type="submit" name="add" value="Adicionar" class="btn_show_popup">
					
					<table border=1>
	
						<tr>
							<td width="130" height="30"><b>	Número				</b></td>
							<td width="130" height="30"><b>	Data			</b></td>
							<td width="130" height="30"><b>	IP	</b></td>
							<td width="130" height="30"><b>	Sensor de Porta	</b></td>
							<td width="130" height="30"><b>	Sensor de Presença	</b></td>
							<td width="130" height="30"><b>	Sensor de Lâmpadas	</b></td>
							<td width="130" height="30"><b>	Sensor de Ar	</b></td>
							<td width="180" height="30"><b>	Opções				</b></td>
						</tr>
						
						<%

						if(sala.getListaMicroControlador() != null){
							for(MicroControlador mc : sala.getListaMicroControlador()){
								out.print("<tr>");
								out.print("	   <td width=\"100\">" +  mc.getId()    + "	</td>");
								out.print("		<td width=\"100\">"     + new SimpleDateFormat().getDateInstance(DateFormat.MEDIUM).format(mc.getDtInstalacao().getTimeInMillis()) + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getIp() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorPorta() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorPresenca() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorLampada() + "	</td>");
								out.print("		<td width=\"100\">"     +  mc.getSensorAr() + "	</td>");
								out.print("		<td width=\"210\" height=\"40\">");
								out.print("			<a href=\"/"+getServletContext().getInitParameter("app-name")+"/ServletAlterarMicroControlador?id="+mc.getId()+"\">			Alterar		</a> |");
								out.print("<a onclick='confirmaExclusaoGerente("+mc.getId()+")' href='#'> Excluir |</a>");
								out.print("			<a href=\"/"+getServletContext().getInitParameter("app-name")+"/ServletDetalhesGerente?id="+mc.getId()+"\">		Detalhes	</a>");
								out.print("		</td>");
								out.print("</tr>");
							}
						}
					%>
					</table>
					
				<a href="/<%= application.getInitParameter("app-name") %>/JSP/gerente/gerente.jsp">Voltar</a>
				<input type="submit" name="salvar" value="Salvar"/>
			</form>
					
	</div>
	</div>
	</div>	
 </body>
</html>
