package tw.rackx.app;

import tw.rackx.app.calc.CalcActivity;
import tw.rackx.extend.BaseActivity;
import tw.rackx.layout.LayoutMain;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.androidquery.util.AQUtility;

public class AHome extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		activity = this;
		
		Intent intent = new Intent(this, FuncListActivity.class);
		startActivity(intent);
		finish();
//		FileManager.singleton().writeFile("testFile","測試測試");

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
