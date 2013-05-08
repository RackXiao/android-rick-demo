package tw.rackx.app;

import android.app.Application;
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
	public static float scale;
	public static float fontScale;

//	// 設定資料庫
//	public static SQLiteDatabase db = null;
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		
//		// 設定資料庫
//		db = new DBHelper(this, getString(R.string.app_name)).getWritableDatabase();
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
