package com.money.android;

import com.money.android.AppManager;
import com.money.android.R;
import com.money.android.ui.util.MainTab;
import com.money.android.widget.MyFragmentTabHost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.view.LayoutInflater;

import android.view.View;

import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements
		OnTabChangeListener {

	public MyFragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppManager.getAppManager().addActivity(this);

		setContentView(R.layout.activity_main);

		initView();
	}

	private void initTabs() {
		MainTab[] tabs = MainTab.values();
		final int size = tabs.length;
		for (int i = 0; i < size; i++) {
			MainTab mainTab = tabs[i];
			TabSpec tab = mTabHost.newTabSpec(getString(mainTab.getResName()));
			View indicator = LayoutInflater.from(getApplicationContext())
					.inflate(R.layout.tab_indicator, null);
			TextView title = (TextView) indicator.findViewById(R.id.tab_title);
			// Drawable drawable = this.getResources().getDrawable(
			// mainTab.getResIcon());
			// title.setCompoundDrawablesWithIntrinsicBounds(null, drawable,
			// null,
			// null);
			// if (i == 2) {
			// indicator.setVisibility(View.INVISIBLE);
			// mTabHost.setNoTabChangedTag(getString(mainTab.getResName()));
			// }
			title.setText(getString(mainTab.getResName()));
			tab.setIndicator(indicator);
			tab.setContent(new TabContentFactory() {

				@Override
				public View createTabContent(String tag) {
					return new View(MainActivity.this);
				}
			});
			mTabHost.addTab(tab, mainTab.getClz(), null);

		}
	}

	@Override
	public void onTabChanged(String tabId) {
		final int size = mTabHost.getTabWidget().getTabCount();
		for (int i = 0; i < size; i++) {
			View v = mTabHost.getTabWidget().getChildAt(i);
			if (i == mTabHost.getCurrentTab()) {
				v.setSelected(true);
			} else {
				v.setSelected(false);
			}
		}
		supportInvalidateOptionsMenu();
	}

	private Fragment getCurrentFragment() {
		return getSupportFragmentManager().findFragmentByTag(
				mTabHost.getCurrentTabTag());
	}

	private void initView() {

		mTabHost = (MyFragmentTabHost) findViewById(android.R.id.tabhost);

		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

		if (android.os.Build.VERSION.SDK_INT > 10) {
			mTabHost.getTabWidget().setShowDividers(0);
		}

		initTabs();

		mTabHost.setCurrentTab(0);
		mTabHost.setOnTabChangedListener(this);

	}

}
