package com.money.android.platform;

import java.util.ArrayList;

import com.money.android.R;
import com.money.android.base.BaseFragment;
import com.money.android.common.entity.Platform;
import com.money.android.common.util.MyLog;
import com.money.android.subject.SubjectListAdapter;
import com.money.android.widget.PullToRefreshListView;
import com.money.android.widget.PullToRefreshListView.OnLoadMoreListener;
import com.money.android.widget.PullToRefreshListView.OnRefreshListener;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlatformFragment extends BaseFragment {
	// protected FragmentManager mFragmentManager;
	private PullToRefreshListView mListView;
	private PlatformListAdapter mAdapter;
	private ArrayList<Platform> platformList;

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {

		};
	};

	@Override
	public void onAttach(Activity activity) {
		MyLog.d(PlatformFragment.class, "onAttach");
		// mFragmentManager = getActivity().getSupportFragmentManager();
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		MyLog.d(PlatformFragment.class, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		MyLog.d(PlatformFragment.class, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_platform, container,false);
		mListView = (PullToRefreshListView) view
				.findViewById(R.id.listview_subject);
		// 设置下拉刷新监听
		mListView.setOnRefreshListener(new OnRefreshListener() {

			@Override
			public void onRefresh() {
				mHandler.postDelayed(new Runnable() {

					@Override
					public void run() {
						// 刷新完成
						mListView.onRefreshComplete();

					}
				}, 3000);

			}
		});

		// 设置上拉加载更多监听
		mListView.setOnLoadListener(new OnLoadMoreListener() {

			@Override
			public void onLoadMore() {
				mHandler.postDelayed(new Runnable() {

					@Override
					public void run() {
						// 加载完成
						mListView.onLoadMoreComplete();
						// 是否允许继续下拉加载
						mListView.setCanLoadMore(false);

					}
				}, 3000);

			}
		});
		initDatas();
		return view;
	}
	
	private void initDatas() {
		platformList = new ArrayList<Platform>();
		addPlatform();
		mAdapter = new PlatformListAdapter(getActivity(),platformList);
		mListView.setAdapter(mAdapter);
	}
	
	private void addPlatform(){
		if(null == platformList){
			platformList = new ArrayList<Platform>();
		}
		Platform platform = new Platform("8%~12%","2536.00万元","2007-06-17","14626人",3.5f,"拍拍贷","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("7%~12%","236.00万元","2006-06-17","14626人",3.5f,"拍拍贷1","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("6%~12%","536.00万元","2005-06-17","14626人",3.5f,"拍拍贷2","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("5%~12%","36.00万元","2004-06-17","14626人",3.5f,"拍拍贷3","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("4%~12%","3536.00万元","2003-06-17","14626人",3.5f,"拍拍贷4","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("3%~12%","4536.00万元","2002-06-17","14626人",3.5f,"拍拍贷5","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~11%","5536.00万元","2001-06-17","14626人",3.5f,"拍拍贷6","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~10%","6536.00万元","2007-06-17","14626人",3.5f,"拍拍贷7","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~13%","7536.00万元","2007-06-17","14626人",3.5f,"拍拍贷8","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~14%","8536.00万元","2007-06-17","14626人",3.5f,"拍拍贷9","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~15%","9536.00万元","2007-06-17","14626人",3.5f,"拍拍贷0","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~16%","2636.00万元","2007-06-17","14626人",3.5f,"拍拍贷1","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~17%","2736.00万元","2007-06-17","14626人",3.5f,"拍拍贷2","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~18%","2836.00万元","2007-06-17","14626人",3.5f,"拍拍贷3","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~19%","2936.00万元","2007-06-17","14626人",3.5f,"拍拍贷4","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~11%","2436.00万元","2007-06-17","14626人",3.5f,"拍拍贷5","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~13%","2336.00万元","2007-06-17","14626人",3.5f,"拍拍贷6","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
		platform = new Platform("8%~14%","2236.00万元","2007-06-17","14626人",3.5f,"拍拍贷7","http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg");
		platformList.add(platform);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		MyLog.d(PlatformFragment.class, "onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		MyLog.d(PlatformFragment.class, "onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		MyLog.d(PlatformFragment.class, "onResume");
		super.onResume();

	}

	@Override
	public void onPause() {
		MyLog.d(PlatformFragment.class, "onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		MyLog.d(PlatformFragment.class, "onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		MyLog.d(PlatformFragment.class, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		MyLog.d(PlatformFragment.class, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		MyLog.d(PlatformFragment.class, "onDetach");
		super.onDetach();
	}
}
