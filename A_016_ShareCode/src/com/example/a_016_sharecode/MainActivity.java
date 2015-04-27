package com.example.a_016_sharecode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView tv_resultado;
	Button obter_resultado;
	Context contexto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		contexto = getBaseContext();
		obter_resultado = (Button) findViewById(R.id.btn_obter_soma);
		tv_resultado = (TextView) findViewById(R.id.tv_resultado);
		
		
		obter_resultado.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent("SOMA_DO_RENATO");
				intent.putExtra("x", 10.5f);
				intent.putExtra("y", 15.6f);

				if (intent.resolveActivity(getPackageManager()) != null) {
					startActivityForResult(intent, 10);
				} else {
					Toast.makeText(contexto, "Erro: Recurso Indisponivel",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			float res = data.getFloatExtra("resultado", 0);
			tv_resultado.setText(String.valueOf(res));
		}else{
			tv_resultado.setText("Resultado cancelado");
		}
	}

}
