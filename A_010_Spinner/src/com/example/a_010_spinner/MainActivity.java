package com.example.a_010_spinner;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context context;
	
	Spinner sp_valor;
	ArrayList<String> lista_Valor;
	ArrayAdapter<String> adapter_Valor;

	Spinner sp_produto;
	ArrayList<Produto> lista_Produto;
	ArrayAdapter<Produto> adapter_Produto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();

		sp_valor = (Spinner) findViewById(R.id.sp_valor);
		lista_Valor = new ArrayList<String>();
		lista_Valor.add("--");
		lista_Valor.add("Impacta");
		lista_Valor.add("Lápis");
		lista_Valor.add("Android");
		lista_Valor.add("iOS");
		lista_Valor.add("Windows Phone");

		adapter_Valor = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item, lista_Valor);
		adapter_Valor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_valor.setAdapter(adapter_Valor);
		sp_valor.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// String st = (String) parent.getItemAtPosition(position);
				String st = (String) parent.getSelectedItem();
				if (st.trim().equalsIgnoreCase("--")) {
				} else {
					Toast.makeText(context, st, Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

		//sp_valor.setSelection(getIndexValor(sp_valor, "Lápis"));


		sp_produto = (Spinner) findViewById(R.id.sp_produto);
		gerarProdutos(10);
		adapter_Produto = new ArrayAdapter<Produto>(context,android.R.layout.simple_spinner_item, lista_Produto);
		adapter_Produto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp_produto.setAdapter(adapter_Produto);
		sp_produto.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
				Produto paux = (Produto) parent.getSelectedItem();
				Toast.makeText(context, String.valueOf(position) + " - " + paux.getIdProduto(), Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});
		sp_produto.setSelection(getIndexProduto(sp_produto, "5"));
	}
	

	private void gerarProdutos(int qtde) {
		lista_Produto = new ArrayList<Produto>();
		for (int i = 0; i < qtde; i++) {
			Produto pAux = new Produto();
			pAux.setIdProduto(String.valueOf(i + 1));
			pAux.setNome("Produto - " + String.valueOf(i + 1));
			lista_Produto.add(pAux);
		}

	}
	
	
	private int getIndexProduto(Spinner spinner, String j) {
		int index = 0;
		for (int i = 0; i < spinner.getCount(); i++) {
			Produto pAux = (Produto) spinner.getItemAtPosition(i);			
			
			if (pAux.getIdProduto().equalsIgnoreCase(j)) {
				index = i;
				break;
			}
		}
		return index;
	}

	private int getIndexValor(Spinner spinner, String valor) {
		int index = 0;
		for (int i = 0; i < spinner.getCount(); i++) {
			String sValor = (String) spinner.getItemAtPosition(i);
			if (sValor.trim().equalsIgnoreCase(valor)) {
				index = i;
				break;
			}
		}
		return index;
	}

};
