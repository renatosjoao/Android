package com.example.a_014_multitelas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SegundaTela extends Activity {

	private Context context;
	private TextView _tv_valor;
	private Button _btn_retorna_valor;
	private int resultado;

	public SegundaTela() {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segundatela);

		_tv_valor = (TextView) findViewById(R.id.segundatela_tv_valor);

		Bundle bundle = getIntent().getExtras();
		resultado = Integer.parseInt(bundle.getString(("valor")));

		_tv_valor.setText(String.valueOf(resultado));

		_btn_retorna_valor = (Button) findViewById(R.id.segundatela_btn_retornavalor);
		_btn_retorna_valor.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Bundle bundle = new Bundle();
				bundle.putString("valorprocessado",String.valueOf(resultado+5));
				
				Intent intent = new Intent();
				intent.putExtras(bundle);
				setResult(RESULT_OK,intent);
				finish();
			}
		});
	}
}
