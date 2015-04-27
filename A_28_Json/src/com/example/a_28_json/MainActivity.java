package com.example.a_28_json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.gson.Gson;

public class MainActivity extends Activity {
	private Context context;
	private Button btn_ler;

	private String readLog(int iID) {
		StringBuilder contents = new StringBuilder();
		try {
			InputStream inputStream = context.getResources().openRawResource(
					iID);
			InputStreamReader inputreader = new InputStreamReader(inputStream);
			BufferedReader input = new BufferedReader(inputreader);
			try {
				String line = null;
				while ((line = input.readLine()) != null) {
					contents.append(line);
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return contents.toString();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		context = getBaseContext();

		btn_ler = (Button) findViewById(R.id.btn_ler);
		// try {
		// Contato caux = new Contato();
		// caux.setIdcontato(20);
		// caux.setNome("Impacta");

		// ArrayList<JSONObject> listaContatos = new ArrayList<JSONObject>();
		// listaContatos.add(caux.toJSJsonObject());
		// JSONArray jsArray = new JSONArray(listaContatos);

		// JSONObject transmissao = new JSONObject();

		// transmissao.put("contatos", jsArray);
		// String st = transmissao.toString();

		// ArrayList<Contato> listaContato = new ArrayList<Contato>();
		// listaContato.add(caux);

		// Gson gson = new Gson();

		// Trasm transmissao_Env = new Trasm();
		// Trasm trasmissao_Rec = new Trasm();

		// transmissao_Env.setContatos(listaContato);

		// Trasm transmissao = new Trasm();
		// transmissao.setContatos(listaContato);

		// String st = gson.toJson(transmissao_Env);
		// trasmissao_Rec = gson.fromJson(st, Trasm.class);

		// int i = 10;
		// i = 20;
		// } catch (JSONException e) {
		// e.printStackTrace();
		// }
		btn_ler.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Gson gson = new Gson();
				OrdemLista olista_env = new OrdemLista();
				OrdemLista olista_rec = new OrdemLista();

				olista_rec = gson.fromJson(readLog(R.raw.os_lista),	OrdemLista.class);

				int i = 10;

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
