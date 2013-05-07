package br.com.command.imovel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import br.com.command.ICommand;
import br.com.persistencia.ImovelPersistencia;

public class ImovelConsultarCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		int id = Integer.parseInt(request.getParameter("id_imovel"));
		ImovelPersistencia ip = new ImovelPersistencia();
		request.setAttribute("consultaImovel", ip.consultaCod(id));

		return "/paginas/imovel/consultaImovel.jsp";
	}

}
