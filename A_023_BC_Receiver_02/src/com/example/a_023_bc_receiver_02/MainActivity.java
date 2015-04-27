package com.example.a_023_bc_receiver_02;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;
	private ResponseReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = getBaseContext();

		IntentFilter iFilter = new IntentFilter("EXECUTAR_PROCESSO");
		iFilter.addCategory(Intent.CATEGORY_DEFAULT);

		receiver = new ResponseReceiver();
		registerReceiver(receiver, iFilter);

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

	public class ResponseReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			Toast.makeText(context, "Receiver no codigo", Toast.LENGTH_SHORT)
					.show();
		}

	}
}
