<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.edu.ifpi.see.model.Usuario"%>
<%@ page import="br.edu.ifpi.see.model.Sala"%>
<%@ page import="br.edu.ifpi.see.model.MicroControlador"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>

<html lang="pt-br">
<head>
<title>Cadastrar Sala</title>
<meta name="author" content="Rita Aquino" />
<meta name="description" content="Site Web Efeitos" />
<link rel="stylesheet"
	href="/<%=application.getInitParameter("app-name")%>/CSS/style.css" />


<script type="text/javascript">
	function showPopup() {
		var popup = document.getElementById('popup');
		popup.style.display = "block";
	}
	function closePopup() {
		var popup = document.getElementById('popup');
		popup.style.display = "none";
	}
</script>

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
	width: 60%;
	height: 300px;
	position: absolute;
	left: 50%;
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

.lbl_ip {
	margin-left: 85px;
	margin-top: 10px;
}

.txt_ip {
	margin-top: 10px;
}

.btn_add {
	margin: 10px 292px 10px;
}
</style>


</head>
<body>
	<div id="fundo">
		<div id="corpo">

			<img
				src="/<%=application.getInitParameter("app-name")%>/IMG/topo-site.png"
				id="img_topo" alt="Logo" title="Acompanhe a eficiência energética !">

			<%
				Usuario u = (Usuario) session.getAttribute("usuario");
				Sala s = (Sala) request.getSession().getAttribute("sala");
			%>
			<div id="header">
				<h4>Parnaiba - PI</h4>
				<p>
					Bem vindo
					<%=u.getNome()%>
				</p>
				<h1>Cadastro de Sala</h1>
			</div>

			<div class="form">
				<form method="POST" action="/<%=application.getInitParameter("app-name")%>/ServletCadastroSala" method="post">
					<%if(s == null){ %>
					<label>Número:</label><input type="text" name="numero"/><br></br>
					<label>Descrição:</label><input type="text" name="descricao"/><br></br>
					<label>Pavimento:</label>
					<select name="pavimento">
						<option value="0">Selecione...</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select><br></br>
					<%}else{ %>
					
					<label>Número:</label><input type="text" name="numero" value="<%=s.getNumero()%>"/><br></br>
					<label>Descrição:</label><input type="text" name="descricao" value="<%=s.getDescricao()%>"/><br></br>
					<label>Pavimento:</label>
					<select name="pavimento">
						<option value="0"><%=s.getPavimento()%></option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select><br></br>
					
					<%} %>
					
					<input type="submit" name="add" value="Adicionar" class="btn_show_popup">
					
					<!--<input type="button" value="Adicionar" onclick="showPopup();" class="btn_show_popup">-->
					
					<table border="1">
						<tr>
							<td width="100">IP</td>
							<td width="100">Sensor de Porta</td>
							<td width="100">Sensor de Presença</td>
							<td width="100">Sensor de Lâmpadas</td>
							<td width="100">Sensor de Ar</td>
							<td width="200">Opções</td>
						</tr>
					
					<%
						if(s != null && s.getListaMicroControlador() != null){
							for(MicroControlador mc : s.getListaMicroControlador()){
								out.print("<tr>");
								out.print("	   <td width=\"100\">"+mc.getIp()+ "</td>");
								out.print("		<td width=\"100\">"+mc.getSensorPorta()+"</td>");
								out.print("		<td width=\"100\">"+mc.getSensorPresenca()+"</td>");
								out.print("		<td width=\"100\">"+mc.getSensorLampada()+"</td>");
								out.print("		<td width=\"100\">"+mc.getSensorAr()+"</td>");
								out.print("		<td width=\"210\" height=\"40\">");
								out.print("<a href=\"/"+getServletContext().getInitParameter("app-name")+"/ServletAlterarGerente?id="+mc.getId()+"\">			Alterar		</a> |");
								out.print("<a onclick='confirmaExclusaoGerente("+mc.getId()+")' href='#'> Excluir |</a>");
								out.print("			<a href=\"/"+getServletContext().getInitParameter("app-name")+"/ServletDetalhesGerente?id="+mc.getId()+"\">		Detalhes	</a>");
								out.print("		</td>");
								out.print("</tr>");
							}
						}
					%>
					
					</table>
										
					<a href="/<%=application.getInitParameter("app-name")%>/JSP/gerente/gerente.jsp">Voltar</a>
					<input class="botao" type="submit" name="salvar" value="Salvar"/>
					
				</form>
				
				<!--<form action="/<%=application.getInitParameter("app-name")%>/ServletCadastroSala" method="post">
						<input class="botao" type="submit" value="Salvar" name="salvar"/>
						<input class="botao" type="submit" value="Add" name="add"/>
				</form>-->
					
				<!-- Janela Popup -- Cadastro de Micro Controlador - Início -->
					<div id="popup">
						<div id="box">
							<div id="fechar" onclick="closePopup()">X</div>
							<form id="frm_popup" action="/<%=application.getInitParameter("app-name")%>/ServletMicroControlador" method="post">
								<label class="lbl_ip">Ip: </label><input type="text" name="ip" class="txt_ip"><br>
								<fieldset id="fs">
									<legend>Sensores:</legend>
									<input type="checkbox" name="porta" value="true">Porta<br>
									<input type="checkbox" name="presenca" value="true">Presença<br>
									<input type="checkbox" name="lampadas" value="true">Lâmpadas<br>
									<input type="checkbox" name="ar" value="true">Ar<br>
								</fieldset>
								<input type="submit" value="Adicionar" class="btn_add">
							</form>
						</div>
					</div>
					<!-- Janela Popup -- Cadastro de Micro Controlador - Fim -->
					
			</div>
		</div>
	</div>
</body>
</html>
