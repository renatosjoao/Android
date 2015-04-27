package com.example.a_0012;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a_0012.Adapter_001.Adapter_001_Acao;

public class MainActivity extends Activity {

	Context context;
	ArrayList<Contatos> lista_Contatos;
	ListView lv_contatos;
	Adapter_001 adp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();
		lv_contatos = (ListView) findViewById(R.id.listView1);
		gerarContatos(100);
		adp = new Adapter_001(context, lista_Contatos);
		adp.setOnDelegateClickListener(new Adapter_001_Acao() {
			@Override
			public void adp_AcaoBotao(long idContato) {
				Toast.makeText(context, "Vindo da Interface - "+String.valueOf(idContato), Toast.LENGTH_SHORT).show();
			}
		});
		lv_contatos.setAdapter(adp);
		lv_contatos.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
				Contatos cAux = (Contatos) parent.getItemAtPosition(position);
				Toast.makeText(context, "Vindo da Lista - "+String.valueOf(cAux.getIdContato()), Toast.LENGTH_SHORT).show();
			}
		});
		
		
		

	}

	private void gerarContatos(int qtde) {
		lista_Contatos = new ArrayList<Contatos>();

		for (int i = 0; i < qtde; i++) {
			Contatos cAux = new Contatos(Long.parseLong(String.valueOf(i + 1)),
					"Nome - " + String.valueOf(i + 1), "Telefone - "
							+ String.valueOf(i + 1));
			lista_Contatos.add(cAux);
		}

	}

}
