package br.com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface ICommand {

	public String execute(HttpServletRequest request) throws ServletException,
			IOException;
}