package br.com.command.imobiliaria;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import br.com.command.ICommand;

public class ImobiliariaCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		return "/paginas/imobiliaria.jsp";

	}

}
