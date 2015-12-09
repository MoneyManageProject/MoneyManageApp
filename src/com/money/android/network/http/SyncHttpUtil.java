package com.money.android.network.http;

import android.content.Context;
import android.text.TextUtils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

public class SyncHttpUtil {
	private static SyncHttpClient httpclient = new SyncHttpClient();
	static {
		httpclient.setConnectTimeout(15000);
		httpclient.setMaxRetriesAndTimeout(1, 15000);
	}

	public static void get(String urlString, AsyncHttpResponseHandler res) // 用一个完整url获取一个string对象

	{
		httpclient.get(urlString, res);
	}

	public static void get(String urlString, RequestParams params,
			AsyncHttpResponseHandler res) // url里面带参数
	{
		httpclient.get(urlString, params, res);
	}

	public static void get(String urlString, JsonHttpResponseHandler res) // 不带参数，获取json对象或者数组
	{
		httpclient.get(urlString, res);
	}

	public static void get(String urlString, RequestParams params,
			JsonHttpResponseHandler res) // 带参数，获取json对象或者数组
	{
		httpclient.get(urlString, params, res);
		
	}

	public static void get(String uString, BinaryHttpResponseHandler bHandler) // 下载数据使用，会返回byte数据
	{
		httpclient.get(uString, bHandler);
	}

	public static void post(String uString, RequestParams params,
			JsonHttpResponseHandler bHandler) // post数据使用，会返回json数据
	{
		httpclient.post(uString, params, bHandler);
	}

	public static void post(String uString, RequestParams params,
			AsyncHttpResponseHandler res) // post数据使用，返回普通的手
	{
		httpclient.post(uString, params, res);
	}

	public static SyncHttpClient getClient() {
		return httpclient;
	}

//	public static void setBasicAuth(Context context) {
//		String userName = PreferencesUtils.getUserData(context,
//				PreferencesUtils.KEY_USERNAME);
//		String sessionPassword = PreferencesUtils.getUserData(context,
//				PreferencesUtils.KEY_SESSION_PASSWORD);
//		if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(sessionPassword)) {
//			httpclient.setBasicAuth(userName, sessionPassword);
//		}
//	}

}