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
 * Status Button
 * @author Jeffrey.Yang
 *
 */
public class StatusButton extends RelativeLayout {

	private ImageView icon;
	private RelativeLayout statusLayout;
	private ImageView statusBackground;
	private TextView statusNumber;
	private int statusCount;

	public StatusButton(Context context) {
		super(context);

		final float scale = LayoutManager.scale;
		final float fontScale = LayoutManager.fontScale;
		
		
		RelativeLayout.LayoutParams rParams = null;
		ImageView imageView = null;
		TextView textView = null;
		
		// 按鈕圖示
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		imageView = new ImageView(context);
		imageView.setId(1);
		imageView.setScaleType(ScaleType.CENTER_INSIDE);
		imageView.setAdjustViewBounds(true);
		addView(imageView, rParams);
		icon = imageView;

		// 未讀取狀態(背景+數量)
		statusLayout = new RelativeLayout(context);
		
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, (int)(32 * scale));
		rParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		rParams.setMargins(0, (int)(4 * scale), 0, 0);
		imageView = new ImageView(context);
		imageView.setAdjustViewBounds(true);
		imageView.setScaleType(ScaleType.FIT_CENTER);
		imageView.setImageResource(R.drawable.number_cir);
		statusLayout.addView(imageView, rParams);
		statusBackground = imageView;
		
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		rParams.setMargins(0, (int)(4 * scale), 0, 0);
		textView = new TextView(context);
		textView.setTextColor(Color.WHITE);
		textView.setTextSize(9 * fontScale);
		textView.setGravity(Gravity.CENTER);
		textView.setText(String.valueOf(statusCount));
		statusLayout.addView(textView, rParams);
		statusNumber = textView;
		
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_RIGHT, 1);
		rParams.addRule(RelativeLayout.ALIGN_TOP, 1);
		statusLayout.setVisibility(GONE);
		addView(statusLayout, rParams);
		
	}

	/**
	 * Set Icon by Resource Id
	 * @param resID
	 */
	public void setIcon(int resID) {
		icon.setImageResource(resID);
	}
	
	/**
	 * Set Status Button Count Text
	 * @param count >1會顯示紅圈
	 */
	public void setStatusCount(int count) {
		statusNumber.setText(String.valueOf(count));
		if (count > 0) {
			statusLayout.setVisibility(VISIBLE);
			if (count > 99) {
				statusBackground.setImageResource(R.drawable.number_cir2);
			} else {
				statusBackground.setImageResource(R.drawable.number_cir);
			}
		} else
			statusLayout.setVisibility(GONE);
	}
	
	/**
	 * 清空Status Count Text
	 */
	public void clearStatusCount() {
		setStatusCount(0);
	}
}
