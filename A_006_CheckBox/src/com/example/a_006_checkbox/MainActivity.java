package com.example.a_006_checkbox;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context context;
	CheckBox cb1, cb2, cb3, cb4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = getBaseContext();

		cb1 = (CheckBox) findViewById(R.id.checkBox1);
		cb2 = (CheckBox) findViewById(R.id.checkBox2);
		cb3 = (CheckBox) findViewById(R.id.checkBox3);
		cb4 = (CheckBox) findViewById(R.id.checkBox4);

		cb1.setChecked(true);
		cb1.isChecked();

		cb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					Toast.makeText(context, "Checkbox 1 marcado",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(context, "Checkbox desmarcado",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		cb2.setOnCheckedChangeListener(changeListener);
		
	}

	private CompoundButton.OnCheckedChangeListener changeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			if (isChecked) {
				Toast.makeText(context, "Checkbox 2 marcado",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(context, "Checkbox 2 desmarcado",
						Toast.LENGTH_SHORT).show();
			}

		}
	};

}
