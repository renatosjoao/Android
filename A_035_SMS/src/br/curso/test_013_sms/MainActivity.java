package br.curso.test_013_sms;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context context;

	EditText et_numero;
	EditText et_sms;
	//
	Button btn_enviar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//
		et_numero = (EditText) findViewById(R.id.et_telefone);
		et_sms = (EditText) findViewById(R.id.et_sms);
		//
		btn_enviar = (Button) findViewById(R.id.btn_Enviar);
		btn_enviar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String numero = et_numero.getText().toString();
				String sms = et_sms.getText().toString();
				//
				try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(numero, null, sms, null, null);
					//
					Toast.makeText(context, "SMS Enviado!!!",
							Toast.LENGTH_SHORT).show();

				} catch (Exception e) {
					Toast.makeText(context, "SMS Enviado!!!",
							Toast.LENGTH_SHORT).show();
				}

			}
		});
	}

}
