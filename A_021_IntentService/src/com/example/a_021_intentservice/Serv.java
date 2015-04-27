package com.example.a_021_intentservice;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Serv extends IntentService {

	int index = 0;

	public Serv() {
		super("SeRvIÁO");
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		try {
			while (index < 25) {
				index++;
				Thread.sleep(1000);
				Log.d("SERV", String.valueOf(index));
			}
		} catch (Exception e) {

		}finally{
			
		}
	}

}
