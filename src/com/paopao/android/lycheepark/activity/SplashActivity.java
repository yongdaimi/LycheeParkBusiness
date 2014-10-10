package com.paopao.android.lycheepark.activity;

import com.paopao.android.lycheepark.R;
import com.paopao.android.lycheepark.logic.http.RequestKey;
import com.paopao.android.lycheepark.logic.http.RequestManager;
import com.paopao.android.lycheepark.logic.http.impl.CheckUpdateRequest;
import com.paopao.android.lycheepark.util.FileHelper;
import com.paopao.android.lycheepark.util.Updater;
import com.paopao.android.lycheepark.widget.AlertDialog;
import com.paopao.android.lycheepark.widget.ProgressDialog;



import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

/*
 * 闪屏
 */
public class SplashActivity extends Activity {

	private CheckUpdateRequest mCheckUpdateRequest;
	private ProgressDialog updateProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		// 检查更新
		checkUpdate();
	}

	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			int httpCode = msg.getData().getInt(RequestKey.HTTP_CODE);
			switch (msg.what) {
			case 1:
				if (httpCode == 200) {
					int resultCode = mCheckUpdateRequest.getResultCode();
					if (resultCode == 0) {
						// new version found
						if (mCheckUpdateRequest.getNeedUpdateCode() == 1) {
							showUpdateDialog(mCheckUpdateRequest.getDesc());
						} else {
								Toast.makeText(getApplicationContext(),getString(R.string.current_is_new_version),
										Toast.LENGTH_SHORT).show();
								loginMainUI();
						}
					} else {
						Toast.makeText(getApplicationContext(),getString(R.string.current_is_new_version),
								Toast.LENGTH_SHORT).show();
						loginMainUI();
					}
				} else {
					Toast.makeText(getApplicationContext(),getString(R.string.current_is_new_version),
							Toast.LENGTH_SHORT).show();
					loginMainUI();
				}
				break;

			default:
				break;
			}
		}

	};

	private void checkUpdate() {
		mCheckUpdateRequest = new CheckUpdateRequest();
		RequestManager.sendRequest(getApplicationContext(),
				mCheckUpdateRequest, mHandler.obtainMessage(1));
	}

	
	private Handler updateHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case Updater.UPDATE_PROGRESS:
				int progress = (Integer) msg.obj;
				updateProgressDialog.setMessage(getString(R.string.is_updating)+ progress + "%");
				break;
			case Updater.UPDATE_EXCEPTION:
				updateProgressDialog.dismiss();
				break;
			case Updater.FILE_DOWNLOAD_SUCCESS:
				FileHelper.installApkFile(getApplicationContext(),Updater.absupdateFilePath);
				updateProgressDialog.dismiss();
				finish();
				break;
			default:
				break;
			}
		};
	};
	
	
	
	/**
	 * 显示更新对话框
	 */
	private void showUpdateDialog(String info) {
		final AlertDialog myAlertDialog = new AlertDialog(this);
		myAlertDialog.setCancelable(false);
		myAlertDialog.setTitle(R.string.tip);
		myAlertDialog.setMessage(info);
		myAlertDialog.setPositiveButton(getString(R.string.confirm),
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						myAlertDialog.dismiss();
						downloadUpdateApk(updateHandler, mCheckUpdateRequest.getUpdateUrl());
					}
				});
		myAlertDialog.setNegativeButton(getString(R.string.cancel),
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						myAlertDialog.dismiss();
						finish();
					}
				});
	}

	
	private void downloadUpdateApk(Handler handler, String url) {
		updateProgressDialog = new ProgressDialog(this);
		updateProgressDialog.setTitle(getString(R.string.is_updating));
		updateProgressDialog.setCancelable(false);
		updateProgressDialog.setCanceledOnTouchOutside(false);
		updateProgressDialog.show();
		Updater updater = new Updater(handler, url);
		updater.startdownLoadupdate();
	}
	
	
	
	/**
	 * 载入主界面UI
	 */
	private void loginMainUI() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}

}
