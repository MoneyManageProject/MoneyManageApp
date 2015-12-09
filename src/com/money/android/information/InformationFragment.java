package com.money.android.information;

import java.util.ArrayList;

import com.money.android.R;
import com.money.android.base.BaseFragment;
import com.money.android.common.entity.Information;
import com.money.android.common.entity.Platform;
import com.money.android.common.util.MyLog;
import com.money.android.platform.PlatformListAdapter;
import com.money.android.widget.PullToRefreshListView;
import com.money.android.widget.PullToRefreshListView.OnLoadMoreListener;
import com.money.android.widget.PullToRefreshListView.OnRefreshListener;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InformationFragment extends BaseFragment {
	// protected FragmentManager mFragmentManager;
	private PullToRefreshListView mListView;
	private InformationAdapter mAdapter;
	private ArrayList<Information> inforList;

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {

		};
	};
	@Override
	public void onAttach(Activity activity) {
		MyLog.d(InformationFragment.class, "onAttach");
		// mFragmentManager = getActivity().getSupportFragmentManager();
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		MyLog.d(InformationFragment.class, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		MyLog.d(InformationFragment.class, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_information, container,
				false);
		mListView = (PullToRefreshListView) view
				.findViewById(R.id.listview_information);
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
		inforList = new ArrayList<Information>();
		addPlatform();
		mAdapter = new InformationAdapter(getActivity(),inforList);
		mListView.setAdapter(mAdapter);
	}
	
	private void addPlatform(){
		if(null == inforList){
			inforList = new ArrayList<Information>();
		}
		Information infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-07",6666);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-11-07",6676);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-11-07",6636);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-06-07",6626);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-08",6616);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-09",6686);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-05",6626);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-04",6666);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-03",6666);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-02",6666);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-01",6666);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-07",6666);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-07",6666);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-07",6666);
		inforList.add(infor);
		infor = new Information("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-07",6666);
		inforList.add(infor);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		MyLog.d(InformationFragment.class, "onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		MyLog.d(InformationFragment.class, "onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		MyLog.d(InformationFragment.class, "onResume");
		super.onResume();

	}

	@Override
	public void onPause() {
		MyLog.d(InformationFragment.class, "onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		MyLog.d(InformationFragment.class, "onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		MyLog.d(InformationFragment.class, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		MyLog.d(InformationFragment.class, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		MyLog.d(InformationFragment.class, "onDetach");
		super.onDetach();
	}
}
