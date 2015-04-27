package com.example.p_011_agenda;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String ID = "id";
	private static final String NOME = "nome";
	private static final String TELEFONE = "telefone";
	private Context context;
	//
	private ListView lv_contatos;
	private SimpleAdapter adapter_HM; // HashMap
	private ArrayList<HashMap<String, String>> lista_HM;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();
		//
		lv_contatos = (ListView) findViewById(R.id.listaContatos);
		//
		gerarProdutos_HM();
		String[] from = { NOME, TELEFONE };
		int[] to = { R.id.row_nome, R.id.row_telefone };
		//
		adapter_HM = new SimpleAdapter(context, lista_HM, R.layout.celula,
				from, to);
		//
		lv_contatos.setAdapter(adapter_HM);

		lv_contatos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				@SuppressWarnings("unchecked")
				HashMap<String, String> hAux = (HashMap<String, String>) parent
						.getItemAtPosition(position);

				Toast.makeText(context, hAux.get(ID), Toast.LENGTH_SHORT)
						.show();
			}
		});

	}

	private void gerarProdutos_HM() {
		lista_HM = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> it = new HashMap<String, String>();
		it.put(ID, "0001");
		it.put(NOME, "Renato");
		it.put(TELEFONE, "3666 0701");
		lista_HM.add(it);
		//
		it = new HashMap<String, String>();
		it.put(ID, "0002");
		it.put(NOME, "Rafaela");
		it.put(TELEFONE, "3528 1630");
		lista_HM.add(it);
		//
		it = new HashMap<String, String>();
		it.put(ID, "0003");
		it.put(NOME, "Pedro");
		it.put(TELEFONE, "3666 0702");
		lista_HM.add(it);
		//
		it = new HashMap<String, String>();
		it.put(ID, "0004");
		it.put(NOME, "Joao");
		it.put(TELEFONE, "3666 0801");
		lista_HM.add(it);
		
	}

}
