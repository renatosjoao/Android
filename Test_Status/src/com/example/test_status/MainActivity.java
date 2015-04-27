package com.example.test_status;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;
	private LocationManager locationManager;
	private Button btn_status;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();
		locationManager = (LocationManager) context
				.getSystemService(LOCATION_SERVICE);

		btn_status = (Button) findViewById(R.id.btn_status);

		btn_status.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mostrarStatus();
			}
		});

	}

	protected void mostrarStatus() {
		boolean gps_habilitado = false;
		boolean network_habilitado = false;

		try {
			gps_habilitado = locationManager
					.isProviderEnabled(LocationManager.GPS_PROVIDER);
		} catch (Exception e) {
		}
		try {
			network_habilitado = locationManager
					.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		} catch (Exception e) {
		}

		//
		String text = "GPS : " + String.valueOf(gps_habilitado) + "\n"
				+ "Network : " + String.valueOf(network_habilitado) + "\n"
				+ "Rede : " + String.valueOf(confirmarMobileDisponivel(context)) + "\n"
				+ "WIFI : " + String.valueOf(confirmarWIFIDisponivel(context))
				+ "\n" + "Airplane : "+ String.valueOf(confirmarAirplaneModeOff(context));

		//
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();

	}

	private boolean confirmarWIFIDisponivel(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		// wifiInfo.isAvailable(); Verificando se a antena está disponível.
		return wifiInfo.isConnected();

	}

	private boolean confirmarMobileDisponivel(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo mobInfo = cm
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		// mobInfo.isAvailable(); Verificando se a antena está disponível.
		return mobInfo.isConnected(); // verificando se está conectado na rede.
	}

	private boolean confirmarAirplaneModeOff(Context contex) {

		int airplane = 0;
		try {
			airplane = android.provider.Settings.System.getInt(
					context.getContentResolver(),
					android.provider.Settings.Global.AIRPLANE_MODE_ON);
		} catch (SettingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airplane == 0;
	}

}
