package com.money.android.subject;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.money.android.widget.viewpagefragment.BaseViewPagerFragment;
import com.money.android.widget.viewpagefragment.OnTabReselectListener;
import com.money.android.widget.viewpagefragment.ViewPageFragmentAdapter;
import com.money.android.widget.viewpagefragment.ViewPageInfo;

/**
 * tab viewpagefragemnt 用于tab fragemnt滑动
 * @author xudengwang
 *
 */
public class SubjectDetailViewpageFragment extends BaseViewPagerFragment
		implements OnTabReselectListener {

	private String[] tabNames = { "introduction", "control", "prove" };

	private String[] tabTitles = { "项目简介", "风控措施", "资产包证明" };

	@Override
	protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
		ArrayList<ViewPageInfo> pageList = new ArrayList<ViewPageInfo>();
		for (int i = 0; i < tabTitles.length; i++) {
			ViewPageInfo viewPageInfo = new ViewPageInfo(0, tabTitles[i],
					tabNames[i], SubjectDetaiIntroductionFragment.class, null);
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
