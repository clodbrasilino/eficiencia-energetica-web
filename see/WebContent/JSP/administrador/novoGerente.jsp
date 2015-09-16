<%@page import="br.edu.ifpi.see.util.GeneratedNumber"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="br.edu.ifpi.see.model.Usuario" %>
<%@ page import="br.edu.ifpi.see.dao.UsuarioDAO" %>
<%@ page import="br.edu.ifpi.see.util.GeneratedNumber" %>
<%@ page import="java.util.HashMap" %>


<html lang="pt-br">

    <head>
    	<title>Cadastro de Gerente</title>
        <meta name="author" content="Rita Aquino" />
        <meta name="description" content="Site Web Efeitos" />
		<link rel="stylesheet" href="/<%= application.getInitParameter("app-name") %>/CSS/style.css" />
	</head>
 <body>
 	<%
 		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
 		UsuarioDAO dao = new UsuarioDAO();
 		GeneratedNumber gn = new GeneratedNumber();
 	%>
 	<div id="fundo">
		<div id="corpo">
		
		
		<img src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png" id="img_topo" alt="Logo" title="Acompanhe a eficiência energética !">
		
	
	<div id="header">
		<h4>			Parnaiba - PI				</h4>
		<p>				Bem vindo <%= u.getNome() %>		</p>
		<h1>			Cadastrar Gerente		 	</h1>
	</div>
	
	
	
	<div id="formulario">
			<form method="POST" action="/<%=application.getInitParameter("app-name")%>/ServletCadastroGerente">
				<br/>
				<br/>
				<label>Número:</label><br/>
				<input type="text" name="numero" disabled value="<%= gn.geraNumeroGerente() %>" class="disabled"/>
				<br/>
				<br/>
				
				<label>Nome:</label><br/>
				<input type="text" name="nome" class="input" />
				<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("nome") : "" %></p>
				
				<label>Endereço:</label><br/>
				<input type="text" name="endereco"  class="input" />
				<br/>
				<br/>
				
				<label>E-mail:</label><br/>
				<input type="text" name="email"  class="input" />
				<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("email") : "" %></p>
				
				<label>Telefone:</label><br/>
				<input type="text" name="telefone"  class="input" />
				<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("telefone") : "" %></p>
				
				<label>Senha:</label><br/>
				<input type="password" name="senha"  class="input" />
				<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("senha") : "" %></p>
				
				<label>Informe a senha novamente:</label><br/>
				<input type="password" name="confirmacaoSenha"  class="input" />
				<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("confirmacaoSenha") : "" %></p>
				
				<a href="/<%= application.getInitParameter("app-name") %>/JSP/administrador/administrador.jsp">Voltar</a>
				<input type="submit" value="Salvar" />
				
			</form>
		</div>
		<%
       		if(request.getAttribute("confirmacao") != null){
       			out.print("<div id=\"confirmacao\">");
       			out.print("		<p> Salvo com sucesso </p>");
       			out.print("</div>");
       		}
         %>
			
		</div>
	</fieldset>
	
	</div>
	</div>	
	
 </body>
</html> 