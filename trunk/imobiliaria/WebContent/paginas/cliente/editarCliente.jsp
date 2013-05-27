<%@page import="br.com.modelo.Cliente"%>
<html>

<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.maskedinput.js" type="text/javascript"></script>

<%
	Cliente cliente = (Cliente) request.getAttribute("cliente");
%>

<form method="post" action="controller.do?acao=ClienteEditar">

	<body>
	
	<script>
		jQuery(function($) {
			$("#telefone").mask("9999-9999");
			$("#cpf").mask("999.999.999-99");
		});
	</script>
	
		<div id="top">
			<ui: insert name="top">
				<center>
					<h1>Edição de Cliente</h1>
				</center>
			</ui:>
		</div>



		<div>
			<div id="content" class="left_content">
				Id: <input id="id_cliente" name="id_cliente" type="text"
					readonly="true" value="<%=cliente.getId_cliente()%>" size="40">
				</td>

			</div>

			<div id="content" class="left_content">
				Cpf: <input id="cpf" name="cpf" type="text"
					value="<%=cliente.getCpf()%>" size="40">
				</td>

			</div>

			<div id="content" class="left_content">
				Nome: <input id="nome" name="nome" type="text"
					value="<%=cliente.getNome()%>" size="40">
				</td>

			</div>

			<div id="content" class="left_content">
				Endereco: <input id="endereco" name="endereco" type="text"
					value="<%=cliente.getEndereco()%>" size="40" />
			</div>
			
			<div id="content" class="left_content">
				Telefone:
				<%
				if (cliente.getContatosCliente().size() > 0) {
			%>
				<input id="telefone" name="telefone" type="text"
					value="<%=cliente.getContatosCliente().get(0).getDescricao()%>"
					size="40" maxlength="8" />
				<%
					} else {
				%>
				<input id="telefone" name="telefone" type="text" size="40" />
				<%
					}
				%>
			</div>

			<input type="button" value="Voltar"
				onclick="location.href='http://localhost:8080/imobiliaria/paginas/cliente.jsp'" />


			<div id="content" class="left_content">

				<div id="content" class="left_content">
					<input type="submit" value="Salvar"
						onclick="alert('Cliente Alterado com sucesso');" /> <input
						type="submit" value="Voltar" />
				</div>
	</body>
</form>
</html>