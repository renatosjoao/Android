package br.curso.test_028_tab_actionbar;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

	ActionBar mActionBar;

	Frag_01 frag_01;
	Frag_02 frag_02;

	int iCurrentFrag = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		mActionBar = getActionBar();
		//
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		ActionBar.TabListener tabListner = new TabListener() {

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				iCurrentFrag = tab.getPosition();
				//
				setCurrentFrag(iCurrentFrag);

			}

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub

			}
		};

		Tab tab = mActionBar.newTab().setText("Android")
				.setIcon(R.drawable.android).setTabListener(tabListner);

		mActionBar.addTab(tab);

		tab = mActionBar.newTab().setText("Apple").setIcon(R.drawable.apple)
				.setTabListener(tabListner);

		mActionBar.addTab(tab);

	}

	protected void setCurrentFrag(int iCurrentFrag) {

		FragmentManager fm = getFragmentManager();
		String sFrag = "";
		//
		switch (iCurrentFrag) {
		case 0:
			sFrag = "frag_01";

			if (fm.findFragmentByTag(sFrag) == null) {

				FragmentTransaction ft = fm.beginTransaction();
				//
				if (frag_01 == null) {

					frag_01 = new Frag_01();
				}
				ft.replace(R.id.ll, frag_01, sFrag);
				ft.commit();
			} else {
				frag_01 = (Frag_01) fm.findFragmentByTag(sFrag);
			}

			break;
		case 1:
			sFrag = "frag_02";

			if (fm.findFragmentByTag(sFrag) == null) {

				FragmentTransaction ft = fm.beginTransaction();
				//
				if (frag_02 == null) {
					frag_02 = new Frag_02();
				}
				ft.replace(R.id.ll, frag_02, sFrag);
				ft.commit();
			} else {
				frag_02 = (Frag_02) fm.findFragmentByTag(sFrag);
			}
			break;

		default:
			break;
		}

	}

}
