package com.example.a_020_asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_valor;
	private Button btn_test;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		tv_valor = (TextView) findViewById(R.id.tv_valor);
		btn_test = (Button) findViewById(R.id.btn_teste);

		btn_test.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new recebeTask().execute();
			}
		});
	}

	private class recebeTask extends AsyncTask<Void, Integer, Void> {

		int index = 0;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			tv_valor.setText("Iniciando ...");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			btn_test.setEnabled(false);
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				while (index < 50) {
					index++;
					Thread.sleep(100);
					publishProgress(index);
				}
			} catch (Exception e) {
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values[0]);
			tv_valor.setText(String.valueOf(values[0]));
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			tv_valor.setText("Fim");
			btn_test.setEnabled(true);
		}

	}

}
