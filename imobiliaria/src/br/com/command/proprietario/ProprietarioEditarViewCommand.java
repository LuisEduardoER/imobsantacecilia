package br.com.command.proprietario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.modelo.Proprietario;
import br.com.persistencia.ProprietarioPersistencia;

public class ProprietarioEditarViewCommand implements ICommand {

	private ProprietarioPersistencia persistencia = new ProprietarioPersistencia();

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		int id_proprietario = Integer.parseInt(request.getParameter("id"));

		Proprietario proprietario = persistencia.consultaCod(id_proprietario)
				.get(0);
		request.setAttribute("proprietario", proprietario);

		return "/paginas/proprietario/editarProprietario.jsp";

	}
}
