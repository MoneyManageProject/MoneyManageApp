/**
 * 
 */
package com.money.android.platform;

import java.util.ArrayList;

import com.money.android.common.entity.Platform;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @author ChenHongLi
 *
 */
public class PlatformListAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<Platform> platformList;
	public PlatformListAdapter(Context ctx,ArrayList<Platform> platformList){
		mContext = ctx;
		this.platformList = platformList;
	}

	@Override
	public int getCount() {
		return platformList.size();
	}

	@Override
	public Object getItem(int position) {
		return platformList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null) {
			convertView = new PlatformItemView(mContext);
		}
		((PlatformItemView)convertView).setData(platformList.get(position));
		return convertView;
	}
}
