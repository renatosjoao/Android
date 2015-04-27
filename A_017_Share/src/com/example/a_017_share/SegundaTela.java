package com.example.a_017_share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SegundaTela extends Activity {

	private Button btn_retorna_soma;
	private float resultado;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segundatela);
		//
		btn_retorna_soma = (Button) findViewById(R.id.segundatela_btn_retorna_soma);
		//
		Intent intent = getIntent();
		float x = intent.getFloatExtra("x", (float) 0.0);
		float y = intent.getFloatExtra("y", (float) 0.0);

		resultado = x + y;

		btn_retorna_soma.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mIntent = new Intent();
				mIntent.putExtra("resultado", resultado);
				setResult(RESULT_OK, mIntent);
				finish();
			}
		});
	}
};
