/**
 * 
 */
package com.money.android.comment;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.money.android.R;
import com.money.android.common.entity.Platform;

/**
 * @author ChenHongLi
 *
 */
public class CommentItemView extends LinearLayout{
	
	
	public CommentItemView(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		initView();
		initListener();
	}
	
	private void initView(){
		LayoutInflater.from(getContext()).inflate(R.layout.view_comment_reply_item, this);
	}
	
	public void setData(Platform platform){
		if(null == platform){
			return;
		}
	}
	
	private void initListener(){
	}
	
}
