package com.example.a_0012;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.provider.CalendarContract.Colors;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Adapter_001 extends BaseAdapter {
	Context context;
	private ArrayList<Contatos> listaContatos;
	private Adapter_001_Acao delegate;

	public Adapter_001_Acao getDelegate() {
		return delegate;
	}

	public void setOnDelegateClickListener(Adapter_001_Acao delegate) {
		this.delegate = delegate;
	}

	public interface Adapter_001_Acao {
		public void adp_AcaoBotao(long idContato);
	}

	public Adapter_001(Context context, ArrayList<Contatos> listaContatos) {
		this.context = context;
		this.listaContatos = listaContatos;
	}

	public Adapter_001() {
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
		return listaContatos.get(position).getIdContato();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ContatoHolder holder = null;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.list_row, parent, false);
			holder = new ContatoHolder();
			holder.tv_nome = (TextView) row
					.findViewById(R.id.lista_row_tv_nome);
			holder.tv_detalhes = (TextView) row
					.findViewById(R.id.lista_row_tv_detalhes);
			holder.btn_show = (Button) row
					.findViewById(R.id.lista_row_btn_show);
			row.setTag(holder);

		} else {
			holder = (ContatoHolder) row.getTag();
		}
		Contatos cAux = listaContatos.get(position);
		holder.tv_nome.setText(cAux.getNome());
		holder.tv_detalhes.setText(cAux.getTelefone());
		if ((position % 2) == 0) {
			holder.tv_detalhes.setTextColor(Color.GREEN);
		} else {
			holder.tv_detalhes.setTextColor(Color.BLUE);

		}
		holder.btn_show.setOnClickListener(new listenetDoBotao(cAux
				.getIdContato()));

		return row;
	}

	private static class ContatoHolder {
		TextView tv_nome;
		TextView tv_detalhes;
		Button btn_show;

	}

	private class listenetDoBotao implements OnClickListener {
		private long idContato;

		public listenetDoBotao(long idContato) {
			this.idContato = idContato;
		}

		@Override
		public void onClick(View v) {
			if (delegate != null) {
				delegate.adp_AcaoBotao(idContato);

			}

		}

	}
}
