package br.com.command.cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.modelo.Cliente;
import br.com.modelo.ContatoCliente;
import br.com.persistencia.ClientePersistencia;

public class ClienteAdicionarCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		
		ContatoCliente cc = new ContatoCliente();
		cc.setDescricao(telefone);
		ArrayList<ContatoCliente> colecao = new ArrayList<ContatoCliente>();
		colecao.add(cc);
		
		Cliente c = new Cliente(cpf, nome, endereco,colecao);
		ClientePersistencia cp = new ClientePersistencia();

		try {
			cp.addCliente(c);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "/paginas/cliente.jsp";
	}
}
