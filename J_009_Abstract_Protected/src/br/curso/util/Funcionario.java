package br.curso.util;

public class Funcionario extends PessoaExtended{

	public Funcionario(String nome, int tipo) {
		super(nome, tipo);
	}

	public Funcionario() {
	}

	@Override
	protected String incluirTitulo(int tipo, String nome) {
		String resultado = "";
		switch (tipo) {
		case 0 :
			resultado = "Sr.";
			break;
		case 1 :
			resultado = "Sra.";
			break;
		default:
			break;
		}
	return resultado + nome;
	}
}
