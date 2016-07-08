<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.*, java.util.*, to.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Alterar Passageiro</title>
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
				<h2 class="content-head is-center">Alterar Passageiro</h2>
			</div>
			<div class="pure-g">
				<div class="l-box-lrg pure-u-1">
					<form class="pure-form pure-form-stacked" action="AlterarPassageiro.do"
						method="post">
						<fieldset>
								<%
									Locale local = new Locale("pt","BR");
									DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT, local);
									PassageiroTO passageiro = (PassageiroTO) request.getAttribute("passageiro");
								%>
							<label>CPF</label> <input type="text" name="cpf" readonly value="<%=passageiro.cpf%>"> 
							<label>Nome</label> <input type="text" name="nomePassageiro" value="<%=passageiro.nome%>"> 
							<label>Sobrenome</label> <input type="text" name="sobrenomePassageiro" value="<%=passageiro.sobrenome%>"> 
							<label>Endereço</label> <input type="text" name="endereço" value="<%=passageiro.endereco%>"> 
							<label>Telefone</label> <input type="text" name="telefone" value="<%=passageiro.telefone%>">
							<label>E-mail</label> <input type="text" name="email" value="<%=passageiro.email%>">
							<label>Titulo</label> <input type="text" name="titulo" value="<%=passageiro.titulo%>"> 

						</fieldset>
						
						<button type="submit" class="pure-button">Alterar</button>
					</form>
				</div>
			</div>
			<div class="footer l-box is-center">Ricardo Teixeira Gomes RA: 201310208 | Wesley Custodio Rocha RA: 201310585 | André Soares Ramos RA: 201310103</div>
			<div class="footer l-box is-center">  </div>	
		</div>
	</div>

</body>
