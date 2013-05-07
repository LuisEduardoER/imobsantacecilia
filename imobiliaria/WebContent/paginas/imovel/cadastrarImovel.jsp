<%@page import="br.com.modelo.TipoImovel"%>
<%@ page import="br.com.modelo.Imovel"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">
</head>

<body>

	<form name="tela" method="post" action="controller.do?acao=ImovelAdd">

		<div id="top">
			<ui: name="top">
				<center>
					<h1>Cadastro do Imóvel</h1>
				</center>
			</ui:>
		</div>

		<div id="content" class="left_content">
			<table>

				<tr>
					<td>Tipo:</td>
					<select name="tipo">
						<%
							for (TipoImovel t : TipoImovel.values()) {
						%>
						<option value="<%=t%>"><%=t%></option>
						<%
							}
						%>
					</select>

				</tr>

				<tr>
					<td>Valor:</td>
					<td><input id="valor_imovel" name="valor_imovel" type="text" size="40" /></td>

				</tr>

				<tr>
					<td>Endereço:</td>
					<td><input id="endereco" name="endereco" type="text" size="40" /></td>
				</tr>

				<tr>
					<td>Area:</td>
					<td><input id="area" name="area" type="text" size="40"></td>
				</tr>

				<tr>
					<td>Descrição:</td>
					<td><input id="descricao_imovel" name="descricao_imovel" type="text"
						size="40" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Salvar"
						onclick="alert('Imovel Cadastrado com sucesso');" /></td>
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