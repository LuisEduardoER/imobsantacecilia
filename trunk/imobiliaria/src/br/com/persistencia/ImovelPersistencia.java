package br.com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.modelo.Imovel;
import br.com.modelo.TipoImovel;

public class ImovelPersistencia {
	
	public void addImovel(Imovel imovel) throws SQLException {

		BancoDeDadosManager bdm = new BancoDeDadosManager();
		Connection con = bdm.getConexao();

		String MAX = "select MAX(id_imovel) from imovel";

		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(MAX);
		int id_imovel = 0;

		while (rs.next()) {
			id_imovel = rs.getInt("MAX");
		}

		id_imovel = id_imovel + 1;
		
		int tipo;
		if(imovel.getTipo() == TipoImovel.ALUGUEL){
			tipo = 0;
		}else {
			tipo = 1;
		}

		String sql = "insert into imovel values('" + id_imovel + "', '"
				+ tipo + "' , '" + imovel.getValor_imovel() + "' , '"
				+ imovel.getEndereco() + "' , '" + imovel.getArea() + "' , '" + imovel.getDescricao()
				+ "')";

		s.executeUpdate(sql);

		con.close();
		s.close();
	}

	public List<Imovel> consultaCod(int id_imovel) {

		List<Imovel> imoveis = new ArrayList<Imovel>();
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			String id = "select * from imovel where id_imovel='" + id_imovel
					+ "'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(id);
			while (rs.next()) {
				Imovel imovel = new Imovel();
				imovel.setId_imovel(Integer.parseInt(rs
						.getString("id_imovel")));
				int tipo = rs.getInt("tipo_imovel_id_tipo_imovel");
				if(tipo == 0) {
					imovel.setTipo(TipoImovel.ALUGUEL);
				}else {
					imovel.setTipo(TipoImovel.VENDA);
				}
				imovel.setValor_imovel(rs.getInt("valor_imovel"));
				imovel.setEndereco(rs.getString("endereco"));
				imovel.setArea(rs.getString("area"));
				imovel.setDescricao(rs.getString("descricao_imovel"));
				imoveis.add(imovel);
			}

			con.close();
			s.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imoveis;
	}

	public ArrayList<Imovel> listarImoveis() {
		ArrayList<Imovel> lista = new ArrayList<Imovel>();
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			Statement s = con.createStatement();
			String sql = "select * from imovel ";
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Imovel imovel = new Imovel();
				imovel.setId_imovel(Integer.parseInt(rs
						.getString("id_imovel")));
				int tipo = rs.getInt("tipo_imovel_id_tipo_imovel");
				if(tipo == 0) {
					imovel.setTipo(TipoImovel.ALUGUEL);
				}else {
					imovel.setTipo(TipoImovel.VENDA);
				}
				imovel.setValor_imovel(rs.getInt("valor_imovel"));
				imovel.setEndereco(rs.getString("endereco"));
				imovel.setArea(rs.getString("area"));
				imovel.setDescricao(rs.getString("descricao_imovel"));

				lista.add(imovel);
			}
			con.close();
			s.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void removerImovel(int id_imovel) {

		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			Statement s = con.createStatement();
			String sql = "delete from imovel where id_imovel = '"
					+ id_imovel + "'";

			s.executeUpdate(sql);

			con.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void EditarImovel(Imovel imovel) {
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();
			
			int tipo;
			if(imovel.getTipo() == TipoImovel.ALUGUEL){
				tipo = 0;
			}else {
				tipo = 1;
			}
			
			String sql = "update imovel set tipo_imovel_id_tipo_imovel = '"
					+ tipo + "', valor_imovel =  '" + imovel.getValor_imovel() + "', endereco = '"
					+ imovel.getEndereco() + "', area = '"
					+ imovel.getArea() + "', descricao_imovel = '" + imovel.getDescricao() 
					+ "' where id_imovel = '" + imovel.getId_imovel() + "'";
			Statement s = con.createStatement();
			s.executeUpdate(sql);

			con.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
