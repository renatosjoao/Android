package br.curso;

import java.util.ArrayList;
import java.util.Collections;


public class Principal{

	
	
	
public static void main(String[] args) {
	 String texto = "renato stoffalette joao";
	 
	 char[] textoAux = texto.toCharArray();
	 
	 for(int i=0, j=textoAux.length-1; i<textoAux.length /2; i++,j--){
		 char aux = textoAux[i];
		 textoAux[i]= textoAux[j];
		 textoAux[j] = aux; 
	 }
	 
	 System.out.println(textoAux);
}
}
