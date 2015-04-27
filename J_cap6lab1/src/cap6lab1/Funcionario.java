/**
 *  
 * 07/05/2014
 * @author Renato Stoffalette Joao
 */
package cap6lab1;

public class Funcionario {

	
	public String nome;
	public String sobrenome;
	public String cargo;
	public float salario;
	
	public Funcionario() {
	
	}

	public Funcionario(String nome, String sobrenome, String cargo,
			float salario) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cargo = cargo;
		this.salario = salario;
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

	
}
