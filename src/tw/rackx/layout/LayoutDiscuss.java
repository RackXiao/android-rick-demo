package tw.rackx.layout;

import tw.rackx.app.GV;
import tw.rackx.extend.LayoutBase;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class LayoutDiscuss extends LayoutBase {
	
	// getCalcMenuLayout
	public static int DisplayView = ++BaseId;
	public static int EditText = ++BaseId;
	public static int BtnSend = ++BaseId;

	public static View getDiscussLayout(Context context) {
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;

		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		rParams.setMargins(0, 0, 0, (int)(72 * GV.scaleY));
		ScrollView scrollView = new ScrollView(context);
		baseLayout.addView(scrollView, rParams);

		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		RelativeLayout rv = new RelativeLayout(context);
		rv.setId(DisplayView);
		scrollView.addView(rv);

		rParams = new RelativeLayout.LayoutParams((int)(720 * GV.scaleX), LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins(0, 0, (int)(72 * GV.scaleX), 0);
		EditText editText = new EditText(context);
		editText.setId(EditText);
		baseLayout.addView(editText, rParams);

		rParams = new RelativeLayout.LayoutParams((int)(720 * GV.scaleX), LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, (int)(980 * GV.scaleY), 0, 0);
		editText = new EditText(context);
		rv.addView(editText, rParams);

		rParams = new RelativeLayout.LayoutParams((int)(72 * GV.scaleX), LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		Button btn = new Button(context);
		btn.setId(BtnSend);
		btn.setText("↵");
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

		return setBaseLayoutScreenResolution(baseLayout);
	}

}
