package com.example.viewpagerinfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ChildPageFragment extends Fragment{

	static Fragment newInstance() {
		ChildPageFragment cpf = new ChildPageFragment();
		return cpf;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.single_page, container, false);
	}
}
