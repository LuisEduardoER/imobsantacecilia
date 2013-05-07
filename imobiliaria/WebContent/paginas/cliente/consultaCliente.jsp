<%@page import="br.com.modelo.TipoBuscaCliente"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@page import="br.com.modelo.Cliente"%>

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

<body>
	<form method="post" action="controller.do?acao=ClienteConsultar">
		<div id="top">
			<ui: name="top">
				<center>
					<h1>Consulta de Cliente</h1>
				</center>
			</ui:>
		</div>



		<div>
			<div id="content" class="left_content">
				Procurar: <input id="busca" name="busca" type="text" size="40">
				<select
					name="TipoBuscaCliente">
					<%
						for (TipoBuscaCliente t : TipoBuscaCliente.values()) {
					%>
						<option value="<%=t%>"><%=t%></option>
					<% } %>
				</select>
				<input type="submit" value="Consultar" />
			</div>
		</div>

	</form>

	<table>

		<input type="button" value="Voltar"
			onclick="location.href='http://localhost:8080/imobiliaria/paginas/cliente.jsp'" />


		<div>
			<div id="content" class="left_content">
				<center>
					<h1>Resultado da Consulta</h1>
				</center>
			</div>

		</div>

		<%
			ArrayList<Cliente> clientes = (ArrayList<Cliente>) request
					.getAttribute("consultaCliente");
			if (clientes != null) {
				Iterator<Cliente> it = clientes.iterator();
				while (it.hasNext()) {
					Cliente cliente = it.next();
		%>
		<div>

			<div id="content" class="left_content">
				Id:
				<%=cliente.getId_cliente()%>
			</div>

			<div id="content" class="left_content">
				CPF:
				<%=cliente.getCpf()%>
			</div>

			<div id="content" class="left_content">
				Nome:
				<%=cliente.getNome()%>
			</div>

			<div id="content" class="left_content">
				Endereco:
				<%=cliente.getEndereco()%>
			</div>

			<div id="content" class="left_content">
				Telefone:
				<%=cliente.getContatosCliente().get(0).getDescricao()%>
			</div>

		</div>
		<div id="content" class="left_content">
			<input type="button" value="Editar"
				onclick="editar(<%=cliente.getId_cliente()%>)" /> <input
				type="button" value="Excluir" class="FormBotao"
				onclick="confirmExclusao(<%=cliente.getId_cliente()%>)" />
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