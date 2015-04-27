package com.example.a_018_ac_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;
	private Button btn_show;
	private Button btn_show_customizado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();
		btn_show = (Button) findViewById(R.id.btn_show);
		btn_show_customizado = (Button) findViewById(R.id.btn_show_customizado);
		btn_show.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder alerta = new AlertDialog.Builder(
						MainActivity.this);
				alerta.setTitle("Teste de Integração !!!");
				alerta.setMessage("Erro :Dados Inválidos");
				alerta.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Toast.makeText(context, "OK",
										Toast.LENGTH_SHORT).show();
							}
						});
				alerta.setNeutralButton("Não",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Toast.makeText(context, "Não",
										Toast.LENGTH_SHORT).show();
							}
						});
				alerta.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Toast.makeText(context, "Cancelar",
										Toast.LENGTH_SHORT).show();
							}
						});
				alerta.show();
			}
		});

		btn_show_customizado.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final Context contextInterno = v.getContext();
				LayoutInflater lInflater = LayoutInflater.from(contextInterno);
				final View tvView = lInflater.inflate(R.layout.alerttextview,
						null);
				final EditText input1 = (EditText) tvView
						.findViewById(R.id.et_nome);
				final AlertDialog.Builder aBuilder = new AlertDialog.Builder(
						contextInterno);
				aBuilder.setTitle("Digite os dados de envio :")
						.setView(tvView)
						.setIcon(R.drawable.ic_launcher)
						.setPositiveButton("OK",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										String st1 = input1.getText()
												.toString();
										Toast.makeText(context, st1,
												Toast.LENGTH_SHORT).show();
									}
								});

				aBuilder.show();
			}
		});
	}

	@Override
	public void onBackPressed() {
		AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
		alerta.setTitle("Sair do Sistema!!!");
		alerta.setMessage("Deseja Realmente Sair ???");
		alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
		alerta.setNegativeButton("Não",new DialogInterface.OnClickListener() {
					@Override
			public void onClick(DialogInterface dialog, int which) {
					}
				});
		alerta.show();

	}

}
