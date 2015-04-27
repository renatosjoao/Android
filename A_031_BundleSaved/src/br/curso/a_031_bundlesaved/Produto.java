package br.curso.a_031_bundlesaved;

import java.io.Serializable;

public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5800224103133837152L;
	private long codigo;
	private String nome;
	private float precounitario;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrecounitario() {
		return precounitario;
	}

	public void setPrecounitario(float precounitario) {
		this.precounitario = precounitario;
	}

}
