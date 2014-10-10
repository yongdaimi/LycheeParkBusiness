package com.paopao.android.lycheepark.activity;

import android.view.View;
import android.widget.Button;

import com.paopao.android.lycheepark.R;

/**
 * 职位管理
 * @author yongdaimi
 * @remark 
 * @date 2014-10-10 下午05:00:08
 * @company Copyright ©PaoPao.Inc. All Rights Reserved.
 */
public class JobManagerActivity extends BaseActivity {

	private Button job_manager_finish;
	
	@Override
	protected void setContainer() {
		setContentView(R.layout.activity_job_manager);
	}

	@Override
	protected void setListener() {
		job_manager_finish.setOnClickListener(this);

	}

	@Override
	protected void init() {
		job_manager_finish = getView(R.id.job_manager_finish);

	}
	
	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		// 关闭
		case R.id.job_manager_finish:
			finish();
			break;

		default:
			break;
		}
	}

}
