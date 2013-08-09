package com.otiga.dress.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

public class UtilsDialog {

	/**
	 * 自訂單行文字訊息
	 * @param activity
	 * @param messageId
	 * @param backgroundColor
	 */
	public static void createAlertDialog(Activity activity, int messageId, int backgroundColor){
		Builder alertBuilder = new AlertDialog.Builder(activity);
		alertBuilder.setTitle("");
		alertBuilder.setMessage(messageId);
		AlertDialog dialog = alertBuilder.show();
		dialog.setCanceledOnTouchOutside(true);
		TextView messageText = (TextView)dialog.findViewById(android.R.id.message);
		messageText.layout(0, 0, 800, 50);
		messageText.setBackgroundColor(backgroundColor);
		messageText.setTextColor(Color.WHITE);
		messageText.setTextSize(18 * LayoutManager.fontScale);
		messageText.setGravity(Gravity.CENTER);
		dialog.show();
	}

	/**
	 * 建立Loading .... ProgressDialog
	 * @param activity
	 * @param string 
	 * @return
	 */
	public static ProgressDialog createProgressDialog(Activity activity, String dialogString){
		ProgressDialog proDialog = new ProgressDialog(activity, android.R.style.Theme_DeviceDefault_Dialog);
		proDialog.setCanceledOnTouchOutside(false);
		proDialog.show();
		
		TextView tv1 = (TextView) proDialog.findViewById(android.R.id.message);
		tv1.setText(String.format("%s...", dialogString));
		return proDialog;
	}
	
	/**
	 * 可填入String的dialog(關閉app)
	 * @param activity
	 * @param msg
	 */
	public static void showDialogServerStatus(final Activity activity, final String msg) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				AlertDialog.Builder ad = alert_dialog2(activity,R.string.ServerStatusTitle,msg);
				ad.show();
			}
		});
	}
	
	/**
	 * 可填入String的dialog(不關閉app)
	 * @param activity
	 * @param msg
	 */
	public static void showDialogServerMsg(final Activity activity, final String msg) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				AlertDialog.Builder ad = alert_dialog3(activity,R.string.ServerStatusTitle,msg);
				ad.show();
			}
		});
	}

	/**
	 * 無網路可使用的 Error AlertDialog
	 * @param activity
	 */
	public static void showDialogServerStatusGetError(final Activity activity) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				AlertDialog.Builder ad = alert_dialog(activity,R.string.ServerStatusGetErrorTitle,R.string.ServerStatusGetErrorMessage);
				ad.show();
			}
		});
				
	}

	/**
	 * 網路中斷的 Error AlertDialog
	 * @param activity
	 */
	public static void showDialogNoNetwork(final Activity activity) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				AlertDialog.Builder ad = alert_dialog(activity,R.string.DialogNoNetworkTitle,R.string.DialogNoNetworkMessage);
				ad.show();
			}
		});
		
	}
	
	/**
	 * 基礎AlertDialog(關閉app)
	 */
	public static AlertDialog.Builder alert_dialog(Activity activity ,int title ,int message){
		AlertDialog.Builder ad = new AlertDialog.Builder(activity)   
	    .setTitle(title)  
	    .setMessage(message)  
	    .setPositiveButton(R.string.BtnSure,  
	    		new DialogInterface.OnClickListener() {  
	            	public void onClick(DialogInterface dialog,int whichButton) { 
	            		ActivityStackControlUtil.finishProgram();
	                }  
	            })
	    .setCancelable(false);
		
		return ad;
	}
	
	/**
	 * 基礎AlertDialog2(關閉app)
	 */
	public static AlertDialog.Builder alert_dialog2(Activity activity ,int title ,String message){
		AlertDialog.Builder ad = new AlertDialog.Builder(activity)   
	    .setTitle(title)  
	    .setMessage(message)  
	    .setPositiveButton(R.string.BtnSure,  
	    		new DialogInterface.OnClickListener() {  
	            	public void onClick(DialogInterface dialog,int whichButton) { 
	            		ActivityStackControlUtil.finishProgram();
	                }  
	            })
	    .setCancelable(false);
		
		return ad;
	}
	
	/**
	 * 基礎AlertDialog3(不關閉app)
	 */
	public static AlertDialog.Builder alert_dialog3(Activity activity ,int title ,String message){
		AlertDialog.Builder ad = new AlertDialog.Builder(activity)   
	    .setTitle(title)  
	    .setMessage(message)  
	    .setPositiveButton(R.string.BtnSure,  
	    		new DialogInterface.OnClickListener() {  
	            	public void onClick(DialogInterface dialog,int whichButton) { 
	                }  
	            })
	    .setCancelable(false);
		
		return ad;
	}
}
