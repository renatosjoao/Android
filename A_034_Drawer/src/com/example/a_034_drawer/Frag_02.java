package com.example.a_034_drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Frag_02 extends Fragment {

	private Button btn_mudar;
	//private MainActivity host;
	
	private frag_02Inter delegate;
	
	public interface frag_02Inter{
		public void acionar_mudanca(String texto);
	}

	public void setDelegate(frag_02Inter delegate) {
		this.delegate = delegate;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.frag_02, container, false);
		btn_mudar = (Button) view.findViewById(R.id.btn_mudar);
		//host = (MainActivity) getActivity();
		btn_mudar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//host.mudar_Texto("Texto Alterado");
				//host.fechar_Drawer();
				if(delegate != null){
					delegate.acionar_mudanca("Texto Alterado");

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				}
			}
		});
		return view;
	}
}
