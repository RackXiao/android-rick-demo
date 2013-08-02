package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * FACEBOOK社群頁面單格顯示元件
 * @author Jeffrey.Yang
 *
 */
public class CommunityFriendView extends RelativeLayout {

	public enum FriendType {
		FACEBOOK,
		RECOMMAND,
	};
	
	private Bitmap coverBitmap;
	private ImageView coverImage;
	private TextView username;
	private ImageView friendTypeImage;
	private AQuery aq;
	
	public CommunityFriendView(Context context) {
		super(context);
		
		final float scale = LayoutManager.scale;
		final float fontScale = LayoutManager.fontScale;
		
		aq = new AQuery(context);
		RelativeLayout layout = null;
		RelativeLayout.LayoutParams rParams = null;
		ImageView imageView = null;
		TextView textView = null;
		
		//FB Friend Image
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		imageView = new ImageView(context);
		imageView.setId(1);
		imageView.setBackgroundColor(Color.argb(200, 0, 0, 0));
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setAdjustViewBounds(true);
		addView(imageView, rParams);
		coverImage = imageView;
		
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, (int)(30 * scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		layout = new RelativeLayout(context);
		layout.setBackgroundResource(R.drawable.name_bar);
		addView(layout, rParams);
		
		//FB Friend Name
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		textView = new TextView(context);
		textView.setSingleLine();
		textView.setTextSize(12 * fontScale);
		textView.setPadding((int)(7 * scale), 0, 0, 0);
		textView.setGravity(Gravity.CENTER_VERTICAL);
		textView.setTextColor(Color.WHITE);
		layout.addView(textView, rParams);
		username = textView;
		
		//User Name旁的Icon 
		rParams = new LayoutParams((int)(24 * scale), (int)(24 * scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.addRule(RelativeLayout.CENTER_VERTICAL);
		rParams.setMargins(0, 0, (int)(4 * scale), 0);
		imageView = new ImageView(context);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setAdjustViewBounds(true);
		layout.addView(imageView, rParams);
		friendTypeImage = imageView;
		
	}
	
	/**
	 * Show Cover By Bitmap
	 * @param bm Bitmap
	 */
	public void setCover(Bitmap bm) {
		if (coverBitmap != null) {
			coverBitmap.recycle();
			coverBitmap = null;
		}
		coverImage.setImageBitmap(bm);
		coverBitmap = bm;
	}
	
	/**
	 * Show Cover by URL
	 * @param url String
	 */
	public void setCoverUrl(String url) {
		aq.id(coverImage).image(url);
	}
	
	/**
	 * Set UserName 
	 * @param text String
	 */
	public void setUserName(String text) {
		username.setText(text);
	}
	
	/**
	 * Set Bottom Icon ADD or ReCommand
	 * @param type FrendType
	 */
	public void setFriendType(FriendType type) {
		switch (type) {
		case FACEBOOK:
			friendTypeImage.setImageResource(R.drawable.icon_newadd);
			break;
		case RECOMMAND:
			friendTypeImage.setImageResource(R.drawable.icon_newrecommand);
			break;
		}
	}
	
}
