<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="javax.persistence.EntityTransaction" %>
<%@ page import="br.edu.ifpi.see.dao.SalaDAO" %>
<%@ page import="br.edu.ifpi.see.model.Sala" %>
<%@ page import="br.edu.ifpi.see.model.Status" %>
<%@ page import="br.edu.ifpi.see.model.MicroControlador" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.edu.ifpi.see.request.GeneratedStatus" %>
<%@ page import="br.edu.ifpi.see.request.Response" %>
<%@ page import="br.edu.ifpi.see.paginator.Paginator" %>
<%@ page import="br.edu.ifpi.see.util.SalaUtil" %>
<%@ page import="java.util.HashMap" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="pt-br">

    <head>
    	<title>Sistema de Eficiência Energetica IFPI Parnaíba</title>
        <meta name="author" content="RitaAquino" />
        <meta name="description" content="Site Web Efeitos" />
        <!--<meta http-equiv="refresh" content="10"/>-->
		<link rel="stylesheet" href="/<%= application.getInitParameter("app-name") %>/CSS/style_index.css"/>
		<script>
			function transition(){
				var img = document.getElementById('img_topo');
				img.setAttribute('class', 'depois');
			}

			function alteraPagina(){
				setTimeout("chamaPagina()", 5000);
			}

			function chamaPagina(){
				window.location="/see/AlternaPaginasServlet?resource=/see";
			}
			
			//alteraPagina();
		</script>
	</head>
	
 <body onload="transition()">
 	<!-- 
 		Projeto Supervisionado 2015
 		Turma: Técnico de Informatica 2014.1
 		Professor Responsável: Clodoaldo Basilino
 	
 	 -->
 	<div id="fundo">
 		<div id="corpo">
     	 	<img  src="/<%= application.getInitParameter("app-name") %>/IMG/topo-site.png"  id="img_topo" title="Logo" class="antes">
     
		    <div id="header">
		    	 
		        <form action="/<%= application.getInitParameter("app-name") %>/ServletAutenticacao" method="post" id="login">
		            
		            <label>
		                Login: 
		                <input type="text" name="email" />
		            </label>
		            
		            <label>
		                Senha:
		                <input type="password" name="senha" />
		                <input type="submit" value="Logar"/>
		            </label>
		            
		        </form>
		       
		        <h4> Parnaiba - PI </h4>
		        <%
		        	String msg = (String) session.getAttribute("mensagem");
		        	
		        	if(msg != null){
		        		out.println("<div id=\"erro_login\">");
		        		out.print("  	<p>" + msg + " </p>");
		        		out.println("</div>");
		        		session.setAttribute("mensagem", "");
		        	}
		        %>
		        <h1>Sistema de Eficiência Energética</h1>
		        <h3>Monitoramento do Sistema</h3>
		        
		    </div>
		    <!-- #header FIM -->
		            <div class="btn">
		                <table>
		                	<%
		                		SalaDAO dao = new SalaDAO();
		                		if(request.getSession().getAttribute("paginator") == null){
		                			request.getSession().setAttribute("paginator",new Paginator());
		                		}
		                		Paginator p = (Paginator) request.getSession().getAttribute("paginator");
		                		p.setLista(dao.pesquisar("select s from Sala s"));
		                		p.setLinhas(20);
		                		 
		                		List<Sala> salas = (List<Sala>) p.getSublista();
		                		
		                		if(salas != null){
		                			int k = 0;
	                    			for(int i=0; i<4; i++){
	                    				out.print("<tr>");
	                    				for(int j=0; j<5; j++){
	                    					Sala s = SalaUtil.getSala(k, salas);
	                    					GeneratedStatus gs = new GeneratedStatus();
	                    					Status status = gs.getStatus(s.getListaMicroControlador());
	                    					if(!s.getStatus().getDescricao().equals("Sem Micro Controlador")){
	                    						out.print("<td width='100' height='50' bgcolor='"+s.getStatus().getCor()+"'");
		                    					out.print("<h1>"+s.getNumero()+"</h1>");
		                    					out.print("<h4>"+s.getStatus().getDescricao()+"</h4>");
		                    					out.print("</td>");
	                    					}
	                    					if(k < 20){
	                    						k++;
	                    					}
	                    				}
	                    				out.print("</tr>");
			                    	}
		                		}else{
		                			out.print("<h1>Não há salas cadastradas!</h1>");
		                		}
		                		
                    		%>
		                </table>
		                <%
		                	out.print(p.temListaAnterior() ? "<a href='/"+application.getInitParameter("app-name")+"/ListaPaginaAnteriorServlet?resource=/see'>Anterior</a> " : "");
		                	out.print(p.temProximaLista() ? " <a href='/"+application.getInitParameter("app-name")+"/ListaProximaPaginaServlet?resource=/see'>Próxima</a>" : "");
		                %>
		            </div> 
             
            <div id="legenda">
                <table>
                    <tr>
                        <td bgcolor=#0F0 width="20"></td>
                        <td width="60"><font color=#191970>Normal </font> </td>
                        <td bgcolor=#FF0 width="20"> </td>
                        <td width="80"> <font color=#191970>Moderado </font> </td>
                        <td bgcolor=#F00 width="20"> </td>
                        <td><font color=#191970>Precisando de Manutenção Imediata</font></td>	
                    </tr>
                 </table>
            </div>
        </div>
   </div>
   <div id="rodape"><p><a href="#">DESENVOLVEDORES</a></p></div>
 </body>
 </html>
