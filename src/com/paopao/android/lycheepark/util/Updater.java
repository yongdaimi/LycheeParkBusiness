package com.paopao.android.lycheepark.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.os.Handler;
import android.os.Message;

public class Updater {

	public static final int UPDATE_PROGRESS = 101;
	public static final int FILE_DOWNLOAD_SUCCESS = 103;
	public static final int UPDATE_EXCEPTION = 102;
	private Handler handler;

	private String url;

	public static String absupdateFilePath = FileHelper.DOWNLOAD_DIR
			+ File.separator + "talkbox_updater.apk";

	public Updater(Handler updateHandler, String url) {
		this.handler = updateHandler;
		this.url = url;
	}

	public Updater() {
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void startdownLoadupdate() {

		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					int downLoadPercent = 0;
					File file = new File(absupdateFilePath);
					if (!file.exists()) {
						file.createNewFile();
					}

					URL Url = new URL(url);
					URLConnection conn = Url.openConnection();

					long length = file.length();
					if (length > 0) {
						if (file.delete()) {
							file.createNewFile();
						}
					}
					conn.connect();
					InputStream is = conn.getInputStream();
					long totalFileSize = conn.getContentLength();//
					FileOutputStream fos = new FileOutputStream(
							absupdateFilePath, true);
					byte buf[] = new byte[1024 << 8];
					long downLoadFilePosition = 0;

					int numread;
					while ((numread = is.read(buf)) != -1) {
						fos.write(buf, 0, numread);
						downLoadFilePosition += numread;
						int percent = FileHelper.getPercentage(
								downLoadFilePosition, totalFileSize);
						if (percent > downLoadPercent) {
							Message message = handler
									.obtainMessage(UPDATE_PROGRESS);
							message.obj = percent;
							message.sendToTarget();
						}
						downLoadPercent = percent;
						Thread.sleep(50);
					}
					Message m = handler.obtainMessage(FILE_DOWNLOAD_SUCCESS);
					m.sendToTarget();
				} catch (Exception e) {
					e.printStackTrace();
					Message message = handler.obtainMessage(UPDATE_EXCEPTION);
					message.sendToTarget();
				}

			}
		}).start();

	}
}
