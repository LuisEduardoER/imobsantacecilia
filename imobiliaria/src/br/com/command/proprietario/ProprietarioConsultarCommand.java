package br.com.command.proprietario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.modelo.Cliente;
import br.com.modelo.Proprietario;
import br.com.persistencia.ClientePersistencia;
import br.com.persistencia.ProprietarioPersistencia;

public class ProprietarioConsultarCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		String tipoBusca = request.getParameter("TipoBuscaCliente");
		String busca = request.getParameter("busca");

		ProprietarioPersistencia pp = new ProprietarioPersistencia();
		List<Proprietario> proprietarios = new ArrayList<Proprietario>();

		if (tipoBusca.equals("Id")) {
			proprietarios = pp.consultaCod(Integer.parseInt(busca));
		} else if (tipoBusca.equals("Nome")) {
			proprietarios = pp.consultaNome(busca);
		} else if (tipoBusca.equals("Endereço")) {
			proprietarios = pp.consultaEndereco(busca);
		}

		request.setAttribute("consultaProprietario", proprietarios);

		return "/paginas/proprietario/consultaProprietario.jsp";
	}
}
