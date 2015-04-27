package com.example.p_011_produto;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context context;
	ListView lView;
	ArrayList<Produto> lista_Produto;
	ArrayAdapter<Produto> adapter_Produto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();

		lView = (ListView) findViewById(R.id.lView);
		geraListaProduto(15);
		adapter_Produto = new ArrayAdapter<Produto>(context,
				android.R.layout.simple_list_item_1, lista_Produto);
		lView.setAdapter(adapter_Produto);

		lView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Produto pAux = (Produto) parent.getItemAtPosition(position);
				long idCod = pAux.getIdCodigo();
				Toast.makeText(context, String.valueOf(idCod),
						Toast.LENGTH_SHORT).show();

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void geraListaProduto(int numProd) {
		lista_Produto = new ArrayList<Produto>();
		for (int i = 1; i <= numProd; i++) {
			Produto pAux = new Produto();
			pAux.setIdCodigo(Long.parseLong((String.valueOf(i))));
			pAux.setNome("Produto - " + String.valueOf(i));
			lista_Produto.add(pAux);
		}

	}

}
