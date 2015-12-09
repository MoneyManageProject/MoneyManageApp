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
public class CommentItemReplyView extends LinearLayout{
	private ImageView ivHead;
	private TextView tvName,tvService,tvExperience,tvSecurity,tvCon,tvTime,btnZan,btnReply;
	
	public CommentItemReplyView(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		initView();
		initListener();
	}
	
	private void initView(){
		LayoutInflater.from(getContext()).inflate(R.layout.view_comment_item, this);
		ivHead				= (ImageView)findViewById(R.id.iv_comment_item_head);
		tvName				= (TextView)findViewById(R.id.tv_comment_item_name);
		tvService			= (TextView)findViewById(R.id.tv_comment_item_service);
		tvExperience		= (TextView)findViewById(R.id.tv_comment_item_experience);
		tvSecurity			= (TextView)findViewById(R.id.tv_comment_item_security);
		tvCon				= (TextView)findViewById(R.id.tv_comment_item_con);
		tvTime				= (TextView)findViewById(R.id.tv_comment_item_time);
		btnZan				= (TextView)findViewById(R.id.btn_comment_item_zan);
		btnReply			= (TextView)findViewById(R.id.btn_comment_item_reply);
	}
	
	public void setData(Platform platform){
		if(null == platform){
			return;
		}
	}
	
	private void initListener(){
	}
}
