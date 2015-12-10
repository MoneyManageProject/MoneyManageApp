/**
 * 
 */
package com.money.android.common.custom;

import com.money.android.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

/**
 * @author Administrator
 *
 */
public class SelectView extends Spinner{

	public SelectView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public SelectView(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		setBackgroundColor(getResources().getColor(R.color.white));
	}

}
