package com.money.android.subject;

import com.money.android.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SubjectListAdapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mInflater;
	public SubjectListAdapter(Context ctx){
		mContext = ctx;
		mInflater = LayoutInflater.from(mContext);
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
			convertView = mInflater.inflate(R.layout.view_subject_item, null);
		}
		return convertView;
	}

}
