package br.com.command.imovel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.modelo.Imovel;
import br.com.modelo.TipoImovel;
import br.com.persistencia.ImovelPersistencia;

public class ImovelEditarCommand implements ICommand{

		@Override
		public String execute(HttpServletRequest request) throws ServletException,
				IOException {

			int id_imovel = Integer.parseInt(request.getParameter("id_imovel"));
			String tipo = request.getParameter("tipo");
			int valor = Integer.parseInt(request.getParameter("valor_imovel"));
			String endereco = request.getParameter("endereco");
			String area = request.getParameter("area");
			String descricao = request.getParameter("descricao_imovel");
			
			TipoImovel tipoImovel;
			if(tipo.equals("Venda")) {
				tipoImovel = TipoImovel.VENDA;
			} else {
				tipoImovel = TipoImovel.ALUGUEL;
			}
			
			ImovelPersistencia persistence = new ImovelPersistencia();
			Imovel imovel = new Imovel(valor, endereco, descricao, area, tipoImovel);
			imovel.setId_imovel(id_imovel);

			persistence.EditarImovel(imovel);

			return "/paginas/imovel.jsp";
		}
	}

