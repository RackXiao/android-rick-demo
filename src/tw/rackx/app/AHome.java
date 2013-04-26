package tw.rackx.app;

import tw.rackx.app.calc.CalcActivity;
import tw.rackx.util.L;
import tw.rackx.util.LayoutManager;
import tw.rackx.util.UtilBase;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class AHome extends Activity {
	private static final String TAG = AHome.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//XXX 設定解析度，必需在第一個開啟頁面被執行一次
		UtilBase.loadScreenResolution(this);
		
		//HIDDEN TITLE
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		setContentView(LayoutManager.getMainLayout(this));

		initBtnEvent();
		
		L.d(TAG, "onCreate");
	}
	
	private void initBtnEvent() {
		Button btn;
		btn = (Button) findViewById(LayoutManager.BtnCalc);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AHome.this, CalcActivity.class);
	    		startActivity(intent);
			}
		});
		
		btn = (Button) findViewById(LayoutManager.BtnDialog);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AHome.this, Dialog.class);
	    		startActivity(intent);
			}
		});
		
		btn = (Button) findViewById(LayoutManager.BtnTabMenu);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(AHome.this, TabMenu.class);
	    		startActivity(intent);
			}
		});
	}
	
}
