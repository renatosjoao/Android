/**
 *  
 * 07/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int repeticoes = 12;
		int indice = 0;
		
		while(indice < repeticoes) {
			System.out.println(indice);
			indice++;
		}
		
		System.out.println("--------------------");
		
		indice = 0;
		
		do {
			System.out.println(indice);
			indice++;
		}while(indice < repeticoes);
	
	}

}
