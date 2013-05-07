
<html>
<link rel="stylesheet" type="text/css" href="./paginas/css/template.css">

<form method="post" action="controllerServlet.do?acao=proprietario.jsp">
	<body>
		<div id="top">
			<ui: name="top">
				<center>
					<h1>Proprietario</h1>
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

				<li><a href="controller.do?acao=ProprietarioAddView">
						Adicionar proprietario</a></li>
				<li><a href="controller.do?acao=ProprietarioConsultarView">
						Consultar proprietario</a></li>
				<li><a href="controller.do?acao=ProprietarioListar"> Editar
						proprietario</a></li>

			</ul>

		</div>
		<div id="bottom">
			<ui:insert name="bottom">
				<center>Direitos Reservados</center>
			</ui:insert>
		</div>

	</body>
</html>