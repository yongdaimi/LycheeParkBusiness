package com.paopao.android.lycheepark.domain;

import android.graphics.drawable.Drawable;

/**
 * 进程信息
 * @author yongdaimi
 * @date 2014/6/30
 */
public class TaskInfo {

	/**
	 * 缩略图标
	 */
	private Drawable task_icon;
	/**
	 * 进程名称
	 */
	private String task_name;
	/**
	 * 进程所耗内存
	 */
	private long task_memory;
	/**
	 * 进程所在包名
	 */
	private String packageName;
	/**
	 * 进程ID
	 */
	private int pid;
	/**
	 * 是否已被选中
	 */
	private boolean isChecked;
	/**
	 * 是否为用户进程
	 */
	private boolean isUserTask;
	
	
	public Drawable getTask_icon() {
		return task_icon;
	}
	public void setTask_icon(Drawable task_icon) {
		this.task_icon = task_icon;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public long getTask_memory() {
		return task_memory;
	}
	public void setTask_memory(long task_memory) {
		this.task_memory = task_memory;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	public boolean isUserTask() {
		return isUserTask;
	}
	public void setUserTask(boolean isUserTask) {
		this.isUserTask = isUserTask;
	}
	
	
}
