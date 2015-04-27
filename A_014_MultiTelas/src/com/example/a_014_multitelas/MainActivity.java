package com.example.a_014_multitelas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Context context;
	private Button _btn_chamast1;
	private Button _btn_chamast2;
	private Button _btn_telefone;
	private TextView _tv_resultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		_tv_resultado = (TextView) findViewById(R.id.telainicial_tv_resultado);
		_btn_chamast1 = (Button) findViewById(R.id.telainicial_btn_chamast1);
		//
		_btn_chamast1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, SegundaTela.class);
				Bundle bundle = new Bundle();
				bundle.putString("valor", "10");
				intent.putExtras(bundle);
				startActivity(intent);
				finish();
			}
		});

		_btn_chamast2 = (Button) findViewById(R.id.telainicial_btn_chamast2);
		_btn_chamast2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, SegundaTela.class);
				Bundle bundle = new Bundle();
				bundle.putString("valor", "10");
				intent.putExtras(bundle);
				startActivityForResult(intent, 1);
			}
		});

		_btn_telefone = (Button) findViewById(R.id.telainicial_btn_telefone);
		_btn_telefone.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String sNumero = "99432-2797";
				//String sNumero = "98281-9495";
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:"+sNumero));
				startActivity(intent);
				
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				Bundle bundle = data.getExtras();
				String resultado_final = bundle.getString("valorprocessado");
				_tv_resultado.setText("Valor processad : " + resultado_final);
			} else if (resultCode == RESULT_CANCELED) {
				_tv_resultado.setText("Valor processado : cancelado");
			}

			break;

		default:
			break;
		}
	}

}
