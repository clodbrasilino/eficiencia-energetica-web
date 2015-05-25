<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="pt-br">

    <head>
    	<title>Sistema de Eficiência Energetica IFPI Parnaíba</title>
        <meta name="author" content="RitaAquino" />
        <meta name="description" content="Site Web Efeitos" />
		<link rel="stylesheet" href="/<%= application.getInitParameter("app-name") %>/CSS/style_index.css"/>
		<script>
			function transition(){
				var img = document.getElementById('img_topo');
				img.setAttribute('class', 'depois');
			}
			
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
		    	 
		        <form action="/<%= application.getInitParameter("app-name") %>/ServletIndentificaUsuario" method="post" id="login">
		            
		            <label>
		                Login: 
		                <input type="text" name="email" /> 
		            </label>
		            
		            <label>
		                Senha:
		                <input type="password" name="senha" />
		                <input type="submit" value="    Logar    "/>
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
		        <h1>	Sistema de Eficiência Energética </h1>
		        
		    </div>
		    <!-- #header FIM -->
	     
    
		    <div class="monit">
		        <h3> Monitoramento do Sistema </h3>
		            <div class="btn">
		                <table>
		                    <tr>
		                        <td width="100" height="50" bgcolor=#0F0>Sala 1</td>
		                        <td width="100" height="50" bgcolor=#F00>Sala 2</td>
		                        <td width="100" height="50" bgcolor=#FF0>Sala 3</td>
		                        <td width="100" height="50" bgcolor=#0F0>Sala 4</td>
		                        <td width="100" height="50" bgcolor=#F00>Sala 5</td>
		                    </tr>
		                    <tr>
		                        <td width="100" height="50" bgcolor=#FF0>Sala 6</td>
		                        <td width="100" height="50" bgcolor=#FF0>Sala 7</td>
		                        <td width="100" height="50" bgcolor=#0F0>Sala 8</td>
		                        <td width="100" height="50" bgcolor=#F00>Sala 9</td>
		                        <td width="100" height="50" bgcolor=#0F0>Sala 10</td>
		                    </tr>
		                    <tr>
		                        <td width="100" height="50" bgcolor=#F00>Sala 11</td>
		                        <td width="100" height="50" bgcolor=#0F0>Sala 12</td>
		                        <td width="100" height="50" bgcolor=#F00>Sala 13</td>
		                        <td width="100" height="50" bgcolor=#0F0>Sala 14</td>
		                        <td width="100" height="50" bgcolor=#FF0>Sala 15</td>
		                    </tr>
		                    <tr>
		                        <td width="100" height="50"  bgcolor=#FF0>Sala 16</td>
		                        <td width="100" height="50"  bgcolor=#FF0>Sala 17</td>
		                        <td width="100" height="50" bgcolor=#0F0>Sala 18</td>
		                        <td width="100" height="50" bgcolor=#F00>Sala 19</td>
		                        <td width="100" height="50" bgcolor=#0F0>Sala 20</td>
		                    </tr>
		                </table>
		            </div>
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
   <div id="rodape"></div>
 </body>
 </html>