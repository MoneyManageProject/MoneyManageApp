/**
 * 
 */
package com.money.android.platform;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.money.android.R;
import com.money.android.common.custom.SelectView;

/**
 * @author ChenHongLi
 *
 */
public class PlatformSelectView extends LinearLayout{
	
	private SelectView svOnlineTime,svSecurityMode,svAverageIncome,svScore;

    private List<String> listOnlineTime = new ArrayList<String>();
    private List<String> listSecurityMode = new ArrayList<String>();
    private List<String> listAverageIncome = new ArrayList<String>();
    private List<String> listScore = new ArrayList<String>();
    
	public PlatformSelectView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	private void init(){
		initView();
		initData();
		initListener();
	}
	
	private void initView(){
		LayoutInflater.from(getContext()).inflate(R.layout.view_platform_select, this);
		svOnlineTime			= (SelectView)findViewById(R.id.sv_platform_online_time);
		svSecurityMode			= (SelectView)findViewById(R.id.sv_platform_security_mode);
		svAverageIncome			= (SelectView)findViewById(R.id.sv_platform_average_income);
		svScore					= (SelectView)findViewById(R.id.sv_platform_score);
	}
	
	@SuppressWarnings("unchecked")
	private void initData(){
		addOnlineTimeList();
		svOnlineTime.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.view_selectview_item, listOnlineTime));
		((ArrayAdapter<String>)svOnlineTime.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		addSecurityModeList();
		svSecurityMode.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.view_selectview_item, listSecurityMode));
		((ArrayAdapter<String>)svSecurityMode.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		svSecurityMode.setSelection(0);
		
		addAverageIncome();
		svAverageIncome.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.view_selectview_item, listAverageIncome));
		((ArrayAdapter<String>)svAverageIncome.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		svAverageIncome.setSelection(0);
		
		addScore();
		svScore.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.view_selectview_item, listScore));
		((ArrayAdapter<String>)svScore.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		svScore.setSelection(0);
	}
	
	private void initListener(){
		svOnlineTime.setOnItemSelectedListener(onItemSelectedListener);
		svOnlineTime.setSelection(0,true);
		svSecurityMode.setOnItemSelectedListener(onItemSelectedListener);
		svSecurityMode.setSelection(0,true);
		svAverageIncome.setOnItemSelectedListener(onItemSelectedListener);
		svAverageIncome.setSelection(0,true);
		svScore.setOnItemSelectedListener(onItemSelectedListener);
		svScore.setSelection(0,true);
	}
	
	private OnItemSelectedListener onItemSelectedListener = new Spinner.OnItemSelectedListener() {    
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {    
            /* 将mySpinner 显示*/    
            arg0.setVisibility(View.VISIBLE);
            arg1.setVisibility(View.VISIBLE);
            ((TextView)arg1).setTextColor(getContext().getResources().getColor(R.color.black));
            ((TextView)arg1).setTextSize(10);
        }    
        public void onNothingSelected(AdapterView<?> arg0) {
            arg0.setVisibility(View.VISIBLE);
        }    
    };
	
	private void addOnlineTimeList(){
		for(int i = 0;i < 15;i++){
			listOnlineTime.add((2007 + i) + "");
		}
	}
	
	private void addSecurityModeList(){
		listSecurityMode.add("平台自有资金");
		listSecurityMode.add("平台风险准本金");
		listSecurityMode.add("保险公司");
		listSecurityMode.add("融资性担保公司");
		listSecurityMode.add("非融资性担保公司");
		listSecurityMode.add("小贷公司");
		listSecurityMode.add("其他");
	}
	
	private void addAverageIncome(){
		listAverageIncome.add("低于8%");
		listAverageIncome.add("8% ~ 12%");
		listAverageIncome.add("12% ~ 16%");
		listAverageIncome.add("16% ~ 20%");
		listAverageIncome.add("20%以上");
	}
	
	private void addScore(){
		listScore.add("1");
		listScore.add("2");
		listScore.add("3");
		listScore.add("4");
		listScore.add("5");
	}
	
}
