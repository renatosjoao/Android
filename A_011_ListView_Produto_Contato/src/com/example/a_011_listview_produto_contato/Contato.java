package com.example.a_011_listview_produto_contato;

public class Contato {

	
	private long idcontato;
	private String nome;
	private String telefone;
	
	public Contato() {
	}

	public Contato(long idcontato, String nome, String telefone) {
		this.idcontato = idcontato;
		this.nome = nome;
		this.telefone = telefone;
	}

	public long getIdcontato() {
		return idcontato;
	}

	public void setIdcontato(long idcontato) {
		this.idcontato = idcontato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


}
