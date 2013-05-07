package br.com.command.proprietario;

import java.io.IOException;
import java.sql.SQLException;
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

public class ProprietarioAdicionarCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		
		ContatoProprietario cp = new ContatoProprietario();
		cp.setDescricao(telefone);
		ArrayList<ContatoProprietario> colecao = new ArrayList<ContatoProprietario>();
		colecao.add(cp);
		
		Proprietario p = new Proprietario(cpf, nome, endereco,colecao);
		ProprietarioPersistencia pp = new ProprietarioPersistencia();

		try {
			pp.addProprietario(p);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "/paginas/proprietario.jsp";
	}

}
