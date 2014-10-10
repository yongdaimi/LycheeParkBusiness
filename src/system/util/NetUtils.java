package system.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络工具
 * @author yongdaimi
 * @date 2014-8-19 下午05:26:26
 */
public class NetUtils {


	/**
	 * 验证当前网络状态
	 * @param context
	 * @return
	 */
	public static boolean checkNet(Context context) {
		
		boolean wifiConnected = isWIFIConnected(context);
		boolean mobileConnected = isMOBILEConnected(context);
		if (wifiConnected==false & mobileConnected==false) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * 判断WIFI是否连通
	 * @param context
	 * @return
	 */
	public static boolean isWIFIConnected(Context context) {
		
		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断GPRS是否连通
	 * @param context
	 * @return
	 */
	public static boolean isMOBILEConnected(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		}
		return false;
	}
	
}
