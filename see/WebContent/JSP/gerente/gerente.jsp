<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpi.see.model.Usuario" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
	<head>
		<title>Página Principal do Gerente</title>
		<meta name="author" content="Rita Aquino" />
		<meta name="description" content="Site Web Efeitos" />
		<link rel="stylesheet" href="/<%= application.getInitParameter("app-name") %>/CSS/style.css" />
	</head>
	<body>
		<div id="fundo">
			<div id="corpo">
			
			<img src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png" id="img_topo" alt="Logo" title="Acompanhe a eficiência energética !">
			
			<%
				Usuario u = (Usuario) request.getSession().getAttribute("usuario");
			%>
			
			<div id="header">
				<h4>			Parnaiba - PI								</h4>
				<p>				Bem vindo <%= u.getNome() %>		</p>
				<h1>			Informações das Salas cadastradas			</h1>
			</div>
	
				<div class="infor">
					<table border=1>
	
						<tr>
							<td width="130" height="30"><b>	Número				</b></td>
							<td width="130" height="30"><b>	Status				</b></td>
							<td width="130" height="30"><b>	Micro-Controlador	</b></td>
							<td width="180" height="30"><b>	Opções				</b></td>
						</tr>
						
						<tr>
							<td width="100">					S 001	</td>
							<td width="100">					Livre	</td>
							<td width="100">					MC001	</td>
							<td width="210" height="40">
								
								<a href="/<%= application.getInitParameter("app-name") %>/jsp/gerente/alterarSala.jsp">	Alterar		</a>	| 
								<a href="/<%= application.getInitParameter("app-name") %>/ServletExcluirSala">				Excluir		</a>	| 
								<a href="/<%= application.getInitParameter("app-name") %>/jsp/gerente/detalheSala.jsp">	Detalhes	</a>
							</td>
						</tr>
						
						<tr>
							<td width="100">				S 002			</td>
							<td width="100">				Em Ultilização	</td>
							<td width="100">				MC002			</td>
							<td width="210" height="40">
								<a href="/<%= application.getInitParameter("app-name") %>/jsp/gerente/alterarSala.jsp">	Alterar		</a>	| 
								<a href="/<%= application.getInitParameter("app-name") %>/ServletExcluirSala">				Excluir		</a> 	| 
								<a href="/<%= application.getInitParameter("app-name") %>/jsp/gerente/detalheSala.jsp">	Detalhes	</a>
							</td>
						</tr>
						
						<tr>
							<td width="100">				S 003			</td>
							<td width="100">				Desperdício		</td>
							<td width="100">				MC003			</td>
							<td width="210" height="40">
								<a href="JSP/alterarSala.jsp">						Alterar		</a>	|
								<a href="/<%= application.getInitParameter("app-name") %>/ServletExcluirSala">				Excluir		</a> 	| 
								<a href="/<%= application.getInitParameter("app-name") %>/jsp/gerente/detalheSala.jsp">	Detalhes	</a>
							</td>
						</tr>
						
						<tr>
							<td width="100">				S 004			</td>
							<td width="100">				Desperdício 	</td>
							<td width="100">				MC004			</td>
							<td width="210" height="40">
								<a href="/<%= application.getInitParameter("app-name") %>/jsp/gerente/alterarSala.jsp">	Alterar		</a>	|
								<a href="/<%= application.getInitParameter("app-name") %>/ServletExcluirSala">				Excluir		</a> 	| 
								<a href="/<%= application.getInitParameter("app-name") %>/jsp/gerente/detalheSala.jsp">	Detalhes	</a>
							</td>
						</tr>
						
						
					</table>
				</div>
	
				<div class="botao">
					<table>
					<tr>
						<td>
							<form action="/<%= application.getInitParameter("app-name") %>/ServletLogout"><input type="submit" value="Sair"/></form>
						</td>
						<td>
							<form action="/<%= application.getInitParameter("app-name") %>/JSP/gerente/novoSala.jsp"> 
								<input type="submit" value=" Nova Sala ">
							</form>
						</td>
				</table>
				</div>
			</div>
		</div>
	</body>
</html>