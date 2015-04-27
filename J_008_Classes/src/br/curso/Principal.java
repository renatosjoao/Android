/**
 *  
 * 07/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class Principal {

	public static void main(String[] args) {
	Funcionario func = new Funcionario("Renato", "S. Joao","Diretor",50000.00f);
	func.setCargo("CEO");
	
	System.out.println("------------------------------");
	System.out.println("Nome : " +func.getNome());
	System.out.println("Sobrenome : " +func.getSobrenome());
	System.out.println("Cargo : " +func.getCargo());
	System.out.println("Salario : "+func.getSalario());
	System.out.println("------------------------------");
	
	Terceirizado ter = new Terceirizado("Renato", "S. Joao","Diretor",50000.00f, "IBM");
	
	System.out.println("------------------------------");
	System.out.println("Nome : " +ter.getNome());
	System.out.println("Sobrenome : " +ter.getSobrenome());
	System.out.println("Cargo : " +ter.getCargo());
	System.out.println("Salario : "+ter.getSalario());
	System.out.println("Empresa : "+ter.getNomeEmpresa());
	System.out.println("------------------------------");
	
	ter.multiplicarSalario(5);
	
	Util.mostrarMensagem("Nome : "+ter.getNome());
	Util.mostrarMensagem(ter);
	
	
	
	
	}

}
