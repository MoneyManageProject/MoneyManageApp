package com.money.android.subject;

import com.money.android.R;
import com.money.android.base.BaseFragment;
import com.money.android.common.util.MyLog;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SubjectFragment extends BaseFragment {
	// protected FragmentManager mFragmentManager;

	@Override
	public void onAttach(Activity activity) {
		MyLog.d(SubjectFragment.class, "onAttach");
		// mFragmentManager = getActivity().getSupportFragmentManager();
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		MyLog.d(SubjectFragment.class, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		MyLog.d(SubjectFragment.class, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_subject, container,
				false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		MyLog.d(SubjectFragment.class, "onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		MyLog.d(SubjectFragment.class, "onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		MyLog.d(SubjectFragment.class, "onResume");
		super.onResume();

	}

	@Override
	public void onPause() {
		MyLog.d(SubjectFragment.class, "onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		MyLog.d(SubjectFragment.class, "onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		MyLog.d(SubjectFragment.class, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		MyLog.d(SubjectFragment.class, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		MyLog.d(SubjectFragment.class, "onDetach");
		super.onDetach();
	}
}
