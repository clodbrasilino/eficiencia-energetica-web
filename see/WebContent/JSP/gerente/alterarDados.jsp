<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="br.edu.ifpi.see.model.Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<title>Atualizando Dados Cadastrais</title>
<meta name="author" content="Rita Aquino" />
<meta name="description" content="Site Web Efeitos" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style.css" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style_alterarDados.css" />
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
	width: 400px;
	height: 350px;
		
}




#fechar:hover {color: green;}

#frm_popup {
	width: 200px;
	padding-top: 40px;
	padding-left: 38px; 
	
}

/*
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
*/
</style>
<script type="text/javascript">
	function ativaCampo(campo){
		document.getElementById(campo).disabled = false;
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
	<div id="fundo">
 		<div id="corpo">
     	 	<img  src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png"  id="img_topo" title="Logo" class="antes">

	<div id="header">
		<h4>Parnaiba - PI</h4>
		<p>Bem vindo, <% out.print(u.getNome()); %></p>
		<h1>Atualizando dados cadastrais</h1>
	</div>

	<div id="formulario" style="padding-top: 50px;">
		<form method="POST" action="/<%=application.getInitParameter("app-name")%>/ServletAlterarDadosGerente">
		
		<label>Número:</label>
		<input type="text" name="numero" value="G00<%=u.getId()%>" disabled />
		<br/>
		
		<label>Nome:</label>
		<input type="text" name="nome" value="<%= u.getNome() != null ? u.getNome() : "" %>" />
		<br/>
		
		<label>Endereço:</label>
		<input type="text" name="endereco" value="<%= u.getEndereco() != null ? u.getEndereco() : "" %>" />
		<br/>
		
		<label>Email:</label>
		<input type="text" name="email" value="<%= u.getEmail() != null ? u.getEmail() : "" %>" />
		<br/>
		
		<label>Telefone:</label>
		<input type="text" name="telefone" value="<%= u.getTelefone() != null ? u.getTelefone() : "" %>" />
		<br/><br/>
		
		
		
		
			<input type="hidden" name="id" value="<%=u.getId()%>">
			<a href="/<%= application.getInitParameter("app-name") %>/JSP/gerente/gerente.jsp">Voltar</a>
			<a href="#" onclick="showPopup()">Alterar senha</a>
			<input class="botao" type="submit" value="Salvar" />
			
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
			<form id="frm_popup" action="/<%=application.getInitParameter("app-name")%>/ServletAlterarSenhaGerente" method="post">
				<label class="lbl_senha">Senha atual: </label><input type="password" name="senhaAtual" class="txt_senha"><br>
				<label class="lbl_nova_senha">Nova senha: </label><input type="password" name="novaSenha" class="txt_nova_senha"><br>
				<label class="lbl_confirmacao_senha">Confirmação da senha: </label><input type="password" name="confirmacaoSenha" class="txt_confirmacao_senha"><br>
				<input id="btn_salvar" type="submit" value="Salvar" class="btn_salvar">
			</form>
		</div>
	</div>
	
	</div>
	</div>
	
</body>
</html>
