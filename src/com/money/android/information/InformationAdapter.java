/**
 * 
 */
package com.money.android.information;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.money.android.common.entity.Information;

/**
 * @author ChenHongLi
 *
 */
public class InformationAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<Information> platformList;
	public InformationAdapter(Context ctx,ArrayList<Information> platformList){
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
			convertView = new InforItemView(mContext);
		}
		((InforItemView)convertView).setData(platformList.get(position));
		return convertView;
	}
}
