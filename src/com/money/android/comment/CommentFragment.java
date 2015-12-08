package com.money.android.comment;

import com.money.android.R;
import com.money.android.base.BaseFragment;
import com.money.android.common.util.MyLog;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CommentFragment extends BaseFragment {
	// protected FragmentManager mFragmentManager;

	@Override
	public void onAttach(Activity activity) {
		MyLog.d(CommentFragment.class, "onAttach");
		// mFragmentManager = getActivity().getSupportFragmentManager();
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		MyLog.d(CommentFragment.class, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		MyLog.d(CommentFragment.class, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_comment, container,
				false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		MyLog.d(CommentFragment.class, "onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		MyLog.d(CommentFragment.class, "onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		MyLog.d(CommentFragment.class, "onResume");
		super.onResume();

	}

	@Override
	public void onPause() {
		MyLog.d(CommentFragment.class, "onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		MyLog.d(CommentFragment.class, "onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		MyLog.d(CommentFragment.class, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		MyLog.d(CommentFragment.class, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		MyLog.d(CommentFragment.class, "onDetach");
		super.onDetach();
	}
}
