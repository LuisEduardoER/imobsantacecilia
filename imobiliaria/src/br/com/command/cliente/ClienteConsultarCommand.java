package br.com.command.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.modelo.Cliente;
import br.com.persistencia.ClientePersistencia;

public class ClienteConsultarCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		String tipoBusca = request.getParameter("TipoBuscaCliente");
		String busca = request.getParameter("busca");
		
		ClientePersistencia cp = new ClientePersistencia();
		List<Cliente> clientes = new ArrayList<Cliente>();

		if (tipoBusca.equals("Id")) {
			clientes = cp.consultaCod(Integer.parseInt(busca));
		} else if (tipoBusca.equals("Nome")) {
			clientes = cp.consultaNome(busca);
		} else if (tipoBusca.equals("Endereço")) {
			clientes = cp.consultaEndereco(busca);
		}
		
		request.setAttribute("consultaCliente", clientes);

		return "/paginas/cliente/consultaCliente.jsp";
	}

}
