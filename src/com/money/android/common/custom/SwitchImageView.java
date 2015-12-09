/**
 * 
 */
package com.money.android.common.custom;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.money.android.R;
import com.zero.zerolib.cache.SyncCommonLocalLoadImage2;

/**
 * 图片轮播自定义控件，可以直接java 新建一个对象，也可用于xml文件，在xml中使用时需注意，必须进行初始化（即调用init方法）才可使用
 * 轮播采用循环播放功能，并具备dot显示
 * @author ChenHongLi
 *
 */
public class SwitchImageView extends RelativeLayout{
	/**当前显示的页*/
	private  int currPage = 0;
	/**viewPager的适配器*/
	private SwitchImageAdapter  adapter;
	private ViewPager viewPager;
	/**dot父层级*/
	private LinearLayout dotContainer;
	private ArrayList<String> imagePathList;
	/**保存所有生成的dot，以便对他们进行UI修改*/
	private ArrayList<SwitchImageDotView> dotViewList;
	/**滚动时间设置工具*/
	private FixedSpeedScroller scroller=null;
	/**滚动动画时间*/
	private final int SCROLL_TIME = 1000;
	/**滚动间隔时间*/
	private final int SCROLL_INTERVAL_TIME = 5000;
	public SwitchImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SwitchImageView(Context context,ArrayList<String> imagePathList) {
		super(context);
		init(imagePathList);
	}
	
	public void init(ArrayList<String> imagePathList){
		this.imagePathList = imagePathList;
		initView();
		initData();
		initListener();
	}
	
	private void initView(){
		LayoutInflater.from(getContext()).inflate(R.layout.view_switch_image, this);
		dotContainer = (LinearLayout)findViewById(R.id.switch_image_dot_container);
		viewPager = (ViewPager)findViewById(R.id.switch_image_viewpager);
	}
	
	private void initData(){
		//为viewPager设置适配器
		adapter = new SwitchImageAdapter(imagePathList,getContext());
		viewPager.setAdapter(adapter);
		setScrollerTime(SCROLL_TIME);
		initDot();
		//开启定时器，每隔2秒自动播放下一张（通过调用线程实现）
		//设置一个线程，该线程用于通知UI线程变换图片
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new ViewPagerTask(), SCROLL_INTERVAL_TIME, SCROLL_INTERVAL_TIME, TimeUnit.MILLISECONDS);
	}
	
	private void initListener(){
		viewPager.setOnPageChangeListener(pageChangeListener);
	}
	/**
	 * 初始化dot，根据图片数目，并设置第一张为选中状态
	 * */
	private void initDot(){
		int size = imagePathList.size();
		dotViewList = new ArrayList<SwitchImageView.SwitchImageDotView>();
		SwitchImageDotView dotView;
		for(int i = 0;i < size;i++){
			dotView = new SwitchImageDotView(getContext());
			dotContainer.addView(dotView);
			dotViewList.add(dotView);
		}
		dotViewList.get(0).setSelected();
	}
	/**设置所有dot为初始状态*/
	private void reSetAllDot(){
		for(SwitchImageDotView dotView : dotViewList){
			dotView.setNormal();
		}
	}

	//监听ViewPager的变化
	private OnPageChangeListener pageChangeListener = new OnPageChangeListener(){
		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}

		@Override
		public void onPageSelected(int position) {
			//记录的页面
			currPage = position;
			reSetAllDot();
			dotViewList.get(currPage % imagePathList.size()).setSelected();
		}
	};
	private class ViewPagerTask implements Runnable{
		@Override
		public void run() {
			//每次页数加1，保证循环滚动，因为页数已经无限大
//			currPage =(currPage+ 1)%imagePathList.size();
			if(currPage == Integer.MAX_VALUE){
				//如果当前页数超过int最大值则重新置0
				currPage = 0;
			}else{
				currPage++;
			}
			//发送消息给UI线程
			handler.sendEmptyMessage(0);
		}
	}
	
	private Handler handler= new Handler(){
		public void handleMessage(Message msg) {
			//接收到消息后，更新页面
			viewPager.setCurrentItem(currPage);
		};
	};
	/**
	 * 反射修改view pager滚动速度
	 * @param scrollerTime
	 * @author ChenHongLi
	 */
	public void setScrollerTime(int scrollerTime){
		try {
			if(scroller!=null){
				 scroller.setScrollDuration(scrollerTime);
			}else{
				Field mScroller;
	            mScroller = ViewPager.class.getDeclaredField("mScroller");
	            mScroller.setAccessible(true);
	            scroller= new FixedSpeedScroller(viewPager.getContext(),new AccelerateInterpolator());
	            scroller.setScrollDuration(scrollerTime);
	            mScroller.set(viewPager, scroller);
			}
        } catch (Exception e) {
        	Log.d("HongLi", "in setScrollerTime error.");
            e.printStackTrace();
        }
	}
	/**viewpager滚动设置*/
	public class FixedSpeedScroller extends Scroller {
	    private int scrollTime = 1500;
	 
	    public FixedSpeedScroller(Context context) {
	        super(context);
	    }
	 
	    public FixedSpeedScroller(Context context, Interpolator interpolator) {
	        super(context, interpolator);
	    }
	 
	    @Override
	    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
	        // Ignore received duration, use fixed one instead
	        super.startScroll(startX, startY, dx, dy, scrollTime);
	    }
	 
	    @Override
	    public void startScroll(int startX, int startY, int dx, int dy) {
	        // Ignore received duration, use fixed one instead
	        super.startScroll(startX, startY, dx, dy, scrollTime);
	    }
	 
	    public void setScrollDuration(int time) {
	        scrollTime = time;
	    }
	 
	    public int getScrollDuration() {
	        return scrollTime;
	    }
	}
	/**
	 * 图片切换ViewPager的Adapter，设置循环滚动，getCount返回int类型最大值
	 * */
	public class SwitchImageAdapter extends PagerAdapter{
		private ArrayList<String> imageSource;
		private ArrayList<ImageView> imageViewList;
		private Context context;
//		ViewPager每次仅最多加载三张图片（有利于防止发送内存溢出）
		public SwitchImageAdapter(ArrayList<String> imageSource,Context context){
			this.imageSource = imageSource;
			this.context = context;
			imageViewList = new ArrayList<ImageView>();
			initImageView();
		}
		
		private void initImageView(){
			int size = imageSource.size();
			//图片切换不会有太多，因此可以先创建所有的ImageView控件，但不提供图片资源
			ImageView imageView;
			for(int i = 0;i < size;i++){
				imageView = new ImageView(context);
				imageView.setScaleType(ScaleType.FIT_XY);
				imageViewList.add(imageView);
			}
		}
		
		@Override
		public int getCount() {
			//只有一张时不需要滚动
			if(1 == imageViewList.size()){
				return 1;
			}
			//多张需要循环滚动
			return Integer.MAX_VALUE;
		}
		
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			//判断将要显示的图片是否和现在显示的图片是同一个
			//arg0为当前显示的图片，arg1是将要显示的图片
//			Log.e("HongLi", "isViewFromObject:" + (arg0 == arg1));
			return arg0 == arg1;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			//此处不需要调用remove view
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			//初始化将要显示的图片，将该图片加入到container中，即viewPager中
			int realPosition = position % imageViewList.size();
			ImageView imageView = imageViewList.get(realPosition);
			//异步获取图片资源
//			SyncCommonLoadImage.getInstance().loadImage(1, imageSource.get(realPosition), imageView);
			SyncCommonLocalLoadImage2.getInstance().loadImage(imageSource.get(realPosition), imageView, 0);
			//必须remove之后再添加,防止直接添加抛exception，不做任何处理会导致需要显示的view在别的view下层
			container.removeView(imageView);
			container.addView(imageView);
			return imageView;
		}
	}
	/**
	 * 下标图
	 * */
	private class SwitchImageDotView extends ImageView{
		/**置左边距为7px*/
		private final int  LEFT_MARGIN = 7;
		public SwitchImageDotView(Context context) {
			super(context);
			init();
		}
		
		private void init(){
			initData();
			initListener();
		}
		
		private void initData(){
			this.setImageResource(R.drawable.switch_image_dot_normal);
			//设置左边距为7px
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			params.leftMargin = LEFT_MARGIN;
			this.setLayoutParams(params);
		}
		
		private void initListener(){
			//可以设置监听
		}
		
		public void setSelected(){
			this.setImageResource(R.drawable.switch_image_dot_selected);
		}
		
		public void setNormal(){
			this.setImageResource(R.drawable.switch_image_dot_normal);
		}
		
	}
	
}
