<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<p>				Bem vindo Administrador			</p>
		<center><h1>	Atualizando dados do Gerente 	</h1></center>
	</div>	
	
	<div class="form">        	
		<form method="POST" action="/<%= application.getInitParameter("app-name") %>/ServletControleGerente">
			<table>            		
				<tr>
                   	<td>	<label>Nº Gerente:</label>									</td>
                    <td>	<input type="text" name="numero"  value="" disabled/>			</td>
                </tr>
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
               
				<input class="botao" type="submit" value="Salvar"/>
		</form>
		<!-- FIXME Gambiarra nesse form. Ajeitar depois -->
        <form class="botao" action="/<%= application.getInitParameter("app-name") %>/FiltroControl"><input type="submit" value="Voltar"></form>
		
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