package br.com.command.proprietario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.persistencia.ProprietarioPersistencia;

public class ProprietarioRemoverCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		ProprietarioPersistencia proprietariop = new ProprietarioPersistencia();

		proprietariop.removerProprietario(id);

		return "/paginas/proprietario.jsp";
	}

}
