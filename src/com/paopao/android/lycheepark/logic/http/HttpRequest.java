package com.paopao.android.lycheepark.logic.http;

import org.json.JSONException;

public abstract class HttpRequest {

	protected String requestParas = "";

	protected String responseContent;

	protected int resultCode = -1;

	protected int requestType;

	public static final String BASE_URL = "http://61.160.251.76:89/CRM.ashx"; // http://61.160.251.76:89/CRM.ashx
	// http://112.22.26.30:84/CRM.ashx
	public static String BUSINESS_URL = "";

	public static String CONNECTION_STRING = "";

	// public static final String R_PATH = "http://down.ylife.cn/";

	// public static final String APK_PATH = "http://app.ylife.cn";

	public static final String HEAD_ICON_DOWNLOAD_PATH = "http://61.160.251.153:77/userIcon/";// http://61.160.251.76:90/userIcon/

	public static final String PIC_DOWNLOAD_PATH = "http://61.160.251.153:77/pic/";// http://61.160.251.76:90/pic/咨询

	public static final String HEAD_ICON_UPLOAD_PATH = "http://61.160.251.153:66/UserIcon.ashx";// http://61.160.251.76:88/UserIcon.ashx

	public static final String PIC_UPLOAD_PATH = "http://61.160.251.153:66/upload.ashx";// http://61.160.251.76:88/upload.ashx
	// http://192.168.1.222/upload.ashx
	public static String token;

	public static String serviceToken;

	public boolean valid = true;

	public static String resUrl;

	public static String dailshow_PIC = "http://61.160.251.153:77/";// 获取货架陈列图片
																	// http://192.168.1.222:87
																	// http://61.160.251.76:90/
	public static String plan_pic_uploadUrl = "http://61.160.251.153:66/file.ashx";
	public static String plan_dowloadUrlString = "http://61.160.251.153:77/workpic/";
	public static String database_downloadURL = "";// 数据库下载

	/**
	 * 
	 * 
	 * @throws JSONException
	 */
	public abstract void createRequestBody() throws JSONException;

	/**
	 *  
	 */
	public abstract void parseResponse() throws JSONException;

	public abstract String getUrl();

	public String getRequestParas() {
		return requestParas;
	}

	public int getRequestType() {
		return requestType;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public void cancelRequest() {
		valid = false;
	}

	public void activeRequest() {
		valid = true;
	}

	public boolean isValid() {
		return valid;
	}

}
