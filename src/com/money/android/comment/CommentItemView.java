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
import com.money.android.common.entity.Comment;
import com.money.android.common.entity.Information;
import com.zero.zerolib.cache.SyncCommonLocalLoadImage2;

/**
 * @author ChenHongLi
 *
 */
public class CommentItemView extends LinearLayout{
	private ImageView ivImg;
	private TextView tvTitle,tvCon,tvTime,tvCommentCount;
	
	public CommentItemView(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		initView();
		initListener();
	}
	
	private void initView(){
		LayoutInflater.from(getContext()).inflate(R.layout.view_comment_item, this);
		ivImg			= (ImageView)findViewById(R.id.iv_comment_img);
		tvTitle			= (TextView)findViewById(R.id.tv_comment_title);
		tvCon			= (TextView)findViewById(R.id.tv_comment_con);
		tvTime			= (TextView)findViewById(R.id.tv_comment_time);
		tvCommentCount	= (TextView)findViewById(R.id.tv_comment_comment_count);
	}
	
	public void setData(Comment comment){
		if(null == comment){
			return;
		}
		SyncCommonLocalLoadImage2.getInstance().loadNetImage(comment.getHeadPath(), ivImg, 0);
		tvTitle.setText(comment.getTitle());
		tvCon.setText(comment.getContent());
		tvTime.setText(comment.getTime());
		tvCommentCount.setText(getResources().getString(R.string.comment_comment_count, comment.getCommentCount()));
	}
	
	private void initListener(){
		
	}
	
}
