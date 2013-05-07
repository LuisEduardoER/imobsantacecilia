<%@page import="br.com.modelo.Imovel"%>
<%@page import="br.com.modelo.TipoImovel"%>
<html>

<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">

<%
	Imovel imovel = (Imovel) request.getAttribute("imovel");
%>

<form method="post" action="controller.do?acao=ImovelEditar">

	<body>
		<div id = "top">
			<ui: insert name = "top">
				<center>
					<h1>Edição do Imóvel</h1>
				</center>
			</ui:>
		</div>
		
		
		
		<div>
		<div id = "content" class = "left_content">
				Id:
				<input id="id_imovel" name="id_imovel" type="text" readonly="true"
					value="<%=imovel.getId_imovel()%>" size="40"></td>
			
			</div>
			
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
			
			<div id = "content" class = "left_content">								
				Valor:
				<input id="valor_imovel" name="valor_imovel" type="text"
					value="<%=imovel.getValor_imovel()%>" size="40"></td>
			
			</div>
	
			<div id = "content" class = "left_content">
				Endereco:	
				<input id="endereco" name="endereco" type="text"
					value="<%=imovel.getEndereco()%>" size="40" />
			</div>
			<div id = "content" class = "left_content">
				Area:	
				<input id="area" name="area" type="text"
					value="<%=imovel.getArea()%>" size="40" maxlength="8" />
			</div>
			<div id = "content" class = "left_content">
				Descrição:	
				<input id="descricao_imovel" name="descricao_imovel" type="text"
					value="<%=imovel.getDescricao()%>" size="40" maxlength="8" />
			</div>
			
	<input type="button" value="Voltar" onclick="location.href='http://localhost:8080/imobiliaria/paginas/imovel.jsp'" />	
			
			
			<div id="content" class="left_content">

			<div id = "content" class = "left_content">
				<input type="submit" value="Salvar"
					onclick="alert('Imovel Alterado com sucesso');" />
				<input type="submit" value="Voltar" />
			</div>

	</body>	
</form>
</html>