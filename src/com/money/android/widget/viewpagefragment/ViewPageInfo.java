package com.money.android.widget.viewpagefragment;

import android.os.Bundle;

public final class ViewPageInfo {

	public final String tag;
	public final Class<?> clss;
	public final Bundle args;
	public final String title;
	public final int icon;

	// public ViewPageInfo(String _title, String _tag, Class<?> _class, Bundle
	// _args) {
	// title = _title;
	// tag = _tag;
	// clss = _class;
	// args = _args;
	// }

	public ViewPageInfo(int _icon, String _title, String _tag, Class<?> _class, Bundle _args) {
		title = _title;
		icon = _icon;
		tag = _tag;
		clss = _class;
		args = _args;
	}
}