package com.example.a_032_viewpager;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	private Context context;
	private ViewPager pager;
	private PagerTabStrip pagerTabStrip;
	private ArrayList<Fragment> fragments;
	private String[] titulos = { "Titulo 1", "Titulo 2", "Titulo 3" };
	private Frag_01 frag_01;
	private Frag_02 frag_02;
	private Frag_03 frag_03;
	private FPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);

		context = getBaseContext();

		frag_01 = new Frag_01();
		frag_02 = new Frag_02();
		frag_03 = new Frag_03();

		fragments = new ArrayList<Fragment>();

		fragments.add(frag_01);
		fragments.add(frag_02);
		fragments.add(frag_03);

		adapter = new FPagerAdapter(getSupportFragmentManager(), fragments);

		pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				Toast.makeText(context, String.valueOf(position),
						Toast.LENGTH_SHORT).show();

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});

	}

	private class FPagerAdapter extends FragmentPagerAdapter {

		ArrayList<Fragment> fragments;

		public FPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}

		@Override
		public Fragment getItem(int position) {
			return fragments.get(position);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return titulos[position];
		}

	}

}
