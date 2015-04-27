package br.curso.android_final_pacientes;

import java.net.URI;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import br.com.impacta.final_pacientes.R;
import br.curso.android_final_library.DBase.Comunicacao;
import br.curso.android_final_library.DBase.Util;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.telephony.gsm.GsmCellLocation;

public class DB_Service extends IntentService {

	private NotificationManager mNotifyManager;
	private NotificationCompat.Builder mBuilder;

	public DB_Service() {
		super("DB_Service");
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mBuilder = new NotificationCompat.Builder(getApplicationContext());
		//

		Gson gson = new Gson();

		String msg = "";

		try {
			Dados_Env dados_Env = new Dados_Env();
			//
			dados_Env.setUser("Hugo");
			dados_Env.setPwd(Util.md5("teste"));
			dados_Env.setPacientes(10);
			//
			String sRetorno = Comunicacao.getInputStringFromUrl(
					Constantes.uRL1, gson.toJson(dados_Env));

			String[] sRetorno_Var = sRetorno.split("#WSTAG#");

			switch (sRetorno_Var.length) {
			case 0:
				msg = "Erro: Resposta do Servidor Inválida!!!";
				break;
			case 1:
				if (sRetorno_Var[0].trim().equalsIgnoreCase("")) {
					msg = "Erro: DownLoad!!!";
				} else {
					msg = "Erro: " + sRetorno_Var[0];
				}
				break;
			case 2:
				msg = "Sincronismo Realizado com Sucesso!!!";
				//
				if (Integer.parseInt(sRetorno_Var[0]) == 0) {
					Dados_Rec dados_Rec = gson.fromJson(sRetorno_Var[1],
							Dados_Rec.class);
					//
					PacienteDao pacienteDao = new PacienteDao(
							getApplicationContext());
					pacienteDao.inserirPacienteLista(dados_Rec.getPacientes());
					//
					Intent broadcastIntent = new Intent();
					broadcastIntent.setAction("TEM_DADOS");
					broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
					sendBroadcast(broadcastIntent);					
					

				} else {
					msg = "Erro: " + sRetorno_Var[1];
				}
				break;
			default:
				msg = "Erro: Indeterminado. Possível Erro do WS";
				break;
			}
		} catch (Exception e) {
			msg = "Erro: " + e.toString();
		}

		mBuilder.setContentTitle("Sincronismo!!!").setContentText(msg)
				.setSmallIcon(R.drawable.ic_launcher).setAutoCancel(true);
		mBuilder.setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.s_whistle));
		//
		mBuilder.setDefaults(Notification.FLAG_SHOW_LIGHTS | Notification.DEFAULT_VIBRATE | Notification.PRIORITY_DEFAULT);
		//
		mNotifyManager.notify(0, mBuilder.build());
	}

}
