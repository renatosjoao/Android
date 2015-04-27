package com.example.a_final_pacientes;

import java.util.ArrayList;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	private Context context;
	private ResponseReceiver receiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		context = getBaseContext();

		Intent msgIntent = new Intent(getBaseContext(), DB_Service.class);
		startService(msgIntent);
		
		IntentFilter filter = new IntentFilter("TEM_DADOS");
		filter.addCategory(Intent.CATEGORY_DEFAULT);
		receiver = new ResponseReceiver();
		registerReceiver(receiver, filter);
		
	}

	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(receiver);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class ResponseReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			mostrarDados();
		}

		private void mostrarDados() {
			PacienteDao pacienteDao = new PacienteDao(context);
			ArrayList<Paciente> retorno = pacienteDao.getPacienteLista_VO();
			Log.d("SISTEMA",  "VINDO DA LISTA" + String.valueOf(retorno.size()));
		}

	}
}
