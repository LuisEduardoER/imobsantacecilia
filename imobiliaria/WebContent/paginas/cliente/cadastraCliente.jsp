<%@page import="javax.swing.JFormattedTextField"%>
<%@page import="javax.swing.text.MaskFormatter"%>
<%@ page import="br.com.modelo.Cliente"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput.js" type="text/javascript"></script>
</head>

<body>

	<script>
		jQuery(function($) {
			$("#telefone").mask("9999-9999");
			$("#cpf").mask("999.999.999-99");
		});
	</script>

	<form name="tela" method="post" action="controller.do?acao=ClienteAdd">

		<div id="top">
			<ui: name="top">
				<center>
					<h1>Cadastro de Cliente</h1>
				</center>
			</ui:>
		</div>

		<div id="content" class="left_content">
			<table>
				<tr>
					<td>CPF:</td>
					<td><input id="cpf" name="cpf" type="text" size="40" /></td>
				</tr>

				<tr>
					<td>Nome:</td>
					<td><input id="nome" name="nome" type="text" size="40"></td>
				</tr>

				<tr>
					<td>Endereco:</td>
					<td><input id="endereco" name="endereco" type="text" size="40" /></td>

				</tr>

				<tr>
					<td>Telefone:</td>
					<td><input id="telefone" name="telefone" type="text" size="40" /></td>

				</tr>

				<tr>
					<td><input type="submit" value="Salvar"
						onclick="alert('Cliente Cadastrado com sucesso');" /></td>
					<td><input type="reset" value="Limpar"> <input
						type="submit" value="Voltar"></td>
				</tr>

			</table>
		</div>

		<div id="bottom">
			<ui:insert name="bottom">
				<center>Direitos Reservados</center>
			</ui:insert>
		</div>
	</form>
</body>
</html>