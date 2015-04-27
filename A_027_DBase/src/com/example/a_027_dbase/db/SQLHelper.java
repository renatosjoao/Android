package com.example.a_027_dbase.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

	public SQLHelper(Context context, String nomeBanco, int versaoBanco) {
		super(context, nomeBanco, null, versaoBanco);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		createDB(db);
		populateDB(db);

	}

	private void populateDB(SQLiteDatabase db) {
		ContentValues cv = new ContentValues();
		try {
			cv.put("idcontato", 1);
			cv.put("nome", "N. Hugo");
			cv.put("telefone", "(0xx11) 97123-6474");
			cv.put("datanascimento", "18-03-1968");
			db.insert("contatos", null, cv);
			cv.clear();
			//
			cv.put("idcontato", 3);
			cv.put("nome", "Renato");
			cv.put("telefone", "(0xx11) 99999-9999");
			cv.put("datanascimento", "19878-09-15");
			db.insert("contatos", null, cv);

			//
			cv.put("idcontato", 2);
			cv.put("nome", "Jorge");
			cv.put("telefone", "(0xx11) 99999-9999");
			cv.put("datanascimento", "19878-09-15");
			db.insert("contatos", null, cv);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createDB(SQLiteDatabase db) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("CREATE TABLE IF NOT EXISTS[contatos] ([idcontato] BIGINT NOT NULL, [nome] VARCHAR(50) NOT NULL,  [telefone] VARCHAR(20), [datanascimento] DATETIME NOT NULL,  CONSTRAINT [] PRIMARY KEY ([idcontato]));");
			db.execSQL(sb.toString().toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists contatos");
		onCreate(db);
	}

}
