/**
 * 
 * 06/05/2014
 * @author Renato Stoffalette Joao
 */
package br.curso;

public class Principal {

	
	public static void main(String[] args) {
		byte b = 100;
		
		short s = 0100; //octal armazenado em short
		
		int oct = 010;
		int hexa = 0x10;
		int bin = 0b10; 
		
		long l = 953336500L;
		
		float f = 56.0f;
		
		double d = 0.5;
		
		char c = '\u0072';
		
		boolean boo = true;
		
		System.out.println(b);
		System.out.println(s);
		System.out.println(oct);
		System.out.println(hexa);
		System.out.println(bin);
		System.out.println(l);
		System.out.println(d);
		System.out.println(c);
		System.out.println(boo);
		
	
	}
}
