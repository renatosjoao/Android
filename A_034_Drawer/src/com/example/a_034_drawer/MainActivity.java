package com.example.a_034_drawer;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.a_034_drawer.Frag_02.frag_02Inter;

public class MainActivity extends FragmentActivity {

	final private String FRAG_01 = "frag_01";
	final private String FRAG_02 = "frag_02";
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private LinearLayout opc_drawer;
	private CharSequence mTitle;
	private CharSequence mDrawerTitle;
	private Frag_01 frag_01;
	private Frag_02 frag_02;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_Layout);
		opc_drawer = (LinearLayout) findViewById(R.id.opc_drawer);
		mTitle = getTitle();
		mDrawerTitle = "Opções";
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {

			@Override
			public void onDrawerClosed(View drawerView) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu();
			}

		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		//
		FragmentManager fm = getSupportFragmentManager();
		if (fm.findFragmentByTag(FRAG_01) == null) {
			frag_01 = new Frag_01();
			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.container, frag_01, FRAG_01);
			ft.commit();
		} else {
			frag_01 = (Frag_01) fm.findFragmentByTag(FRAG_01);
		}
		if (fm.findFragmentByTag(FRAG_02) == null) {
			frag_02 = new Frag_02();
			frag_02.setDelegate(new frag_02Inter() {

			////// Forma Anônima - Usando Interface e delegate...
				@Override
				public void acionar_mudanca(String texto) {
					mudar_Texto(texto);
					fechar_Drawer();
				}
			});
			//////
			
			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.opc_drawer, frag_02, FRAG_02);
			ft.commit();
		} else {
			frag_02 = (Frag_02) fm.findFragmentByTag(FRAG_02);
		}

	}

	public void mudar_Texto(String texto) {
		if (frag_01 != null) {
			frag_01.mudar_TextoFragment(texto);
		}
	}

	public void fechar_Drawer() {
		mDrawerLayout.closeDrawer(opc_drawer);

	}
}
