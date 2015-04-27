package com.example.a_033_fonts;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_01;
	private TextView tv_02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		tv_01 = (TextView) findViewById(R.id.tv_01);
		tv_02 = (TextView) findViewById(R.id.tv_02);
		//
		Typeface titlefont_01 = Typeface.createFromAsset(getAssets(),
				"JollyLodger-Regular.ttf");
		Typeface titlefont_02 = Typeface.createFromAsset(getAssets(),
				"QumpellkaNo12.otf");

		tv_01.setTypeface(titlefont_01);
		tv_01.setTextSize(30);
		tv_02.setTypeface(titlefont_02);
	}

}
