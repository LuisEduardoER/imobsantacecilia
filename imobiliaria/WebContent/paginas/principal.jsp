<%@page import="br.com.modelo.Usuario"%>
<html>

<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">

<br>

<form method="post" action="controllerServlet.do?acao=principal.jsp">

	<body>
		<div id="top">
			<ui: insert name="top">
				<center>
					<h1>Imobiliária Santa Cecília</h1>
			</ui:>
			</center>

			<td width="50%">
				<%
					Usuario usuario = (Usuario) session.getAttribute("logado");
				%>
				<h3>
					Bem Vindo
					<%=usuario.getLogin()%></h3>
			</td>

		</div>
		<div>
			<div id="left">
				<ui: insert name="left">


				</ui:>
			</div>
		</div>

		<div id="content" class="left_content">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="controller.do?acao=Imobiliaria">A Imobiliária</a></li>
				<li><a href="controller.do?acao=Imovel">Imóveis</a></li>
				<li><a href="controller.do?acao=Cliente"> Cliente </li>
				<li><a href="controller.do?acao=Proprietario"> Proprietario</a></li>

			</ul>

		</div>
		<div id="bottom">
			<ui:insert name="bottom">
				<center>Direitos Reservados</center>
			</ui:insert>
		</div>
</html>