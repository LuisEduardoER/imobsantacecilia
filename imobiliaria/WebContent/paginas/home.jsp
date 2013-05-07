<%@ page import = "java.util.*" %>

<html>
	<link rel="stylesheet" type="text/css" href="./paginas/css/template.css"/>
	
	<%session.invalidate(); %>
	
	
	
	<center>
		<form method="post" action="controllerServlet.do?acao=ValidaLogin">
		
		<body>
		
			<div id = "top"> 
				<ui: insert name = "top"><center><font size = "30" face = "Times New Roman" ><h1>Sistema Imobiliário</font></h1></ui:></center>	
			</div>
			
			
			
				<div>				
					<div  id="content" class="left_content">
						Login:					
							<input id = "nome" name = "nome" type = "text", size = "30">							
					</div>
						
					<div id = "content" class = "left_content">
						Senha: 
							<input id = "senha" name = "senha" type = "password", size = "30">								
					</div>
						
					<div id = "content" class = "left_content">
							
						<input type = "submit" value = "Logar"/>
						<input type = "submit" value="Limpar">
							
					</div>	
				</div>										
			</div>
			
			<div id="bottom">
            <ui:insert name="bottom">
                <center>Direitos Reservados</center>
            </ui:insert>
        </div>		
									
		</body>
						
		</form>
	</center>
	

</html>