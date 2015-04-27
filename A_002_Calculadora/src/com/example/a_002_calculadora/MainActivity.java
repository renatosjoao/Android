package com.example.a_002_calculadora;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText et_val1;
	EditText et_val2;
	TextView t_res;

	Button btn_somar;
	Button btn_subtrair;
	Button btn_multiplicar;
	Button btn_dividir;
	Button btn_limpar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		et_val1 = (EditText) findViewById(R.id.et_val1);
		et_val2 = (EditText) findViewById(R.id.et_val2);

		t_res = (TextView) findViewById(R.id.t_res);

		btn_somar = (Button) findViewById(R.id.btn_somar);
		btn_subtrair = (Button) findViewById(R.id.btn_sub);
		btn_limpar = (Button) findViewById(R.id.btn_limpar);
		btn_dividir = (Button) findViewById(R.id.btn_div);
		btn_multiplicar = (Button) findViewById(R.id.btn_mult);

		btn_somar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					float resultado = somar();
					t_res.setText(String.valueOf(resultado));
				} catch (Exception e) {
				}

			}
		});
		
		btn_subtrair.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					float resultado = subtrair();
					t_res.setText(String.valueOf(resultado));
				} catch (Exception e) {
				}

			}
		});

		btn_multiplicar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					float resultado = multiplicar();
					t_res.setText(String.valueOf(resultado));
				} catch (Exception e) {
				}

			}
		});
		btn_dividir.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					float resultado = dividir();
					t_res.setText(String.valueOf(resultado));
				} catch (Exception e) {
				}

			}
		});

		btn_limpar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					limpar();
				} catch (Exception e) {
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public float somar() {
		
		float val1 = Float.parseFloat(et_val1.getText().toString().trim());
		float val2 = Float.parseFloat(et_val2.getText().toString().trim());
		return val1+val2;
	}
	
	public float subtrair() {
		
		float val1 = Float.parseFloat(et_val1.getText().toString().trim());
		float val2 = Float.parseFloat(et_val2.getText().toString().trim());
		return val1-val2;
	}
	
	public float multiplicar() {
		
		float val1 = Float.parseFloat(et_val1.getText().toString().trim());
		float val2 = Float.parseFloat(et_val2.getText().toString().trim());
		return val1*val2;
	}

	public float dividir() {
		
		float val1 = Float.parseFloat(et_val1.getText().toString().trim());
		float val2 = Float.parseFloat(et_val2.getText().toString().trim());
		return val1/val2;
	}



	public void limpar() {
		et_val1.setText("");
		et_val2.setText("");
		t_res.setText("");
	}

}
