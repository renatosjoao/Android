package com.example.a_011_listview_produto_contato;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Contato> listaContatos;
	
	public MyAdapter() {
	}

	@Override
	public int getCount() {
		return listaContatos.size();
	}

	@Override
	public Object getItem(int position) {
		return listaContatos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return listaContatos.get(position).getIdcontato();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ContatoHolder cHolder = null;
		if(row == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.row_esp,parent,false);
			cHolder = new ContatoHolder();
			cHolder.row_tv_id = (TextView) row.findViewById(R.id.row_esp_tv_id);
			cHolder.row_tv_nome = (TextView) row.findViewById(R.id.row_esp_tv_nome);
			cHolder.row_tv_telefone = (TextView) row.findViewById(R.id.row_esp_tv_telefone);
			row.setTag(cHolder);
		}else{
			cHolder = (ContatoHolder) row.getTag();
		}
		Contato cAux = listaContatos.get(position);
		cHolder.row_tv_id.setText(String.valueOf(cAux.getIdcontato()));
		cHolder.row_tv_nome.setText(cAux.getNome());
		cHolder.row_tv_telefone.setText(cAux.getTelefone());
		return row;
		
	}
	
	public MyAdapter(Context context, ArrayList<Contato> listaContatos) {
		this.context = context;
		this.listaContatos = listaContatos;
	}

	private static class ContatoHolder {
		TextView row_tv_id;
		TextView row_tv_nome;
		TextView row_tv_telefone;
	}


}
