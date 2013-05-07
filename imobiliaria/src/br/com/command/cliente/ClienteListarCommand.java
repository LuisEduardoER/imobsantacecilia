package br.com.command.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.persistencia.ClientePersistencia;

public class ClienteListarCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		ClientePersistencia cp = new ClientePersistencia();
		request.setAttribute("ListaClientes", cp.listarClientes());

		return "/paginas/cliente/listarCliente.jsp";
	}

}
