package com.otiga.dress.utils;

import android.app.Activity;

/**
 * Manager Activity Stack
 * @author Jeffrey.Yang
 *
 */
public class ActivityStackControlUtil {
	
//	private static List<Activity> activityList = new ArrayList<Activity>();
	
	public static void remove(Activity activity) {
//		activityList.remove(activity);
	}
	
	public static void add(Activity activity) {
//		activityList.add(activity);
	}
	
	public static void finishProgram() {
//		for (Activity activity : activityList) {
//			activity.finish();
//		}
		android.os.Process.killProcess(android.os.Process.myPid());
		System.exit(0);
	}
}
