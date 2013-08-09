package com.otiga.dress.layout.component;


import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.otiga.dress.layout.LayoutManager;

/**
 * 文字加Icon的Button
 * @author Jeffrey.Yang
 *
 */
public class ImageTextButton extends RelativeLayout {

	private ImageView icon;
	private TextView text;
	
	public ImageTextButton(Context context) {
		super(context);
		
		RelativeLayout.LayoutParams rParams = null;
		ImageView imageView = null;
		TextView textView = null;
		
		LinearLayout lLayout = null;
		LinearLayout.LayoutParams lParams = null;
		
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		lLayout = new LinearLayout(context);
		lLayout.setOrientation(LinearLayout.VERTICAL);
		lLayout.setWeightSum(2);
		addView(lLayout, rParams);
		
		// 按鈕圖示
		lParams = new LinearLayout.LayoutParams((int)(34 * LayoutManager.scale), (int)(34 * LayoutManager.scale), (int)(1 * LayoutManager.scale));
		lParams.setMargins(0, 8, 0, 0);
		lParams.gravity = Gravity.CENTER;
		imageView = new ImageView(context);
		imageView.setScaleType(ScaleType.CENTER_INSIDE);
		imageView.setAdjustViewBounds(true);
		imageView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return false;
			}
		});
		lLayout.addView(imageView, lParams);
		icon = imageView;
		
		// 按鈕文字
		lParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1);
		lParams.gravity = Gravity.CENTER;
		textView = new TextView(context);
		textView.setTextColor(Color.WHITE);
		textView.setTextSize(12);
		textView.setGravity(Gravity.CENTER);
		textView.setText("");
		textView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return false;
			}
		});
		lLayout.addView(textView, lParams);
		text = textView;
	}
	
	/**
	 * Set Button's Icon by Resource Id
	 * @param resId int
	 */
	public void setIcon(int resId) {
		icon.setImageResource(resId);
	}
	
	/**
	 * Set Button's Text
	 * @param s String
	 */
	public void setText(String s) {
		text.setText(s);
	}
	
	
}
