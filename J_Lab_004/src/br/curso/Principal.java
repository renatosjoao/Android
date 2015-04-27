/**
 *  
 * 07/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class Principal {

	public static void main(String[] args) {
		String mes = "MARÇO";
		switch(mes) {
			case "JANEIRO":
				System.out.println(" 31 dias");
				break;
			case "FEVEREIRO":
				System.out.println(" 29 dias");
				break;
			case "MARÇO":
				System.out.println(" 31 dias");
				break;
			case "ABRIL":
				System.out.println(" 30 dias");
				break;
			case "MAIO":
				System.out.println(" 31 dias");
				break;
			case "JUNHO":
				System.out.println(" 30 dias");
				break;
			case "JULHO":
				System.out.println(" 31 dias");
				break;
			case "AGOSTO":
				System.out.println(" 31 dias");
				break;
			case "SETEMBRO":
				System.out.println(" 30 dias");
				break;
			case "OUTUBRO":
				System.out.println(" 31 dias");
				break;
			case "NOVEMBRO":
				System.out.println(" 30 dias");
				break;
			case "DEZEMBRO":
				System.out.println(" 31 dias");
				break;
			default: 
				break;
		}
		}
}
