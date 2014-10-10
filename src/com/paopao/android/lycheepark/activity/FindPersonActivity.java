package com.paopao.android.lycheepark.activity;

import android.view.View;
import android.widget.Button;

import com.paopao.android.lycheepark.R;

/**
 * 找人
 * @author yongdaimi
 * @remark 
 * @date 2014-10-10 下午02:38:09
 * @company Copyright ©PaoPao.Inc. All Rights Reserved.
 */
public class FindPersonActivity extends BaseActivity{

	
	private Button find_person_look_up;
	private Button find_person_finish;
	
	@Override
	protected void setContainer() {
		
		setContentView(R.layout.activity_find_person);
		
	}

	@Override
	protected void setListener() {
		find_person_look_up.setOnClickListener(this);
		find_person_finish.setOnClickListener(this);
	}

	@Override
	protected void init() {
		find_person_look_up = getView(R.id.find_person_look_up);
		find_person_finish = getView(R.id.find_person_finish);
		
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		// 筛选
		case R.id.find_person_look_up:
			
			break;
		// 关闭
		case R.id.find_person_finish:
			finish();
			break;

		default:
			break;
		}
	}
	
}
