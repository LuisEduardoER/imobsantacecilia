<%@ page import="br.com.modelo.Cliente"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>

<html>
<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">


<script type="text/javascript">     			
	function editar(cod) {
   			window.location.href="/imobiliaria/controller.do?acao=ClienteEditarView&id=" + cod;
	}        
</script>

<script type="text/javascript">     			
	function confirmExclusao(cod) {        
   		if (confirm("Tem certeza que deseja excluir esse cliente?")) {
   			window.location.href="/imobiliaria/controller.do?acao=ClienteRemover&id=" + cod;
   		}     
	}        
</script>

<body>
	<form method="post" action="controller.do?acao=ClienteListar">
		<div id="top">
			<ui: name="top">
				<center>
					<h1>Lista de Clientes</h1>
				</center>
			</ui:>
		</div>
		<table>
			<%
				ArrayList clientes = (ArrayList) request
						.getAttribute("ListaClientes");
				Iterator<Cliente> it = clientes.iterator();

				while (it.hasNext()) {
					Cliente cliente = it.next();
			%>
			<div>

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
					<%=cliente.getTelefone()%>
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
			%>
		</table>
		<input type="button" value="Voltar"
			onclick="location.href='http://localhost:8080/imobiliaria/paginas/principal.jsp'" />

		<div id="bottom">
			<ui:insert name="bottom">
				<center>Direitos Reservados</center>
			</ui:insert>
		</div>

	</form>
</body>
</html>