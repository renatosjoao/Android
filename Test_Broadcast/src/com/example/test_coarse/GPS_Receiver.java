package com.example.test_coarse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.Toast;

public class GPS_Receiver extends BroadcastReceiver {

	private boolean gps_habilitado;
	private boolean network_habilitado;
	private LocationManager lm;

	@Override
	public void onReceive(Context context, Intent intent) {

		lm = (LocationManager) context
				.getSystemService(Context.LOCATION_SERVICE);

		try {
			gps_habilitado = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			network_habilitado = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String text = "";
		if(gps_habilitado){
			text  += "GPS Habilitado";
		}else{
			text  += "GPS Desabilitado";
		}
		if(network_habilitado){
			text  += "\n Network Habilitado";
			
		}else{
			text  += "\n Network Desabilitado";
		}
		
		//
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();

	}

}
