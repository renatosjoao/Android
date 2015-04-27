/**
 *  
 * 07/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

	private static Scanner in;

	public boolean verificaPrimo(int num){
		int divisoes = 0;
		for(int i=1; i <= num; i++){
			if (num % i == 0 ){
				divisoes++;
			}
		}
		if (divisoes == 2){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.print("Insira um numero para verificação = ");
		in = new Scanner(System.in);
		int numero = in.nextInt();
		switch(numero){
			case 0:
				System.out.println(" Zero (0) não é um número primo ");
				break;
			case 1:
				System.out.println(" Um (1) não é um número primo. ");
				break;
			default:
				Principal p1 = new Principal();
				boolean res = p1.verificaPrimo(numero);
				if (!  res){
					System.out.println(numero+ " não é um número primo");
				}else{
					System.out.println(numero+ " é um número primo");
				}
				break;
		}
		
	}

}
