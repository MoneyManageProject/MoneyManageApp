/**
 * 
 */
package com.money.android.comment;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.money.android.R;
import com.money.android.base.BaseActivity;

/**
 * @author ChenHongLi
 *
 */
public class CommentDetailActivity extends BaseActivity{
	
	private ImageView ivHead;
	private TextView btnBack,btnZan,btnReply;
	private TextView tvTime,tvSource,tvContent,tvName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}
	
	private void init(){
		initView();
		initData();
		initListener();
	}
	
	private void initView(){
		setContentView(R.layout.activity_comment_detail);
		ivHead				= (ImageView)findViewById(R.id.iv_comment_detail_head);
		btnBack				= (TextView)findViewById(R.id.tv_title_back);
		btnZan				= (TextView)findViewById(R.id.btn_comment_detail_zan);
		btnReply			= (TextView)findViewById(R.id.btn_comment_detail_reply);
		tvTime				= (TextView)findViewById(R.id.tv_comment_detail_time);
		tvSource			= (TextView)findViewById(R.id.tv_comment_detail_source);
		tvContent			= (TextView)findViewById(R.id.tv_comment_detail_con);
		tvName				= (TextView)findViewById(R.id.tv_comment_detail_name);
	}
	
	private void initData(){
		
	}
	
	private void initListener(){
		btnBack.setOnClickListener(onClickListener);
	}
	
	private OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(v == btnBack){
				finish();
			}
		}
	};
	
}
