/**
 * 
 */
package com.money.android.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * @author chenhongli
 * 
 */
public class BaseFragment extends Fragment {

	protected void replaceFragment(int layoutId, Fragment fragment) {
		FragmentTransaction fragmentTransaction = getActivity()
				.getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(layoutId, fragment);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commitAllowingStateLoss();
	}

	protected void replaceFragment(int layoutId, Fragment fragment,
			boolean isBack) {
		FragmentTransaction fragmentTransaction = getActivity()
				.getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(layoutId, fragment);
		if (isBack) {
			fragmentTransaction.addToBackStack(null);
		}
		fragmentTransaction.commitAllowingStateLoss();
	}

	protected void addFragment(int layoutId, Fragment fragment) {
		FragmentTransaction fragmentTransaction = getActivity()
				.getSupportFragmentManager().beginTransaction();
		fragmentTransaction.add(layoutId, fragment);
		fragmentTransaction.commitAllowingStateLoss();
	}

}
