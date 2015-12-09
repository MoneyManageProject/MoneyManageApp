package com.money.android.platform;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.money.android.R;
import com.money.android.base.BaseFragment;

public class PlatformInfoFragment extends BaseFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.fragment_platform_info,
						container, false);
		return view;
	}

}
