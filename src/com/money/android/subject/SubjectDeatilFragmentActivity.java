package com.money.android.subject;

import com.money.android.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class SubjectDeatilFragmentActivity extends FragmentActivity {
	private FragmentManager mFgmanager;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.fragment_activity_subject_detail);

		mFgmanager = getSupportFragmentManager();
		addViewpageFragment();
	}
	
	private void addViewpageFragment(){
		SubjectDetailViewpageFragment viewpageFragment = new SubjectDetailViewpageFragment();
		addFragment(R.id.fragment_container, viewpageFragment);
	}

	protected void replaceFragment(int layoutId, Fragment fragment) {

		FragmentTransaction fragmentTransaction = mFgmanager.beginTransaction();
		fragmentTransaction.replace(layoutId, fragment);
		fragmentTransaction.addToBackStack(fragment.getClass().getName());
		fragmentTransaction.commitAllowingStateLoss();
	}

	protected void addFragment(int layoutId, Fragment fragment) {
		FragmentTransaction fragmentTransaction = mFgmanager.beginTransaction();
		fragmentTransaction.add(layoutId, fragment);
		fragmentTransaction.commitAllowingStateLoss();

	}

}
