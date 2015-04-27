package com.example.a_28_json;

public class Ocorrencia {

	private String descricao;
	private int status;
	
	
	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Ocorrencia(String descricao, int status) {
		this.descricao = descricao;
		this.status = status;
	}


	public Ocorrencia() {
	}

	

}
