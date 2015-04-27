package com.example.a_0012;

public class Contatos {

	long idContato;
	String nome;
	String telefone;

	public long getIdContato() {
		return idContato;
	}

	public void setIdContato(long idContato) {
		this.idContato = idContato;
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

	public Contatos(long idContato, String nome, String telefone) {
		this.idContato = idContato;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Contatos() {
	}

}
