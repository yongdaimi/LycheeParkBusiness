package com.paopao.android.lycheepark.logic.http;

import com.paopao.android.lycheepark.logic.http.HttpUtil.RequestRunnable;


public class RequestThread extends Thread {
	
	private RequestRunnable runnable;

	public RequestThread(Runnable runnable) {
		super();
		this.runnable = (RequestRunnable) runnable;
	}

	public void sendToServer() {
		this.start();
	}

	@Override
	public void run() {
		runnable.run();
	}

}
