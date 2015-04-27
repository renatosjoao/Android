package com.example.a_025_libprj;



import com.example.a_025_lib.Funcoes;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_item);
		
		Funcoes.sNome2();
	}


}
