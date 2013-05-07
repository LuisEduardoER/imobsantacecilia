package br.com.modelo;

public enum TipoImovel {
	
	ALUGUEL("Aluguel"), VENDA("Venda");
	private String tipo;

	private TipoImovel(String tipo){
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString(){
		return tipo;
	}
	
	
}
