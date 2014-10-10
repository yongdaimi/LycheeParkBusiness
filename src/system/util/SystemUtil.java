package system.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.paopao.android.lycheepark.R;
import com.paopao.android.lycheepark.domain.TaskInfo;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Debug.MemoryInfo;

/**
 * 系统工具
 * @author yongdaimi
 * @tip 
 * @date 2014-8-29 下午04:21:32
 */
public class SystemUtil {

	
	/**
	 * 获取应用程序版本号
	 * @param context
	 * @return
	 */
	public static int getAppVersion(Context context) {
		try {
			PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			return packageInfo.versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	
	/**
	 * 获取当前正在运行的进程数量
	 * @param context
	 * @return 正在运行的进程数量
	 */
	public final static int getRunningAppProcessInfoSize(Context context) {
		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		return am.getRunningAppProcesses().size();
	}

	/**
	 * 获取系统当前可用内存
	 * @param context
	 * @return
	 */
	public final static long getAvailMem(Context context) {
		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		am.getMemoryInfo(outInfo);
		long availMem = outInfo.availMem; // 单位是byte
		return availMem;
	}

	/**
	 * 获取系统当前可用内存
	 * @param context
	 * @return 单位：MB
	 */
	public final static int getAvailMemOfMB(Context context) {
		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		android.app.ActivityManager.MemoryInfo outInfo = new android.app.ActivityManager.MemoryInfo();
		am.getMemoryInfo(outInfo);
		int availMem = (int) (outInfo.availMem) / 1024 / 1024; // 单位是byte
		return availMem;
	}

	/**
	 * 获取所有进程信息
	 * @param context
	 * @return
	 */
	public static List<TaskInfo> getTaskInfos(Context context) {
		List<TaskInfo> taskInfos = new ArrayList<TaskInfo>();
		PackageManager pm = context.getPackageManager();
		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> runningAppProcessInfos = am
				.getRunningAppProcesses();
		for (RunningAppProcessInfo info : runningAppProcessInfos) {
			TaskInfo taskInfo = new TaskInfo();

			// 应用包名
			String packageName = info.processName;
			taskInfo.setPackageName(packageName);
			// 进程id
			int pid = info.pid;
			taskInfo.setPid(pid);
			try {
				ApplicationInfo appInfo = pm.getApplicationInfo(packageName, 0);
				// 应用图标
				Drawable task_icon = appInfo.loadIcon(pm);
				if (task_icon != null) {
					taskInfo.setTask_icon(task_icon);
				} else {
					// 因为系统内核进程是没有图标的，所以在这里应该先做出判断
					taskInfo.setTask_icon(context.getResources().getDrawable(
							R.drawable.ic_launcher));
				}

				// 应用名称
				String task_name = (String) appInfo.loadLabel(pm);
				taskInfo.setTask_name(task_name);
				boolean isUserTask = filterApp(appInfo);
				taskInfo.setUserTask(isUserTask);
			} catch (NameNotFoundException e) {
				e.printStackTrace();
				taskInfo.setTask_icon(context.getResources().getDrawable(
						R.drawable.ic_launcher));
				// 将该进程的名字做为该应用的名字
				taskInfo.setTask_name(packageName);
			}

			MemoryInfo[] memoryInfos = am
					.getProcessMemoryInfo(new int[] { pid });
			MemoryInfo memoryInfo = memoryInfos[0];
			// 应用所占用的内存大小
			long totalmem = memoryInfo.getTotalPrivateDirty(); // 单位是KB
																// 返回所有的已经占用的内存信息
			taskInfo.setTask_memory(totalmem * 1024);
			taskInfos.add(taskInfo);
		}
		return taskInfos;
	}

	/**
	 * 获得当前正在运行的用户进程
	 * @param context
	 * @return
	 */
	public static List<TaskInfo> getUserTaskInfos(Context context) {
		List<TaskInfo> userTaskInfos = new ArrayList<TaskInfo>();
		PackageManager pm = context.getPackageManager();
		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> runningAppProcessInfos = am
				.getRunningAppProcesses();
		for (RunningAppProcessInfo info : runningAppProcessInfos) {
			// 应用包名
			String packageName = info.processName;
			try {
				ApplicationInfo appInfo = pm.getApplicationInfo(packageName, 0);
				boolean isUserTask = filterApp(appInfo);
				if (isUserTask) {
					TaskInfo taskInfo = new TaskInfo();
					taskInfo.setPackageName(packageName);
					userTaskInfos.add(taskInfo);
				}
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
		}
		return userTaskInfos;
	}
	
	
	
	/**
	 * 验证当前进程是否为用户进程
	 * @param info
	 * @return
	 */
	public static boolean filterApp(ApplicationInfo info) {
		// 原来是系统应用，用户手动升级
		if ((info.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
			return true;
			// 用户自己安装的应用程序
		} else if ((info.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 杀死所有进程
	 * @param context
	 */
	public final static void killAllProgress(Context context) {
		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> runningAppProcesses = am
				.getRunningAppProcesses();
		for (RunningAppProcessInfo info : runningAppProcesses) {
			am.killBackgroundProcesses(info.processName);
		}
	}

	
	
	/*
	 * 验证手机是否支持蓝牙功能
	 */
	public static boolean checkBlueTooth() {
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter
				.getDefaultAdapter();
		if (bluetoothAdapter != null) {
			return true;
		}
		return false;
	}
	
	
	/*
	 * 获得SD卡当前可用空间 单位：MB
	 */
	public static final int getUsableSpace() {
		long currentSpace = Environment.getExternalStorageDirectory()
				.getUsableSpace();
		int usableSpace = (int) (currentSpace / 1024 / 1024);
		return usableSpace;
	}
	
	
	/**
	 * 获取磁盘缓存目录
	 * @param context
	 * @param uniqueName 
	 *  示例：bitmap代表应用程序缓存图片  music代表音乐  txt代表文本
	 * @return
	 */
	public static String getDiskCacheDir(Context context, String uniqueName) {

		String cachePath = null;
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())
				|| !Environment.isExternalStorageRemovable()) {
			cachePath = Environment.getExternalStorageDirectory().getPath()
					+ "/Android/data/" + context.getPackageName()
					+ File.separator + "cache/" + uniqueName;
		} else {
			cachePath = context.getCacheDir().getPath();
		}
		return cachePath;
	}
	
	
	/**
	 * 获取网点离线图片缓存目录
	 * @param context
	 * @param uniqueName 网点id
	 * @return
	 */
	public static String getPosPicCacheDir(Context context, String uniqueName) {
		
		String cachePath = null;
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())
				|| !Environment.isExternalStorageRemovable()) {
			cachePath = Environment.getExternalStorageDirectory().getPath()
			+ "/Android/data/" + context.getPackageName()
			+ File.separator + "cache/poi/" + uniqueName;
		} else {
			cachePath = context.getCacheDir().getPath();
		}
		return cachePath;
	}
	
	
	
	/**
	 * 获取当前系统环境下，应用程序最大可用内存
	 * @return
	 */
	public static int getAppMaxRunningMemory() {
//		ActivityManager mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//		int mMaxMemory = mActivityManager.getMemoryClass();
		int maxMemory = (int) Runtime.getRuntime().maxMemory();
		return maxMemory;
	}
	
	
	/**
	 * 验证SDCard是否存在
	 * @return
	 */
	public static boolean hasSDCard() {
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 获取货架陈列照片缓存目录
	 * @return
	 */
	public static String getAppImageCacheDirectory() {
		if (hasSDCard()) {
			File file = new File(Environment.getExternalStorageDirectory()+ "/businessexpert/picture");
			if (!file.exists()) {
				file.mkdirs();
			}
			return file.getAbsolutePath();
		}
		return "";
	}
	
	
	
	/**
	 * 获取指定文件目录下文件的路径集合 当前只匹配文件后缀为".jpg .jpeg .png 的文件"
	 * @param strPath 指定文件目录
	 * @tips Scheme.FILE.wrap 须UIL支持
	 * @return 包含指定要求的文件路径集合
	 */
	public static ArrayList<String> getAppPicturePaths(String strPath) {
		if (!hasSDCard()) {
			return null;
		}
		ArrayList<String> list = new ArrayList<String>();
		File fileDirectory = new File(strPath);
		File[] listFiles = fileDirectory.listFiles();
		if (listFiles == null) {
			return null;
		}
		
		for (File file : listFiles) {
			if (file.isFile()) {
				int index = file.getAbsolutePath().lastIndexOf(".");
				if (index <= 0) {
					continue;
				}
				String suff = file.getAbsolutePath().substring(index);
				if (suff.toLowerCase().equals(".jpg") ||
						suff.toLowerCase().equals(".jpeg") ||
						suff.toLowerCase().equals(".png")
				) {
					list.add(Scheme.FILE.wrap(file.getAbsolutePath()));
				}
			}
		}
		return list;
	}
	
	
	/**
	 * 统计文件夹下文件的个数
	 * @param path
	 * @return
	 */
	public static int calculateTotalCountFromFolder(String path) {
		File fileDirectory = new File(path);
		if (fileDirectory.isDirectory()) {
			return fileDirectory.listFiles().length;
		}
		return 0;
	}
	
	
	/*
	 * 删除磁盘文件
	 */
	public static boolean deleteFile(File file) {
		if (file.exists()) {
			if (file.isFile()) {
				return file.delete();
			} else if (file.isDirectory()) {
				File[] delFiles = file.listFiles();
				for (int i = 0; i < delFiles.length; i++) {
					deleteFile(delFiles[i]);
				}
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 删除多个文件 
	 * @param filePaths 当前文件路径集合可能包含File:/// 前缀，需使用Scheme.FILE.crop 拆封
	 */
	public static void deleteMultiFile(List<String> filePaths) {
		for (String path : filePaths) {
			File tempFile = new File(Scheme.FILE.crop(path));
			deleteFile(tempFile);
		}
	}
	
	
	/**
	 * 拷贝磁盘文件
	 * @param srcPath 源文件位置
	 * @param desPath 目标文件位置 注意：该路径必须为完整文件名
	 */
	public static void copyFileToTargetFolder(String srcPath, String desPath) {
		
		File tempFile = new File(srcPath);
		if (!tempFile.exists()) {
			return;
		}
		
		BufferedInputStream inputStream = null;
		BufferedOutputStream outputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(tempFile));
			outputStream = new BufferedOutputStream(new FileOutputStream(new File(desPath)));
			int len = 0;
			byte[] bytes = new byte[1024];
			while((len = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes,0,len);
				outputStream.flush();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
