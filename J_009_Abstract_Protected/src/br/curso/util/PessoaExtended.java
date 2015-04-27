package br.curso.util;

public abstract class PessoaExtended extends Pessoa {

	@Override
	public void fazerSaudacao() {
		System.out.println("------------------");
		System.out.println("Nome ");
		System.out.println("------------------");
		//
		super.fazerSaudacao();
	}

	public PessoaExtended() {
	}

	public PessoaExtended(String nome, int tipo) {
		super(nome, tipo);
	}

}
