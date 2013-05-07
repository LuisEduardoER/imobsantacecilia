package br.com.modelo;

import java.util.ArrayList;

public class Proprietario {

	private String nome;
	private String cpf;
	private String endereco;
	private int id_proprietario;
	private ArrayList<ContatoProprietario> contatosProprietario;
	
	public Proprietario(){
		super();
		contatosProprietario = new ArrayList<ContatoProprietario>();
	}
	
	public Proprietario(String cpf,String nome, String endereco, ArrayList<ContatoProprietario> contatosProprietario){
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.contatosProprietario = contatosProprietario;
	
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setId_proprietario(int id_cliente) {
		this.id_proprietario = id_cliente;
	}

	public int getId_proprietario() {
		return id_proprietario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<ContatoProprietario> getContatosProprietario() {
		return contatosProprietario;
	}

	public void setContatosProprietario(
			ArrayList<ContatoProprietario> contatosProprietario) {
		this.contatosProprietario = contatosProprietario;
	}
}
