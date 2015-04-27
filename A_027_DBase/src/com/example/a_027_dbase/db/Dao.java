package com.example.a_027_dbase.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Dao {

	private Context context;
	protected SQLiteDatabase db;
	
	

	public Dao(Context context) {
		this.context = context;
		
	}

	public void abrirBanco() {
		SQLHelper sqlHelper_var = new SQLHelper(context, Constantes.BANCO, Constantes.BANCO_VERSAO);
		this.db = sqlHelper_var.getWritableDatabase();
		
	}
	
	public void fecharBanco(){
		if (this.db!=null) {
			this.db.close();
	}
	}
}
