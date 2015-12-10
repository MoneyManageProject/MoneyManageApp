/**
 * 
 */
package com.money.android.subject;

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
public class SubjectSelectView extends LinearLayout{
	
	private SelectView svInvestmentMoney,svInvestmentTime,svExpectReturn,svRisk;

    private List<String> listInvestmentMoney = new ArrayList<String>();
    private List<String> listInvestmentTime = new ArrayList<String>();
    private List<String> listExpectReturn = new ArrayList<String>();
    private List<String> listRisk = new ArrayList<String>();
    
	public SubjectSelectView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	private void init(){
		initView();
		initData();
		initListener();
	}
	
	private void initView(){
		LayoutInflater.from(getContext()).inflate(R.layout.view_subject_select, this);
		svInvestmentMoney			= (SelectView)findViewById(R.id.sv_subject_investment_money);
		svInvestmentTime			= (SelectView)findViewById(R.id.sv_subject_investment_time);
		svExpectReturn				= (SelectView)findViewById(R.id.sv_subject_expect_return);
		svRisk						= (SelectView)findViewById(R.id.sv_subject_risk);
	}
	
	@SuppressWarnings("unchecked")
	private void initData(){
		addOnlineTimeList();
		svInvestmentMoney.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, listInvestmentMoney));
		((ArrayAdapter<String>)svInvestmentMoney.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		addSecurityModeList();
		svInvestmentTime.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, listInvestmentTime));
		((ArrayAdapter<String>)svInvestmentTime.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		svInvestmentTime.setSelection(0);
		
		addAverageIncome();
		svExpectReturn.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, listExpectReturn));
		((ArrayAdapter<String>)svExpectReturn.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		svExpectReturn.setSelection(0);
		
		addScore();
		svRisk.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, listRisk));
		((ArrayAdapter<String>)svRisk.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		svRisk.setSelection(0);
	}
	
	private void initListener(){
		svInvestmentMoney.setOnItemSelectedListener(onItemSelectedListener);
		svInvestmentMoney.setSelection(0,true);
		svInvestmentTime.setOnItemSelectedListener(onItemSelectedListener);
		svInvestmentTime.setSelection(0,true);
		svExpectReturn.setOnItemSelectedListener(onItemSelectedListener);
		svExpectReturn.setSelection(0,true);
		svRisk.setOnItemSelectedListener(onItemSelectedListener);
		svRisk.setSelection(0,true);
	}
	
	private OnItemSelectedListener onItemSelectedListener = new Spinner.OnItemSelectedListener() {    
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {    
            /* 将mySpinner 显示*/    
            arg0.setVisibility(View.VISIBLE);
            arg1.setVisibility(View.VISIBLE);
            ((TextView)arg1).setTextColor(getContext().getResources().getColor(R.color.black));
            ((TextView)arg1).setTextSize(12);
        }    
        public void onNothingSelected(AdapterView<?> arg0) {
            arg0.setVisibility(View.VISIBLE);
        }    
    };
	
	private void addOnlineTimeList(){
		listInvestmentMoney.add("0~5万元");
		listInvestmentMoney.add("5~10万元");
		listInvestmentMoney.add("10~20万元");
		listInvestmentMoney.add("20~50万元");
		listInvestmentMoney.add("50万元以上");
	}
	
	private void addSecurityModeList(){
		listInvestmentTime.add("1~3个月");
		listInvestmentTime.add("3~6个月");
		listInvestmentTime.add("6~12个月");
		listInvestmentTime.add("1年~2年");
		listInvestmentTime.add("2年以上");
	}
	
	private void addAverageIncome(){
		listExpectReturn.add("低于8%");
		listExpectReturn.add("8% ~ 12%");
		listExpectReturn.add("12% ~ 16%");
		listExpectReturn.add("16% ~ 20%");
		listExpectReturn.add("20%以上");
	}
	
	private void addScore(){
		for(int i = 0;i < 5;i++){
			listRisk.add(i + "");
		}
	}
	
}
