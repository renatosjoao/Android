package br.curso.android_final_pacientes;

import java.util.ArrayList;

import br.com.impacta.final_pacientes.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	Context context;
	ResponseReceiver receiver;

	ListView lv_pacientes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		lv_pacientes = (ListView) findViewById(R.id.telainicial_lv_pacientes);
		//
		Intent msgIntent = new Intent(context, DB_Service.class);
		startService(msgIntent);
		//
		IntentFilter filter = new IntentFilter("TEM_DADOS");
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		receiver = new ResponseReceiver();
		registerReceiver(receiver, filter);
	}

	public class ResponseReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			mostraDados();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//
		unregisterReceiver(receiver);
	}

	private void mostraDados() {
		PacienteDao pacienteDao = new PacienteDao(context);
		ArrayList<Paciente> pacientes = pacienteDao.getPacienteLista_VO();
		//
		Log.d("SISTEMA", "Total: " + String.valueOf(pacientes.size()));
	}

}
