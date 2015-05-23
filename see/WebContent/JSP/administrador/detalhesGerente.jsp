<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ page import="br.edu.ifpi.see.model.Usuario" %>
<%@ page import="br.edu.ifpi.see.util.JPAUtil" %>
<%@ page import="javax.persistence.EntityTransaction" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="br.edu.ifpi.see.dao.UsuarioDAO" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
    <head>
    	<title>Detalhes do Gerente</title>
        <meta name="author" content="Rita Aquino" />
        <meta name="description" content="Site Web Efeitos" />
		<link rel="stylesheet" href="/<%= application.getInitParameter("app-name") %>/CSS/style.css" />
	</head>
 <body>
 	<%
 		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
 		Usuario gerente = (Usuario) request.getAttribute("gerente");
 	%>
 
	<div id="fundo">
		<div id="corpo">  
		
		
		 <img  src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png"  id="topo_site" alt="Logo" title="Logo"> 
			
		
		<div id="header">
			<h4>			Parnaiba - PI				</h4>
			<p>				Bem vindo <%= u.getNome() %>		</p>
			<h1>			Detalhes do Gerente 		</h1>
		</div>	
		
		<fieldset>
			<legend> Detalhes do Gerente </legend>
			<div>
				<p>N�mero: <%= gerente.getId() %></p>
				<p>Nome: <%= gerente.getNome() %></p>
				<p>Endere�o: <%= gerente.getEndereco() %></p>
				<p>Email: <%= gerente.getEmail() %></p>
				<p>Telefone: <%= gerente.getTelefone() %></p>
				<p>Ativo: <%= gerente.getAtivo() %></p>
	        
	        <a href="/<%= application.getInitParameter("app-name") %>/JSP/administrador/administrador.jsp">Voltar</a>
	        
			</div>	
		</fieldset>
	</div>
	</div>
 </body>
</html> 