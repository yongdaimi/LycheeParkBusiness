package com.paopao.android.lycheepark.activity;

import java.io.File;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import system.util.SystemUtil;



import android.app.Application;


/**
 * 定义全局变量
 * @author yongdaimi
 * @remark 
 * @date 2014-10-9 上午10:13:47
 * @company Copyright ©PaoPao.Inc. All Rights Reserved.
 */
public class MyApplication extends Application {

	
	@Override
	public void onCreate() {
		super.onCreate();
		// 初始化ImageLoader
		File cacheDir  = new File(SystemUtil.getDiskCacheDir(getApplicationContext(), "bitmap"));
		int cacheSize = SystemUtil.getAppMaxRunningMemory() / 5; // 图片缓存池大小为程序最大可用内存的1/5
		ImageLoaderConfiguration configuration = 
			new ImageLoaderConfiguration.Builder(getApplicationContext())
		.memoryCacheExtraOptions(480, 800) // default = device screen dimensions 
		.diskCacheExtraOptions(480, 800, null)
		.taskExecutor(null)
		.taskExecutorForCachedImages(null)
		// 配置线程池数量
		.threadPoolSize(8)
		// 线程优先级
		.threadPriority(Thread.NORM_PRIORITY -1)
		.tasksProcessingOrder(QueueProcessingType.FIFO)
		.denyCacheImageMultipleSizesInMemory()
		 // 配置内存缓存策略 ，也可以不使用图片缓存池，以WeakMemoryCache()替代
		.memoryCache(new LruMemoryCache(cacheSize)) //
		.memoryCacheSize(cacheSize)
		.memoryCacheSizePercentage(13)
		// 配置磁盘缓存策略
		.diskCache(new UnlimitedDiscCache(cacheDir))
		.diskCacheSize(50*1024*1024)
		.diskCacheFileCount(100)
		.diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
		.imageDownloader(new BaseImageDownloader(getApplicationContext()))
		.imageDecoder(new BaseImageDecoder(true))
		.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
		// .writeDebugLogs() // 打印调试信息 仅用于调试 发布后关闭
		.build();
		
		ImageLoader.getInstance().init(configuration);
		
		
	}

	
	
	
	
}
