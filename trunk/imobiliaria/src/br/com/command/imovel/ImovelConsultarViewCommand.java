package br.com.command.imovel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;

public class ImovelConsultarViewCommand implements ICommand {
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		return "/paginas/imovel/consultaImovel.jsp";
	}

}
