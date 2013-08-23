package tw.rackx.extend;

import tw.rackx.util.UtilBase;

import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.BitmapAjaxCallback;
import com.androidquery.util.AQUtility;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class BaseActivity extends Activity {

	protected Activity activity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// set the max number of concurrent network connections, default is 4
		AjaxCallback.setNetworkLimit(8);

		// set the max number of icons (image width <= 50) to be cached in memory, default is 20
		BitmapAjaxCallback.setIconCacheLimit(20);

		// set the max number of images (image width > 50) to be cached in memory, default is 20
		BitmapAjaxCallback.setCacheLimit(40);

		// set the max size of an image to be cached in memory, default is 1600 pixels (ie. 400x400)
		BitmapAjaxCallback.setPixelLimit(400 * 400);

		// set the max size of the memory cache, default is 1M pixels (4MB)
		BitmapAjaxCallback.setMaxPixelLimit(8000000);

//		File ext = Environment.getExternalStorageDirectory();
//		File cacheDir = new File(ext, getString(R.string.app_name));
//		AQUtility.setCacheDir(cacheDir);

		// 設定解析度，必需在第一個開啟頁面被執行一次
		UtilBase.loadScreenResolution(this);
		
		//HIDDEN TITLE
//		getActionBar().hide();
		getActionBar().setDisplayShowHomeEnabled(true);
//		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void onDestroy() {
		if (isTaskRoot()) {
			// clean the file cache with advance option
			long triggerSize = 3000000;	// starts cleaning when cache size is larger than 3M
			long targetSize = 2000000;	// remove the least recently used files until cache size is less than 2M
			AQUtility.cleanCacheAsync(this, triggerSize, targetSize);
		}
		super.onDestroy();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
//			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		// open 群益下單軟體
//		Intent intent = getPackageManager().getLaunchIntentForPackage("com.mitake.m2a.cap");
	}
}
