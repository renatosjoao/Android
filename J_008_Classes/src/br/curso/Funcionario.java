/**
 *  
 * 07/05/2014
 * @author Renato Stoffalette Joao
 */

package br.curso;


public class Funcionario {
	
	private String nome;
	private String sobrenome;
	private String cargo;
	private float salario;
	
	private int numFilhos;
	
	public Funcionario() {
		
	}

	
	public Funcionario(String nome, String sobrenome, String cargo,float salario) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cargo = cargo;
		this.salario = salario;
	}

	public int getNumFilhos() {
		return numFilhos;
	}
	
	public void setNumFilhos(int numFilhos) {
		this.numFilhos = numFilhos;
	}

	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public void multiplicarSalario(float salario){
		this.salario *= salario;
	}
	
}
