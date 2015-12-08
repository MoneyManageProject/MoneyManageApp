package com.money.android.information;

import com.money.android.R;
import com.money.android.base.BaseFragment;
import com.money.android.common.util.MyLog;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InformationFragment extends BaseFragment {
	// protected FragmentManager mFragmentManager;

	@Override
	public void onAttach(Activity activity) {
		MyLog.d(InformationFragment.class, "onAttach");
		// mFragmentManager = getActivity().getSupportFragmentManager();
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		MyLog.d(InformationFragment.class, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		MyLog.d(InformationFragment.class, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_information, container,
				false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		MyLog.d(InformationFragment.class, "onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		MyLog.d(InformationFragment.class, "onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		MyLog.d(InformationFragment.class, "onResume");
		super.onResume();

	}

	@Override
	public void onPause() {
		MyLog.d(InformationFragment.class, "onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		MyLog.d(InformationFragment.class, "onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		MyLog.d(InformationFragment.class, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		MyLog.d(InformationFragment.class, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		MyLog.d(InformationFragment.class, "onDetach");
		super.onDetach();
	}
}
