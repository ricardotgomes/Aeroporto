<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.*, java.util.*, to.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Consultar Passageiro</title>
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
				<li class="pure-menu-item"><a href="incluirpassageiro.html" class="pure-menu-link">Incluir</a></li>
				<li class="pure-menu-item"><a href="alterarpassageiro.html" class="pure-menu-link">Alterar</a></li>
				<li class="pure-menu-item"><a href="excluirpassageiro.html" class="pure-menu-link">Excluir</a></li>
				<li class="pure-menu-item"><a href="consultarpassageiro.html" class="pure-menu-link">Consultar</a></li>
			</ul>
		</div>
	</div>

	<div class="content-wrapper">
		<div class="content">
			<div class="content">
				<h2 class="content-head is-center">Passageiro Consultado</h2>
			</div>
			<div class="pure-g">
				<div class="l-box-lrg pure-u-1">
				<table class="pure-table">
				<thead>
				<tr>
				<th>Nome</th><th>Sobrenome</th><th>CPF</th><th>Endereço</th><th>Telefone</th><th>E-mail</th><th>Titulo</th>
				</tr>
				</thead><tbody>
				<%
				Locale local = new Locale("pt","BR");
				DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT, local);
					PassageiroTO passageiro = (PassageiroTO) request.getAttribute("passageiro");
				    
					out.println("<tr><td>"+passageiro.nome+"</td><td>"+passageiro.sobrenome+"</td><td>"+
							passageiro.cpf+"</td><td>"+passageiro.endereco+
							"</td><td>"+passageiro.telefone+"</td><td>"+passageiro.email+"</td><td>"+passageiro.titulo+"</td></tr>");
					
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