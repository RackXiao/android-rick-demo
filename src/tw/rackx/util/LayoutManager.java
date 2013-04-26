package tw.rackx.util;


import tw.rackx.R;
import tw.rackx.app.GV;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LayoutManager {
	
	public static int BaseId = 1000;
	
	// getMainLayout
	public static int BtnCalc = ++BaseId;
	public static int BtnDialog = ++BaseId;
	public static int BtnTabMenu = ++BaseId;
	
	public static int WelcomeBackground = ++BaseId;
	public static int WelcomeFBButton = ++BaseId;
	
	public static RelativeLayout setBaseLayoutScreenResolution(RelativeLayout rLayout){
		RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams((int)(GV.targetResolution.x * GV.scale), (int)(GV.targetResolution.y * GV.scale));
		rParams.setMargins((int)(((float)GV.resolution.x - (GV.targetResolution.x * GV.scale)) / 2.0f), (int)(((float)GV.resolution.y - (GV.targetResolution.y * GV.scale)) / 2.0f), 0, 0);
		rLayout.setLayoutParams(rParams);
		return rLayout;
	}
	
	/**
	 * 初始選單
	 * @param context
	 * @return
	 */
	public static View getMainLayout(Context context) {
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		Button btn = null;

		// 計算功能
		rParams = new RelativeLayout.LayoutParams((int)(160 * GV.scale), (int)(160 * GV.scale));
		btn = new Button(context);
		btn.setId(BtnCalc);
		btn.setText(R.string.cate_calc);
		baseLayout.addView(btn, rParams);

		rParams = new RelativeLayout.LayoutParams((int)(160 * GV.scale), (int)(160 * GV.scale));
		rParams.setMargins((int)(160 * GV.scale), 0, 0, 0);
		btn = new Button(context);
		btn.setId(BtnDialog);
		btn.setText(R.string.btn_dialog);
		baseLayout.addView(btn, rParams);

		rParams = new RelativeLayout.LayoutParams((int)(160 * GV.scale), (int)(160 * GV.scale));
		rParams.setMargins((int)(320 * GV.scale), 0, 0, 0);
		btn = new Button(context);
		btn.setId(BtnTabMenu);
		btn.setText(R.string.btn_show_tabmenu);
		baseLayout.addView(btn, rParams);
		
		return setBaseLayoutScreenResolution(baseLayout);
	}
	
	/**
	 * WelcomeLayout的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getWelcomeLayout(Context context) {
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		ImageView imageView = null;
		
//		baseLayout.setBackgroundResource(R.drawable.img_welcomebg);

		// Facebook 按鈕
		rParams = new RelativeLayout.LayoutParams((int)(370 * GV.scale), (int)(80 * GV.scale));
		rParams.setMargins((int)(58 * GV.scale), (int)(462 * GV.scale), 0, 0);
		imageView = new ImageView(context);
		imageView.setId(WelcomeFBButton);
//		imageView.setBackgroundResource(R.drawable.btn_fblogin);
		baseLayout.addView(imageView, rParams);

		return setBaseLayoutScreenResolution(baseLayout);
	}
}
