package com.paopao.android.lycheepark.util;

import android.util.Log;

public final class LogX {

	public static void e(String tag, String message) {
		if (AppConfig.debugMode) {
			Log.e(tag, message);
		}
	}
}
