package com.example.a_008_radiobutton_checkbox;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context context;
	//
	CheckBox ck_01;
	//
	RadioButton rb01;
	RadioButton rb02;
	RadioGroup rg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();
		rb01 = (RadioButton) findViewById(R.id.rb_01);
		rb02 = (RadioButton) findViewById(R.id.rb_02);
		rg = (RadioGroup) findViewById(R.id.rg);
		ck_01 = (CheckBox) findViewById(R.id.ckb_01);
		ck_01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				Toast.makeText(context, "Checkbox", Toast.LENGTH_SHORT).show();
			}
		});
		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				Toast.makeText(context, "RadioGroup", Toast.LENGTH_SHORT).show();
			}
		});
	}

}
