/**
 *  
 * 06/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int valor = 100;
		
		if(valor < 200){ 
			//System.out.println("Menor");
		}else{
			//System.out.println("Maior");
		}
		
		
		//
		System.out.println("---------------");
		int valor2 = 50;
		
		switch (valor2) {
		case 50:
			System.out.println("50");
			//break;
		case 30:
			System.out.println("30");
			break;
		case 60:
			System.out.println("60");	
		default:
			System.out.println("Valor fora do padrão : " + valor2);
			break;
		}
	}
}
