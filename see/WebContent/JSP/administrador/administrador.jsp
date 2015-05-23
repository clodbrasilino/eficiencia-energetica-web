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
<title>P�gina Principal do Administrador</title>
<meta name="author" content="Rita Aquino" />
<meta name="description" content="Site Web Efeitos" />
<link rel="stylesheet"
	href="/<%=application.getInitParameter("app-name")%>/CSS/style.css" />
<script type="text/javascript" src="/see/JS/ConfirmacaoExcluir.js"></script>
</head>
<body>
	<div id="fundo">
		<div id="corpo">

			<%
				Usuario u = (Usuario) request.getSession().getAttribute("usuario");
				EntityManager em = (EntityManager) getServletContext().getAttribute("em");
				UsuarioDAO dao = new UsuarioDAO();
			%>

			<img
				src="/<%=application.getInitParameter("app-name")%>/IMG/topo-site.png"
				id="img_topo" alt="Logo" title="Acompanhe a efici�ncia energ�tica !">


			<div id="header">
				<h4>Parnaiba - PI</h4>
				<p>Bem vindo, <% out.print(u.getNome()); %></p>
				<h1>Informa��es dos gerentes cadastrados</h1>
			</div>
			
			<a href="/<%= application.getInitParameter("app-name") %>/ServletAlterarAdministrador?id="<%=u.getId() %>>Alterar dados cadastrais</a>
			
			<div class="infor">
				<table border=1>
					<tr>
						<td width="130" height="30"><b> N�mero </b></td>
						<td width="130" height="30"><b> Nome </b></td>
						<td width="130" height="30"><b> E-mail </b></td>
						<td width="130" height="30"><b> Ativo </b></td>
						<td width="180" height="30"><b> Op��es </b></td>
					</tr>
					<%
						em.getTransaction().begin();
						ArrayList<Usuario> lista = dao.listaGerentes();
						em.getTransaction().commit();

						for(Usuario usuario : lista){
							out.print("<tr>");
							out.print("	   <td width=\"100\"> G00" +  usuario.getId()    + "	</td>");
							out.print("		<td width=\"100\">"     +  usuario.getNome()  + "	</td>");
							out.print("		<td width=\"100\">"     +  usuario.getEmail() + "	</td>");
							out.print("		<td width=\"100\">"     +  usuario.getAtivo() + "	</td>");
							out.print("		<td width=\"210\" height=\"40\">");
							out.print("			<a href=\"/"+getServletContext().getInitParameter("app-name")+"/ServletAlterarGerente?id="+usuario.getId()+"\">			Alterar		</a> |");
							out.print("<a onclick='confirmaExclusaoGerente("+usuario.getId()+")' href='#'> Excluir |</a>");
							out.print("			<a href=\"/"+getServletContext().getInitParameter("app-name")+"/ServletDetalhesGerente?id="+usuario.getId()+"\">		Detalhes	</a>");
							out.print("		</td>");
							out.print("</tr>");
						}
					%>
				</table>
			</div>

			<div class="botao">
				<table>
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
								<input type="submit" value=" Novo Gerente ">
							</form>
						</td>
				</table>
			</div>
		</div>



	</div>
</body>
</html>