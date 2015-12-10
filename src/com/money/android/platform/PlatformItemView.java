/**
 * 
 */
package com.money.android.platform;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.money.android.R;
import com.money.android.common.custom.StarScoreView;
import com.money.android.common.entity.Platform;
import com.zero.zerolib.cache.SyncCommonLocalLoadImage2;

/**
 * @author zero
 *
 */
public class PlatformItemView extends LinearLayout{
	
	private StarScoreView cvStarScoreView;
	private ImageView ivPlatformLogo;
	private TextView tvPlatformName,tvRateRange,tvTradingVolume,tvOnlineTime,tvInvestmentNumber;
	
	public PlatformItemView(Context context) {
		super(context);
		init();
	}

	private void init(){
		initView();
	}

	private void initView(){
		LayoutInflater.from(getContext()).inflate(R.layout.view_platform_item, this);
		cvStarScoreView			= (StarScoreView)findViewById(R.id.cv_platform_score);
		ivPlatformLogo			= (ImageView)findViewById(R.id.iv_platform_logo);
		tvPlatformName			= (TextView)findViewById(R.id.tv_platform_name);
		tvRateRange				= (TextView)findViewById(R.id.tv_platform_rate_range);
		tvTradingVolume			= (TextView)findViewById(R.id.tv_platform_trading_volume);
		tvOnlineTime			= (TextView)findViewById(R.id.tv_platform_online_time);
		tvInvestmentNumber		= (TextView)findViewById(R.id.tv_platform_investment_number);
	}

	public void setData(Platform platform){
		if(null == platform){
			return;
		}
		cvStarScoreView.setData(platform.getScore());
		SyncCommonLocalLoadImage2.getInstance().loadNetImage(platform.getPlatformLogoPath(), ivPlatformLogo, 0);
		tvPlatformName.setText(platform.getPlatformName());
		tvRateRange.setText(platform.getRateRange());
		tvTradingVolume.setText(platform.getSevenTradingVolume());
		tvOnlineTime.setText(platform.getOnlineTime());
		tvInvestmentNumber.setText(platform.getSevenInvestmentNumber());
	}

}
