<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpi.see.model.Usuario"%>
<%@ page import="br.edu.ifpi.see.util.JPAUtil"%>
<%@ page import="javax.persistence.EntityManager"%>
<%@ page import="br.edu.ifpi.see.dao.UsuarioDAO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<title>Atualizando Dados Cadastrais</title>
<meta name="author" content="Rita Aquino" />
<meta name="description" content="Site Web Efeitos" />
<link rel="stylesheet"
	href="/<%=application.getInitParameter("app-name")%>/CSS/style2.css" />
</head>
<body>


	<img
		src="/<%=application.getInitParameter("app-name")%>/IMG/topo-site.png"
		id="img_topo" alt="Logo" title="Logo">


	<div class="corpo">
		<h4>Parnaiba - PI</h4>
		<p>Bem vindo, Administrador</p>
		<center>
			<h1>Atualizando dados cadastrais</h1>
		</center>
	</div>

	<%
		Usuario administrador = (Usuario) request.getSession().getAttribute("usuario");
	%>
	<div class="form">
		<form method="POST"
			action="/<%=application.getInitParameter("app-name")%>/ServletAlterarAdministrador">
			<table>
				<tr>
					<td><label>N�mero:</label></td>
					<td><input type="text" name="numero"
						value="G00<%=administrador.getId()%>" disabled /></td>
				</tr>
				<tr>
					<td><label>Nome:</label></td>
					<td><input type="text" name="nome" value="<%=administrador.getNome()%>"
						class="input" /></td>
				</tr>
				<tr>
					<td><label>Endere�o:</label></td>
					<td><input type="text" name="endereco"
						value="<%=administrador.getEndereco()%>" class="input" /></td>
				</tr>
				<tr>
					<td><label>E-mail:</label></td>
					<td><input type="text" name="email"
						value="<%=administrador.getEmail()%>" class="input" /></td>
				</tr>
				<tr>
					<td><label>Telefone:</label></td>
					<td><input type="text" name="telefone"
						value="<%=administrador.getTelefone()%>" class="input" /></td>
				</tr>
				<tr>
					<td><label>Senha:</label></td>
					<td><input type="password" name="senha"
						value="<%=administrador.getSenha()%>" class="input" /></td>
				</tr>
			</table>
			<input type="hidden" name="id" value="<%=administrador.getId()%>"> <input
				class="botao" type="submit" value="Salvar" />
		</form>

		<%
			if (request.getAttribute("confirmacao") != null) {
				out.print("<div id=\"confirmacao\">");
				out.print("		<p> Salvo com sucesso </p>");
				out.print("</div>");
			}
		%>
		
		<a href="/<%= application.getInitParameter("app-name") %>/JSP/administrador/administrador.jsp">Voltar</a>

	</div>

</body>
</html>