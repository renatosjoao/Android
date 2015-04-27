package com.example.a_011_listview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context context;
	ListView lv_valor;
	ArrayList<String> listaDados;
	ArrayAdapter<String> adapterDados;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();

		lv_valor = (ListView) findViewById(R.id.lv_valor);

		listaDados = new ArrayList<String>();
		listaDados.add("Hugo");
		listaDados.add("Pedro");
		listaDados.add("Carlos");
		listaDados.add("Joaquim");
		listaDados.add("Pereira");
		listaDados.add("Maria");
		listaDados.add("Joaquina");
		listaDados.add("Roberta");
		listaDados.add("Marcinha");
		listaDados.add("Perez");
		listaDados.add("Hugo");
		listaDados.add("Pedro");
		listaDados.add("Carlos");
		listaDados.add("Joaquim");
		listaDados.add("Pereira");

		adapterDados = new ArrayAdapter<String>(context,
				android.R.layout.simple_list_item_multiple_choice, listaDados);

		lv_valor.setAdapter(adapterDados);

		lv_valor.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String st = (String) listaDados.get(position);

				
				Toast.makeText(context, String.valueOf(listaDados.size()), Toast.LENGTH_SHORT).show();

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
