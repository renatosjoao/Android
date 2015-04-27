package br.curso.test_drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Frag_02 extends Fragment {

	MainActivity host;
	Button btn_mudar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final View view = inflater.inflate(R.layout.frag_02, container, false);

		host = (MainActivity) getActivity();
		//
		btn_mudar = (Button) view.findViewById(R.id.btn_mudar);
		btn_mudar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				host.mudar_Texto("Texto Alterado!!!");
				host.fechar_drawer();
			}
		});

		return view;
	}

}
