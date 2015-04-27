package com.example.teste_contatos;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;

public class MainActivity extends Activity {

	private Context context;
	private ArrayList<HashMap<String, String>> listaDeContatos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = getBaseContext();

		criarLista();
	}

	private void criarLista() {
		listaDeContatos = new ArrayList<HashMap<String, String>>();
		Uri uriContatos = ContactsContract.Contacts.CONTENT_URI;
		String order = ContactsContract.Contacts.DISPLAY_NAME;
		Cursor cursor = getContentResolver().query(uriContatos, null, null,null, order);
		
		while (cursor.moveToNext()) {
			HashMap<String,String> item = new HashMap<String, String>();
			item.put("codigo",cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID)));
			item.put("nome",cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
			item.put("temtelefone",cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
			
			listaDeContatos.add(item);
			
			
		}

	}

	

}
