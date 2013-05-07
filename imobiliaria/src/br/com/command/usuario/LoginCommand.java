package br.com.command.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import br.com.command.ICommand;
import br.com.modelo.Usuario;
import br.com.persistencia.UsuarioPersistencia;

public class LoginCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) throws ServletException,
			IOException {

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(nome, senha);
		UsuarioPersistencia up = new UsuarioPersistencia();

			if (usuario.loginValido() == true) {
				return "/paginas/principal.jsp";
			} else {
				up.getUsuario(usuario);
			}

			return "/paginas/principal.jsp";
	}
}

