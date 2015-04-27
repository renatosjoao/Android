package com.example.a_011_listview_hm_customadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter_001 extends BaseAdapter {

	private Context context;
	private ArrayList<HashMap<String, String>> listaProdutos;

	public Adapter_001() {
	}

	@Override
	public int getCount() {
		return listaProdutos.size();
	}

	public Adapter_001(Context context,
			ArrayList<HashMap<String, String>> listaProdutos) {
		super();
		this.context = context;
		this.listaProdutos = listaProdutos;
	}

	@Override
	public Object getItem(int position) {
		return listaProdutos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return Long.parseLong(listaProdutos.get(position).get(Constantes.ID));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ProdutoHolder Holder = null;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.row_esp, parent, false);
			Holder = new ProdutoHolder();
			Holder.row_tv_codigo = (TextView) row.findViewById(R.id.row_esp_tv_codigo);
			Holder.row_tv_descricao = (TextView) row.findViewById(R.id.row_esp_tv_descricao);
			row.setTag(Holder);
		} else {
			Holder = (ProdutoHolder) row.getTag();
		}
		
		HashMap<String, String> item = listaProdutos.get(position);
		Holder.row_tv_codigo.setText(item.get(Constantes.ID));
		Holder.row_tv_descricao.setText(item.get(Constantes.DESCRICAO));
		return row;
	}

	public class ProdutoHolder {
		TextView row_tv_codigo;
		TextView row_tv_descricao;
	}

}
