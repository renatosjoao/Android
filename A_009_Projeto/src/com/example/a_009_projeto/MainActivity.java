package com.example.a_009_projeto;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context context;
	EditText nome;
	EditText idade;
	EditText cidade;
	CheckBox ck_01;
	Button bt_01;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		context = getBaseContext();
		nome = (EditText) findViewById(R.id.et_01);
		idade = (EditText) findViewById(R.id.et_02);
		cidade = (EditText) findViewById(R.id.et_03);
		ck_01 = (CheckBox) findViewById(R.id.ck_01);
		bt_01 = (Button) findViewById(R.id.bt_01);

		bt_01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isChecked = ck_01.isChecked();
				String msg;
				if (isChecked) {
					if (nome.getText().toString().length() > 0) {
						if ((cidade.getText().toString()
								.equalsIgnoreCase("SP"))
								&& (Integer
										.parseInt(idade.getText().toString()) > 25)) {
							msg = "R$ 1.000,00 Liberado";
							Toast.makeText(context, msg, Toast.LENGTH_SHORT)
									.show();
							// ifSP > 25 -> 1000
							// SP 500
							// outro 50
						} else if (((cidade.getText().toString()
								.equalsIgnoreCase("SP")) && (Integer
								.parseInt(idade.getText().toString()) <= 25))) {
							msg = "R$ 500,00 Liberado";
							Toast.makeText(context, msg, Toast.LENGTH_SHORT)
									.show();
						} else {
							msg = "R$ 50,00 Liberado";
							Toast.makeText(context, msg, Toast.LENGTH_SHORT)
									.show();
						}
					} else {
						Toast.makeText(context, "Digite um nome",
								Toast.LENGTH_SHORT).show();
					}
				} else {
					Toast.makeText(context, "Nenhum valor liberado",
							Toast.LENGTH_SHORT).show();
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
