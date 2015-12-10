/**
 * 
 */
package com.money.android.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.money.android.R;
import com.money.android.common.entity.Platform;

/**
 * @author xudengwang
 * 
 */
public class HotCommentView extends LinearLayout {
	private LinearLayout mCommentContainer;
	private EditText mCommentEdit;

	private Context mContext;

	public HotCommentView(Context context) {
		super(context);
		mContext = context;
		init();
	}

	public HotCommentView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		init();
	}

	private void init() {
		initView();
		initListener();
	}

	private void initView() {
		LayoutInflater.from(getContext()).inflate(R.layout.view_hot_comment,
				this);
		mCommentContainer = (LinearLayout) findViewById(R.id.comment_container_lin);
		CommentItemReplyView itemView = new CommentItemReplyView(mContext);
		mCommentContainer.addView(itemView);
		CommentItemReplyView itemView2 = new CommentItemReplyView(mContext);
		mCommentContainer.addView(itemView2);
		mCommentEdit = (EditText) findViewById(R.id.comment_edittxt);
	}

	private void initListener() {
	}

}
