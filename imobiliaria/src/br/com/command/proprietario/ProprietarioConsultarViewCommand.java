package br.com.command.proprietario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;

public class ProprietarioConsultarViewCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		return "/paginas/proprietario/consultaProprietario.jsp";
	}


}
