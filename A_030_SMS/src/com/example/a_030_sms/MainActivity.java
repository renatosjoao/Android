package com.example.a_030_sms;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context contexto;
	private EditText et_numero;
	private EditText et_mensagem;
	private Button btn_enviar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		contexto = getBaseContext();

		et_numero = (EditText) findViewById(R.id.et_numero);
		et_mensagem = (EditText) findViewById(R.id.et_mensagem);
		btn_enviar = (Button) findViewById(R.id.btn_enviar);

		btn_enviar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String numero = et_numero.getText().toString();
				String mensagem = et_mensagem.getText().toString();

				try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(numero, null, mensagem, null, null);
					Toast.makeText(contexto, "SMS Enviado", Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					Toast.makeText(contexto, "SMS Nao Enviado", Toast.LENGTH_SHORT).show();
				}

			}
		});
	}

}
