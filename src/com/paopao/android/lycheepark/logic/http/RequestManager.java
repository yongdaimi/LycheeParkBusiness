package com.paopao.android.lycheepark.logic.http;

import android.content.Context;
import android.os.Message;

public class RequestManager {

	/**
	 * 
	 * @param context
	 * @param request
	 * @param message
	 */
	public static void sendRequest(Context context, HttpRequest request,
			Message message) {

		HttpUtil.sendRequest(context, request, message);
	}
}
