package com.example.a_010_spinner;

public class Produto {

	private String idProduto;
	private String nome;

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	@Override
	public String toString() {
		return this.nome;
	}

	public void Produto(String idProduto, String nome) {
		this.idProduto = idProduto;
		this.nome = nome;
	}

	public Produto() {
	}

}
