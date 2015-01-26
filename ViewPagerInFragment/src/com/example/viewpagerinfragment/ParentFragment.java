package com.example.viewpagerinfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ParentFragment extends Fragment {

	static final int NUM_ITEMS = 10;

	MyAdapter adapter;

	ViewPager mPager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.view_pager, container, false);
		mPager = (ViewPager)v.findViewById(R.id.pager);
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		adapter = new MyAdapter(getChildFragmentManager());
		mPager.setAdapter(adapter);
	}

	public static class MyAdapter extends FragmentStatePagerAdapter {

		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return ChildPageFragment.newInstance();
		}

		@Override
		public int getCount() {
			return NUM_ITEMS;
		}

	}
}
