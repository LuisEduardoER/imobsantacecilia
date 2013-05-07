<%@ page import="br.com.modelo.Imovel"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>

<html>
<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">


<script type="text/javascript">     			
	function editar(cod) {
   			window.location.href="/imobiliaria/controller.do?acao=ImovelEditarView&id=" + cod;
	}        
</script>

<script type="text/javascript">     			
	function confirmExclusao(cod) {        
   		if (confirm("Tem certeza que deseja excluir esse imovel?")) {
   			window.location.href="/imobiliaria/controller.do?acao=ImovelRemover&id=" + cod;
   		}     
	}        
</script>

<body>
	<form method="post" action="controller.do?acao=ImovelListar">
		<div id="top">
			<ui insert name="top">
			<center>
				<h1>Lista de Imoveis
			</center>
			</ui>
		</div>
		<table>
			<%
				ArrayList imoveis = (ArrayList) request
						.getAttribute("ListaImoveis");
				Iterator<Imovel> it = imoveis.iterator();

				while (it.hasNext()) {
					Imovel imovel = it.next();
			%>
			<div>

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
					Descrição:
					<%=imovel.getDescricao()%>
				</div>

			</div>
			<div id="content" class="left_content">
				<input type="button" value="Editar" onclick="editar(<%=imovel.getId_imovel()%>)"/>
					<input type="button" value="Excluir"
					class="FormBotao" onclick="confirmExclusao(<%=imovel.getId_imovel()%>)" />
			</div>
			<br>
			<%
				}
			%>
		</table>
		<input type="button" value="Voltar"
			onclick="location.href='http://localhost:8080/imobiliaria/paginas/imovel.jsp'" />

		<div id="bottom">
			<ui:insert name="bottom">
				<center>Direitos Reservados</center>
			</ui:insert>
		</div>
</body>
</html>