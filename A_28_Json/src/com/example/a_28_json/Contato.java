package com.example.a_28_json;

import org.json.JSONObject;

public class Contato {

	private int idcontato;
	private String nome;

	public Contato() {
	}

	public int getIdcontato() {
		return idcontato;
	}

	public void setIdcontato(int idcontato) {
		this.idcontato = idcontato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Contato(int idcontato, String nome) {
		this.idcontato = idcontato;
		this.nome = nome;
	}

	public JSONObject toJSJsonObject() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("idcontato",getIdcontato());
			jsonObject.put("nome",getNome());
			return jsonObject;
		} catch (Exception e) {
			return null;
		}
	}

}
