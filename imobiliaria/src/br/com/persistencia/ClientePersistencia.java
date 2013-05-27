package br.com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.modelo.Cliente;
import br.com.modelo.ContatoCliente;

public class ClientePersistencia {

	public void addCliente(Cliente cliente) throws SQLException {

		BancoDeDadosManager bdm = new BancoDeDadosManager();
		Connection con = bdm.getConexao();

		String MAX = "select MAX(id_cliente) from cliente";

		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(MAX);
		int id_cliente = 0;

		while (rs.next()) {
			id_cliente = rs.getInt("MAX");
		}

		id_cliente = id_cliente + 1;

		String sql = "insert into cliente values('" + id_cliente + "', '"
				+ cliente.getCpf() + "' , '" + cliente.getNome() + "' , '"
				+ cliente.getEndereco() + "')";

		s.executeUpdate(sql);

		String MAX2 = "select MAX(id_contato_cliente) from contato_cliente";
		Statement st = con.createStatement();
		ResultSet rst = s.executeQuery(MAX2);
		int id_contato_cliente = 0;

		while (rst.next()) {
			id_contato_cliente = rst.getInt("MAX");
		}

		id_contato_cliente = id_contato_cliente + 1;

		ContatoCliente cc = cliente.getContatosCliente().get(0);
		String sql2 = "insert into contato_cliente values('"
				+ id_contato_cliente + "', '" + id_cliente + "' , '"
				+ cc.getDescricao() + "')";

		st.executeUpdate(sql2);

		con.close();
		s.close();
		st.close();

	}

	public List<Cliente> consultaCod(int id_cliente) {

		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			String id = "select * from cliente where id_cliente='" + id_cliente
					+ "'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(id);
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(Integer.parseInt(rs
						.getString("id_cliente")));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));

				ArrayList<ContatoCliente> contatos = new ArrayList<ContatoCliente>();
				String id2 = "select * from contato_cliente where cliente_id_cliente = "
						+ cliente.getId_cliente();

				Statement s2 = con.createStatement();
				ResultSet rs2 = s2.executeQuery(id2);
				while (rs2.next()) {
					ContatoCliente contato = new ContatoCliente();
					contato.setIdContatoCliente(Integer.parseInt(rs2
							.getString("id_contato_cliente")));
					contato.setIdCliente(cliente.getId_cliente());
					contato.setDescricao(rs2.getString("descricao"));

					contatos.add(contato);
				}

				cliente.setContatosCliente(contatos);
				clientes.add(cliente);
				s2.close();
			}

			con.close();
			s.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public List<Cliente> consultaNome(String nome) {

		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			String id = "select * from cliente where lower(nome) like lower('%"
					+ nome + "%')";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(id);
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(Integer.parseInt(rs
						.getString("id_cliente")));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));

				ArrayList<ContatoCliente> contatos = new ArrayList<ContatoCliente>();
				String id2 = "select * from contato_cliente where cliente_id_cliente = "
						+ cliente.getId_cliente();

				Statement s2 = con.createStatement();
				ResultSet rs2 = s2.executeQuery(id2);
				while (rs2.next()) {
					ContatoCliente contato = new ContatoCliente();
					contato.setIdContatoCliente(Integer.parseInt(rs2
							.getString("id_contato_cliente")));
					contato.setIdCliente(cliente.getId_cliente());
					contato.setDescricao(rs2.getString("descricao"));

					contatos.add(contato);
				}

				cliente.setContatosCliente(contatos);
				clientes.add(cliente);
				s2.close();
			}

			con.close();
			s.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public List<Cliente> consultaEndereco(String endereco) {

		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			String id = "select * from cliente where endereco like '%"
					+ endereco + "%'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(id);
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(Integer.parseInt(rs
						.getString("id_cliente")));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));

				ArrayList<ContatoCliente> contatos = new ArrayList<ContatoCliente>();
				String id2 = "select * from contato_cliente where cliente_id_cliente = "
						+ cliente.getId_cliente();

				Statement s2 = con.createStatement();
				ResultSet rs2 = s2.executeQuery(id2);
				while (rs2.next()) {
					ContatoCliente contato = new ContatoCliente();
					contato.setIdContatoCliente(Integer.parseInt(rs2
							.getString("id_contato_cliente")));
					contato.setIdCliente(cliente.getId_cliente());
					contato.setDescricao(rs2.getString("descricao"));

					contatos.add(contato);
				}

				cliente.setContatosCliente(contatos);
				clientes.add(cliente);
				s2.close();
			}

			con.close();
			s.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			Statement s = con.createStatement();
			String sql = "select * from cliente ";
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(Integer.parseInt(rs
						.getString("id_cliente")));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));

				ArrayList<ContatoCliente> contatos = new ArrayList<ContatoCliente>();
				String id2 = "select * from contato_cliente where cliente_id_cliente = "
						+ cliente.getId_cliente();

				Statement s2 = con.createStatement();
				ResultSet rs2 = s2.executeQuery(id2);
				while (rs2.next()) {
					ContatoCliente contato = new ContatoCliente();
					contato.setIdContatoCliente(Integer.parseInt(rs2
							.getString("id_contato_cliente")));
					contato.setIdCliente(cliente.getId_cliente());
					contato.setDescricao(rs2.getString("descricao"));

					contatos.add(contato);

					lista.add(cliente);
				}
				
				cliente.setContatosCliente(contatos);
				lista.add(cliente);
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

	public void removerCliente(int id_cliente) {

		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			Statement s = con.createStatement();

			String sql = "delete from contato_cliente where cliente_id_cliente = '"
					+ id_cliente + "'";

			s.executeUpdate(sql);

			String sql2 = "delete from cliente where id_cliente = '"
					+ id_cliente + "'";

			s.executeUpdate(sql2);

			con.close();
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void EditarCliente(Cliente cliente) {
		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			String sql = "update cliente set cpf = '" + cliente.getCpf()
					+ "', nome = '" + cliente.getNome() + "', endereco = '"
					+ cliente.getEndereco() + "' where id_cliente = '"
					+ cliente.getId_cliente() + "'";
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
