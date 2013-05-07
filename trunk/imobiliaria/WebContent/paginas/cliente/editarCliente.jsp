<%@page import="br.com.modelo.Cliente"%>
<html>

<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">

<%
	Cliente cliente = (Cliente) request.getAttribute("cliente");
%>

<form method="post" action="controller.do?acao=ClienteEditar">

	<body>
		<div id = "top">
			<ui: insert name = "top">
				<center>
					<h1>Edição de Cliente</h1>
				</center>
			</ui:>
		</div>
		
		
		
		<div>
		<div id = "content" class = "left_content">
				Id:
				<input id="id_cliente" name="id_cliente" type="text" readonly="true"
					value="<%=cliente.getId_cliente()%>" size="40"></td>
			
			</div>
			
			<div id = "content" class = "left_content">								
				Cpf:
				<input id="cpf" name="cpf" type="text"
					value="<%=cliente.getCpf()%>" size="40" maxlength="11"></td>
			
			</div>
			
			<div id = "content" class = "left_content">								
				Nome:
				<input id="nome" name="nome" type="text"
					value="<%=cliente.getNome()%>" size="40"></td>
			
			</div>
	
			<div id = "content" class = "left_content">
				Endereco:	
				<input id="endereco" name="endereco" type="text"
					value="<%=cliente.getEndereco()%>" size="40" />
			</div>
			<div id = "content" class = "left_content">
				Telefone:	
				<input id="telefone" name="telefone" type="text"
					value="<%=cliente.getTelefone()%>" size="40" maxlength="8" />
			</div>
			
	<input type="button" value="Voltar" onclick="location.href='http://localhost:8080/imobiliaria/paginas/cliente.jsp'" />
		
		<!-- Aqui coloca um botão para saber se quer 
			adicionar mais um numero de contato do cliente,
			Se sim indica para uma pagina de contato cliente para que 
			possa ser adicionado mais contatos de telefone e e-mail. -->	
			
			
			<div id="content" class="left_content">

			<div id = "content" class = "left_content">
				<input type="submit" value="Salvar"
					onclick="alert('Cliente Alterado com sucesso');" />
				<input type="submit" value="Voltar" />
			</div>

	</body>	
</form>
</html>