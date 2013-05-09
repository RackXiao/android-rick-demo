package tw.rackx.layout;

import tw.rackx.R;
import tw.rackx.app.GV;
import tw.rackx.util.LayoutManager;
import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class LayoutCalc {

	private static int BaseId = 10000;
	
	// getCalcMenuLayout
	public static int BtnCalcCDP = ++BaseId;

	// getCalcCDPLayout
	public static int ETOPEN = ++BaseId;
	public static int ETHIGH = ++BaseId;
	public static int ETLOW = ++BaseId;
	public static int ETCLOSE = ++BaseId;
	public static int ETBtnCalcCDP = ++BaseId;
	public static int ETTVH3 = ++BaseId;
	public static int ETTVH2 = ++BaseId;
	public static int ETTVH1 = ++BaseId;
	public static int ETTVBOP = ++BaseId;
	public static int ETTVL1 = ++BaseId;
	public static int ETTVL2 = ++BaseId;
	public static int ETTVL3 = ++BaseId;
	
	/**
	 * 計算功能選單
	 * @param context
	 * @return
	 */
	public static View getCalcMenuLayout(Context context) {
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		Button btn = null;

		rParams = new RelativeLayout.LayoutParams((int)(160 * GV.scale), (int)(160 * GV.scale));
		btn = new Button(context);
		btn.setId(BtnCalcCDP);
		btn.setText(R.string.calc_cdp);
		baseLayout.addView(btn, rParams);

//		rParams = new RelativeLayout.LayoutParams((int)(160 * GlobalValue.scale), (int)(160 * GlobalValue.scale));
//		rParams.setMargins((int)(160 * GlobalValue.scale), 0, 0, 0);
//		btn = new Button(context);
//		btn.setId(BtnDialog);
//		btn.setText(R.string.btn_dialog);
//		baseLayout.addView(btn, rParams);
//
//		rParams = new RelativeLayout.LayoutParams((int)(160 * GlobalValue.scale), (int)(160 * GlobalValue.scale));
//		rParams.setMargins((int)(320 * GlobalValue.scale), 0, 0, 0);
//		btn = new Button(context);
//		btn.setId(BtnTabMenu);
//		btn.setText(R.string.btn_show_tabmenu);
//		baseLayout.addView(btn, rParams);

		return LayoutManager.setBaseLayoutScreenResolution(baseLayout);
	}

	/**
	 * 計算CDP功能
	 * @param context
	 * @return
	 */
	public static View getCalcCDPLayout(Context context) {
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout rsv = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		ScrollView sv = new ScrollView(context);
		TextView tv = null;
		EditText et = null;
		Button btn = null;

		int [] tvLabel = new int[] {R.string.calc_cdp_open,R.string.calc_cdp_high,R.string.calc_cdp_low,R.string.calc_cdp_close};
		int [] edID = new int[] {ETOPEN,ETHIGH,ETLOW,ETCLOSE};
		
		for(int i=0;i<tvLabel.length;i++){
			// 標籤
			rParams = new RelativeLayout.LayoutParams((int)(240 * GV.scale), (int)(60 * GV.scale));
			rParams.setMargins(0, (int)(i * 60 * GV.scale), 0, 0);
			tv = new TextView(context);
			tv.setId(++BaseId);
			tv.setTextSize(16 * GV.fontScale);
			tv.setGravity(Gravity.CENTER);
			tv.setTextColor(Color.rgb(53, 214, 214));
			tv.setText(tvLabel[i]);
			baseLayout.addView(tv, rParams);
			
			// 輸入框
			rParams = new RelativeLayout.LayoutParams((int)(240 * GV.scale), (int)(60 * GV.scale));
			rParams.addRule(RelativeLayout.RIGHT_OF, BaseId);
			rParams.addRule(RelativeLayout.ALIGN_TOP, BaseId);
			et = new EditText(context);
			et.setId(edID[i]);
			et.setSingleLine(true);
			et.setTextSize(16 * GV.fontScale);
			et.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
//			et.setTextColor(Color.BLACK);
//			et.setHint("");
			et.setInputType(InputType.TYPE_CLASS_NUMBER);
			baseLayout.addView(et, rParams);
		}

		// 計算按鈕
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, (int)(60 * GV.scale));
		rParams.addRule(RelativeLayout.BELOW, BaseId);
		rParams.addRule(RelativeLayout.CENTER_HORIZONTAL, BaseId);
		btn = new Button(context);
		btn.setId(ETBtnCalcCDP);
		btn.setText(R.string.btn_calc_cdp);
		baseLayout.addView(btn, rParams);


		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		rParams.addRule(RelativeLayout.BELOW, ETBtnCalcCDP);
		rParams.addRule(RelativeLayout.CENTER_HORIZONTAL, ETBtnCalcCDP);
		sv.addView(rsv);
		baseLayout.addView(sv,rParams);

		edID = new int[] {ETTVH3,ETTVH2,ETTVH1,ETTVBOP,ETTVL1,ETTVL2,ETTVL3};

		// 壓 BOP 撐
		for(int i=0;i<edID.length;i++){
			rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, (int)(60 * GV.scale));
			rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
			rParams.setMargins(0, (int)(i * 60 * GV.scale), 0, 0);
			tv = new TextView(context);
			tv.setId(edID[i]);
			tv.setTextSize(16 * GV.fontScale);
			tv.setGravity(Gravity.CENTER);
			tv.setTextColor(Color.rgb(53, 214, 214));
			rsv.addView(tv, rParams);
		}
		
		return LayoutManager.setBaseLayoutScreenResolution(baseLayout);
	}
}
