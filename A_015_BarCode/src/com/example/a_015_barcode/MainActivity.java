package com.example.a_015_barcode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;
	private Button btn_BarCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();

		btn_BarCode = (Button) findViewById(R.id.btn_bcode);
		btn_BarCode.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(
						"com.google.zxing.client.android.SCAN");
				intent.putExtra("SCAN_CODE",
						"CODE_39_MODE,CODE_128_MODE,QR_CODE_MODE");
				if (intent.resolveActivity(getPackageManager()) != null) {
					startActivityForResult(intent, 1);
				}else{
					Toast.makeText(context, "Favor instalar o Zxing BarCode",Toast.LENGTH_SHORT).show();
				}

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				String resultado = data.getStringExtra("SCAN_RESULT");
				Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
			} else if (resultCode == RESULT_CANCELED) {
			}

			break;

		default:
			break;
		}
	}

}
