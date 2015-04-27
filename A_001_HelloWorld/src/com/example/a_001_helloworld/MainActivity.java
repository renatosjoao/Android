package com.example.a_001_helloworld;

import com.example.a_001_helloworld.R.id;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.text.format.Time;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView outroNome;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		setContentView(R.layout.telainicial);

		outroNome = (TextView) findViewById(R.id.teste);	
		outroNome.setText("Mudei Android") ;
		
		outroNome.setTextColor(getResources().getColor(R.color.vermelho));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
