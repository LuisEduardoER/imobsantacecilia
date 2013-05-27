<%@page import="br.com.modelo.TipoBuscaCliente"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@page import="br.com.modelo.Proprietario"%>

<html>
<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">

<script type="text/javascript">
	function editar(cod) {
		window.location.href = "/imobiliaria/controller.do?acao=ClienteEditarView&id="
				+ cod;
	}
</script>

<script type="text/javascript">
	function confirmExclusao(cod) {
		if (confirm("Tem certeza que deseja excluir esse cliente?")) {
			window.location.href = "/imobiliaria/controller.do?acao=ClienteRemover&id="
					+ cod;
		}
	}
</script>

<form method="post" action="controller.do?acao=ProprietarioConsultar">

	<body>
		<div id="top">
			<ui: name="top">
				<center>
					<h1>Consulta de Proprietario</h1>
				</center>
			</ui:>
		</div>



		<div>
			<div id="content" class="left_content">
				Procurar: <input id="busca" name="busca" type="text" size="40">
				<select name="TipoBuscaClient">
					<%
						for (TipoBuscaCliente t : TipoBuscaCliente.values()) {
					%>
					<option value="<%=t%>"><%=t%></option>
					<%
						}
					%>
				</select> <input type="submit" value="Consultar" />
			</div>
		</div>
</form>

<table>

	<input type="button" value="Voltar"
		onclick="location.href='http://localhost:8080/imobiliaria/paginas/proprietario.jsp'" />


	<div>
		<div id="content" class="left_content">
			<center>
				<h1>Resultado da Consulta</h1>
			</center>
		</div>

	</div>

	<%
		ArrayList<Proprietario> proprietarios = (ArrayList<Proprietario>) request
				.getAttribute("consultaProprietario");
		if (proprietarios != null) {
			Iterator<Proprietario> it = proprietarios.iterator();
			while (it.hasNext()) {
				Proprietario proprietario = it.next();
	%>
	<div>

		<div id="content" class="left_content">
			Id:
			<%=proprietario.getId_proprietario()%>
		</div>

		<div id="content" class="left_content">
			CPF:
			<%=proprietario.getCpf()%>
		</div>

		<div id="content" class="left_content">
			Nome:
			<%=proprietario.getNome()%>
		</div>

		<div id="content" class="left_content">
			Endereco:
			<%=proprietario.getEndereco()%>
		</div>

		<div id="content" class="left_content">
			<%
					if (proprietario.getContatosProprietario().size() > 0) {
				%>
				Telefone:
				<%=proprietario.getContatosProprietario().get(0)
								.getDescricao()%>
				<%
					}
				%>
		</div>

	</div>
	<div id="content" class="left_content">
		<input type="button" value="Editar"
				onclick="editar(<%=proprietario.getId_proprietario()%>)" /> <input
				type="button" value="Excluir" class="FormBotao"
				onclick="confirmExclusao(<%=proprietario.getId_proprietario()%>)" />
	</div>
	<br>
	<%
		}
		}
	%>
</table>

<div id="bottom">
	<ui:insert name="bottom">
		<center>Direitos Reservados</center>
	</ui:insert>
</div>

</body>
</html>