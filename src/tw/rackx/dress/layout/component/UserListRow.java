package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * UserListRow Component
 */
public class UserListRow extends RelativeLayout {

	public int resPhoto;
	public int resName;
	public int resPlace;
	public int resTraceBtn;
	
	public UserListRow(Context context) {
		super(context);
	}

	public UserListRow(Context context,int id) {
		super(context);
		
		setId(id);
		
		RelativeLayout.LayoutParams rParams = null;
		ImageView imageView = null;
		TextView textView = null;
		
		// 分隔線
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(5 * LayoutManager.scale));
		imageView = new ImageView(context);
		imageView.setId(id + 1);
		imageView.setImageResource(R.drawable.divide_line);
		imageView.setScaleType(ScaleType.FIT_XY);
		addView(imageView, rParams);
		
		// 頭像圖示
		rParams = new RelativeLayout.LayoutParams((int)(50 * LayoutManager.scale), (int)(50 * LayoutManager.scale));
		rParams.setMargins((int)(23 * LayoutManager.scale), (int)(22 * LayoutManager.scale), 0, 0);
		imageView = new ImageView(context);
		resPhoto = id + 2;
		imageView.setId(resPhoto);
		addView(imageView, rParams);

		// 名稱
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.RIGHT_OF, resPhoto);
		rParams.addRule(RelativeLayout.ALIGN_TOP, resPhoto);
		rParams.setMargins((int)(14 * LayoutManager.scale), 0, 0, 0);
		textView = new TextView(context);
		resName = id + 3;
		textView.setId(resName);
		textView.setTextColor(Color.rgb(53, 214, 214));
		textView.setTextSize(18 * LayoutManager.fontScale);
		addView(textView, rParams);
		
		// 位置
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, resName);
		rParams.addRule(RelativeLayout.BELOW, resName);
		textView = new TextView(context);
		resPlace = id + 4;
		textView.setId(resPlace);
		textView.setTextColor(Color.rgb(169, 169, 169));
		textView.setTextSize(12 * LayoutManager.fontScale);
		addView(textView, rParams);
		
		// 追蹤按鈕
		rParams = new RelativeLayout.LayoutParams((int)(84 * LayoutManager.scale), (int)(72 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.setMargins(0, (int)(24 * LayoutManager.scale), (int)(20 * LayoutManager.scale), (int)(24 * LayoutManager.scale));
		StatusButton traceBtn = new StatusButton(context);
		resTraceBtn = id + 5;
		traceBtn.setId(resTraceBtn);
		traceBtn.setGravity(Gravity.BOTTOM | Gravity.LEFT);
		addView(traceBtn, rParams);
	}
}
