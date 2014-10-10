package com.paopao.android.lycheepark.activity;

import android.view.View;
import android.widget.Button;

import com.paopao.android.lycheepark.R;

/**
 * 发布兼职
 * @author yongdaimi
 * @remark 
 * @date 2014-10-10 下午02:38:09
 * @company Copyright ©PaoPao.Inc. All Rights Reserved.
 */
public class PublishPartTimeJobActivity extends BaseActivity{

	
	private Button publish_part_time_job;
	private Button publish_part_time_finish;
	
	@Override
	protected void setContainer() {
		
		setContentView(R.layout.activity_publish_part_time_job);
		
	}

	@Override
	protected void setListener() {
		publish_part_time_job.setOnClickListener(this);
		publish_part_time_finish.setOnClickListener(this);
	}

	@Override
	protected void init() {
		publish_part_time_job = getView(R.id.publish_part_time_job);
		publish_part_time_finish = getView(R.id.publish_part_time_finish);
		
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		// 发布兼职
		case R.id.publish_part_time_job:
			
			break;
		// 关闭
		case R.id.publish_part_time_finish:
			finish();
			break;

		default:
			break;
		}
	}
	
}
