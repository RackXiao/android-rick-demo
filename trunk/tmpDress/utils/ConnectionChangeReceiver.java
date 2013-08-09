package com.otiga.dress.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.analytics.tracking.android.Log;

public class ConnectionChangeReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		boolean isNetworkAvailable = isNetworkAvailable(context);
		// 監控網路狀態
//		Toast.makeText(context, "isNetworkAvailable:" + isNetworkAvailable,
//				Toast.LENGTH_LONG).show();
		Log.i("isNetworkAvailable:" + isNetworkAvailable);
	}

	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getApplicationContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cm == null) {
			return false;
		} else {
			NetworkInfo[] infos = cm.getAllNetworkInfo();
			if (infos != null) {
				for (NetworkInfo networkInfo : infos) {
					if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
