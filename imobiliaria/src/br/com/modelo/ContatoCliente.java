package br.com.modelo;

public class ContatoCliente {
	
	private int idContatoCliente;
	private int idCliente;
	private String descricao;
	
	public ContatoCliente(int idContatoCliente, int idCliente, String descricao) {
		super();
		this.idContatoCliente = idContatoCliente;
		this.idCliente = idCliente;
		this.descricao = descricao;
	}
	
	public ContatoCliente() {
		super();
	}

	public int getIdContatoCliente() {
		return idContatoCliente;
	}
	
	public void setIdContatoCliente(int idContatoCliente) {
		this.idContatoCliente = idContatoCliente;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
