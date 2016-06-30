<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpi.see.model.Usuario"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="br.edu.ifpi.see.util.GeneratedNumber"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<title>Atualizando Dados Cadastrais</title>
<meta name="author" content="Rita Aquino" />
<meta name="description" content="Site Web Efeitos" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style.css" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style_alterarDados.css" />
<script type="text/javascript" src="/<%=application.getInitParameter("app-name")%>/JS/pop_alterarDados.js"></script>
</head>

<body>

	<%
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
		GeneratedNumber gn = new GeneratedNumber();
	%>
	<div id="fundo">
 		<div id="corpo">
     	 	<img  src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png"  id="img_topo" title="Logo" class="antes">
     
	
	<div id="header">
		<h4>Parnaiba - PI</h4>
		<p>Bem vindo, <% out.print(u.getNome()); %></p>
		<h1>Atualizando dados cadastrais</h1>
	</div>

	<div id="formulario" style="padding-top: 50px;">
		<form method="POST" action="/<%=application.getInitParameter("app-name")%>/ServletAlterarDadosAdministrador">
		
		<label>Número:</label>
		<input type="text" name="numero" value="<%= u.getId() != 0 ? gn.converteNumeroAdministrador() : "" %>" disabled />
		<br/>
		
		<label>Nome:</label>
		<input id="txtNome" type="text" name="nome" value="<%= u.getNome() != null ? u.getNome() : "" %>" class="input"/>
		<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("nome") : "" %></p>
		
		<label>Endereço:</label>
		<input id="txtEndereco" type="text" name="endereco" value="<%= u.getEndereco() != null ? u.getEndereco() : "" %>" class="input" />
		<br/>
		
		<label>E-mail:</label>
		<input id="txtEmail" type="text" name="email" value="<%= u.getEmail() != null ? u.getEmail() : "" %>" class="input" />
		<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("email") : "" %></p>
			
		<label>Telefone:</label>
		<input id="txtTelefone" type="text" name="telefone" value="<%= u.getTelefone() != null ? u.getTelefone() : "" %>" class="input" />
		<p><%= session.getAttribute("erros") != null ? ((HashMap<String,String>) session.getAttribute("erros")).get("telefone") : "" %></p>
			
		<a href="/<%= application.getInitParameter("app-name") %>/JSP/administrador/administrador.jsp">Voltar</a>
		<a href="#" onclick="showPopup()">Alterar senha</a>
		<input type="hidden" name="id" value="<%=u.getId()%>"> <input class="botao" type="submit" value="Salvar" style="float: right;"/>
		
		
		
		
		</form>

		<%
			if (request.getAttribute("confirmacao") != null) {
				out.print("<div id=\"confirmacao\">");
				out.print("		<p> Salvo com sucesso </p>");
				out.print("</div>");
			}
		%>
		
		

	</div>
	
	<!-- Formulário de alteração da senha -->
	<div id="popup">
		<div id="box">
			<div id="fechar" onclick="closePopup()">FECHAR</div>
			<form id="frm_popup" action="/<%=application.getInitParameter("app-name")%>/ServletAlterarSenhaAdministrador" method="post" style="padding:40px 35px;">
				<label class="lbl_senha">Senha atual: </label>
				<input type="password" name="senhaAtual" class="txt_senha">
				<br>
				<label class="lbl_nova_senha">Nova senha: </label>
				<input type="password" name="novaSenha" class="txt_nova_senha">
				<br>
				<label class="lbl_confirmacao_senha">Confirmação da senha: </label>
				<input type="password" name="confirmacaoSenha" class="txt_confirmacao_senha"><br>
				<input id="btn_salvar" type="submit" value="Salvar" class="btn_salvar">
			</form>
		</div>
	</div>
	
	</div>
	</div>
		
</body>
</html>
