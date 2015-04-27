package br.curso.test_034_gps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context context;

	LocationManager locationManager;

	Button btn_gps;
	Button btn_netw;
	Button btn_stop;

	TextView tv_tipo;
	TextView tv_latitude;
	TextView tv_longitude;

	double latitude;
	double longitude;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		tv_tipo = (TextView) findViewById(R.id.tv_tipo);
		tv_latitude = (TextView) findViewById(R.id.tv_latitude);
		tv_longitude = (TextView) findViewById(R.id.tv_longitude);
		//
		locationManager = (LocationManager) context
				.getSystemService(LOCATION_SERVICE);

		//
		btn_gps = (Button) findViewById(R.id.btn_gps);
		btn_gps.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				limparCampos();
				//
				tv_tipo.setText("GPS");
				//
				btn_gps.setEnabled(false);
				btn_netw.setEnabled(false);
				//
				locationManager.requestLocationUpdates(
						LocationManager.GPS_PROVIDER, 0, 0, gpsListner);
			}
		});
		//
		btn_netw = (Button) findViewById(R.id.btn_NetW);
		btn_netw.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				limparCampos();
				//
				tv_tipo.setText("NetWork");
				//
				btn_gps.setEnabled(false);
				btn_netw.setEnabled(false);
				//
				locationManager.requestLocationUpdates(
						LocationManager.NETWORK_PROVIDER, 0, 0, gpsListner);
			}
		});
		//
		btn_stop = (Button) findViewById(R.id.btn_stop);
		btn_stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//
				btn_gps.setEnabled(true);
				btn_netw.setEnabled(true);
				//
				locationManager.removeUpdates(gpsListner);
			}
		});
	}

	protected void limparCampos() {
		latitude = 0;
		longitude = 0;
		//
		tv_latitude.setText("0");
		tv_longitude.setText("0");
	}

	private LocationListener gpsListner = new LocationListener() {

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onLocationChanged(Location location) {
			latitude = location.getLatitude();
			longitude = location.getLongitude();
			//
			tv_latitude.setText(String.valueOf(latitude));
			tv_longitude.setText(String.valueOf(longitude));
		}
	};
}
