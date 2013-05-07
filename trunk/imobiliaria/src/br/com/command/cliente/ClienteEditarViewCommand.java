package br.com.command.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.modelo.Cliente;
import br.com.persistencia.ClientePersistencia;

public class ClienteEditarViewCommand implements ICommand {
	
	private ClientePersistencia persistencia = new ClientePersistencia();
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		int id_cliente = Integer.parseInt(request.getParameter("id"));

		Cliente cliente = persistencia.consultaCod(id_cliente).get(0);
		request.setAttribute("cliente", cliente);

		return "/paginas/cliente/editarCliente.jsp";
	}


}
