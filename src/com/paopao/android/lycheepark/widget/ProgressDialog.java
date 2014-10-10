package com.paopao.android.lycheepark.widget;



import com.paopao.android.lycheepark.R;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * 通用 普通进度框
 * @author yongdaimi
 * @description 
 * @date 2014-8-25 下午01:42:06
 */
public class ProgressDialog extends Dialog {


	private ImageView common_progress_dialog_img;
	private TextView common_progress_dialog_tv;
	
	public ProgressDialog(Context context) {
		this(context,R.style.common_progress_dialog);
	}

	public ProgressDialog(Context context, int theme) {
		super(context, theme);
		View view = LayoutInflater.from(context).inflate(R.layout.common_progress_dialog, null);
		common_progress_dialog_img = (ImageView) view.findViewById(R.id.common_progress_dialog_img);
		common_progress_dialog_tv = (TextView) view.findViewById(R.id.common_progress_dialog_tv);
		Animation animation = AnimationUtils.loadAnimation(context, R.anim.common_progress_dialog_loading);
		common_progress_dialog_img.setAnimation(animation);
		setContentView(view);
	}
	
	
	public void setMessage(int resId) {
		common_progress_dialog_tv.setText(resId);
	}
	
	public void setMessage(String msg) {
		common_progress_dialog_tv.setText(msg);
	}
	
}
