package br.com.nmsystems.curso.sms.interceptor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) 
    {
    	String sFinal = "";
        //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();        
        SmsMessage[] msgs = null;
        String str = "";            
        if (bundle != null)
        {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];            
            for (int i=0; i<msgs.length; i++){
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);                
                str += msgs[i].getMessageBody().toString();
            }
            //
            if ( str.contains("APS:")){
//            	String[] separated = str.split(" ");
//            	int iIndex = separated.length - 1;
//            	sFinal = separated[iIndex].replace(".","");
            	sFinal = str.replaceAll("APS:", "");
            	
                //---display the new SMS message---
                Toast.makeText(context, sFinal, Toast.LENGTH_SHORT).show();
                //
                abortBroadcast();
                //
            }
        }                         
    }
}
