<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.*, java.util.*, to.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Consultar Voo</title>
<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.6.0/grids-responsive-min.css">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link rel="stylesheet" href="css/layouts/marketing.css">
</head>
<body>
	<div class="header">
		<div class="home-menu pure-menu pure-menu-horizontal pure-menu-fixed">
			<a class="pure-menu-heading" href="index.html">Sistema de
				Aeroporto</a>
			<ul class="pure-menu-list">
				<li class="pure-menu-item"><a href="incluirvoo.html" class="pure-menu-link">Incluir</a></li>
				<li class="pure-menu-item"><a href="alterarvoo.html" class="pure-menu-link">Alterar</a></li>
				<li class="pure-menu-item"><a href="excluirvooe.html" class="pure-menu-link">Excluir</a></li>
				<li class="pure-menu-item"><a href="consultarvoo.html" class="pure-menu-link">Consultar</a></li>
			</ul>
		</div>
	</div>

	<div class="content-wrapper">
		<div class="content">
			<div class="content">
				<h2 class="content-head is-center">Voo Consultado</h2>
			</div>
			<div class="pure-g">
				<div class="l-box-lrg pure-u-1">
				<table class="pure-table">
				<thead>
				<tr>
				<th>Codigo Voo</th><th>Codigo Aeronave</th><th>Nome Aeronave</th><th>Valor do Voo</th><th>Data/Hora</th><th>Escala</th><th>Origem</th><th>Destino</th>
				</tr>
				</thead><tbody>
				<%
				Locale local = new Locale("pt","BR");
				DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT, local);
					VooTO voo = (VooTO) request.getAttribute("voo");
				    
					out.println("<tr><td>"+voo.codVoo+"</td><td>"+voo.codAeronave+"</td><td>"+voo.nomeAeronave+"</td><td>"+
					voo.valorVoo+"</td><td>"+voo.dataHora+"</td><td>"+voo.escala+
					"</td><td>"+voo.origem+"</td><td>"+voo.destino+"</td></tr>");
					
				%>
				</tbody></table>
				</div>
			</div>
			<div class="footer l-box is-center">Ricardo Teixeira Gomes RA: 201310208 | Wesley Custodio Rocha RA: 201310585 | André Soares Ramos RA: 201310103</div>
			<div class="footer l-box is-center">  </div>
		</div>
	</div>

</body>
</html>