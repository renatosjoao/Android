package com.example.a_final_pacientes;

import java.util.ArrayList;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.a_final_library.Comunicacao;
import com.example.a_final_library.Util;
import com.google.gson.Gson;

public class DB_Service extends IntentService {

	// responsável por mandar fazer a notificação
	private NotificationManager mNotifyMAnager;
	// notificação em si
	private NotificationCompat.Builder mBuilder;

	public DB_Service() {
		super("DB_Service");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		mNotifyMAnager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mBuilder = new NotificationCompat.Builder(getApplicationContext());

		Gson gson = new Gson();
		String msg = "";

		try {

			Dados_Env dados_env = new Dados_Env();
			dados_env.setUser("Hugo");
			dados_env.setPwd(Util.md5("teste"));
			dados_env.setPacientes(10);

			String sRetorno = Comunicacao.getInputStringFromUrl(
					Constantes.uRl1, gson.toJson(dados_env).toString());
			String[] sRetorno_var = sRetorno.split("#WSTAG#");

			switch (sRetorno_var.length) {
			case 0:
				msg = "Erro: Resposta Invalida do Servidor";
			case 1:
				if (sRetorno_var[0].trim().equalsIgnoreCase("")) {
					msg = "Erro: Download";
				} else {
					msg = "Erro: " + sRetorno_var[0].trim();
				}
				break;
			case 2:
				msg = "Sincronismo Realizado com Sucesso !!!";
				if (Integer.parseInt(sRetorno_var[0]) == 0) {
					Dados_Rec dados_Rec = gson.fromJson(sRetorno_var[1],
							Dados_Rec.class);

					PacienteDao pacienteDao = new PacienteDao(
							getApplicationContext());
					pacienteDao.inserirPacienteLista(dados_Rec.getPacientes());

					Intent broadcastIntent = new Intent();
					broadcastIntent.setAction("TEM_DADOS");
					broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
					sendBroadcast(broadcastIntent);

					//ArrayList<Paciente> retorno = pacienteDao
					//		.getPacienteLista_VO();
					//Log.d("SISTEMA", String.valueOf(retorno.size()));
				} else {
					msg = "Erro : " + sRetorno_var[1];
				}
				break;
			default:
				break;
			}

		} catch (Exception e) {
			msg = "Erro: " + e.toString();
		}

		mBuilder.setContentTitle("Sincronismo !!!")
				.setContentText(msg)
				.setSmallIcon(R.drawable.ic_launcher)
				.setAutoCancel(true)
				.setDefaults(
						Notification.DEFAULT_SOUND
								| Notification.DEFAULT_VIBRATE);

		mNotifyMAnager.notify(0, mBuilder.build());
	}

}
