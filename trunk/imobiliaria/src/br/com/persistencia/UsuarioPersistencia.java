package br.com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.modelo.Usuario;

public class UsuarioPersistencia {

	public void addUsuario(Usuario usuario) throws SQLException {

		BancoDeDadosManager bdm = new BancoDeDadosManager();
		Connection con = bdm.getConexao();

		String sql = "insert into usuario values ('" + usuario.getLogin()
				+ "' , '" + usuario.getSenha() + "')";

		Statement s = con.createStatement();
		s.executeUpdate(sql);

		con.close();
		s.close();
	}

	public Usuario getUsuario(Usuario usuario) {

		Usuario retorno = null;

		try {
			BancoDeDadosManager bdm = new BancoDeDadosManager();
			Connection con = bdm.getConexao();

			String sql = "select * from usuario where login = '"
					+ usuario.getLogin() + "' and senha = '"
					+ usuario.getSenha() + "'";

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				retorno = new Usuario(login, senha);
			}

			con.close();
			s.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retorno;
	}
}
