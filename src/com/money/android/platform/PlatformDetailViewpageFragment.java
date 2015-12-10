package com.money.android.platform;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.money.android.subject.SubjectFragment;
import com.money.android.widget.viewpagefragment.BaseViewPagerFragment;
import com.money.android.widget.viewpagefragment.OnTabReselectListener;
import com.money.android.widget.viewpagefragment.ViewPageFragmentAdapter;
import com.money.android.widget.viewpagefragment.ViewPageInfo;

public class PlatformDetailViewpageFragment extends BaseViewPagerFragment
		implements OnTabReselectListener {

	private String[] tabNames = { "platform_info", "platform_subject" };

	private String[] tabTitles = { "平台信息", "平台标的" };

	private Class[] claszz = new Class[] { PlatformInfoFragment.class,
			SubjectFragment.class };

	@Override
	protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
		ArrayList<ViewPageInfo> pageList = new ArrayList<ViewPageInfo>();
		for (int i = 0; i < tabTitles.length; i++) {
			ViewPageInfo viewPageInfo = new ViewPageInfo(0, tabTitles[i],
					tabNames[i], claszz[i], null);
			pageList.add(viewPageInfo);

		}
		adapter.addAllTab(pageList);
	}

	private Bundle getBundle(int type) {
		Bundle bundle = new Bundle();
		bundle.putInt("content_type", type);
		return bundle;
	}

	@Override
	public void onTabReselect() {
		try {
			int currentIndex = mViewPager.getCurrentItem();
			Fragment currentFragment = getChildFragmentManager().getFragments()
					.get(currentIndex);
			if (currentFragment != null
					&& currentFragment instanceof OnTabReselectListener) {
				OnTabReselectListener listener = (OnTabReselectListener) currentFragment;
				listener.onTabReselect();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

}
