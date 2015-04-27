package com.example.a_011_listview_hm_customadapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	private Context context;
	private ListView lv_produtos;
	private Adapter_001 adp;
	private ArrayList<HashMap<String, String>> lista_Produtos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();
		lv_produtos = (ListView) findViewById(R.id.lv_produtos);
		gerarProdutos(1000);
		adp = new Adapter_001(context, lista_Produtos);
		lv_produtos.setAdapter(adp);
	}

	private void gerarProdutos(int qtde) {
		lista_Produtos = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < qtde; i++) {
			HashMap<String, String> item = new HashMap<String, String>();
			item.put(Constantes.ID, String.valueOf(i + 1));
			item.put(Constantes.DESCRICAO, "Produto - " + String.valueOf(i + 1));
			lista_Produtos.add(item);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
