package br.com.modelo;
import br.com.persistencia.UsuarioPersistencia;

public class Usuario {

	private String login;
	private String senha;

	public Usuario() {
		this.login = null;
		this.senha = null;
	}

	public Usuario(String login, String senha) {

		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean loginValido() {
		UsuarioPersistencia up = new UsuarioPersistencia();
		Usuario usuario = up.getUsuario(this);
		if (usuario == null) {
			return false;
		}
		return true;
	}
}