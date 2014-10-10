package com.paopao.android.lycheepark.activity;


import com.paopao.android.lycheepark.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


/**
 * 主界面
 * @author yongdaimi
 * @remark 
 * @date 2014-10-9 上午09:56:19
 * @company Copyright ©PaoPao.Inc. All Rights Reserved.
 */
public class MainActivity extends BaseActivity {

	private Button main_publish_part_time_job;
	private Button main_find_person;
	private Button main_message_notice;
	private Button main_manager_job;
	
	private ImageView main_user_icon;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	
	
	@Override
	protected void setListener() {
		main_publish_part_time_job.setOnClickListener(this);
		main_find_person.setOnClickListener(this);
		main_message_notice.setOnClickListener(this);
		main_manager_job.setOnClickListener(this);
		main_user_icon.setOnClickListener(this);
	}

	@Override
	protected void init() {
		main_publish_part_time_job = getView(R.id.main_publish_part_time_job);
		main_find_person = getView(R.id.main_find_person);
		main_message_notice = getView(R.id.main_message_notice);
		main_manager_job = getView(R.id.main_manager_job);
		main_user_icon = getView(R.id.main_user_icon);
	}

	@Override
	protected void setContainer() {
		setContentView(R.layout.activity_main);
	}
	
	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		// 发布兼职
		case R.id.main_publish_part_time_job:
			startActivity(new Intent(getApplicationContext(),PublishPartTimeJobActivity.class));
			break;
		// 找人
		case R.id.main_find_person:
			startActivity(new Intent(getApplicationContext(),FindPersonActivity.class));
			break;
		// 消息通知
		case R.id.main_message_notice:
			startActivity(new Intent(getApplicationContext(),MessageActivity.class));
			break;
		// 职位管理
		case R.id.main_manager_job:
			startActivity(new Intent(getApplicationContext(),JobManagerActivity.class));
			break;
		// 个人中心
		case R.id.main_user_icon:
			startActivity(new Intent(getApplicationContext(),SetMyInfoActivity.class));
			break;

		default:
			break;
		}
	}
	

}
