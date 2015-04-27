package com.example.a_28_json;

import java.util.ArrayList;


public class OrdemServico {

	private int id_os;
	private float valorpedido;
	private ArrayList<Ocorrencia> ocorrencias;
	
	public OrdemServico() {
	}

	
	public int getIdOs() {
		return id_os;
	}


	public void setIdOs(int idOs) {
		this.id_os = idOs;
	}


	public float getValorpedido() {
		return valorpedido;
	}


	public void setValorpedido(float valorpedido) {
		this.valorpedido = valorpedido;
	}


	public ArrayList<Ocorrencia> getLista_ocorrencias() {
		return ocorrencias;
	}


	public void setLista_ocorrencias(ArrayList<Ocorrencia> lista_ocorrencias) {
		this.ocorrencias = lista_ocorrencias;
	}


	public OrdemServico(int idOs, float valorpedido,ArrayList<Ocorrencia> lista_ocorrencias) {
		this.id_os = idOs;
		this.valorpedido = valorpedido;
		this.ocorrencias = lista_ocorrencias;
	}

	

	

}
