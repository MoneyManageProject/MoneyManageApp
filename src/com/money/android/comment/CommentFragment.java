package com.money.android.comment;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.money.android.R;
import com.money.android.base.BaseFragment;
import com.money.android.common.entity.Comment;
import com.money.android.common.util.MyLog;
import com.money.android.information.InforDetailActivity;
import com.money.android.widget.PullToRefreshListView;
import com.money.android.widget.PullToRefreshListView.OnLoadMoreListener;
import com.money.android.widget.PullToRefreshListView.OnRefreshListener;

public class CommentFragment extends BaseFragment {
	// protected FragmentManager mFragmentManager;

	private PullToRefreshListView mListView;
	private CommentListAdapter mAdapter;
	private ArrayList<Comment> commentList;

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {

		};
	};
	
	@Override
	public void onAttach(Activity activity) {
		MyLog.d(CommentFragment.class, "onAttach");
		// mFragmentManager = getActivity().getSupportFragmentManager();
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		MyLog.d(CommentFragment.class, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		MyLog.d(CommentFragment.class, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_comment, container,
				false);
		mListView = (PullToRefreshListView) view
				.findViewById(R.id.listview_platform);
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
	
	private OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
			Intent intent = new Intent();
			intent.setClass(getActivity(), CommentDetailActivity.class);
			startActivity(intent);
		}
	};
	
	private void initDatas() {
		commentList = new ArrayList<Comment>();
		addPlatform();
		mAdapter = new CommentListAdapter(getActivity(),commentList);
		mListView.setAdapter(mAdapter);

		//设置点击事件
		mListView.setOnItemClickListener(onItemClickListener);
	}
	
	private void addPlatform(){
		if(null == commentList){
			commentList = new ArrayList<Comment>();
		}
		Comment infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-07",6666);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-11-07",6676);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-11-07",6636);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-06-07",6626);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-08",6616);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-09",6686);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-05",6626);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-04",6666);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-03",6666);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-02",6666);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-01",6666);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-07",6666);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-07",6666);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-07",6666);
		commentList.add(infor);
		infor = new Comment("http://192.168.1.199/08/2015-08-20_14_56_29200002_s.jpg","砸钱圈地为哪般 P2P疑被对赌倒逼","券商、地产、石墨烯概念股涨幅居前，军工股普跌","2015-12-07",6666);
		commentList.add(infor);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		MyLog.d(CommentFragment.class, "onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		MyLog.d(CommentFragment.class, "onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		MyLog.d(CommentFragment.class, "onResume");
		super.onResume();

	}

	@Override
	public void onPause() {
		MyLog.d(CommentFragment.class, "onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		MyLog.d(CommentFragment.class, "onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		MyLog.d(CommentFragment.class, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		MyLog.d(CommentFragment.class, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		MyLog.d(CommentFragment.class, "onDetach");
		super.onDetach();
	}
}
