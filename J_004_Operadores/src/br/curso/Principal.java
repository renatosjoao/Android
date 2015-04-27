/**
 * 
 * 06/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class Principal {

	public static void main(String[] args) {
		//Resto da divisão
		System.out.println(5 % 3);
		
		//Operadores Incrementais
		int x = 4;
		// x = x + 1;
		// x += 1;
		// x++;
		// System.out.println(x);
		System.out.println(x++);
		System.out.println(++x);
		System.out.println(x--);
		System.out.println(--x);
		
		
		int a=20, b=30, c=1, d=20;
		String aa = "20";
		//Operadores Relacionais
		System.out.println(b < a);
		System.out.println(a == d);
		System.out.println(c > d);
		System.out.println(a != d);
		System.out.println(a <= d);
		System.out.println(c >= b);
		
		//Operadores Logicos
		System.out.println((a<b) && (a==d));
		System.out.println((a<b) || (a!=d));
		System.out.println(!(a<b));
		
		//Operador Ternário
		System.out.println(a+b > b-a ? "Sim" : "Não");
		
		System.out.println(String.valueOf(aa));
	}

}
