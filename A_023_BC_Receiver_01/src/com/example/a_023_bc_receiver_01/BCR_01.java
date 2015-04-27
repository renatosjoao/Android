package com.example.a_023_bc_receiver_01;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BCR_01 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Recebido pelo Receiver 01", Toast.LENGTH_SHORT).show();
	}

}
