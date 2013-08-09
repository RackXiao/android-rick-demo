package com.otiga.dress.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.analytics.tracking.android.EasyTracker;
import com.otiga.dress.data.ConstantTerm;
import com.otiga.dress.data.handler.DressbookAPI;
import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;
import com.otiga.dressbook.WelcomeActivity;

public class Utils {
	
	/**
	 * 初始化,載入螢幕資訊,APIParam,GA,分類品牌更新
	 */
	public static void initSys(Activity activity){
		// 初始常數
		if ( null == ConstantTerm.resolution ){
			//初始一些畫畫面的值
			LayoutManager.loadScreenResolution(activity);
			
			initAPIParam(activity);
			
			//GA在主程式初始後面才能正常使用	
			EasyTracker.getInstance().setContext(activity);
		}
		
		// 當天第一次開啟app時，所更新的資料
		SharedPreferences settings = activity.getSharedPreferences(ConstantTerm.UPDATE_PREF, Context.MODE_PRIVATE);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		String today = sdf.format(new Date());
		if(null==UtilsFile.getCategory(activity) || !today.equals(settings.getString(ConstantTerm.UPDATE_TIME, null))){
			UtilsFile.updateCategory(activity);
			UtilsFile.updateBrand(activity);
			Editor editor = settings.edit();
			editor.putString(ConstantTerm.UPDATE_TIME, today);
			editor.commit();
		}
	}
	
	/**
	 * 初始SERVER的參數，看是要連到正式還是測試環境
	 * 定義在strings.xml檔裡
	 * @param activity 
	 */
	private static void initAPIParam(Activity activity) {
		ConstantTerm.IS_TEST_ENV = Boolean.valueOf(activity.getString(R.string.IS_TEST_ENV));
		if(!ConstantTerm.IS_TEST_ENV){
			ConstantTerm.API_PATH = activity.getString(R.string.API_PATH);
			ConstantTerm.IMAGE_SERVER_PATH = activity.getString(R.string.IMAGE_SERVER_PATH);
		} else {
			ConstantTerm.API_PATH = activity.getString(R.string.TEST_API_PATH);
			ConstantTerm.IMAGE_SERVER_PATH = activity.getString(R.string.TEST_IMAGE_SERVER_PATH);
		}
	}

	/**
	 * 基本的系統檢查
	 * 目前檢查網路，後檢查User_id是否存在
	 * @param activity
	 * @return
	 */
	public static boolean sysPreChk(Activity activity){
        if(!chkNetworkStatus(activity)){
        	UtilsDialog.showDialogNoNetwork(activity);
        	return false;
        }

        if(!chkUserIsExist()){
        	Utils.doSomethingWhenNoUserId(activity);
        	return false;
        }
        
        chkServerStatus(activity);
        
		return true;
	}
	
	/**
	 * 檢查Server BroadCastMessage 
	 * @param activity
	 */
	public static void chkServerStatus(final Activity activity){		
		DressbookAPI.singleton().getBroadcastMessage(new DressbookAPI.GetBroadcastMessageCallback() {		
			@Override
			public void OnResult(Exception exception, int isShow, String Message, int Msgid) {
				
				if(isShow == 1){//顯示訊息,離開app
					UtilsDialog.showDialogServerStatus(activity, Message);
				}
				else if(isShow ==2){//顯示訊息,不離開app
					if(!ConstantTerm.msgidList.contains(Msgid)){//沒有show過此msgid的
						UtilsDialog.showDialogServerMsg(activity, Message);
						ConstantTerm.msgidList.add(Msgid);
					}					
				}
				else if(isShow ==3){//無訊息,強制關閉app
					ActivityStackControlUtil.finishProgram();
				}
			}
		});	
	}

	/**
	 * 檢查網路
	 * ps.程式一開始沒有User_id，唯一單獨使用
	 * @return
	 */
	public static boolean chkNetworkStatus(Activity activity){
		ConnectivityManager connMgr = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		if (connMgr != null) {
	       NetworkInfo info = connMgr.getActiveNetworkInfo();
	       if (info != null)
	    	   return (info.isConnected());
		}
		return false;
	}

	/**
	 * 檢查使用者ID是否正常
	 * ps.有些不用檢查網路，所以會被單獨使用
	 * @return
	 */
	public static boolean chkUserIsExist(){
		return (null != ConstantTerm.act_user);
	}

	/**
	 * User_id為錯誤值的處理
	 * @param activity
	 */
	public static void doSomethingWhenNoUserId(Activity activity) {
		//TODO noUser_id, 導到首頁重新登入
		Intent intent = new Intent(activity, WelcomeActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		activity.startActivity(intent);
		activity.finish();
		
		//UtilsDialog.showDialogNoUserId(activity);
	}
	
}
