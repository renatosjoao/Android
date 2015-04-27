package br.curso.a_029_httpsync;

public class Contato {

	private long idcontato;
	private String nome;

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

	@Override
	public String toString() {
		return this.nome;
	}

}
