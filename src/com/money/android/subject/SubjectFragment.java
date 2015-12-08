package com.money.android.subject;

import com.money.android.R;
import com.money.android.base.BaseFragment;
import com.money.android.common.util.MyLog;
import com.money.android.widget.PullToRefreshListView;
import com.money.android.widget.PullToRefreshListView.OnLoadMoreListener;
import com.money.android.widget.PullToRefreshListView.OnRefreshListener;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SubjectFragment extends BaseFragment {
	// protected FragmentManager mFragmentManager;
	private PullToRefreshListView mListView;
	private SubjectListAdapter mAdapter;

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {

		};
	};

	@Override
	public void onAttach(Activity activity) {
		MyLog.d(SubjectFragment.class, "onAttach");
		// mFragmentManager = getActivity().getSupportFragmentManager();
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		MyLog.d(SubjectFragment.class, "onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		MyLog.d(SubjectFragment.class, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_subject, container,
				false);
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
		mAdapter = new SubjectListAdapter(getActivity());
		mListView.setAdapter(mAdapter);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		MyLog.d(SubjectFragment.class, "onActivityCreated");
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		MyLog.d(SubjectFragment.class, "onStart");
		super.onStart();
	}

	@Override
	public void onResume() {
		MyLog.d(SubjectFragment.class, "onResume");
		super.onResume();

	}

	@Override
	public void onPause() {
		MyLog.d(SubjectFragment.class, "onPause");
		super.onPause();
	}

	@Override
	public void onStop() {
		MyLog.d(SubjectFragment.class, "onStop");
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		MyLog.d(SubjectFragment.class, "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		MyLog.d(SubjectFragment.class, "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		MyLog.d(SubjectFragment.class, "onDetach");
		super.onDetach();
	}
}
