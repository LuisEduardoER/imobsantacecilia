package br.com.modelo;

public class ContatoProprietario {
	
	private int idContatoProprietario;
	private int idProprietario;
	private String descricao;
	
	public ContatoProprietario(int idContatoProprietario, int idProprietario, 
			String descricao) {
		super();
		this.idContatoProprietario = idContatoProprietario;
		this.idProprietario = idProprietario;
		this.descricao = descricao;
	}
	
	public ContatoProprietario() {
		super();
	}

	
	public int getIdContatoProprietario() {
		return idContatoProprietario;
	}

	public void setIdContatoProprietario(int idContatoProprietario) {
		this.idContatoProprietario = idContatoProprietario;
	}

	public int getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(int idProprietario) {
		this.idProprietario = idProprietario;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

