package tw.rackx.layout;

import tw.rackx.R;
import tw.rackx.app.GV;
import tw.rackx.extend.LayoutBase;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LayoutMain extends LayoutBase{
	
	// getMainLayout
	public static int BtnCalc = ++BaseId;
	public static int BtnDiscuss = ++BaseId;
	public static int BtnDialog = ++BaseId;
	public static int BtnTabMenu = ++BaseId;
	
	public static int WelcomeBackground = ++BaseId;
	public static int WelcomeFBButton = ++BaseId;
	
	private static int placeOfBtn;
	
	/**
	 * 初始選單
	 * @param context
	 * @return
	 */
	public static View getMainLayout(Context context) {
		placeOfBtn = 0;
		
		RelativeLayout baseLayout = new RelativeLayout(context);
				 
		// 計算功能
		baseLayout = addBtn(baseLayout,context,BtnCalc,context.getString(R.string.cate_calc));
		
		baseLayout = addBtn(baseLayout,context,BtnDiscuss,"討論區");
		
		baseLayout = addBtn(baseLayout,context,BtnDialog,context.getString(R.string.btn_dialog));
		
		baseLayout = addBtn(baseLayout,context,BtnTabMenu,context.getString(R.string.btn_show_tabmenu));
		
		return setBaseLayoutScreenResolution(baseLayout);
	}
	
	private static RelativeLayout addBtn(RelativeLayout baseLayout, Context context, int id, String name) {
		RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams((int)(160 * GV.scaleX), (int)(160 * GV.scaleX));
		rParams.setMargins((int)(160 * GV.scaleX)*(placeOfBtn%3), (int)(160 * GV.scaleX)*(placeOfBtn/3), 0, 0);
		Button btn = new Button(context);
		btn.setId(id);
		btn.setText(name);
		baseLayout.addView(btn, rParams);
		placeOfBtn++;
		return baseLayout;
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
		rParams = new RelativeLayout.LayoutParams((int)(370 * GV.scaleX), (int)(80 * GV.scaleX));
		rParams.setMargins((int)(58 * GV.scaleX), (int)(462 * GV.scaleX), 0, 0);
		imageView = new ImageView(context);
		imageView.setId(WelcomeFBButton);
//		imageView.setBackgroundResource(R.drawable.btn_fblogin);
		baseLayout.addView(imageView, rParams);

		return setBaseLayoutScreenResolution(baseLayout);
	}
}
