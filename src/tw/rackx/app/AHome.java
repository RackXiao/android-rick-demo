package tw.rackx.app;

import tw.rackx.app.calc.CalcActivity;
import tw.rackx.extend.ExtendActivity;
import tw.rackx.layout.LayoutMain;
import tw.rackx.util.UtilBase;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.BitmapAjaxCallback;
import com.androidquery.util.AQUtility;

public class AHome extends ExtendActivity {

	private Activity activity = this;
	
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

		setContentView(LayoutMain.getMainLayout(this));

		initBtnEvent();
	}
	
	private void initBtnEvent() {
		Button btn;
		btn = (Button) findViewById(LayoutMain.BtnCalc);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AHome.this, CalcActivity.class);
	    		startActivity(intent);
			}
		});
		
		btn = (Button) findViewById(LayoutMain.BtnDiscuss);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Toast.makeText(activity, "On going.", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(AHome.this, DiscussActivity.class);
	    		startActivity(intent);
			}
		});
		
		btn = (Button) findViewById(LayoutMain.BtnBluetoothTest);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				Toast.makeText(activity, "On going.", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(AHome.this, BluetoothTest.class);
	    		startActivity(intent);
			}
		});
		
		btn = (Button) findViewById(LayoutMain.BtnDialog);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AHome.this, Dialog.class);
	    		startActivity(intent);
			}
		});
		
		btn = (Button) findViewById(LayoutMain.BtnTabMenu);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(activity, "Re-write Now.", Toast.LENGTH_SHORT).show();
//				Intent intent = new Intent(AHome.this, TabMenu.class);
//	    		startActivity(intent);
			}
		});
	}

	@Override
	public void onDestroy() {
		if (isTaskRoot()) {
			// clean the file cache with advance option
			long triggerSize = 3000000;	// starts cleaning when cache size is larger than 3M
			long targetSize = 2000000;	// remove the least recently used files until cache size is less than 2M
			AQUtility.cleanCacheAsync(this, triggerSize, targetSize);
		}
		super.onDestroy();
	}
}
