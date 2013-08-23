package tw.rackx.dao;

import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;

import com.androidquery.callback.BitmapAjaxCallback;

/**
 * Global Variety
 * @author Rick
 *
 */
public class GV extends Application{
	
	// == 參數 ==
	// 設定解析度
	public static final PointF targetResolution = new PointF(480, 800);
	public static Point resolution;
	public static DisplayMetrics displayMetrics;
	public static float scaleX;
	public static float scaleY;
	public static float fontScale;
	
	public static final String PACKAGE_NAME = "RICK_DEMO";
	private static final String SETTING_PREF = "setting_pref";
	public static SharedPreferences SP;

//	// 設定資料庫
//	public static SQLiteDatabase db = null;
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		
//		// 設定資料庫
//		db = new DBHelper(this, getString(R.string.app_name)).getWritableDatabase();
		
		SP = getSharedPreferences(SETTING_PREF, MODE_PRIVATE);
	}
	
	@Override
	public void onTerminate() {
		super.onTerminate();
		
//		db.close();
	}
	
	@Override
	public void onLowMemory() {
        //clear all memory cached images when system is in low memory
        //note that you can configure the max image cache count, see CONFIGURATION
		BitmapAjaxCallback.clearCache();
	}
}
