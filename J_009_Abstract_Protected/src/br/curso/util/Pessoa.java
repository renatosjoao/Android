package br.curso.util;

public abstract class Pessoa {

	private String nome;
	private int tipo;
	
	
	public Pessoa() {
	}


	public Pessoa(String nome, int tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	
	protected abstract String incluirTitulo(int tipo, String nome);

	public void fazerSaudacao(){
		System.out.println("Seja bem vindo " 
				+ incluirTitulo(this.tipo, this.nome));
		
	}
}
