package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * UserBanner Component
 */
public class UserBanner extends RelativeLayout {

	private Bitmap photoBitmap;
	private ImageView photoImage;
	private TextView username;
	private TextView location;
	public TextView trackingInfo;
	public TextView followingInfo;
	private TextView joinDate;
	public StatusButton followSwitchButton;
	public ImageView saveButton;
	private AQuery aq;
	
	public UserBanner(Context context) {
		super(context);
	}
	public UserBanner(Context context, boolean isShowFollowButton) {
		super(context);
		
		final float scale = LayoutManager.scale;
		final float fontScale = LayoutManager.fontScale;
		
		aq = new AQuery(context);
		
		RelativeLayout.LayoutParams rParams = null;
		ImageView imageView = null;
		TextView textView = null;
		
		setBackgroundColor(Color.WHITE);
		
		// 頭像圖示
		rParams = new LayoutParams((int)(150 * scale), (int)(150 * scale));
		rParams.setMargins((int)(8 * scale), (int)(10 * scale), 0, 0);
		imageView = new ImageView(context);
		imageView.setId(100);
		imageView.setScaleType(ScaleType.FIT_CENTER);
		addView(imageView, rParams);
		photoImage = imageView;
		
		// 姓名
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.RIGHT_OF, 100);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, 100);
		rParams.setMargins((int)(17 * scale), (int)(5 * scale), 0, 0);
		textView = new TextView(context);
		textView.setId(101);
		//textView.setText("姓名");
		textView.setTextColor(Color.rgb(103, 103, 103));
		textView.setTextSize(22 * fontScale);
		textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		addView(textView, rParams);
		username = textView;
		
		// 所在地
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, 101);
		rParams.addRule(RelativeLayout.BELOW, 101);
		textView = new TextView(context);
		textView.setId(102);
		//textView.setText("所在地");
		textView.setTextColor(Color.rgb(169, 169, 169));
		textView.setTextSize(12 * fontScale);
		textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		addView(textView, rParams);
		location = textView;

		// 加入日期
		rParams = new LayoutParams((int)(210 * scale), LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, 101);
		rParams.addRule(RelativeLayout.BELOW, 102);
		rParams.setMargins(0, (int)(12 * scale), 0, 0);
		textView = new TextView(context);
		textView.setId(105);
		//textView.setText("什麼時間加入的");
		textView.setTextColor(Color.rgb(53, 214, 214));
		textView.setTextSize(12 * fontScale);
		textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		addView(textView, rParams);
		joinDate = textView;
			
		// 關注中：此使用者關注了多少人
		rParams = new LayoutParams((int)(145 * scale), (int)(50 * scale));
		rParams.addRule(RelativeLayout.ALIGN_LEFT, 101);
		rParams.addRule(RelativeLayout.BELOW, 105);
		textView = new TextView(context);
		textView.setId(103);
		textView.setTextColor(Color.WHITE);
		textView.setBackgroundResource(R.drawable.bg_follow);
		textView.setTextSize(12 * fontScale);
		textView.setGravity(Gravity.CENTER);
		addView(textView, rParams);
		trackingInfo = textView;
		
		// 追蹤者：此使用者被多少人追蹤
		rParams = new LayoutParams((int)(145 * scale), (int)(50 * scale));
		rParams.addRule(RelativeLayout.RIGHT_OF, 103);
		rParams.addRule(RelativeLayout.ALIGN_BOTTOM, 103);
		rParams.setMargins((int)(4 * scale), 0, 0, 0);
		textView = new TextView(context);
		textView.setId(104);
		textView.setTextColor(Color.WHITE);
		textView.setBackgroundResource(R.drawable.bg_follow);
		textView.setTextSize(12 * fontScale);
		textView.setGravity(Gravity.CENTER);
		textView.setPadding(0, 0, 0, 0);
		addView(textView, rParams);
		followingInfo = textView;
	
		if (isShowFollowButton) {
			// 追蹤按鈕
			rParams = new RelativeLayout.LayoutParams((int)(84 * LayoutManager.scale), (int)(72 * LayoutManager.scale));
			rParams.addRule(RelativeLayout.ALIGN_RIGHT, 104);
			rParams.addRule(RelativeLayout.ALIGN_BOTTOM, 105);
			rParams.setMargins(0, (int)(24 * scale), 0, (int)(4 * scale));
			followSwitchButton = new StatusButton(context);
			followSwitchButton.setId(106);
			followSwitchButton.setGravity(Gravity.BOTTOM | Gravity.LEFT);
			followSwitchButton.setVisibility(View.GONE);
			addView(followSwitchButton, rParams);
		}
		
		// 分隔條線
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, (int)(168 * scale), 0, 0);
		imageView = new ImageView(context);
		imageView.setId(107);
		imageView.setImageResource(R.drawable.line_item_divid);
		imageView.setScaleType(ScaleType.CENTER_CROP);
		addView(imageView, rParams);
	}
	
	/**
	 * Set User Photo Image by Bitmap
	 * @param bm
	 */
	public void setPhoto(Bitmap bm) {
		if (photoBitmap != null) {
			photoBitmap.recycle();
			photoBitmap = null;
		}
		photoImage.setImageBitmap(bm);
		photoBitmap = bm;
	}
	
	/**
	 * Set User Photo Image by URL
	 * @param url
	 */
	public void setPhotoUrl(String url) {
		aq.id(photoImage).image(url, true, false);
	}
	
	/**
	 * Set User Name Text
	 * @param text
	 */
	public void setUsername(String text) {
		username.setText(text);
	}
	
	/**
	 * Set User Location Text
	 * @param text
	 */
	public void setLocation(String text) {
		location.setText(text);
	}
	
	/**
	 * Set Following Count text
	 * @param count
	 */
	public void setFollowingCount(int count) {
		if (count > -1) {
			followingInfo.setText(String.format("%d %s", count, getContext().getString(R.string.UserBannerHowMuchFollowers)));
		}
	}
	
	/**
	 * Set Tracking Count text
	 * @param count
	 */
	public void setTrackingCount(int count) {
		if (count > -1) {
			trackingInfo.setText(String.format("%d %s", count, getContext().getString(R.string.UserBannerHowMuchTracking)));
		}
	}
	
	/**
	 * Set User Join Date Text
	 * @param text
	 */
	public void setJoinDate(String text) {
		joinDate.setText(String.format("%s加入", text));
	}
	
	/**
	 * Get User Location Text
	 * @return String
	 */
	public String getLocation() {
		return location.getText().toString();
	}

}
