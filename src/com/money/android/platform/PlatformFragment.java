package com.money.android.platform;

import com.money.android.R;
import com.money.android.base.BaseFragment;
import com.money.android.common.util.MyLog;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlatformFragment extends BaseFragment {
	// protected FragmentManager mFragmentManager;

	@Override
	public void onAttach(Activity activity) {
		MyLog.d(PlatformFragment.class, "onAttach");
		// mFragmentManager = getActivity().getSupportFragmentManager();
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		MyLog.d(PlatformFragment.class, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		MyLog.d(PlatformFragment.class, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_platform, container,
				false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		MyLog.d(PlatformFragment.class, "onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		MyLog.d(PlatformFragment.class, "onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		MyLog.d(PlatformFragment.class, "onResume");
		super.onResume();

	}

	@Override
	public void onPause() {
		MyLog.d(PlatformFragment.class, "onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		MyLog.d(PlatformFragment.class, "onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		MyLog.d(PlatformFragment.class, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		MyLog.d(PlatformFragment.class, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		MyLog.d(PlatformFragment.class, "onDetach");
		super.onDetach();
	}
}
