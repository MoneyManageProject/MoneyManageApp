package com.money.android.subject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SubjectListAdapter extends BaseAdapter {
	private Context mContext;
	public SubjectListAdapter(Context ctx){
		mContext = ctx;
	}

	@Override
	public int getCount() {
		return 20;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null) {
			convertView = new SubjectItemView(mContext);
		}
		return convertView;
	}

}
