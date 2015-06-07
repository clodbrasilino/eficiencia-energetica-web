<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Emulador SEE - Configurar</title>
		<style type="text/css">
			table{
				border: 1px solid black;
			}
			td{
				padding: 5px;
				border: 1px solid black;
			}
			table {
				border-collapse: separate;
				border-spacing: 5px;	
			}
			
		</style>
	</head>
	<body>
		<table>
			<caption>Emulador SEE - Configurar</caption>
			<thead>
				<tr>
					<th>Sensor</th>
					<th>Estado</th>
					<th>Ligar</th>
					<th>Desligar</th>
					<th>Desativar</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Porta</td>
					<td><%= ((br.edu.ifpi.see.emulador.model.EstadoEmulador)application.getAttribute("estadoAtual")).getPorta() %></td>
					<td><form action="desligaPorta" method="get"><input type="submit" value="Abrir"></form></td>
					<td><form action="ligaPorta" method="get"><input type="submit" value="Fechar"></form></td>
					<td><form action="desativaPorta" method="get"><input type="submit" value="Desativar"></form></td>
				</tr>
				<tr>
					<td>Sensor de Presenca</td>
					<td><%= ((br.edu.ifpi.see.emulador.model.EstadoEmulador)application.getAttribute("estadoAtual")).getPresenca() %></td>
					<td><form action="ligaPresenca" method="get"><input type="submit" value="Ligar"></form></td>
					<td><form action="desligaPresenca" method="get"><input type="submit" value="Desligar"></form></td>
					<td><form action="desativaPresenca" method="get"><input type="submit" value="Desativar"></form></td>
				</tr>
				<tr>
					<td>Lampada</td>
					<td><%= ((br.edu.ifpi.see.emulador.model.EstadoEmulador)application.getAttribute("estadoAtual")).getLuz() %></td>
					<td><form action="ligaLuz" method="get"><input type="submit" value="Ligar"></form></td>
					<td><form action="desligaLuz" method="get"><input type="submit" value="Desligar"></form></td>
					<td><form action="desativaLuz" method="get"><input type="submit" value="Desativar"></form></td>
				</tr>
				<tr>
					<td>Ar-condicionado</td>
					<td><%= ((br.edu.ifpi.see.emulador.model.EstadoEmulador)application.getAttribute("estadoAtual")).getAr() %></td>
					<td><form action="ligaAr" method="get"><input type="submit" value="Ligar"></form></td>
					<td><form action="desligaAr" method="get"><input type="submit" value="Desligar"></form></td>
					<td><form action="desativaAr" method="get"><input type="submit" value="Desativar"></form></td>
				</tr>
			</tbody>
		</table>
	</body>
</html>