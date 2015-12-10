/**
 * 
 */
package com.money.android.comment;

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
public class CommentSelectView extends LinearLayout{
	
	private SelectView svHot,svTime,svEssence,svPlate;

    private List<String> listHot = new ArrayList<String>();
    private List<String> listTime = new ArrayList<String>();
    private List<String> listEssence = new ArrayList<String>();
    private List<String> listPlate = new ArrayList<String>();
    
	public CommentSelectView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	private void init(){
		initView();
		initData();
		initListener();
	}
	
	private void initView(){
		LayoutInflater.from(getContext()).inflate(R.layout.view_comment_select, this);
		svHot				= (SelectView)findViewById(R.id.sv_comment_hot);
		svTime				= (SelectView)findViewById(R.id.sv_comment_time);
		svEssence			= (SelectView)findViewById(R.id.sv_comment_essence);
		svPlate				= (SelectView)findViewById(R.id.sv_comment_plate);
	}
	
	@SuppressWarnings("unchecked")
	private void initData(){
		addHotList();
		svHot.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, listHot));
		((ArrayAdapter<String>)svHot.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		addTimeList();
		svTime.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, listTime));
		((ArrayAdapter<String>)svTime.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		svTime.setSelection(0);
		
		addEssenceList();
		svEssence.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, listEssence));
		((ArrayAdapter<String>)svEssence.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		svEssence.setSelection(0);
		
		addPlateList();
		svPlate.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, listPlate));
		((ArrayAdapter<String>)svPlate.getAdapter()).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		svPlate.setSelection(0);
	}
	
	private void initListener(){
		svHot.setOnItemSelectedListener(onItemSelectedListener);
		svHot.setSelection(0,true);
		svTime.setOnItemSelectedListener(onItemSelectedListener);
		svTime.setSelection(0,true);
		svEssence.setOnItemSelectedListener(onItemSelectedListener);
		svEssence.setSelection(0,true);
		svPlate.setOnItemSelectedListener(onItemSelectedListener);
		svPlate.setSelection(0,true);
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
	
	private void addHotList(){
		listHot.add("最热10");
		listHot.add("最热20");
		listHot.add("最热30");
	}
	
	private void addTimeList(){
		listTime.add("最近1天");
		listTime.add("最近2天");
		listTime.add("最近3天");
		listTime.add("最近7天");
	}
	
	private void addEssenceList(){
		listEssence.add("精华帖");
		listEssence.add("水贴");
	}
	
	private void addPlateList(){
		listPlate.add("投资");
		listPlate.add("曝光");
		listPlate.add("公告");
		listPlate.add("活动");
		listPlate.add("行业");
		listPlate.add("投诉");
	}
	
}
