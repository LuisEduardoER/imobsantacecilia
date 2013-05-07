package br.com.command.imovel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.persistencia.ImovelPersistencia;

public class ImovelRemoverCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		ImovelPersistencia imovelp = new ImovelPersistencia();

		imovelp.removerImovel(id);

		return "/paginas/imovel.jsp";
	}

}
