package com.paopao.android.lycheepark.activity;


import com.paopao.android.lycheepark.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * 登录界面
 * @author yongdaimi
 * @remark 
 * @date 2014-10-9 上午10:00:58
 * @company Copyright ©PaoPao.Inc. All Rights Reserved.
 */


public class LoginActivity extends BaseActivity {


	private EditText login_username;
	private EditText login_password;
	private Button login;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_login);
		super.onCreate(savedInstanceState);
	}
	
	
	
	@Override
	protected void setContainer() {
		setContentView(R.layout.activity_login);
	}
	
	
	@Override
	protected void setListener() {
		login.setOnClickListener(this);
	}

	
	
	
	@Override
	protected void init() {
		
		login_username = getView(R.id.login_username);
		login_password = getView(R.id.login_password);
		login = getView(R.id.login);
		
	}

	
	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		// 登录
		case R.id.login:
			
			break;

		default:
			break;
		}
	}


	


}
