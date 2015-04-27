package com.example.a_007_radiobutton;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {

	RadioGroup rg;
	RadioButton rb_01;
	RadioButton rb_02;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		rg = (RadioGroup) findViewById(R.id.rg);
		rb_01 = (RadioButton) findViewById(R.id.radioButton1);
		rb_02 = (RadioButton) findViewById(R.id.radioButton2);
		context = getBaseContext();
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				String resultado = "";

				switch (checkedId) {
				case R.id.radioButton1:
					resultado = "Botao 1";
					break;
				case R.id.radioButton2:
					resultado = "Botao 2";
					break;
				default:
					break;
				}
				Toast.makeText(context, resultado,Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
