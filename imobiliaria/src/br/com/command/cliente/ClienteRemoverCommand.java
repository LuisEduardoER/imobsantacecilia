package br.com.command.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.persistencia.ClientePersistencia;

public class ClienteRemoverCommand implements ICommand{

		@Override
		public String execute(HttpServletRequest request) throws ServletException,
				IOException {

			int id = Integer.parseInt(request.getParameter("id"));

			ClientePersistencia clientep = new ClientePersistencia();

			clientep.removerCliente(id);

			return "/paginas/cliente.jsp";
		}

}
