package com.example.a_019_thread;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Context context;
	private TextView tv_valor;
	private Button btn_parar;

	private boolean flagParar = false;
	private int iIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();

		tv_valor = (TextView) findViewById(R.id.tv_valor);

		btn_parar = (Button) findViewById(R.id.btn_parar);

		btn_parar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				flagParar = !flagParar;

			}
		});

		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					while (!flagParar && iIndex < 100) {
						sleep(100);
						iIndex++;
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								tv_valor.setText(String.valueOf(iIndex));								
							}
						});

					}
				} catch (Exception e) {
				}

			}
		};

		t1.start();
	}

}
