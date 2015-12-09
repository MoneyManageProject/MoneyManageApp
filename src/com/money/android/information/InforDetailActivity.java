/**
 * 
 */
package com.money.android.information;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.money.android.R;
import com.money.android.base.BaseActivity;

/**
 * @author ChenHongLi
 *
 */
public class InforDetailActivity extends BaseActivity{
	
	private TextView btnBack,btnZan,btnReply;
	private TextView tvTime,tvSource,tvContent;
	
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
		setContentView(R.layout.activity_infor_detail);
		btnBack				= (TextView)findViewById(R.id.tv_title_back);
		btnZan				= (TextView)findViewById(R.id.btn_infor_detail_zan);
		btnReply			= (TextView)findViewById(R.id.btn_infor_detail_reply);
		tvTime				= (TextView)findViewById(R.id.tv_infor_detail_time);
		tvSource			= (TextView)findViewById(R.id.tv_infor_detail_source);
		tvContent			= (TextView)findViewById(R.id.tv_infor_detail_con);
	}
	
	private void initData(){
		
	}
	
	private void initListener(){
		btnBack.setOnClickListener(onClickListener);
	}
	
	private OnClickListener onClickListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			if(v == btnBack){
				finish();
			}
		}
		
	};
	
}
