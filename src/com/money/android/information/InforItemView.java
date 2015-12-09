/**
 * 
 */
package com.money.android.information;

import com.money.android.R;
import com.money.android.common.entity.Information;
import com.zero.zerolib.cache.SyncCommonLocalLoadImage2;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
public class InforItemView extends LinearLayout{

	private ImageView ivImg;
	private TextView tvTitle,tvCon,tvTime,tvCommentCount;
	
	public InforItemView(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		initView();
		initListener();
	}
	
	private void initView(){
		LayoutInflater.from(getContext()).inflate(R.layout.view_info_item, this);
		ivImg			= (ImageView)findViewById(R.id.iv_infor_img);
		tvTitle			= (TextView)findViewById(R.id.tv_infor_title);
		tvCon			= (TextView)findViewById(R.id.tv_infor_con);
		tvTime			= (TextView)findViewById(R.id.tv_infor_time);
		tvCommentCount	= (TextView)findViewById(R.id.tv_infor_comment_count);
	}
	
	public void setData(Information information){
		if(null == information){
			return;
		}
		SyncCommonLocalLoadImage2.getInstance().loadNetImage(information.getThumbNailPath(), ivImg, 0);
		tvTitle.setText(information.getTitle());
		tvCon.setText(information.getContent());
		tvTime.setText(information.getTime());
		tvCommentCount.setText(getResources().getString(R.string.infor_comment_count, information.getCommentCount()));
	}
	
	private void initListener(){
		
	}

}
