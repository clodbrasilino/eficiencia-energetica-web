<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="br.edu.ifpi.see.model.Usuario" %>


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
 	%>
 	<div id="fundo">
		<div id="corpo">
		
		
	<img src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png" id="img_topo" alt="Logo" title="Acompanhe a eficiência energética !">
		
	
	<div id="header">
		<h4>			Parnaiba - PI				</h4>
		<p>				Bem vindo <%= u.getNome() %>		</p>
		<h1>			Cadastrar Gerente		 	</h1>
	</div>	
	
	<fieldset>
		<div>        	
			<form method="POST" action="/<%= application.getInitParameter("app-name") %>/ServletCadastroGerente">
				<table>            		
					<tr>
	                    <td>	<label>Nome:</label>										</td>
	                    <td>	<input type="text" name="nome" class="input"/>				</td>
	                </tr>
	                <tr>
	                	<td>	<label>Endereço:</label>									</td>
	                   <td>		<input type="text" name="endereco" class="input"/>		</td>
	                </tr>
					<tr>
	                	<td>	<label>E-mail:</label>										</td>
	                   <td>		<input type="text" name="email" class="input"/>			</td>
	                </tr>
	                <tr>
	                	<td>	<label>Telefone:</label>									</td>
	                    <td>	<input type="text" name="telefone" class="input"/>		</td>
	                 </tr>
	                 <tr>
	                	<td>	<label>Senha:</label>										</td>
	                    <td>	<input type="password" name="senha" class="input"/>			</td>
	                 </tr>
	               </table>
	               
					<input type="submit" value=" Salvar "/>
			</form>
			
			
			<!-- Gambiarra nesse form. Ajeitar depois -->
	        <form action="/<%= application.getInitParameter("app-name") %>/jsp/administrador/administrador.jsp"><input type="submit" value="Voltar"></form>
			
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