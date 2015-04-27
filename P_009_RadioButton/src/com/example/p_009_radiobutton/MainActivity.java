package com.example.p_009_radiobutton;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	Context context;
	RadioButton rb01;
	RadioButton rb02;
	RadioButton rb03;
	RadioButton rb04;
	RadioButton rb05;
	RadioButton rb06;
	RadioGroup rg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = getBaseContext();
		rb01 = (RadioButton) findViewById(R.id.rb_01);
		rb02 = (RadioButton) findViewById(R.id.rb_02);
		rb03 = (RadioButton) findViewById(R.id.rb_03);
		rb04 = (RadioButton) findViewById(R.id.rb_04);
		rb05 = (RadioButton) findViewById(R.id.rb_05);
		rb06 = (RadioButton) findViewById(R.id.rb_06);

		rb01.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					String msg = "Radio Button 1 clicado";
					Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
					rb02.setChecked(false);
					rb03.setChecked(false);
					rb04.setChecked(false);
					rb05.setChecked(false);
					rb06.setChecked(false);
				}
			}
		});

		rb02.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					String msg = "Radio Button 2 clicado";
					Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
					rb01.setChecked(false);
					rb03.setChecked(false);
					rb04.setChecked(false);
					rb05.setChecked(false);
					rb06.setChecked(false);
				}
			}
		});

		rb03.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					String msg = "Radio Button 3 clicado";
					Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
					rb01.setChecked(false);
					rb02.setChecked(false);
					rb04.setChecked(false);
					rb05.setChecked(false);
					rb06.setChecked(false);
				}
			}
		});
		rb04.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					String msg = "Radio Button 4 clicado";
					Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
					rb01.setChecked(false);
					rb02.setChecked(false);
					rb03.setChecked(false);
					rb05.setChecked(false);
					rb06.setChecked(false);
				}
			}
		});

		rb05.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					String msg = "Radio Button 5 clicado";
					Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
					rb01.setChecked(false);
					rb02.setChecked(false);
					rb03.setChecked(false);
					rb04.setChecked(false);
					rb06.setChecked(false);
				}
			}
		});
		rb06.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					String msg = "Radio Button 6 clicado";
					Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
					rb01.setChecked(false);
					rb02.setChecked(false);
					rb03.setChecked(false);
					rb04.setChecked(false);
					rb05.setChecked(false);
				}
			}
		});

	}
}
