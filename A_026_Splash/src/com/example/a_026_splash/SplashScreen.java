package com.example.a_026_splash;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashScreen extends Activity {

	private Context context;
	private static int SPLASH_TIMEOUT = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		context = getBaseContext();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				Intent intent = new Intent(context, MainActivity.class);
				startActivity(intent);
				finish();
			}
		}, SPLASH_TIMEOUT);
	}
	

}
