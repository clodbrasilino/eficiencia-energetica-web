<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpi.see.model.Usuario"%>
<%@ page import="br.edu.ifpi.see.model.Gerente"%>
<%@ page import="br.edu.ifpi.see.util.JPAUtil"%>
<%@ page import="javax.persistence.EntityManager"%>
<%@ page import="br.edu.ifpi.see.dao.UsuarioDAO"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="br.edu.ifpi.see.util.GeneratedNumber"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<title>Atualizando Cadastro de Gerente</title>
<meta name="author" content="Rita Aquino" />
<meta name="description" content="Site Web Efeitos" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style_alterarGerente.css" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style.css" />
</head>
<body>
	
	<div id="fundo">
 		<div id="corpo">
     	 	<img  src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png"  id="img_topo" title="Logo" class="antes">
     
	

	 <div id="header">
		<h4>	Parnaiba - PI					</h4>
		<p>		Bem vindo, Administrador		</p>
		<h1>	Atualizando dados do Gerente	</h1>
	</div>

	<%
		Gerente gerente = (Gerente) request.getAttribute("gerente");
		GeneratedNumber gn = new GeneratedNumber();
	%>
	<div id="formulario">
			<form method="POST" action="/<%=application.getInitParameter("app-name")%>/ServletAlterarGerente">
				<br/>
				<br/>
				<label>N�mero:</label><br/>
				<input type="text" name="numero" value="<%=gn.converteNumeroGerente(gerente.getId())%>" disabled class="disabled"/>
				<br/>
				<br/>
				
				<label>Nome:</label><br/>
				<input type="text" name="nome" value="<%=gerente.getNome()%>" class="input" />
				<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("nome") : "" %></p>
				
				<label>Endere�o:</label><br/>
				<input type="text" name="endereco" value="<%=gerente.getEndereco()%>" class="input" />
				<br/>
				<br/>
				
				<label>E-mail:</label><br/>
				<input type="text" name="email" value="<%=gerente.getEmail()%>" class="input" />
				<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("email") : "" %></p>
				
				<label>Telefone:</label><br/>
				<input type="text" name="telefone" value="<%=gerente.getTelefone()%>" class="input" />
				<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("telefone") : "" %></p>
				
				<label>Senha:</label><br/>
				<input type="password" name="senha" value="<%=gerente.getSenha()%>" class="input" />
				<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("senha") : "" %></p>
				
				<label>Informe a senha novamente:</label><br/>
				<input type="password" name="confirmacaoSenha" value="<%=gerente.getSenha()%>" class="input" />
				<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("confirmacaoSenha") : "" %></p>
				
				<label>Ativo:</label>
				<input type="checkbox" name="ativo" value="true" <%= gerente.isAtivo() == true ? "checked" : "" %> class="input"/>
				<input type="hidden" name="id" value="<%=gerente.getId()%>">
				<br/>
				<br/>
				<br/>
				
				<a href="/<%= application.getInitParameter("app-name") %>/JSP/administrador/administrador.jsp">Voltar</a>
				<input type="submit" value="Salvar" />
				
			</form>
		</div>

		<%
			if (request.getAttribute("confirmacao") != null) {
				out.print("<div id=\"confirmacao\">");
				out.print("		<p> Salvo com sucesso </p>");
				out.print("</div>");
			}
		%>		
		

	</div>
	</div>
	

</body>
</html>
