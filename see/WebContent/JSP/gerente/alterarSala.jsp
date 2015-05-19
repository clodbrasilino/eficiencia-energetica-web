<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="br.edu.ifpi.see.model.Usuario" %>
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
		
	%>	
	<div class="corpo">
		<h4>			Parnaiba - PI		</h4>
		<p>				Bem vindo <%= u.getNome() %>	</p>
		<h1>        	Atualizando Sala 	</h1>
	</div>	
		
	<div class="form">
		<form method="POST" action="/<%= application.getInitParameter("app-name") %>/ServletAlterarSala">
				<label>Nº sala:</label>
				<input type="number" name="numero" />
				
				<br><br>
				
				<label>Descrição: </label>
				<br>
				<textarea rows=6 cols=50></textarea>
				<br>
				
				<input type="submit" value="Salvar"/>
			</form>
			<form action="/<%= application.getInitParameter("app-name") %>/jsp/gerente/gerente.jsp"><input type="submit" value=" Voltar "></form>
	</div>
	</div>
	</div>	
 </body>
</html>
