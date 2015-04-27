package com.example.a_022_app;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {
	
	public AppCentral app;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		app = (AppCentral) getApplication();
	}
	public BaseActivity() {
		// TODO Auto-generated constructor stub
	}

}
