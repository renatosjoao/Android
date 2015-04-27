package br.com.nmsystems.curso.sms.interceptor;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SMSIntercept extends Activity {

	Button btnSMS;
	EditText etPhone;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsintercept);
        
        etPhone = (EditText)findViewById(R.id.etTelephone);
        btnSMS = (Button)findViewById(R.id.btnSendSMS);
        btnSMS.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String sPhone = etPhone.getText().toString();
				
				try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(sPhone, null, "APS: Neo ( Hugo )", null, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_smsintercept, menu);
        return true;
    }

    
}
