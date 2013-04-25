package tw.rackx.app;

import tw.rackx.R;
import tw.rackx.util.DBHelper;
import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;

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

	// 設定資料庫
	public static SQLiteDatabase db = null;
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		// 設定資料庫
		db = new DBHelper(this, getString(R.string.app_name)).getWritableDatabase();
	}
	
	@Override
	public void onTerminate() {
		super.onTerminate();
		
		db.close();
	}
}
