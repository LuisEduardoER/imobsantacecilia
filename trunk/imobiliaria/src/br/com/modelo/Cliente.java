package br.com.modelo;

import java.util.ArrayList;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String endereco;
	private int id_cliente;
	private ArrayList<ContatoCliente> contatosCliente;
	
	public Cliente(){
		super();
		contatosCliente = new ArrayList<ContatoCliente>();
	}
	
	public Cliente(String cpf,String nome, String endereco, ArrayList<ContatoCliente> contatosCliente){
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.contatosCliente = contatosCliente;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_cliente() {
		return id_cliente;
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

	public ArrayList<ContatoCliente> getContatosCliente() {
		return contatosCliente;
	}

	public void setContatosCliente(ArrayList<ContatoCliente> contatosCliente) {
		this.contatosCliente = contatosCliente;
	}

	
	

}
