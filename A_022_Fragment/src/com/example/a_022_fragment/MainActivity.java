package com.example.a_022_fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	Frag01 frag01;
	Frag02 frag02;

	Button btn_01;
	Button btn_02;

	int iFrag = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		btn_01 = (Button) findViewById(R.id.btn_01);
		btn_02 = (Button) findViewById(R.id.btn_02);

		btn_01.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				iFrag = 1;
				setFrag(iFrag);
			}
		});

		btn_02.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				iFrag = 2;
				setFrag(iFrag);

			}
		});

		setFrag(iFrag);
	}

	private void setFrag(int iFragmento) {

		FragmentManager fm = getSupportFragmentManager();
		String sTag = "";
		switch (iFragmento) {
		case 1:
			sTag = "frag01";
			if (fm.findFragmentByTag(sTag) == null) {
				frag01 = new Frag01();
				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.ll_frag, frag01, sTag);
				ft.commit();
			} else {
				frag01 = (Frag01) fm.findFragmentByTag(sTag);
			}
			break;
		case 2:
			sTag = "frag02";
			if (fm.findFragmentByTag(sTag) == null) {
				frag02 = new Frag02();
				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.ll_frag, frag02, sTag);
				ft.commit();
			} else {
				frag02 = (Frag02) fm.findFragmentByTag(sTag);
			}
			break;
		default:
			break;
		}

	}
}
