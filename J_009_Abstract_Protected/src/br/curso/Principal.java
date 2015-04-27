package br.curso;

import br.curso.util.Funcionario;

public class Principal {

	public Principal() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Funcionario funH = new Funcionario("Renato", 0);
		Funcionario funM = new Funcionario("Maria", 1);
		
		funH.fazerSaudacao();
		funM.fazerSaudacao();
	}

}
