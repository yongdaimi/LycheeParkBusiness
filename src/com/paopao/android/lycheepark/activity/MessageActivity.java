package com.paopao.android.lycheepark.activity;

import android.view.View;
import android.widget.Button;

import com.paopao.android.lycheepark.R;

/**
 * 消息通知
 * @author yongdaimi
 * @remark 
 * @date 2014-10-10 下午02:38:09
 * @company Copyright ©PaoPao.Inc. All Rights Reserved.
 */
public class MessageActivity extends BaseActivity{

	
	private Button message_clear;
	private Button message_finish;
	
	@Override
	protected void setContainer() {
		
		setContentView(R.layout.activity_message);
		
	}

	@Override
	protected void setListener() {
		message_clear.setOnClickListener(this);
		message_finish.setOnClickListener(this);
	}

	@Override
	protected void init() {
		message_clear = getView(R.id.message_clear);
		message_finish = getView(R.id.message_finish);
		
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		// 清除消息
		case R.id.message_clear:
			
			break;
		// 关闭
		case R.id.message_finish:
			finish();
			break;

		default:
			break;
		}
	}
	
}
