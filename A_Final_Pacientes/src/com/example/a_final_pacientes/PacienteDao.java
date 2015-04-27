package com.example.a_final_pacientes;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.a_final_library.Dao;

public class PacienteDao extends Dao {

	public PacienteDao(Context context) {
		super(context);
	}

	public ArrayList<Paciente> getPacienteLista_VO() {
		ArrayList<Paciente> pacienteLista = new ArrayList<Paciente>();
		//
		abrirBanco();

		StringBuilder sqlQ = new StringBuilder();
		sqlQ.append("select * from paciente order by nome");

		Cursor cursor = db.rawQuery(sqlQ.toString(), null);

		while (cursor.moveToNext()) {
			Paciente pAux = new Paciente();
			pAux.setCodigo(cursor.getLong(cursor.getColumnIndex("codigo")));
			pAux.setNome(cursor.getString(cursor.getColumnIndex("nome")));
			pacienteLista.add(pAux);
		}

		fecharBanco();
		//
		return pacienteLista;

	}

	public void inserirPacienteLista(ArrayList<Paciente> alPaciente) {
		abrirBanco();
		db.beginTransaction();
		//
		try {
			db.delete("paciente", null, null);

			for (Paciente paciente : alPaciente) {
				db.insert("paciente", null, getContentValue(paciente));
			}

			db.setTransactionSuccessful();
		} finally {
			db.endTransaction();
		}
		//
		fecharBanco();

	}

	private ContentValues getContentValue(Paciente paciente) {
		ContentValues cv = new ContentValues();
		//
		if (paciente.getCodigo() > 0) {
			cv.put("codigo", paciente.getCodigo());

		}

		if (paciente.getNome() != null) {
			cv.put("nome", paciente.getNome());

		}

		//
		return cv;
	}
}
