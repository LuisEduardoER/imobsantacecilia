package br.com.command.imovel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.modelo.Imovel;
import br.com.modelo.TipoImovel;
import br.com.persistencia.ImovelPersistencia;

public class ImovelAdicionarCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		String tipo = request.getParameter("tipo");		
		int valor_imovel  = Integer.parseInt(request.getParameter("valor_imovel"));
		String endereco = request.getParameter("endereco");
		String area = request.getParameter("area");
		String descricao = request.getParameter("descricao_imovel");
		
		TipoImovel tipoImovel;
		if(tipo.equals("venda")) {
			tipoImovel = TipoImovel.VENDA;
		} else {
			tipoImovel = TipoImovel.ALUGUEL;
		}
		
		Imovel i = new Imovel(valor_imovel, endereco, descricao, area, tipoImovel);
		ImovelPersistencia imop = new ImovelPersistencia();

		try {
			imop.addImovel(i);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "/paginas/imovel.jsp";
	}
}
