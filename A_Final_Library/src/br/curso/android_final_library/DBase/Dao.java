package br.curso.android_final_library.DBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

public class Dao {
	private static final String BANCO = Environment
			.getExternalStorageDirectory().getPath() + "/PacientesDBase.db3";
	private static final int BANCO_VERSAO = 1;

	private Context context;
	protected SQLiteDatabase db;

	public Dao(Context context) {
		this.context = context;
	}

	public void abrirBanco() {
		SQLiteHelper SQLiteHelper_Var = new SQLiteHelper(context, BANCO,
				BANCO_VERSAO);

		this.db = SQLiteHelper_Var.getWritableDatabase();
	}

	public void fechar() {
		if (this.db != null) {
			this.db.close();
		}
	}
}
