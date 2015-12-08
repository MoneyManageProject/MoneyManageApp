package com.money.android.ui.util;

import com.money.android.R;
import com.money.android.comment.CommentFragment;
import com.money.android.information.InformationFragment;
import com.money.android.platform.PlatformFragment;
import com.money.android.subject.SubjectFragment;

public enum MainTab {

	SUBJECT(0, R.string.tab_subject, SubjectFragment.class),

	PLATFORM(1, R.string.tab_platform, PlatformFragment.class),

	INFORMATION(2, R.string.tab_information, InformationFragment.class),

	COMMENT(3, R.string.tab_comment, CommentFragment.class);

	private int idx;
	private int resName;
	private int resIcon;
	private Class<?> clz;

	private MainTab(int idx, int resName, Class<?> clz) {
		this.idx = idx;
		this.resName = resName;
		this.clz = clz;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getResName() {
		return resName;
	}

	public void setResName(int resName) {
		this.resName = resName;
	}

	public int getResIcon() {
		return resIcon;
	}

	public void setResIcon(int resIcon) {
		this.resIcon = resIcon;
	}

	public Class<?> getClz() {
		return clz;
	}

	public void setClz(Class<?> clz) {
		this.clz = clz;
	}
}
