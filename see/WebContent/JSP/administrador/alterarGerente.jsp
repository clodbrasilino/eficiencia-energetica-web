<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="br.edu.ifpi.see.model.Usuario" %>
<%@ page import="br.edu.ifpi.see.util.JPAUtil" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="br.edu.ifpi.see.dao.UsuarioDAO" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
    <head>
    	<title>Atualizando Cadastro de Gerente</title>
        <meta name="author" content="Rita Aquino" />
        <meta name="description" content="Site Web Efeitos" />
		<link rel="stylesheet" href="/<%= application.getInitParameter("app-name") %>/CSS/style2.css"/>
	</head>
 <body>
		
		
	<img src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png" id="img_topo" alt="Logo" title="Logo"> 
		
	
	<div class="corpo">
		<h4>			Parnaiba - PI					</h4>
		<p>				Bem vindo, Administrador			</p>
		<center><h1>	Atualizando dados do Gerente 	</h1></center>
	</div>	
	
	<%
		Usuario u = (Usuario) request.getAttribute("usuario");
	%>
	<div class="form">        	
		<form method="POST" action="/<%= application.getInitParameter("app-name") %>/ServletAlterarGerente">
			<table>            		
				<tr>
                   	<td>	<label>Nº Gerente:</label>									</td>
                    <td>	<input type="text" name="numero"  value="G00<%= u.getId() %>" disabled/>			</td>
                </tr>
                <tr>
                    <td>	<label>Nome:</label>										</td>
                    <td>	<input type="text" name="nome" value="<%= u.getNome() %>" class="input"/>				</td>
                </tr>
                <tr>
                	<td>	<label>Endereço:</label>									</td>
                   <td>		<input type="text" name="endereco" value="<%= u.getEndereco() %>" class="input"/>		</td>
                </tr>
				<tr>
                	<td>	<label>E-mail:</label>										</td>
                   <td>		<input type="text" name="email" value="<%= u.getEmail() %>" class="input"/>			</td>
                </tr>
                <tr>
                	<td>	<label>Telefone:</label>									</td>
                    <td>	<input type="text" name="telefone" value="<%= u.getTelefone() %>" class="input"/>		</td>
                 </tr>
                 <tr>
                	<td>	<label>Senha:</label>										</td>
                    <td>	<input type="password" name="senha" value="<%= u.getSenha() %>" class="input"/>			</td>
                 </tr>
               </table>
               <input type="hidden" name="id" value="<%= u.getId() %>">
				<input class="botao" type="submit" value="Salvar"/>
		</form>
		<!-- FIXME Gambiarra nesse form. Ajeitar depois -->
        <form class="botao" action="/<%= application.getInitParameter("app-name") %>/JSP/administrador/administrador.jsp"><input type="submit" value="Voltar"></form>
		
		<%
               		if(request.getAttribute("confirmacao") != null){
               			out.print("<div id=\"confirmacao\">");
               			out.print("		<p> Salvo com sucesso </p>");
               			out.print("</div>");
               		}
               %>
		
	</div>	
	
 </body>
</html> 