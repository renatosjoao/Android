package com.example.a_011_listview_produto_contato;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	private Context context;
	private ListView listView_Contatos;
	private ArrayList<Contato> lista_Contatos;
	private MyAdapter mAdapter = null;
	private final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
	private final java.util.Random rand = new java.util.Random();
	private final Set<String> identifiers = new HashSet<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		context = getBaseContext();

		listView_Contatos = (ListView) findViewById(R.id.lv_contatos);
		geraContatos(100);
		mAdapter = new MyAdapter(context, lista_Contatos);
		listView_Contatos.setAdapter(mAdapter);
	}

	private void geraContatos(int qtd) {
		lista_Contatos = new ArrayList<Contato>();
		for (int i = 0; i < qtd; i++) {

			Contato cAux = new Contato();
			cAux.setIdcontato(Long.parseLong(String.valueOf(i)));
			cAux.setNome(randomIdentifier());
			cAux.setTelefone("3666-0701");
			lista_Contatos.add(cAux);
		}

	}

	public String randomIdentifier() {
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = rand.nextInt(5) + 5;
			for (int i = 0; i < length; i++)
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			if (identifiers.contains(builder.toString()))
				builder = new StringBuilder();
		}
		return builder.toString();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
