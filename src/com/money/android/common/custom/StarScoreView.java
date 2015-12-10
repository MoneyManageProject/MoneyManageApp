/**
 * 
 */
package com.money.android.common.custom;

import com.money.android.R;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
public class StarScoreView extends LinearLayout{
	
	private BitmapDrawable bitStarFull,bitStarEmpty,bitStarHalf;
	private TextView tvScore;
	/**
	 * 最大星星数量
	 */
	private final int MAX_STAR_SIZE = 5;

	public StarScoreView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public StarScoreView(Context context) {
		super(context);
		init();
	}

	private void init(){
		//根据图片加载工具加载三张星图
		bitStarFull = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.platform_starscore_full));
		bitStarEmpty = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.platform_starscore_empty));
		bitStarHalf = new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.platform_starscore_full));
		this.setOrientation(LinearLayout.HORIZONTAL);
	}
	
	/**
	 * 分数必须为0-MAX_STAR_SIZE的仅有一位小数的数字
	 * @param score
	 */
	public void setData(float score){
		Log.e("HongLi", "score:" + score);
		removeAllViews();
		if(score < 0 || score > MAX_STAR_SIZE){
			return;
		}
		//创建星星view
		for(int i = 0;i < (int)score;i++){
			addStarView(bitStarFull);
		}
		if(score - (int)score >= 0.5){
			addStarView(bitStarHalf);
		}
		int leaveSize = MAX_STAR_SIZE - (int)score - (score - (int)score >= 0.5 ? 1 : 0);
		for(int i = 0;i < leaveSize;i++){
			addStarView(bitStarEmpty);
		}
		//创建分数view
		tvScore = new TextView(getContext());
		setScoreTextStyle(tvScore);
		tvScore.setText(getResources().getString(R.string.platform_score, score));
	}
	
	private void addStarView(BitmapDrawable bitmapDrawable){
		if(null == bitmapDrawable){
			return;
		}
		ImageView imageView = new ImageView(getContext());
		imageView.setImageDrawable(bitmapDrawable);
		this.addView(imageView);
	}
	
	private void setScoreTextStyle(TextView tvScore){
		if(null == tvScore){
			return;
		}
		tvScore.setTextColor(getResources().getColor(R.color.platform_score));
		tvScore.setTextSize(18);
	}
}
