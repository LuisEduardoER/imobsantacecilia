
<html>
<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">



<form method="post" action="controllerServlet.do?acao=cliente.jsp">
	<body>
		<div id="top">
			<ui: name="top">
				<center>
					<h1>Cliente</h1>
				</center>
			</ui:>
		</div>

		<div>
			<div id="left">
				<ui: insert name="left">


				</ui:>
			</div>
		</div>

		<div id="content" class="left_content">
			<ul>

				<li><a href="controller.do?acao=ClienteAddView"> Adicionar
						Cliente</a></li>
				<li><a href="controller.do?acao=ClienteConsultarView">
						Consultar cliente</a></li>
				<li><a href="controller.do?acao=ClienteListar"> Editar
						cliente</a></li>

			</ul>

		</div>
		<div id="bottom">
			<ui:insert name="bottom">
				<center>Direitos Reservados</center>
			</ui:insert>
		</div>

	</body>
</html>