<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifpi.see.model.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
    <head>
    	<title>Alterar Micro Controlador</title>
        <meta name="author" content="Rita Aquino" />
        <meta name="description" content="Site Web Efeitos" />
		<link rel="stylesheet" href="/<%= application.getInitParameter("app-name") %>/CSS/style.css"/>
	</head>
 <body>
 	<div id="fundo">
		<div id="corpo">
		
		<img src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png" id="img_topo" alt="Logo" title="Acompanhe a eficiência energética !">
			
	<%
		Usuario u = (Usuario) session.getAttribute("usuario");
	%>	
	<div id="header">
		<h4>			Parnaiba - PI					</h4>
		<p>				Bem vindo <%= u.getNome() %>	</p>
		<h1> 			Cadastro de Micro Controlador	</h1>
	</div>	
		
	<div class="form">
		<form method="POST" action="/<%=application.getInitParameter("app-name")%>/ServletSalvarMicroControlador">
				<label>IP:</label>
				<input type="text" name="ip" />
				<br><br>
				
				<fieldset>
					<legend>Sensores:</legend>
					<input type="checkbox" value="true" name="porta">Porta</br>
					<input type="checkbox" value="true" name="presenca">Presença</br>
					<input type="checkbox" value="true" name="lampadas">Lâmpadas</br>
					<input type="checkbox" value="true" name="ar">Ar</br>
				</fieldset>
				<br><br>
				
				<a href="/<%= application.getInitParameter("app-name") %>/JSP/gerente/novaSala.jsp">Voltar</a>	
				
				<input class="botao"type="submit" value=" Salvar "/>
			</form>
		
	</div>
	</div>
	</div>	
 </body>
</html>