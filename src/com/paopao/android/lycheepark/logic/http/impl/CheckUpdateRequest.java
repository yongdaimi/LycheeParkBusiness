package com.paopao.android.lycheepark.logic.http.impl;

import org.json.JSONException;
import org.json.JSONObject;


import com.paopao.android.lycheepark.logic.http.HttpRequest;
import com.paopao.android.lycheepark.logic.http.RequestKey;
import com.paopao.android.lycheepark.util.AES;
import com.paopao.android.lycheepark.util.AppConfig;


public class CheckUpdateRequest extends HttpRequest {
	
	private int mNeedUpdateCode = 1;
	private int mForceUpdateCode = 1;

	private String mUpdateUrl;

	private String desc;

	@Override
	public void createRequestBody() throws JSONException {
		JSONObject rootObject = new JSONObject();
		rootObject.put(RequestKey.REQUEST_TYPE, "checkUpdate");
		rootObject.put(RequestKey.CHECKUPDATE_VERSION, AppConfig.version);
		rootObject.put("Platform", "android");
		requestParas = AES.encrypt(rootObject.toString(), AES.KEY);
	}

	@Override
	public void parseResponse() throws JSONException {
		JSONObject rootObject = new JSONObject(responseContent);
		resultCode = Integer.valueOf(rootObject
				.getString(RequestKey.RESULT_CODE));
		if (resultCode == 0) {
			mNeedUpdateCode = Integer.valueOf(rootObject
					.getString(RequestKey.CHECKUPDATE_NEED_UPDATE));
			if (mNeedUpdateCode == 1) {
				mUpdateUrl = AES.decrypt(
						rootObject.getString(RequestKey.UPDATE_DOWNLOADURL),
						AES.KEY);
				desc = rootObject.getString(RequestKey.CHECKUPDATE_UPDATE_DESC);
			}
		}
	}

	@Override
	public String getUrl() {
		return BASE_URL;
	}

	public int getNeedUpdateCode() {
		return mNeedUpdateCode;
	}

	public int getForceUpdateCode() {
		return mForceUpdateCode;
	}

	public String getUpdateUrl() {
		return mUpdateUrl;
	}

	public String getDesc() {
		return desc;
	}

}
