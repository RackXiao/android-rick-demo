package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * UserListRow Component
 */
public class UserListBanner extends RelativeLayout {
	
	public UserListBanner(Context context) {
		super(context);
		
		RelativeLayout.LayoutParams rParams = null;
		ImageView imageView;
		TextView textView;
		
		// TOP BAR
		setId(LayoutManager.UserListBanner);
		setBackgroundColor(Color.rgb(51, 181, 229));
		
		// 頭像圖示
		rParams = new RelativeLayout.LayoutParams((int)(50 * LayoutManager.scale), (int)(50 * LayoutManager.scale));
		rParams.setMargins((int)(23 * LayoutManager.scale), (int)(22 * LayoutManager.scale), 0, 0);
		imageView = new ImageView(context);
		imageView.setId(LayoutManager.UserListPhoto);
		imageView.setImageResource(R.drawable.icon_portrait);
		addView(imageView, rParams);
		
		// 標題
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.RIGHT_OF, LayoutManager.UserListPhoto);
		rParams.addRule(RelativeLayout.CENTER_VERTICAL);
		rParams.setMargins((int)(14 * LayoutManager.scale), 0, 0, 0);
		textView = new TextView(context);
		textView.setId(LayoutManager.UserListTitle);
		textView.setTextSize(20 * LayoutManager.fontScale);
		textView.setTextColor(Color.WHITE);
		addView(textView, rParams);
	}
}
