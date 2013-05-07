package br.com.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDadosManager {

		private static final String NOME_BANCO = "imobiliaria";
		private static final String login = "postgres";
		private static final String senha = "admin";

		public Connection getConexao() {

			Connection con = null;

			try {

				Class.forName("org.postgresql.Driver");

				con = DriverManager.getConnection(
						"jdbc:postgresql://localhost/imobiliaria", login, senha);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return con;
		}
}