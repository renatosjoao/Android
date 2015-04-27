/**
 *  
 * 07/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class Util {

	public static void mostrarMensagem(String msg){
		System.out.println(msg);
	}
	
	public static void mostrarMensagem(Terceirizado ter){
		System.out.println("------------------------------");
		System.out.println("Nome : " +ter.getNome());
		System.out.println("Sobrenome : " +ter.getSobrenome());
		System.out.println("Cargo : " +ter.getCargo());
		System.out.println("Salario : "+ter.getSalario());
		System.out.println("Empresa : "+ter.getNomeEmpresa());
		System.out.println("------------------------------");
	}
}
