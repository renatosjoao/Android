package com.example.a_28_json;

import java.util.ArrayList;

public class OrdemLista {

	private ArrayList<OrdemServico> os_lista;
	
	public OrdemLista() {
		
	}

	public OrdemLista(ArrayList<OrdemServico> lista_os) {
		this.os_lista = lista_os;
	}

	public ArrayList<OrdemServico> getLista_os() {
		return os_lista;
	}

	public void setLista_os(ArrayList<OrdemServico> lista_os) {
		this.os_lista = lista_os;
	}

	
	
}
