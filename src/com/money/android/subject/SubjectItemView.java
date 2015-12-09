/**
 * 
 */
package com.money.android.subject;

import com.money.android.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * @author Administrator
 *
 */
public class SubjectItemView extends LinearLayout{

	public SubjectItemView(Context context) {
		super(context);
		init();
	}
	private void init(){
		initView();
		initData();
		initListener();
	}
	
	private void initView(){
		LayoutInflater.from(getContext()).inflate(R.layout.view_subject_item, this);
	}
	
	private void initData(){
		
	}
	
	private void initListener(){
		
	}
}
