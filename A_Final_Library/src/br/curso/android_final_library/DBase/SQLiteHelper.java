package br.curso.android_final_library.DBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

	public SQLiteHelper(Context context, String nomeBanco, int versao) {
		super(context, nomeBanco, null, versao);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		createDB(db);
	}

	private void createDB(SQLiteDatabase db) {
		try {
			db.execSQL("CREATE TABLE [paciente] ([codigo] INT NOT NULL, [nome] [NVARCHAR(50)] NOT NULL, CONSTRAINT [] PRIMARY KEY ([codigo]));");
		} catch (Exception e) {

		} finally {

		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists paciente ");
		onCreate(db);
	}

}
