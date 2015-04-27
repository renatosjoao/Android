package br.curso.android_final_pacientes;

import java.util.ArrayList;

import br.curso.android_final_library.DBase.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class PacienteDao extends Dao {

	public PacienteDao(Context context) {
		super(context);
	}

	public ArrayList<Paciente> getPacienteLista_VO() {
		ArrayList<Paciente> pacienteLista = new ArrayList<Paciente>();
		abrirBanco();
		//
		StringBuilder sqlQ = new StringBuilder();

		sqlQ.append("select * from paciente order by nome");

		Cursor cursor = db.rawQuery(sqlQ.toString(), null);

		while (cursor.moveToNext()) {
			Paciente pAux = new Paciente();
			//
			pAux.setCodigo(cursor.getLong(cursor.getColumnIndex("codigo")));
			pAux.setNome(cursor.getString(cursor.getColumnIndex("nome")));
			//
			pacienteLista.add(pAux);
		}
		//
		fechar();
		return pacienteLista;
	}

	public void inserirPacienteLista(ArrayList<Paciente> alPaciente) {
		abrirBanco();
		db.beginTransaction();

		try {
			db.delete("paciente", null, null);

			for (Paciente paciente : alPaciente) {
				db.insert("paciente", null, getContentValues(paciente));
			}
			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}

		fechar();
	}

	private ContentValues getContentValues(Paciente paciente) {
		ContentValues contentValues = new ContentValues();

		if (paciente.getCodigo() > 0) {
			contentValues.put("codigo", paciente.getCodigo());
		}
		if (paciente.getNome() != null) {
			contentValues.put("nome", paciente.getNome());
		}

		return contentValues;
	}

}
