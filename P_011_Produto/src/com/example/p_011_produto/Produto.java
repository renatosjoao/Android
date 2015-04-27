package com.example.p_011_produto;

public class Produto {
	private long idCodigo;
	private String nome;
	
	
	@Override
	public String toString() {
		return this.nome;
	}


	public long getIdCodigo() {
		return idCodigo;
	}


	public void setIdCodigo(long idCodigo) {
		this.idCodigo = idCodigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Produto() {
		// TODO Auto-generated constructor stub
	}

}
