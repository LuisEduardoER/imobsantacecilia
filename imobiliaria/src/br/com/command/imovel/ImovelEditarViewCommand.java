package br.com.command.imovel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.modelo.Imovel;
import br.com.persistencia.ImovelPersistencia;

public class ImovelEditarViewCommand implements ICommand {

	private ImovelPersistencia persistencia = new ImovelPersistencia();

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		int id_imovel = Integer.parseInt(request.getParameter("id"));

		Imovel imovel = persistencia.consultaCod(id_imovel).get(0);
		request.setAttribute("imovel", imovel);

		return "/paginas/imovel/editarImovel.jsp";

	}
}
