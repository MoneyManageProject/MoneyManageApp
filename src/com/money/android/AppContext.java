package com.money.android;

import com.money.android.base.BaseApplication;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class AppContext extends BaseApplication {

	private static AppContext instance;

	@Override
	public void onCreate() {
		instance = this;
		super.onCreate();
	}

	/**
	 * 获得当前app运行的AppContext
	 * 
	 * @return
	 */
	public static AppContext getInstance() {
		return instance;
	}

	/**
	 * 强制隐藏输入法键盘
	 */
	public void hideInput(View v) {
		InputMethodManager inputMethodManager = (InputMethodManager) context()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
	}
}
