package com.example.a_027_dbase;

public class Contato {

	private long idContato;
	private String nome;
	private String telefone;
	private String dataNasc;

	public Contato(long idContato, String nome, String telefone, String dataNasc) {
		this.idContato = idContato;
		this.nome = nome;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
	}

	public Contato() {
	}

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

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

}
