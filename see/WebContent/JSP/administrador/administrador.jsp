<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Imports JAVA -->
<%@ page import="br.edu.ifpi.see.model.Usuario"%>
<%@ page import="br.edu.ifpi.see.dao.UsuarioDAO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="javax.persistence.EntityManager"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="pt-br">
<head>
<title>Página Principal do Administrador</title>
<meta name="author" content="Rita Aquino" />
<meta name="description" content="Site Web Efeitos" />
<link rel="stylesheet" href="/<%=application.getInitParameter("app-name")%>/CSS/style_administrador.css" />
<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="/see/JS/ConfirmacaoExcluir.js"></script>
<script>
			function transition(){
				var img = document.getElementById('img_topo');
				img.setAttribute('class', 'depois');
			}
			
		</script>
</head>
<body onload="transition()">
	<div id="fundo">
		<div id="corpo">

			<%
				Usuario u = (Usuario) request.getSession().getAttribute("usuario");
				EntityManager em = (EntityManager) getServletContext().getAttribute("em");
				UsuarioDAO dao = new UsuarioDAO();
			%>

			<img
				src="/<%=application.getInitParameter("app-name")%>/IMG/topo-site.png"
				id="img_topo" alt="Logo" title="Acompanhe a eficiência energética !" class="antes">


			<div id="header">
				<h4>	Parnaiba - PI								</h4>
				<p>		
						Bem vindo, <% out.print(u.getNome()); %> | 
						<a class="meus-dados" href="/<%= application.getInitParameter("app-name") %>/ServletAlterarDadosAdministrador"> Meus Dados </a>
				</p>
				<h1>	Informações dos gerentes cadastrados		</h1>
			</div>
			
			
			<div id="tabela">
			
			<table class="theader">
				<tr>
						<td  width="100" height="30"><b> Número </b></td>
						<td  width="100" height="30"><b> Nome </b></td>
						<td  width="129" height="30"><b> E-mail </b></td>
						<td  width="100" height="30"><b> Ativo </b></td>
						<td  width="210" height="30"><b> Opções </b></td>
					</tr>
			</table>
			
			<div class="infor">
				<table>
				<!--  
					<tr>
						<td width="130" height="30"><b> Número </b></td>
						<td width="130" height="30"><b> Nome </b></td>
						<td width="130" height="30"><b> E-mail </b></td>
						<td width="130" height="30"><b> Ativo </b></td>
						<td width="180" height="30"><b> Opções </b></td>
					</tr>
				-->
					<%
						em.getTransaction().begin();
						ArrayList<Usuario> lista = dao.listaGerentes();
						em.getTransaction().commit();

						for(Usuario usuario : lista){
							out.print("<tr>");
							out.print("	   <td width=\"100\"> G00" +  usuario.getId()    + "	</td>");
							out.print("		<td width=\"100\">"     +  usuario.getNome()  + "	</td>");
							out.print("		<td width=\"120\">"     +  usuario.getEmail() + "	</td>");
							out.print("		<td width=\"100\">"     +  usuario.getAtivo() + "	</td>");
							out.print("		<td width=\"210\" height=\"40\">");
							out.print("			<a href=\"/"+getServletContext().getInitParameter("app-name")+"/ServletAlterarGerente?id="+usuario.getId()+"\">			Alterar		</a> |");
							out.print("<a onclick='confirmaExclusaoGerente("+usuario.getId()+")' href='#'> Excluir </a> |");
							out.print("			<a href=\"/"+getServletContext().getInitParameter("app-name")+"/ServletDetalhesGerente?id="+usuario.getId()+"\">		Detalhes	</a>");
							out.print("		</td>");
							out.print("</tr>");
						}
					%>
				</table>
			</div>
			</div>

			<table class="btns">
				<tr>
					<td>
						<form
							action="/<%=application.getInitParameter("app-name")%>/ServletLogout">
							<input type="submit" value="Sair" />
						</form>
					</td>
					<td>
						<form
							action="/<%=application.getInitParameter("app-name")%>/JSP/administrador/novoGerente.jsp">
							<input type="submit" value=" Novo Gerente " class="novo-gerente">
						</form>
					</td>
			</table>
		</div>
	</div>
	
	<div id="rodape"></div>
</body>
</html>