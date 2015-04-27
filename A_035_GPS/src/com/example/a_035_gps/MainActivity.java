package com.example.a_035_gps;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Context contexto;
	private LocationManager locationManager;
	private Button btn_gps;
	private Button btn_wifi;
	private Button btn_parar;
	private TextView tv_latitude;
	private TextView tv_longitude;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		contexto = getBaseContext();
		btn_gps = (Button) findViewById(R.id.btn_gps);
		btn_wifi = (Button) findViewById(R.id.btn_wifi);
		btn_parar = (Button) findViewById(R.id.btn_parar);

		tv_latitude = (TextView) findViewById(R.id.tv_latitude);
		tv_longitude = (TextView) findViewById(R.id.tv_longitude);

		locationManager = (LocationManager) contexto
				.getSystemService(LOCATION_SERVICE);

		btn_gps.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				locationManager.requestLocationUpdates(
						LocationManager.GPS_PROVIDER, 0, 0, gpsListener);

			}
		});
		btn_wifi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				locationManager.requestLocationUpdates(
						LocationManager.NETWORK_PROVIDER, 0, 0, gpsListener);

			}
		});

		btn_parar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				locationManager.removeUpdates(gpsListener);
			}
		});

	}

	private LocationListener gpsListener = new LocationListener() {

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
		}

		@Override
		public void onProviderEnabled(String provider) {
		}

		@Override
		public void onProviderDisabled(String provider) {
		}

		@Override
		public void onLocationChanged(Location location) {
			tv_latitude.setText(String.valueOf(location.getLatitude()));
			tv_longitude.setText(String.valueOf(location.getLongitude()));
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
