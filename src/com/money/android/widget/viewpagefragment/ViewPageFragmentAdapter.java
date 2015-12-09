package com.money.android.widget.viewpagefragment;

import java.util.ArrayList;

import com.money.android.R;
import com.money.android.widget.PagerSlidingTabStrip;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("Recycle")
public class ViewPageFragmentAdapter extends FragmentStatePagerAdapter {

	private final Context mContext;
	protected PagerSlidingTabStrip mPagerStrip;
	private final ViewPager mViewPager;
	private final ArrayList<ViewPageInfo> mTabs = new ArrayList<ViewPageInfo>();

	public ViewPageFragmentAdapter(FragmentManager fm,
			PagerSlidingTabStrip pageStrip, ViewPager pager) {
		super(fm);
		mContext = pager.getContext();
		mPagerStrip = pageStrip;
		mViewPager = pager;
		mViewPager.setAdapter(this);
		mPagerStrip.setViewPager(mViewPager);
	}

	public void addTab(int icon, String tag, String title, Class<?> clss, Bundle args) {
		ViewPageInfo viewPageInfo = new ViewPageInfo(icon, tag,title, clss, args);
		addFragment(viewPageInfo);
	}

	public void addAllTab(ArrayList<ViewPageInfo> mTabs) {
		for (ViewPageInfo viewPageInfo : mTabs) {
			addFragment(viewPageInfo);
		}
	}

	private void addFragment(ViewPageInfo info) {
		if (info == null) {
			return;
		}

		// 加入tab title
//		View view = LayoutInflater.from(mContext).inflate(
//				R.layout.base_viewpage_fragment_tab_item, null, false);
//		ImageView iconIb = (ImageView) view.findViewById(R.id.iv_tab_icon);
//		iconIb.setImageResource(info.icon);
		
		View view = LayoutInflater.from(mContext).inflate(R.layout.viewpage_fragment_tab_item, null, false);

		TextView tabTitle = (TextView) view.findViewById(R.id.tv_tab_title);
		tabTitle.setText(info.title);
//		 ImageView view = new ImageView(mContext);
//		 view.setImageResource(info.icon);
//		
//		 view.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
//		 LayoutParams.WRAP_CONTENT));

		mPagerStrip.addTab(view);

		mTabs.add(info);
		notifyDataSetChanged();
	}

	/**
	 * 移除第一次
	 */
	public void remove() {
		remove(0);
	}

	/**
	 * 移除一个tab
	 * 
	 * @param index
	 *            备注：如果index小于0，则从第一个开始删 如果大于tab的数量值则从最后一个开始删除
	 */
	public void remove(int index) {
		if (mTabs.isEmpty()) {
			return;
		}
		if (index < 0) {
			index = 0;
		}
		if (index >= mTabs.size()) {
			index = mTabs.size() - 1;
		}
		mTabs.remove(index);
		mPagerStrip.removeTab(index, 1);
		notifyDataSetChanged();
	}

	/**
	 * 移除所有的tab
	 */
	public void removeAll() {
		if (mTabs.isEmpty()) {
			return;
		}
		mPagerStrip.removeAllTab();
		mTabs.clear();
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mTabs.size();
	}

	@Override
	public int getItemPosition(Object object) {
		return PagerAdapter.POSITION_NONE;
	}

	@Override
	public Fragment getItem(int position) {
		ViewPageInfo info = mTabs.get(position);
		return Fragment.instantiate(mContext, info.clss.getName(), info.args);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// return mTabs.get(position).title;
		return mTabs.get(position).tag;
	}
}