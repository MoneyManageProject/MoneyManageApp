package com.money.android.common.util;


import com.money.android.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * toast 单例显示类
 * 
 * @author xudengwang
 * 
 */
public class ToastManager {
	private static Toast mToast;

	public static final int TOAST_FLAG_SUCCESS = 0;// 操作成功
	public static final int TOAST_FLAG_FAILED = 1;// 操作失败
	public static final int TOAST_FLAG_EXCEPTION = 2;// 操作异常

	public static void showToast(Context context, String message) {
		if (mToast == null) {
			initToast(context);
		}

		mToast.setText(message);
		mToast.show();
	}

	/**
	 * 初始化toast
	 * 
	 * @param context
	 */
	public static void initToast(Context context) {
		LayoutInflater inflate = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflate.inflate(R.layout.common_view_toast, null);
		mToast = new Toast(context);
		mToast.setView(view);

	}
}
