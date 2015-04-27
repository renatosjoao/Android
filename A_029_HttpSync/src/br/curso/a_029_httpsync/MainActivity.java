package br.curso.a_029_httpsync;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

public class MainActivity extends Activity {

	private Context context;
	private String resultado;
	private ListView lv_contatos;
	private ArrayList<Contato> contatos = new ArrayList<Contato>();
	private ArrayList<Contato> contatosRetorno = new ArrayList<Contato>();

	private String url1 = "http://www.nmsystems.com.br/testecarga.php";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();
		lv_contatos = (ListView) findViewById(R.id.lv_contatos);

		Thread thread = null;
		try {
			thread = new Thread() {
				@Override
				public void run() {
					gerarContatos(100);

					Dados_Env dados_Env = new Dados_Env();
					dados_Env.setContatos(contatos);

					Gson gson = new Gson();
					Dados_Rec dados_Rec = gson.fromJson(ComDados.getInputStringFromURL(url1,gson.toJson(dados_Env).toString()),Dados_Rec.class);

					resultado = "";
					contatosRetorno = dados_Rec.getContatos();
				//	for (int i = 0; i < contatosRetorno.size(); i++) {
				//		resultado += "Id: "	+ String.valueOf(contatosRetorno.get(i).getIdcontato()+ "Nome: "
				//						+ contatosRetorno.get(i).getNome()
				//						+ "/");
				//	}
					Log.d("HTTP", resultado);
					runOnUiThread(new Runnable() {

						@Override
						public void run() {
							lv_contatos.setAdapter(new ArrayAdapter<Contato>(context,android.R.layout.simple_list_item_1,contatosRetorno));
						}
					});
				}
			};
		} catch (Exception e) {
			Log.d("HTTP", e.toString());
		}
		thread.start();
	}

	protected void gerarContatos(int numero) {
		for (int i = 0; i < numero; i++) {
			Contato cAux = new Contato();
			cAux.setIdcontato(i + 1);
			cAux.setNome("Contato (" + String.valueOf(i + 1) + ")");
			contatos.add(cAux);
		}
	}
}
