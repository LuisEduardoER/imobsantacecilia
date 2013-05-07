package br.com.command.cliente;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.modelo.Cliente;
import br.com.modelo.ContatoCliente;
import br.com.persistencia.ClientePersistencia;


public class ClienteEditarCommand implements ICommand {
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		
		ContatoCliente cc = new ContatoCliente();
		cc.setDescricao(telefone);
		ArrayList<ContatoCliente> colecao = new ArrayList<ContatoCliente>();
		colecao.add(cc);
		
		ClientePersistencia persistence = new ClientePersistencia();
		Cliente cliente = new Cliente(cpf, nome, endereco, colecao);
		cliente.setId_cliente(id_cliente);

		persistence.EditarCliente(cliente);

		return "/paginas/cliente.jsp";
	}

}
