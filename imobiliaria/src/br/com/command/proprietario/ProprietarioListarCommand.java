package br.com.command.proprietario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.persistencia.ProprietarioPersistencia;

public class ProprietarioListarCommand implements ICommand {
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		ProprietarioPersistencia pp = new ProprietarioPersistencia();
		request.setAttribute("ListaProprietarios", pp.listarProprietarios());

		return "/paginas/proprietario/listarProprietario.jsp";
	}

}
