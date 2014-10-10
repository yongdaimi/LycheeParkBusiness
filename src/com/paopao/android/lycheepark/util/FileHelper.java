package com.paopao.android.lycheepark.util;

import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

public class FileHelper {

	public static final String DOWNLOAD_DIR = "/sdcard/businessexpert";

	public static final String TAG = "FileHelper";

	public static void createDownloadDir() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			File downLoadDir = new File(DOWNLOAD_DIR);
			Log.i("createDownloadDir", "" + downLoadDir.mkdirs());
		} else {

		}
	}

	/**
	 * 
	 * @param fileName
	 */
	public static void deleteDownloadFile(String fileName) {
		String absPath = DOWNLOAD_DIR + fileName;
		File downloadFile = new File(absPath);
		if (downloadFile.exists()) {
			downloadFile.delete();
		} else {
			Log.d(TAG, "file:" + absPath + "not exist!");
		}
	}

	public static int getPercentage(float y, float z) {
		double baiy = y * 1.0;
		double baiz = z * 1.0;
		double fen = (baiy / baiz) * 100;

		return (int) fen;
	}

	public static void installApkFile(Context context, String filePath) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setDataAndType(Uri.fromFile(new File(filePath)),
				"application/vnd.android.package-archive");
		context.startActivity(intent);
	}

	public static void uninstallApkFile(Context context, String packageName) {
		Uri uri = Uri.parse("package:" + packageName);
		Intent intent = new Intent(Intent.ACTION_DELETE, uri);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);

	}
}
