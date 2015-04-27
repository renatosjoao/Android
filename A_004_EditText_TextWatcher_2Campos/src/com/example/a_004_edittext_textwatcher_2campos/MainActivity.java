package com.example.a_004_edittext_textwatcher_2campos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	float valorEUP = 1200f;
	private String msg;
	Context context;
	EditText et_desconto;
	EditText et_preco;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		context = getBaseContext();

		et_desconto = (EditText) findViewById(R.id.et_desconto);

		et_desconto.addTextChangedListener(txtDesconto);
		et_preco = (EditText) findViewById(R.id.et_preco);

		et_preco.addTextChangedListener(txtPreco);

		et_preco.setText(String.valueOf(valorEUP));
	}

	private TextWatcher txtPreco = new TextWatcher() {
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		public void afterTextChanged(Editable s) {
			et_desconto.removeTextChangedListener(txtDesconto);
			if (et_preco.getText().length() > 0) {
				float porcentagem = (float) (100.0 - ((Float
						.parseFloat(et_preco.getText().toString()) * 100.0) / valorEUP));
				et_desconto.setText(String.valueOf(porcentagem));
			} else {
				et_desconto.setText("");
			}
			et_desconto.addTextChangedListener(txtDesconto);

		}
	};

	private TextWatcher txtDesconto = new TextWatcher() {
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		public void afterTextChanged(Editable s) {
			et_preco.removeTextChangedListener(txtPreco);
			//if (verificaLimiteDesconto()) {
				if (et_desconto.getText().toString().length() > 0) {
					float desc = Float.parseFloat(et_desconto.getText()
							.toString());
					float precoFinal = (1 - desc / 100) * valorEUP;
					et_preco.setText(String.valueOf(precoFinal));
				} else {
					et_preco.setText(String.valueOf(valorEUP));
				}
			//} else {
				//msg = "Digite valor menor que 100 %";
				//Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
				//et_preco.setText(String.valueOf(valorEUP));
				//et_desconto.setText("0");
			//}
			et_preco.addTextChangedListener(txtPreco);
		}
	};

	public boolean verificaLimiteDesconto() {
		float valor = Float.parseFloat(et_desconto.getText().toString());
		if (valor > 100.0) {
			return false;
		} else {
			return true;
		}

	}
}
