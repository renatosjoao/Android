package br.curso.a_031_bundlesaved;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Produto pAux;

	private EditText et_codigo;
	private EditText et_nome;
	private EditText et_precounitario;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		Log.d("SISTEMA", "onCreate");
		//
		et_codigo = (EditText) findViewById(R.id.et_codigo);
		et_nome = (EditText) findViewById(R.id.et_nome);
		et_precounitario = (EditText) findViewById(R.id.et_precounitario);
		//
		if (savedInstanceState != null) {
			pAux = (Produto) savedInstanceState.getSerializable("pAuxK");
		} else {
			pAux = new Produto();
			pAux.setCodigo(1);
			pAux.setNome("Samsung Galaxy S5");
			pAux.setPrecounitario(2800f);
		}
		//
		et_codigo.setText(String.valueOf(pAux.getCodigo()));
		et_nome.setText(pAux.getNome());
		et_precounitario.setText(String.valueOf(pAux.getPrecounitario()));
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		//
		Log.d("SISTEMA", "onSaveInstanceState");
		//
		pAux.setCodigo(Long.parseLong(et_codigo.getText().toString()));
		pAux.setNome(et_nome.getText().toString());
		pAux.setPrecounitario(Float.parseFloat(et_precounitario.getText()
				.toString()));

		outState.putSerializable("pAuxK", pAux);
		//
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onStart() {
		//
		Log.d("SISTEMA", "onStart");
		//
		super.onStart();
	}

	@Override
	protected void onResume() {
		//
		Log.d("SISTEMA", "onResume");
		//
		super.onResume();
	}

	@Override
	protected void onPause() {
		//
		Log.d("SISTEMA", "onPause");
		//
		super.onPause();
	}

	@Override
	protected void onStop() {
		//
		Log.d("SISTEMA", "onStop");
		//
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		//
		Log.d("SISTEMA", "onDestroy");
		//
		super.onDestroy();
	}
	
	
	
	
	
	
	
	
	
	

}
