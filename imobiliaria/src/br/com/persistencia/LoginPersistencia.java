package br.com.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.modelo.Usuario;

public class LoginPersistencia {

		public Usuario login(Usuario usuario) {

			Usuario retorno = null;

			try {
				BancoDeDadosManager bdm = new BancoDeDadosManager();
				Connection con = bdm.getConexao();

				String sql = "select * from usuario where nome = '"
						+ usuario.getLogin() + "' and senha = '"
						+ usuario.getSenha() + "'";

				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);

				if (rs.next()) {
					String login = rs.getString("nome");
					String senha = rs.getString("senha");
					// retorno = Usuario(login, senha);
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
