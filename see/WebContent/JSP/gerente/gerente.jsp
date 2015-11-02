<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpi.see.model.Usuario" %>
<%@ page import="br.edu.ifpi.see.model.Sala" %>
<%@ page import="br.edu.ifpi.see.dao.SalaDAO" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="javax.persistence.EntityTransaction" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.ifpi.see.request.GeneratedStatus" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
	<head>
		<title>Página Principal do Gerente</title>
		<meta name="author" content="Rita Aquino" />
		<meta name="description" content="Site Web Efeitos" />
		<link rel="stylesheet" href="/<%= application.getInitParameter("app-name") %>/CSS/style.css" />
		<script type="text/javascript" src="/see/JS/ConfirmacaoExcluir.js"></script>
	</head>
	<body>
		<div id="fundo">
			<div id="corpo">
			
			<img src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png" id="img_topo" alt="Logo" title="Acompanhe a eficiência energética !">
			
			<%
				Usuario u = (Usuario) request.getSession().getAttribute("usuario");
			%>
			
			<div id="header">
				<h4>Parnaiba - PI</h4>
				<p>Bem vindo, <% out.print(u.getNome()); %> | <a class="meus-dados" href="/<%= application.getInitParameter("app-name") %>/ServletAlterarDadosGerente"> Meus Dados </a></p>
				<h1>Informações das Salas cadastradas</h1>
				<a href="/<%= application.getInitParameter("app-name") %>/ServletConsultaHistoricoAtualSala">Histórico de consumo</a>
				<a href="/<%= application.getInitParameter("app-name") %>/ServletConsultaTempoConsumoAtualSala">Tempo de consumo</a>
			</div>
	
				<div class="infor">
					<table border=1>
	
						<tr>
							<td width="130" height="30"><b>	Número				</b></td>
							<td width="130" height="30"><b>	Descrição			</b></td>
							<td width="130" height="30"><b>	Status	            </b></td>
							<td width="130" height="30"><b>	Ativa	            </b></td>
							<td width="180" height="30"><b>	Opções				</b></td>
						</tr>
						
						<%
						List<Sala> salas = (List<Sala>) request.getServletContext().getAttribute("salas");
						
						for(Sala s : salas){
							out.print("<tr>");
							out.print("<td width=\"100\">"+s.getNumero()+"</td>");
							out.print("<td width=\"100\">"+s.getDescricao()+"</td>");
							out.print("<td width=\"100\">"+s.getId()+"</td>");
							out.print("<td width=\"100\">"+s.getAtiva()+"</td>");
							out.print("<td width=\"210\" height=\"40\">");
							out.print("<a href=\"/"+getServletContext().getInitParameter("app-name")+"/ServletAlterarSala?id="+s.getId()+"\">Alterar</a> |");
							out.print("<a onclick='confirmaExclusaoSala("+s.getId()+")' href='#'> Excluir |</a>");
							out.print("<a href=\"/"+getServletContext().getInitParameter("app-name")+"/ServletDetalhesSala?id="+s.getId()+"\">Detalhes</a>");
							out.print("</td>");
							out.print("</tr>");
						}
					%>
					</table>
				</div>
	
				<div class="botao">
					<table>
					<tr>
						<td>
							<form action="/<%= application.getInitParameter("app-name") %>/ServletLogout"><input type="submit" value="Sair"/></form>
						</td>
						<td>
							<form action="/<%= application.getInitParameter("app-name") %>/JSP/gerente/novaSala.jsp"> 
								<input type="submit" value=" Nova Sala ">
							</form>
						</td>
				</table>
				</div>
			</div>
		</div>
	</body>
</html>