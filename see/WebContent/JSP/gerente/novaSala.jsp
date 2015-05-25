<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpi.see.model.Usuario" %>
<!DOCTYPE html>

<html lang="pt-br">
    <head>
    	<title>Cadastrar Sala</title>
        <meta name="author" content="Rita Aquino" />
        <meta name="description" content="Site Web Efeitos" />
		<link rel="stylesheet" href="/<%= application.getInitParameter("app-name") %>/CSS/style.css"/>
	</head>
 <body>
 	<div id="fundo">
		<div id="corpo">
		
		<img src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png" id="img_topo" alt="Logo" title="Acompanhe a efici�ncia energ�tica !">
			
	<%
		Usuario u = (Usuario) session.getAttribute("usuario");
	%>	
	<div id="header">
		<h4>			Parnaiba - PI					</h4>
		<p>				Bem vindo <%= u.getNome() %>	</p>
		<h1> 			Cadastro de Sala 				</h1>
	</div>	
		
	<div class="form">
		<form method="POST" action="">
				<label>N�mero:</label>
				<input type="text" name="numero" />
				<br><br>
				
				<label>Descri��o:</label>
				<input type="text" name="descricao" />
				<br><br>
				
				<label>Pavimento:</label>
				<select>
					<option>Selecione...</option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
				<br><br>
				
				<a href="/<%= application.getInitParameter("app-name") %>/JSP/gerente/novoMicroControlador.jsp">Adicionar</a>
				
				<table border="1">
					<tr>
						<td width="100">IP</td>
						<td width="100">Sensor de Porta</td>
						<td width="100">Sensor de Presen�a</td>
						<td width="100">Sensor de L�mpadas</td>
						<td width="100">Sensor de Ar</td>
						<td width="200">Op��es</td>
					</tr>
				</table>
				
				<a href="/<%= application.getInitParameter("app-name") %>/JSP/gerente/gerente.jsp">Voltar</a>
				
				<input class="botao"type="submit" value=" Salvar "/>
			</form>	
		
	</div>
	</div>
	</div>	
 </body>
</html>
