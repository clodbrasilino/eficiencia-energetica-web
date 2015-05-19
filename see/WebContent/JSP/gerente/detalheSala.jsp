<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
    <head>
    	<title>Detalhes da Sala</title>
        <meta name="author" content="Rita Aquino" />
        <meta name="description" content="Site Web Efeitos" />
		<link rel="stylesheet" href="/<%= application.getInitParameter("app-name") %>/CSS/style.css"/>
	</head>
 <body>
	<div id="fundo">
		<div id="corpo">
		
		<img src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png" id="img_topo" alt="Logo" title="Acompanhe a eficiência energética !">
		
	
	<div class="corpo">
		<h4>Parnaiba - PI</h4>
		<p>
			Bem vindo <%= request.getAttribute("nomeUsuario")  %></p>
		<h1>Detalhes da Sala</h1>
	</div>	
	
	<!-- Gambiarra nesse form. Ajeitar depois -->
    <form action="/<%= application.getInitParameter("app-name") %>/jsp/gerente/gerente.jsp"><input type="submit" value="Voltar"></form>
		
	</div>
	</div>
	
 </body>
</html> 