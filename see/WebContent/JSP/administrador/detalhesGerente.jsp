<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ page import="br.edu.ifpi.see.model.Usuario" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
    <head>
    	<title>Detalhes do Gerente</title>
        <meta name="author" content="Rita Aquino" />
        <meta name="description" content="Site Web Efeitos" />
		<link rel="stylesheet" href="/projeto2/CSS/style.css" />
	</head>
 <body>
 	<%
 		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
 	%>
 
	<div id="fundo">
		<div id="corpo">  
		
		
		 <img  src="/projeto2/IMG/topo-site.png"  id="topo_site" alt="Logo" title="Logo"> 
			
		
		<div id="header">
			<h4>			Parnaiba - PI				</h4>
			<p>				Bem vindo <%= u.getNome() %>		</p>
			<h1>			Detalhes do Gerente 		</h1>
		</div>	
		
		<fieldset>
			<legend> Detalhes do Gerente </legend>
			<div>
				<p>Nome:		</p>
				<p>Email:		</p>
				<p>Telefone:	</p>
				<p>Endereço:	</p>
				<p>Categoria:	</p>
	        <!-- Gambiarra nesse form. Ajeitar depois -->
	        <form class="botao" action="/projeto2/jsp/administrador/administrador.jsp"><input type="submit" value="Voltar"></form>
			</div>	
		</fieldset>
	</div>
	</div>
 </body>
</html> 