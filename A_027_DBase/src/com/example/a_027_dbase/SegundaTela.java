package com.example.a_027_dbase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SegundaTela extends Activity {

	private EditText segundatela_et_codigo;
	private EditText segundatela_et_nome;
	private EditText segundatela_et_telefone;
	private EditText segundatela_et_data_nasc;
	private Button btn_salvar;
	private Button btn_cancelar;
	private Button btn_excluir;
	private String msgValidacao;
	private long idContatoAux;
	private Context context;

	private boolean validarCampos() {
		boolean bResultado = true;
		msgValidacao = "";
		if (segundatela_et_nome.getText().length() == 0) {
			msgValidacao = "Erro. Nome Obrigatorio !";
			return false;
		}
		if (segundatela_et_telefone.getText().length() == 0) {
			msgValidacao = "Erro. Telefone Obrigatorio !";
			return false;
		}
		if (segundatela_et_data_nasc.getText().length() == 0) {
			msgValidacao = "Erro. Data Nascimento Obrigatorio !";
			return false;
		}
		return bResultado;
	}

	@Override
	public void onCreate(Bundle saved) {
		super.onCreate(saved);
		setContentView(R.layout.segundatela);

		context = getBaseContext();

		Intent intent = getIntent();
		idContatoAux = Long.parseLong(intent.getStringExtra("idcontato"));

		segundatela_et_codigo = (EditText) findViewById(R.id.segundatela_et_codigo);
		segundatela_et_codigo.setEnabled(false);
		segundatela_et_nome = (EditText) findViewById(R.id.segundatela_et_nome);
		segundatela_et_telefone = (EditText) findViewById(R.id.segundatela_et_telefone);
		segundatela_et_data_nasc = (EditText) findViewById(R.id.segundatela_et_data_nasc);

		btn_salvar = (Button) findViewById(R.id.segunda_tela_btn_salvar);
		btn_excluir = (Button) findViewById(R.id.segunda_tela_btn_excluir);
		btn_cancelar = (Button) findViewById(R.id.segunda_tela_btn_cancelar);

		if (idContatoAux != 0) {
			btn_excluir.setVisibility(View.VISIBLE);
			ContatoDAO contatoDAO = new ContatoDAO(context);
			Contato contato = contatoDAO.getContatoById(idContatoAux);

			segundatela_et_codigo
					.setText(String.valueOf(contato.getIdContato()));
			segundatela_et_nome.setText(contato.getNome());
			segundatela_et_telefone.setText(contato.getTelefone());
			segundatela_et_data_nasc.setText(contato.getDataNasc());

		} else {
			btn_excluir.setVisibility(View.GONE);
		}

		btn_salvar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (validarCampos()) {
					ContatoDAO contatoDAO = new ContatoDAO(context);
					Contato cAux = new Contato();
					if (idContatoAux == 0) {
						cAux.setIdContato(contatoDAO.proximoIdContato());
					} else {
						cAux.setIdContato(idContatoAux);
					}
					cAux.setNome(segundatela_et_nome.getText().toString());
					cAux.setTelefone(segundatela_et_telefone.getText()
							.toString());
					cAux.setDataNasc(segundatela_et_data_nasc.getText()
							.toString());

					contatoDAO.inserirAtualizarContato(cAux);
					idContatoAux = cAux.getIdContato();
					segundatela_et_codigo.setText(String.valueOf(idContatoAux));

					btn_excluir.setVisibility(View.VISIBLE);

				} else {
					Toast.makeText(context, "ERRO", Toast.LENGTH_SHORT).show();
				}
			}
		});

		btn_cancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, MainActivity.class);
				startActivity(intent);
				finish();

			}
		});

		btn_excluir.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ContatoDAO contatoDao = new ContatoDAO(context);
				contatoDao.apagarContato(idContatoAux);

				onBackPressed();

			}
		});

	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent(context, MainActivity.class);
		startActivity(intent);
	}
}
