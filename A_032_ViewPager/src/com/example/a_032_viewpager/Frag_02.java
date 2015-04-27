package com.example.a_032_viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

public class Frag_02 extends Fragment {

	public Frag_02() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.frag_02, container, false); 
		return view;
	}
	
	

}
