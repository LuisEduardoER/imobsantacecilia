<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@page import="br.com.modelo.Imovel"%>

<html>
<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">

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
		<a
			href="controller.do?acao=ImovelEditarView&codigo=<%=imovel.getId_imovel()%>">
			Editar Imovel</a> <a
			href="controller.do?acao=ImovelRemover&codigo=<%=imovel.getId_imovel()%>">
			Remover Imovel</a>
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