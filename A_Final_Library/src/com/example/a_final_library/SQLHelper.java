package com.example.a_final_library;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper{


	public SQLHelper(Context context, String nomeBanco, int versaoBanco) {
		super(context, nomeBanco, null, versaoBanco);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Existe no mundo Real
		createDB(db);
		
	}

	private void createDB(SQLiteDatabase db) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("CREATE TABLE IF NOT EXISTS [paciente] (   [codigo] BIGINT NOT NULL, [nome] NVARCHAR(50) NOT NULL, CONSTRAINT [] PRIMARY KEY ([codigo]));");
			db.execSQL(sb.toString().toLowerCase());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists paciente");
		onCreate(db);
	}


	
}
