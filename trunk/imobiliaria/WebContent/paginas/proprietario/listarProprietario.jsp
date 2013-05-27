<%@ page import="br.com.modelo.Proprietario"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>

<html>
<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">


<script type="text/javascript">     			
	function editar(cod) {
   			window.location.href="/imobiliaria/controller.do?acao=ProprietarioEditarView&id=" + cod;
	}        
</script>

<script type="text/javascript">     			
	function confirmExclusao(cod) {        
   		if (confirm("Tem certeza que deseja excluir esse proprietario?")) {
   			window.location.href="/imobiliaria/controller.do?acao=ProprietarioRemover&id=" + cod;
   		}     
	}        
</script>

<body>
	<form method="post" action="controller.do?acao=ProprietarioListar">
		<div id="top">
			<ui insert name="top">
			<center>
				<h1>Lista de Proprietarios
			</center>
			</ui>
		</div>
		<table>
			<%
				ArrayList proprietarios = (ArrayList) request
						.getAttribute("ListaProprietarios");
				Iterator<Proprietario> it = proprietarios.iterator();

				while (it.hasNext()) {
					Proprietario proprietario = it.next();
			%>
			<div>

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
					Telefone:
					<%=proprietario.getContatosProprietario()%>
				</div>

			</div>
			<div id="content" class="left_content">
				<input type="button" value="Editar" onclick="editar(<%=proprietario.getId_proprietario()%>)"/>
					<input type="button" value="Excluir"
					class="FormBotao" onclick="confirmExclusao(<%=proprietario.getId_proprietario()%>)" />
			</div>
			<br>
			<%
				}
			%>
		</table>
		<input type="button" value="Voltar"
			onclick="location.href='http://localhost:8080/imobiliaria/paginas/proprietario.jsp'" />

		<div id="bottom">
			<ui:insert name="bottom">
				<center>Direitos Reservados</center>
			</ui:insert>
		</div>
</body>
</html>