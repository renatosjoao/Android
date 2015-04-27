package br.curso.a_011_listview_produto_hashmap;

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

	private Context context;
	//
	private ListView lv_produtos;
	private SimpleAdapter adapter_HM; // HashMap
	private ArrayList<HashMap<String, String>> lista_HM;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		lv_produtos = (ListView) findViewById(R.id.lv_produtos);
		//
		gerarProdutos_HM(100);
		String[] from = { ID, NOME };
		int[] to = { R.id.row_esp_tv_codigo, R.id.row_esp_tv_nome };
		//
		adapter_HM = new SimpleAdapter(context, lista_HM, R.layout.row_esp,
				from, to);
		//
		lv_produtos.setAdapter(adapter_HM);
		lv_produtos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				@SuppressWarnings("unchecked")
				HashMap<String, String> iAux = (HashMap<String, String>) parent
						.getItemAtPosition(position);

				Toast.makeText(context, iAux.get(ID), Toast.LENGTH_SHORT)
						.show();

			}
		});
	}

	private void gerarProdutos_HM(int quantidade) {
		lista_HM = new ArrayList<HashMap<String, String>>();
		//
		for (int i = 0; i < quantidade; i++) {
			HashMap<String, String> item = new HashMap<String, String>();
			item.put(ID, String.valueOf(i + 1));
			item.put(NOME, "Produto -" + String.valueOf(i + 1));
			lista_HM.add(item);
		}

	}

}
