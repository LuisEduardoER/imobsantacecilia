package br.com.command.proprietario;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.modelo.Cliente;
import br.com.modelo.ContatoCliente;
import br.com.modelo.ContatoProprietario;
import br.com.modelo.Proprietario;
import br.com.persistencia.ClientePersistencia;
import br.com.persistencia.ProprietarioPersistencia;

public class ProprietarioEditarCommand implements ICommand{

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		int id_proprietario = Integer.parseInt(request.getParameter("id_proprietario"));
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		
		ContatoProprietario cp = new ContatoProprietario();
		cp.setDescricao(telefone);
		ArrayList<ContatoProprietario> colecao = new ArrayList<ContatoProprietario>();
		colecao.add(cp);
		
		
		ProprietarioPersistencia persistence = new ProprietarioPersistencia();
		Proprietario proprietario = new Proprietario(cpf, nome, endereco, colecao);
		proprietario.setId_proprietario(id_proprietario);

		persistence.EditarProprietario(proprietario);

		return "/paginas/proprietario.jsp";
	}
}
