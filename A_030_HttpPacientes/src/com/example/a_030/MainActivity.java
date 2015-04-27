package com.example.a_030;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends Activity {
	private Context context;
	// private String resultado;
	// private String senha;
	private ListView lv_pacientes;
	// private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	private ArrayList<Paciente> pacientesRetorno = new ArrayList<Paciente>();

	private String url1 = "http://www.nmsystems.com.br/testecargapaciente.php";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();
		lv_pacientes = (ListView) findViewById(R.id.lv_pacientes);

		lv_pacientes.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				Paciente pAux = null;
				pAux = (Paciente) parent.getItemAtPosition(position);
				Toast.makeText(context, "Código: "+pAux.getCodigo() + "\n" + "Idade: "+pAux.getIdade() + "\n" + "Peso: "+pAux.getPeso(), Toast.LENGTH_SHORT).show();
			}
			
		});

		Thread thread = new Thread() {

			@Override
			public void run() {
				// String params = null;
				Dados_Env dados_env = new Dados_Env();
				dados_env.setUser("Hugo");
				dados_env.setPwd(Util.md5("teste"));
				dados_env.setPacientes(5);

				Gson gson = new Gson();
				// Log.d("http", "http");
				// Log.d("HTTP", gson.toJson(dados_env).toString());
				// Comunicacao.getInputStringFromURL(url1,
				// gson.toJson(dados_env).toString());
				Log.d("HTTP",
						Comunicacao.getInputStringFromURL(url1,
								gson.toJson(dados_env).toString()));
				String stResults = Comunicacao.getInputStringFromURL(url1, gson
						.toJson(dados_env).toString());
				String[] listaResults = stResults.split("#WSTAG#");
				if (listaResults.length > 1) {
					if (listaResults[0].equalsIgnoreCase("0")) {
						Dados_Rec dados_Rec = gson.fromJson(listaResults[1],
								Dados_Rec.class);
						pacientesRetorno = dados_Rec.getPacientes();

						runOnUiThread(new Runnable() {

							@Override
							public void run() {
								lv_pacientes
										.setAdapter(new ArrayAdapter<Paciente>(
												context,
												android.R.layout.simple_list_item_1,
												pacientesRetorno));
							}
						});
					} else {
						Log.d("HTTP", "Erro : " + listaResults[1]);
					}
				} else {
					Log.d("HTTP", "Erro : " + listaResults[0]);
				}
				// senha = Util.md5(s);
				// enviar -->
				// user
				// pwd(md5)
				// pacientes(num)
			}
		};

		thread.start();
		System.out.println("1");

	}

}
