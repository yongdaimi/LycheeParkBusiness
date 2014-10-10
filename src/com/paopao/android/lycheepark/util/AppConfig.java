package com.paopao.android.lycheepark.util;

public class AppConfig {

	public static boolean debugMode = false;

	public static String version;

	public static final String ACTION_MESSAGE_SIGN = "com.wesley.action.sign";
	public static final String ACTION_MESSAGE_UPDATE_MONEY = "com.wesley.action.moneyupdate";
	public static final String ACTION_MESSAGE_UPDATE_ORDER = "com.wesley.action.order";
	public static final String ACTION_MESSAGE_REFASH_Order = "com.wesley.action.refashrule_order";
	public static final String ACTION_MESSAGE_CLOSE_CLOCK = "com.wesley.action.close_clock";
	public static final String ACTION_MESSAGE_RELOGIN = "com.wesley.action.relogin";
	public static final String ACTION_MESSAGE_UPLOAD_OFFLINE_PICTURE = "com.ylife.action.upload.offline.picture";

	public static final String ACTION_MESSAGE_Sign_refash = "com.wesley.action.Sign_refash";
	public static final String ACTION_MESSAGE_VISIT_SIGN = "com.wesley.action.visit_sign";
	// public static final String ACTION_MESSAGE_REFASH_AA =
	// "com.wesley.action.refashaa";
	public static final String ACTION_MESSAGE_TEAM_REPORT = "com.wesley.action.teamreport";
	public static final int gps_Radius = 200;// 精度圈
	public static final int timeOut = 20;// 定位超时时间
	/**
	 * 小红星显示周期
	 * */
	public static int visitDay = 30;
}
