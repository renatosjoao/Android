package com.example.a_027_dbase;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.a_027_dbase.db.Dao;

public class ContatoDAO extends Dao {

	public void apagarContato(long idcontato) {
		abrirBanco();
		StringBuilder sbWhere = new StringBuilder();
		sbWhere.append("idcontato ='").append(String.valueOf(idcontato))
				.append("'");
		db.delete("contatos", sbWhere.toString(), null);

		fecharBanco();
	}

	public Contato getContatoById(long idcontato) {
		Contato cAux = null;
		abrirBanco();
		StringBuilder str = new StringBuilder();
		str.append("select * from contatos where idcontato ='")
				.append(String.valueOf(idcontato)).append("'");
		Cursor cursor = db.rawQuery(str.toString(), null);
		while (cursor.moveToNext()) {
			cAux = new Contato();
			cAux.setIdContato(cursor.getLong(cursor.getColumnIndex("idcontato")));
			cAux.setNome(cursor.getString(cursor.getColumnIndex("nome")));
			cAux.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
			;
			cAux.setDataNasc(cursor.getString(cursor
					.getColumnIndex("datanascimento")));
			;
		}
		fecharBanco();
		return cAux;
	}

	public void inserirAtualizarContato(Contato contato){
		abrirBanco();
		
		ContentValues cValues = new ContentValues();
		cValues.put("idcontato",contato.getIdContato());
		cValues.put("nome",contato.getNome());
		cValues.put("telefone",contato.getTelefone());
		cValues.put("datanascimento",contato.getDataNasc());
		
		if(db.insert("contatos",null, cValues) == -1){
			StringBuilder sbWhere = new StringBuilder();
			sbWhere.append("idcontato ='").append(String.valueOf(contato.getIdContato())).append("'");
			db.update("contatos",cValues,sbWhere.toString(),null);			
		}
		
		fecharBanco();
		
		
	}
	
	public long proximoIdContato() {
		long proxID = 0;
		abrirBanco();
		StringBuilder sb = new StringBuilder();
		sb.append("select max(idcontato)+1 as id from contatos");
		Cursor cursor = db.rawQuery(sb.toString(), null);
		while (cursor.moveToNext()) {
			proxID = cursor.getLong(cursor.getColumnIndex("id"));
		}
		if (proxID == 0) {
			proxID = 1;
		}
		fecharBanco();
		return proxID;
	}

	public ContatoDAO(Context context) {
		super(context);
	}

	public ArrayList<HashMap<String, String>> listaContatos_HM() {
		ArrayList<HashMap<String, String>> lContatos = new ArrayList<HashMap<String, String>>();

		abrirBanco();

		StringBuilder sb = new StringBuilder();
		sb.append("select * from contatos order by idcontato;");

		Cursor cursor = db.rawQuery(sb.toString(), null);
		while (cursor.moveToNext()) {
			HashMap<String, String> row = new HashMap<String, String>();
			row.put("idcontato", String.valueOf(cursor.getString(cursor
					.getColumnIndex("idcontato"))));
			row.put("nome", String.valueOf(cursor.getString(cursor
					.getColumnIndex("nome"))));
			lContatos.add(row);
		}

		fecharBanco();

		return lContatos;
	}

}
