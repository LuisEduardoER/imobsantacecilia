package br.com.command.imovel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.persistencia.ImovelPersistencia;

public class ImovelListarCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		ImovelPersistencia ip = new ImovelPersistencia();
		request.setAttribute("ListaImoveis", ip.listarImoveis());

		return "/paginas/imovel/listarImovel.jsp";
	}

}