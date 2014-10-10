package com.paopao.android.lycheepark.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Activity 基类
 * @author yongdaimi
 * @remark 
 * @date 2014-10-9 上午09:51:21
 * @company Copyright ©PaoPao.Inc. All Rights Reserved.
 */
public abstract class BaseActivity extends Activity implements OnClickListener{
	
	
	protected MyApplication application;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		application = (MyApplication) getApplication();
		setContainer();
		init();
		setListener();
	}
	
	
	/**
	 * 设置界面内容
	 */
	protected abstract void setContainer();
	
	/**
	 * 设置监听
	 */
	protected abstract void setListener();
	
	
	/**
	 * 初始化
	 */
	protected abstract void init();
	
	
	
	/**
	 * 查找界面元素id
	 * @param <T>
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends View> T getView(int id) {
		return (T)findViewById(id);
	}
	
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
