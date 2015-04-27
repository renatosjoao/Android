package br.curso.test_drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Frag_01 extends Fragment {

	TextView tv_texto;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final View view = inflater.inflate(R.layout.frag_01, container, false);

		tv_texto = (TextView) view.findViewById(R.id.tv_texto);

		return view;
	}

	public void mudar_TextoFragment(String texto) {
		tv_texto.setText(texto);
		tv_texto.setTextColor(0xFFFF0000);
	}

}
