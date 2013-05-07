package br.com.modelo;

public class Imovel {
	
	private int id_imovel;
	private int valor_imovel;
	private String endereco;
	private String descricao;
	private String area;
	private TipoImovel tipo;
	
	public Imovel(){
		super();
	}
	
	public Imovel(int valor_imovel, String endereco, String descricao, String area, TipoImovel tipo){
		super();
		this.valor_imovel = valor_imovel;
		this.endereco = endereco;
		this.descricao = descricao;
		this.area = area;
		this.tipo = tipo;
	}
		
	public int getId_imovel() {
		return id_imovel;
	}
	
	public void setId_imovel(int id_imovel) {
		this.id_imovel = id_imovel;
	}
	
	public int getValor_imovel() {
		return valor_imovel;
	}
	
	public void setValor_imovel(int valor_imovel) {
		this.valor_imovel = valor_imovel;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public TipoImovel getTipo(){
		return tipo;
	}
	
	public void setTipo(TipoImovel tipo) {
		this.tipo = tipo;
	}
}
