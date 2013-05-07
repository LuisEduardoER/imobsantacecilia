package br.com.modelo;

public enum TipoBuscaCliente {
	
	ID("Id"), NOME("Nome"), ENDERECO("Endereço");
	private String tipo;
	
	private TipoBuscaCliente(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return tipo;
	}
	
}
