/**
 *  
 * 07/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class Terceirizado extends Funcionario {

	private String nomeEmpresa;

	
	public Terceirizado() {
		super();
	}

	public Terceirizado(String nome, String sobrenome, String cargo,float salario, String nomeEmpresa) {
		super(nome, sobrenome, cargo, salario);
		this.nomeEmpresa = nomeEmpresa;
	}
	

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	@Override
	public void multiplicarSalario(float salario) {	
		super.multiplicarSalario(salario * 2);
		
	}

	
	
}
