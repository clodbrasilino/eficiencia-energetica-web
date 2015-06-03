<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpi.see.model.Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<title>Atualizando Dados Cadastrais</title>
<meta name="author" content="Rita Aquino" />
<meta name="description" content="Site Web Efeitos" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style2.css" />
<style type="text/css">
#popup {
	background: rgba(0, 0, 0, 0.5);
	width: 100%;
	height: 100%;
	position: fixed;
	left: 0;
	top: 0;
	display: none;
}

#box {
	background: #fff;
	width: 40%;
	height: 300px;
	position: absolute;
	left: 60%;
	top: 50%;
	margin-left: -30%;
	margin-top: -150px;
}

#fechar {
	padding: 5px 10px;
	border: 1px solid #ccc;
	position: absolute;
	right: 3px;
	top: 3px;
	border-radius: 7px;
	color: #ccc;
	cursor: pointer;
}

#fechar:hover {
	color: #666;
	border-color: #666;
}

#frm_popup {
	width: 400px;
	height: 220px;
	margin: 50px auto;
}

#fs {
	width: 100px;
	height: 100px;
	margin: auto;
}

.lbl_senha {
	margin-left: 76px;
	margin-top: 10px;
}

.lbl_nova_senha {
	margin-left: 76px;
	margin-top: 10px;
}

.lbl_confirmacao_senha {
	margin-left: 10px;
	margin-top: 10px;
}

.txt_senha {
	margin-top: 10px;
}

.txt_nova_senha {
	margin-top: 10px;
}

.txt_confirmacao_senha {
	margin-top: 10px;
}

.btn_salvar {
	margin: 10px 280px 10px;
}
</style>
<script type="text/javascript">
	function ativaNome(){
		document.getElementById("txtNome").disabled = false;
	}
	function ativaEndereco(){
		document.getElementById("txtEndereco").disabled = false;
	}
	function ativaEmail(){
		document.getElementById("txtEmail").disabled = false;
	}
	function ativaTelefone(){
		document.getElementById("txtTelefone").disabled = false;
	}
	function showPopup() {
		var popup = document.getElementById('popup');
		popup.style.display = "block";
	}
	function closePopup() {
		var popup = document.getElementById('popup');
		popup.style.display = "none";
	}
</script>
</head>
<body>

	<%
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
	%>
	<img src="/<%=application.getInitParameter("app-name")%>/IMG/topo-site.png" id="img_topo" alt="Logo" title="Logo">

	<div class="corpo">
		<h4>Parnaiba - PI</h4>
		<p>Bem vindo, <% out.print(u.getNome()); %></p>
		<center><h1>Atualizando dados cadastrais</h1></center>
	</div>

	<div class="form">
		<form method="POST" action="/<%=application.getInitParameter("app-name")%>/ServletAlterarDadosAdministrador">
			<table>
				<tr>
					<td><label>Número:</label></td>
					<td><input type="text" name="numero" value="G00<%= u.getId() != 0 ? u.getId() : "" %>" disabled /></td>
				</tr>
				<tr>
					<td><label>Nome:</label></td>
					<td><input id="txtNome" type="text" name="nome" value="<%= u.getNome() != null ? u.getNome() : "" %>" class="input"/></td>
				</tr>
				<tr>
					<td><label>Endereço:</label></td>
					<td><input id="txtEndereco" type="text" name="endereco" value="<%= u.getEndereco() != null ? u.getEndereco() : "" %>" class="input" /></td>
				</tr>
				<tr>
					<td><label>E-mail:</label></td>
					<td><input id="txtEmail" type="text" name="email" value="<%= u.getEmail() != null ? u.getEmail() : "" %>" class="input" /></td>
				</tr>
				<tr>
					<td><label>Telefone:</label></td>
					<td><input id="txtTelefone" type="text" name="telefone" value="<%= u.getTelefone() != null ? u.getTelefone() : "" %>" class="input" /></td>
				</tr>
			</table>
			<a href="#" onclick="showPopup()">Alterar senha</a>
			<input type="hidden" name="id" value="<%=u.getId()%>"> <input class="botao" type="submit" value="Salvar" />
		</form>

		<%
			if (request.getAttribute("confirmacao") != null) {
				out.print("<div id=\"confirmacao\">");
				out.print("		<p> Salvo com sucesso </p>");
				out.print("</div>");
			}
		%>
		
		<a href="/<%= application.getInitParameter("app-name") %>/JSP/administrador/administrador.jsp">Voltar</a>

	</div>
	
	<!-- Formulário de alteração da senha -->
	<div id="popup">
		<div id="box">
			<div id="fechar" onclick="closePopup()">X</div>
			<form id="frm_popup" action="/<%=application.getInitParameter("app-name")%>/ServletAlterarSenhaAdministrador" method="post">
				<label class="lbl_senha">Senha atual: </label><input type="password" name="senhaAtual" class="txt_senha"><br>
				<label class="lbl_nova_senha">Nova senha: </label><input type="password" name="novaSenha" class="txt_nova_senha"><br>
				<label class="lbl_confirmacao_senha">Confirmação da senha: </label><input type="password" name="confirmacaoSenha" class="txt_confirmacao_senha"><br>
				<input id="btn_salvar" type="submit" value="Salvar" class="btn_salvar">
			</form>
		</div>
	</div>
		
</body>
</html>
