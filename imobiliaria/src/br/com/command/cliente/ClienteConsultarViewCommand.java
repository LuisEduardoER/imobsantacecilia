package br.com.command.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.persistencia.ClientePersistencia;

public class ClienteConsultarViewCommand implements ICommand {
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		return "/paginas/cliente/consultaCliente.jsp";
	}

}
