package br.curso;

import java.util.ArrayList;
import java.util.Collections;


public class Principal{

	
	
	
	public static void main(String[] args) {
		ArrayList<Produto> listaProdutos = new ArrayList<>();
		for(int i=0; i<100; i++){
			Produto pAux = new Produto();
			pAux.setId(i+1);
			pAux.setNome("Produto - "+String.valueOf(i+1));
			
			listaProdutos.add(pAux);
			
		}
		
		for(int i=0; i<100; i++){
			Produto pAux = listaProdutos.get(i);
			//System.out.println("-----------");
			//System.out.println("ID :" +pAux.getId());
			//System.out.println(pAux.getNome());
		}
		
		
		ArrayList<Produto> listaProdutos2 = new ArrayList<>();
		Produto p1 = new Produto(10,  "Wladimir");
		Produto p2 = new Produto(1,  "Carla");
		Produto p3 = new Produto(8,  "Almir");
		
		listaProdutos2.add(p1);
		listaProdutos2.add(p2);
		listaProdutos2.add(p3);
		
		Collections.sort(listaProdutos2);
		
		for (Produto p : listaProdutos2){
			System.out.println(p.getNome());
		}
		
	}

}
