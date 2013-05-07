package br.com.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.command.ICommand;
import br.com.command.cliente.ClienteAddViewCommand;
import br.com.command.cliente.ClienteAdicionarCommand;
import br.com.command.cliente.ClienteCommand;
import br.com.command.cliente.ClienteConsultarCommand;
import br.com.command.cliente.ClienteConsultarViewCommand;
import br.com.command.cliente.ClienteEditarCommand;
import br.com.command.cliente.ClienteEditarViewCommand;
import br.com.command.cliente.ClienteListarCommand;
import br.com.command.cliente.ClienteRemoverCommand;
import br.com.command.imobiliaria.ImobiliariaCommand;
import br.com.command.imovel.ImovelAddViewCommand;
import br.com.command.imovel.ImovelAdicionarCommand;
import br.com.command.imovel.ImovelCommand;
import br.com.command.imovel.ImovelConsultarCommand;
import br.com.command.imovel.ImovelConsultarViewCommand;
import br.com.command.imovel.ImovelEditarCommand;
import br.com.command.imovel.ImovelEditarViewCommand;
import br.com.command.imovel.ImovelListarCommand;
import br.com.command.imovel.ImovelRemoverCommand;
import br.com.command.proprietario.ProprietarioAddViewCommand;
import br.com.command.proprietario.ProprietarioAdicionarCommand;
import br.com.command.proprietario.ProprietarioCommand;
import br.com.command.proprietario.ProprietarioConsultarCommand;
import br.com.command.proprietario.ProprietarioConsultarViewCommand;
import br.com.command.proprietario.ProprietarioEditarCommand;
import br.com.command.proprietario.ProprietarioEditarViewCommand;
import br.com.command.proprietario.ProprietarioListarCommand;
import br.com.command.proprietario.ProprietarioRemoverCommand;
import br.com.command.usuario.LoginCommand;

public class ControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private HashMap<String, ICommand> map;

	public void init(ServletConfig confg) throws ServletException {

		map = new HashMap<String, ICommand>();

		map.put("ValidaLogin", new LoginCommand());
		map.put("ClienteAdd", new ClienteAdicionarCommand());
		map.put("ClienteAddView", new ClienteAddViewCommand());
		map.put("ClienteConsultarView", new ClienteConsultarViewCommand());
		map.put("ClienteConsultar", new ClienteConsultarCommand());
		map.put("ClienteRemover", new ClienteRemoverCommand());
		map.put("ClienteEditar", new ClienteEditarCommand() );
		map.put("ClienteEditarView", new ClienteEditarViewCommand());
		map.put("ClienteListar", new ClienteListarCommand());
		map.put("Cliente", new ClienteCommand());
		map.put("Proprietario", new ProprietarioCommand());
		map.put("ProprietarioAdd", new ProprietarioAdicionarCommand());
		map.put("ProprietarioAddView", new ProprietarioAddViewCommand());
		map.put("ProprietarioEditar", new ProprietarioEditarCommand());
		map.put("ProprietarioEditarView", new ProprietarioEditarViewCommand());
		map.put("ProprietarioListar", new ProprietarioListarCommand());
		map.put("ProprietarioConsultar", new ProprietarioConsultarCommand());
		map.put("ProprietarioConsultarView", new ProprietarioConsultarViewCommand());
		map.put("ProprietarioRemover", new ProprietarioRemoverCommand());
		map.put("Imobiliaria", new ImobiliariaCommand());
		map.put("Imovel", new ImovelCommand());
		map.put("ImovelAdd", new ImovelAdicionarCommand());
		map.put("ImovelAddView", new ImovelAddViewCommand());
		map.put("ImovelConsultarView", new ImovelConsultarViewCommand());
		map.put("ImovelConsultar", new ImovelConsultarCommand());
		map.put("ImovelRemover", new ImovelRemoverCommand());
		map.put("ImovelEditar", new ImovelEditarCommand() );
		map.put("ImovelEditarView", new ImovelEditarViewCommand());
		map.put("ImovelListar", new ImovelListarCommand());
		
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");

		ICommand command = this.find(acao);
		String url = command.execute(request);

		RequestDispatcher d = request.getRequestDispatcher(url);
		d.forward(request, response);

	}

	private ICommand find(String acao) throws ServletException {
		if (!map.containsKey(acao)) {
			throw new ServletException("Página Não encontrada: " + acao);
		}

		return (ICommand) map.get(acao);
	}

}
