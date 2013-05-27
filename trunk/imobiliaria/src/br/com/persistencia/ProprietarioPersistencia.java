package br.com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.modelo.Cliente;
import br.com.modelo.ContatoCliente;
import br.com.modelo.ContatoProprietario;
import br.com.modelo.Proprietario;

public class ProprietarioPersistencia {

	public void addProprietario(Proprietario proprietario) throws SQLException {

		BancoDeDadosManager bdm = new BancoDeDadosManager();
		Connection con = bdm.getConexao();

		String MAX = "select MAX(id_proprietario) from proprietario";

		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(MAX);
		int id_proprietario = 0;

		while (rs.next()) {
			id_proprietario = rs.getInt("MAX");
		}

		id_proprietario = id_proprietario + 1;

		String sql = "insert into proprietario values('" + id_proprietario + "', '"
				+ proprietario.getCpf() + "' , '" + proprietario.getNome()
				+ "' , '" + proprietario.getEndereco() + "')";

		s.executeUpdate(sql);

		String MAX2 = "select MAX(id_contato_proprietario) from contato_proprietario";
		Statement st = con.createStatement();
		ResultSet rst = s.executeQuery(MAX2);
		int id_contato_proprietario = 0;

		while (rst.next()) {
			id_contato_proprietario = rst.getInt("MAX");
		}

		id_contato_proprietario = id_contato_proprietario + 1;

		ContatoProprietario cp = proprietario.getContatosProprietario().get(0);
		String sql2 = "insert into contato_proprietario values('"
				+ id_contato_proprietario + "', '" + id_proprietario + "' , '"
				+ cp.getDescricao() + "')";

		st.executeUpdate(sql2);

		con.close();
		s.close();
		st.close();

	}

	public List<Proprietario> consultaCod(int id_proprietario) {

		List<Proprietario> proprietarios = new ArrayList<Proprietario>();
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			String id = "select * from proprietario where id_proprietario='"
					+ id_proprietario + "'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(id);
			while (rs.next()) {
				Proprietario proprietario = new Proprietario();
				proprietario.setId_proprietario(Integer.parseInt(rs
						.getString("id_proprietario")));
				proprietario.setNome(rs.getString("nome"));
				proprietario.setCpf(rs.getString("cpf"));
				proprietario.setEndereco(rs.getString("endereco"));

				ArrayList<ContatoProprietario> contatos = new ArrayList<ContatoProprietario>();
				String id2 = "select * from contato_proprietario where proprietario_id_proprietario = "
						+ proprietario.getId_proprietario();

				Statement s2 = con.createStatement();
				ResultSet rs2 = s2.executeQuery(id2);
				while (rs2.next()) {
					ContatoProprietario contato = new ContatoProprietario();
					contato.setIdContatoProprietario(Integer.parseInt(rs2
							.getString("id_contato_proprietario")));
					contato.setIdProprietario(proprietario.getId_proprietario());
					contato.setDescricao(rs2.getString("descricao"));

					contatos.add(contato);
				}

				proprietario.setContatosProprietario(contatos);
				proprietarios.add(proprietario);
				s2.close();
			}

			con.close();
			s.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proprietarios;
	}
	
	public List<Proprietario> consultaNome(String nome) {

		List<Proprietario> proprietarios = new ArrayList<Proprietario>();
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			String id = "select * from proprietario where lower(nome) like lower('%" + nome
					+ "%')";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(id);
			
			while (rs.next()) {
				Proprietario proprietario = new Proprietario();
				proprietario.setId_proprietario(Integer.parseInt(rs
						.getString("id_proprietario")));
				proprietario.setNome(rs.getString("nome"));
				proprietario.setCpf(rs.getString("cpf"));
				proprietario.setEndereco(rs.getString("endereco"));
				
				ArrayList<ContatoProprietario> contatos = new ArrayList<ContatoProprietario>();
				String id2 = "select * from contato_proprietario where proprietario_id_proprietario = " 
						+ proprietario.getId_proprietario();
				
				Statement s2 = con.createStatement();
				ResultSet rs2 = s2.executeQuery(id2);
				while(rs2.next()) {
					ContatoProprietario contato = new ContatoProprietario();
					contato.setIdContatoProprietario(Integer.parseInt(rs2
							.getString("id_contato_proprietario")));
					contato.setIdProprietario(proprietario.getId_proprietario());
					contato.setDescricao(rs2.getString("descricao"));
					
					contatos.add(contato);
				}
	
				proprietario.setContatosProprietario(contatos);				
				proprietarios.add(proprietario);
				s2.close();
			}

			con.close();
			s.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proprietarios;
	}

	public List<Proprietario> consultaEndereco(String endereco) {

		List<Proprietario> proprietarios = new ArrayList<Proprietario>();
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			String id = "select * from proprietario where endereco like '%"
					+ endereco + "%'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(id);
			while (rs.next()) {
				Proprietario proprietario = new Proprietario();
				proprietario.setId_proprietario(Integer.parseInt(rs
						.getString("id_proprietario")));
				proprietario.setNome(rs.getString("nome"));
				proprietario.setCpf(rs.getString("cpf"));
				proprietario.setEndereco(rs.getString("endereco"));
				
				ArrayList<ContatoProprietario> contatos = new ArrayList<ContatoProprietario>();
				String id2 = "select * from contato_proprietario where proprietario_id_proprietario = " 
						+ proprietario.getId_proprietario();
				
				Statement s2 = con.createStatement();
				ResultSet rs2 = s2.executeQuery(id2);
				while(rs2.next()) {
					ContatoProprietario contato = new ContatoProprietario();
					contato.setIdContatoProprietario(Integer.parseInt(rs2
							.getString("id_contato_proprietario")));
					contato.setIdProprietario(proprietario.getId_proprietario());
					contato.setDescricao(rs2.getString("descricao"));
					
					contatos.add(contato);
				}
	
				proprietario.setContatosProprietario(contatos);				
				proprietarios.add(proprietario);
				s2.close();
			}

			con.close();
			s.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proprietarios;
	}


	public ArrayList<Proprietario> listarProprietarios() {
		ArrayList<Proprietario> lista = new ArrayList<Proprietario>();
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			Statement s = con.createStatement();
			String sql = "select * from proprietario ";
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Proprietario proprietario = new Proprietario();
				proprietario.setId_proprietario(Integer.parseInt(rs
						.getString("id_proprietario")));
				proprietario.setNome(rs.getString("nome"));
				proprietario.setCpf(rs.getString("cpf"));
				proprietario.setEndereco(rs.getString("endereco"));

				ArrayList<ContatoProprietario> contatos = new ArrayList<ContatoProprietario>();
				String id2 = "select * from contato_proprietario where proprietario_id_proprietario = "
						+ proprietario.getId_proprietario();

				Statement s2 = con.createStatement();
				ResultSet rs2 = s2.executeQuery(id2);
				while (rs2.next()) {
					ContatoProprietario contato = new ContatoProprietario();
					contato.setIdContatoProprietario(Integer.parseInt(rs2
							.getString("id_contato_proprietario")));
					contato.setIdProprietario(proprietario.getId_proprietario());
					contato.setDescricao(rs2.getString("descricao"));

					contatos.add(contato);

					lista.add(proprietario);
				}
				
				proprietario.setContatosProprietario(contatos);
				lista.add(proprietario);
				s2.close();
				
			}
			con.close();
			s.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void removerProprietario(int id_proprietario) {

		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			Statement s = con.createStatement();

			String sql = "delete from contato_proprietario where proprietario_id_proprietario = '"
					+ id_proprietario + "'";

			s.executeUpdate(sql);

			String sql2 = "delete from proprietario where id_proprietario = '"
					+ id_proprietario + "'";

			s.executeUpdate(sql2);

			con.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void EditarProprietario(Proprietario proprietario) {
		
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			String sql = "update proprietario set cpf = '" + proprietario.getCpf()
					+ "', nome = '" + proprietario.getNome() + "', endereco = '"
					+ proprietario.getEndereco() + "' where id_proprietario = '"
					+ proprietario.getId_proprietario() + "'";
			System.out.println(sql);
			Statement s = con.createStatement();
			s.executeUpdate(sql);

			con.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
