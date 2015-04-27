package com.example.a_023_bc_receiver_02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BCR_02 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Recebido pelo Receiver 02", Toast.LENGTH_SHORT).show();// TODO Auto-generated method stub
	}

	
}
