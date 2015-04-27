package com.example.a_017_share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Context context;
	private EditText et_x, et_y;
	private Button btn_somar;
	private TextView tv_resultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();
		
		btn_somar = (Button) findViewById(R.id.telainicial_btn_somar);
		et_x = (EditText) findViewById(R.id.telainicial_et_x);
		et_y = (EditText) findViewById(R.id.telainicial_et_y);
		tv_resultado = (TextView) findViewById(R.id.telainicial_tv_resultado);

		btn_somar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent  intent = new Intent("SOMA_DO_RENATO");
				//Intent  intent = new Intent(context, SegundaTela.class);
				intent.putExtra("x",Float.parseFloat(et_x.getText().toString()));
				intent.putExtra("y",Float.parseFloat(et_y.getText().toString()));
				startActivityForResult(intent, 10);
				
			
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if(resultCode == RESULT_OK){
			float res = data.getFloatExtra("resultado", 0);
			tv_resultado.setText("x + y =" +String.valueOf(res));
		}else if(resultCode ==RESULT_CANCELED){
			tv_resultado.setText("x + y = CANCELADO !!!" );
		}
	}
	
	
}
