package com.example.a_003_button_listener;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context context;

	Button btn_01;
	Button btn_02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();
		btn_01 = (Button) findViewById(R.id.btn_01);
		btn_02 = (Button) findViewById(R.id.btn_02);

		// Forma não anônima  
		btn_01.setOnClickListener(btnListener);
		btn_02.setOnClickListener(btnListener);
		
		
	}
	
	
	private View.OnClickListener btnListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			String mensagem = "";
			switch (v.getId()) {
			case R.id.btn_01:
				 mensagem = "Acionamento feito pelo Botao 01";	
				 Toast.makeText(context, mensagem,Toast.LENGTH_SHORT).show();
				 //btn_02.setOnClickListener(null);
				break;
			case R.id.btn_02:
				 mensagem = "Acionamento feito pelo Botao 02";
				 Toast.makeText(context, mensagem,Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		}
	}; 

}
