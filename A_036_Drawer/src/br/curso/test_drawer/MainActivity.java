package br.curso.test_drawer;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity {

	final private String FRAG_01 = "frag_01";
	final private String FRAG_02 = "frag_02";

	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private LinearLayout opc_drawer;

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	Frag_01 frag_01;
	Frag_02 frag_02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		opc_drawer = (LinearLayout) findViewById(R.id.opc_drawer);
		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		//
		mTitle = mDrawerTitle = getTitle();
		mDrawerTitle = "Opções";
		//
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {

			@Override
			public void onDrawerClosed(View drawerView) {
				getActionBar().setTitle(mTitle);
				//mDrawerToggle.syncState();
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				//mDrawerToggle.syncState();
				invalidateOptionsMenu();
			}

		};
		//
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		//
		// frag_01 = new Frag_01();
		// frag_02 = new Frag_02();
		//
		FragmentManager fm = getSupportFragmentManager();
		//
		if (fm.findFragmentByTag(FRAG_01) == null) {
			frag_01 = new Frag_01();
			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.container, frag_01, FRAG_01);
			ft.commit();
		} else {
			frag_01 = (Frag_01) fm.findFragmentByTag(FRAG_01);
		}
		//
		if (fm.findFragmentByTag(FRAG_02) == null) {
			FragmentTransaction ft = fm.beginTransaction();
			frag_02 = new Frag_02();
			ft.replace(R.id.opc_drawer, frag_02, FRAG_02);
			ft.commit();
		} else {
			frag_02 = (Frag_02) fm.findFragmentByTag(FRAG_02);
		}
		//
		if (mDrawerLayout.isDrawerOpen(opc_drawer)){
			getActionBar().setTitle("Aberto");
			invalidateOptionsMenu();
			mDrawerToggle.syncState();
		} else {
			getActionBar().setTitle("Fechado");
			invalidateOptionsMenu();
			mDrawerToggle.syncState();
		}
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	public void mudar_Texto(String texto) {
		if (frag_01 != null) {
			frag_01.mudar_TextoFragment(texto);
		}
	}

	public void fechar_drawer() {
		mDrawerLayout.closeDrawer(opc_drawer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(opc_drawer);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		//
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

}
