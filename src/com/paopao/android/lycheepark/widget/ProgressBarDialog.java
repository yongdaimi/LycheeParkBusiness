package com.paopao.android.lycheepark.widget;

import java.text.NumberFormat;

import com.paopao.android.lycheepark.R;



import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 通用 水平进度条
 * 
 * @author yongdaimi
 * @description
 * @date 2014-8-25 下午01:43:29
 */
public class ProgressBarDialog extends Dialog {

	private Handler mViewUpdateHandler;
	private Context mContext;

	private ProgressBar mProgress;
	private TextView mProgressNumber;
	private TextView mProgressPercent;
	private TextView mMessageView;

	private String mProgressNumberFormat;

	private NumberFormat mProgressPercentFormat;

	private int mMax;
	private int mProgressVal;
	private int mIncrementBy;

	private CharSequence mMessage;

	private boolean mHasStarted;

	public ProgressBarDialog(Context context) {
		this(context, R.style.common_progress_dialog);
	}

	public ProgressBarDialog(Context context, int theme) {
		super(context, theme);
		this.mContext = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LayoutInflater mInflater = LayoutInflater.from(mContext);
		mViewUpdateHandler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				/* Update the number and percent */
				int progress = mProgress.getProgress();
				int max = mProgress.getMax();
				double percent = (double) progress / (double) max;
				String format = mProgressNumberFormat;
				mProgressNumber.setText(String.format(format, progress, max));
				SpannableString tmp = new SpannableString(
						mProgressPercentFormat.format(percent));
				tmp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0,
						tmp.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				mProgressPercent.setText(tmp);
			}

		};

		View view = mInflater
				.inflate(R.layout.common_progress_bar_dialog, null);
		mProgress = (ProgressBar) view
				.findViewById(R.id.common_progress_bar_dialog_progress);
		mProgressPercent = (TextView) view
				.findViewById(R.id.common_progress_bar_dialog_progress_percent);
		mProgressNumber = (TextView) view
				.findViewById(R.id.common_progress_bar_dialog_progress_number);
		mMessageView = (TextView) view
				.findViewById(R.id.common_progress_bar_dialog_title);
		mProgressNumberFormat = "%d/%d";
		mProgressPercentFormat = NumberFormat.getPercentInstance();
		mProgressPercentFormat.setMaximumFractionDigits(0);
		setContentView(view);

		if (mMax > 0) {
			setMax(mMax);
		}

		if (mProgressVal > 0) {
			setProgress(mProgressVal);
		}

		if (mIncrementBy > 0) {
			incrementProgressBy(mIncrementBy);
		}

		if (mMessage != null) {
			setMessage(mMessage);
		}

		onProgressChanged();
	}

	@Override
	protected void onStart() {
		super.onStart();
		mHasStarted = true;
	}

	@Override
	protected void onStop() {
		super.onStop();
		mHasStarted = false;
	}

	public void setMax(int max) {
		if (mProgress != null) {
			mProgress.setMax(max);
			onProgressChanged();
		} else {
			mMax = max;
		}
	}

	public int getMax() {
		if (mProgress != null) {
			return mProgress.getMax();
		}
		return mMax;
	}

	public void setProgress(int value) {
		if (mHasStarted) {
			mProgress.setProgress(value);
			onProgressChanged();
		} else {
			mProgressVal = value;
		}

	}

	public int getProgress() {
		if (mProgress != null) {
			return mProgress.getProgress();
		}
		return mProgressVal;
	}

	public void setMessage(CharSequence message) {
		if (mProgress != null) {
			mMessageView.setText(message);
		} else {
			mMessage = message;
		}
	}

	public void setMessage(int resId) {
		if (mProgress != null) {
			mMessageView.setText(mContext.getString(resId));
		} else {
			mMessage = mContext.getString(resId);
		}
	}

	public void incrementProgressBy(int diff) {
		if (mProgress != null) {
			mProgress.incrementProgressBy(diff);
			onProgressChanged();
		} else {
			mIncrementBy += diff;
		}
	}

	private void onProgressChanged() {
		mViewUpdateHandler.sendEmptyMessage(0);
	}

}