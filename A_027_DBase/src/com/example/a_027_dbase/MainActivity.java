package com.example.a_027_dbase;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private Context contexto;
	private ListView lv_contatos;
	private ArrayList<HashMap<String, String>> fonteDados;
	private SimpleAdapter adapter;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.telainicial_menu_cadastrar_CNovoContato:
			Intent intent = new Intent(contexto, SegundaTela.class);
			intent.putExtra("idcontato", "0");
			startActivity(intent);
			finish();
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		contexto = getBaseContext();

		lv_contatos = (ListView) findViewById(R.id.telainicial_lv_contatos);

		ContatoDAO contatoDao = new ContatoDAO(contexto);

		fonteDados = contatoDao.listaContatos_HM();

		String[] from = { "idcontato", "nome" };
		int[] to = { R.id.row_tv_codigo, R.id.row_tv_nome };

		adapter = new SimpleAdapter(contexto, fonteDados, R.layout.row, from,
				to);
		//
		lv_contatos.setAdapter(adapter);

		lv_contatos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				HashMap<String, String> row = (HashMap<String, String>) parent
						.getItemAtPosition(position);
				Intent intent = new Intent(contexto, SegundaTela.class);
				intent.putExtra("idcontato", row.get("idcontato"));
				startActivity(intent);
				finish();

			}
		});

	}
}
