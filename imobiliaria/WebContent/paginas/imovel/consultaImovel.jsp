<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@page import="br.com.modelo.Imovel"%>

<html>
<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">

<script type="text/javascript">
	function editar(cod) {
		window.location.href = "/imobiliaria/controller.do?acao=ImovelEditarView&id="
				+ cod;
	}
</script>

<script type="text/javascript">
	function confirmExclusao(cod) {
		if (confirm("Tem certeza que deseja excluir esse imovel?")) {
			window.location.href = "/imobiliaria/controller.do?acao=ImovelRemover&id="
					+ cod;
		}
	}
</script>

<form method="post" action="controller.do?acao=ImovelConsultar">

	<body>
		<div id="top">
			<ui: name="top">
				<center>
					<h1>Consulta do Imóvel</h1>
				</center>
			</ui:>
		</div>



		<div>
			<div id="content" class="left_content">
				Id: <input id="id_imovel" name="id_imovel" type="text" size="40">
				<input type="submit" value="Consultar" />
			</div>
		</div>
</form>

<table>

	<input type="button" value="Voltar"
		onclick="location.href='http://localhost:8080/imobiliaria/paginas/imovel.jsp'" />


	<div>
		<div id="content" class="left_content">
			<center>
				<h1>Resultado da Consulta</h1>
			</center>
		</div>

	</div>

	<%
		ArrayList<Imovel> imoveis = (ArrayList<Imovel>) request
				.getAttribute("consultaImovel");
		if (imoveis != null) {
			Iterator<Imovel> it = imoveis.iterator();
			while (it.hasNext()) {
				Imovel imovel = it.next();
	%>
	<div>

		<div id="content" class="left_content">
			Id:
			<%=imovel.getId_imovel()%>
		</div>

		<div id="content" class="left_content">
			Tipo:
			<%=imovel.getTipo()%>
		</div>

		<div id="content" class="left_content">
			Valor:
			<%=imovel.getValor_imovel()%>
		</div>

		<div id="content" class="left_content">
			Endereco:
			<%=imovel.getEndereco()%>
		</div>

		<div id="content" class="left_content">
			Area:
			<%=imovel.getArea()%>
		</div>
		<div id="content" class="left_content">
			Descricao:
			<%=imovel.getDescricao()%>
		</div>


	</div>
	<div id="content" class="left_content">
			<input type="button" value="Editar"
				onclick="editar(<%=imovel.getId_imovel()%>)" /> <input
				type="button" value="Excluir" class="FormBotao"
				onclick="confirmExclusao(<%=imovel.getId_imovel()%>)" />
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