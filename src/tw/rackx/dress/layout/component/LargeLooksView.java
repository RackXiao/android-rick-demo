package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * hotlook與追蹤好友的封面元件
 * @author TSD-Kevin
 *
 */
public class LargeLooksView extends RelativeLayout {
	private int totalHeight;
	private ImageView coverImage;
	private ImageView coverFrame;
	private ImageView stripPanel;
	private ImageView iconLike;
	private ImageView iconDislike;
	private TextView likeNum;
	private TextView dislikeNum;
	private TextView time;
	private ImageView userIcon;
	private TextView name;
	private TextView city;
	private AQuery aq;
	
	public LargeLooksView(Context context) {
		super(context);
	}
	
	public LargeLooksView(Context context,int PicWidth, int PicHeight) {
		super(context);
		
		final float scale = LayoutManager.scale;
		final float fontScale = LayoutManager.fontScale;
		RelativeLayout.LayoutParams rParams = null;
		totalHeight = PicHeight + (int)(91 * scale);
		
		//Cover Image
		rParams = new LayoutParams(PicWidth, PicHeight);
		coverImage = new ImageView(context);
		coverImage.setBackgroundColor(Color.argb(200, 0, 0, 0));
		coverImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
		coverImage.setId(1);
		addView(coverImage, rParams);
		
		//Event frame
		rParams = new LayoutParams((int)(72 * scale), (int)(72 * scale));
		rParams.addRule(RelativeLayout.ALIGN_TOP,1);
		rParams.addRule(RelativeLayout.ALIGN_LEFT,1);
		coverFrame = new ImageView(context);
		coverFrame.setScaleType(ImageView.ScaleType.CENTER_CROP);
		addView(coverFrame, rParams);
		
		//image底下的panel
		rParams = new LayoutParams(PicWidth, (int)(91 * scale));
		rParams.addRule(RelativeLayout.BELOW,1);
		stripPanel = new ImageView(context);
		stripPanel.setImageResource(R.drawable.strip_panel);
		stripPanel.setScaleType(ScaleType.FIT_XY);
		addView(stripPanel, rParams);
		
		//panel的like圖案
		rParams = new LayoutParams((int)(24 * scale), (int)(24 * scale));	
		rParams.addRule(RelativeLayout.BELOW,1);
		rParams.addRule(RelativeLayout.ALIGN_LEFT,1);
		rParams.setMargins((int)(7 * scale), 0, 0, 0);
		iconLike = new ImageView(context);
		iconLike.setImageResource(R.drawable.icon24_like);
		addView(iconLike, rParams);	
		
		//panel的like數量
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW,1);
		rParams.addRule(RelativeLayout.ALIGN_LEFT,1);
		rParams.setMargins((int)(31 * scale), 0, 0, 0);
		likeNum = new TextView(context);
		likeNum.setTextColor(Color.rgb(153, 153, 153));
		likeNum.setTextSize((int)(12 * fontScale));
		addView(likeNum, rParams);
		
		//panel的dislike圖案
		rParams = new LayoutParams((int)(24 * scale), (int)(24 * scale));
		rParams.addRule(RelativeLayout.BELOW,1);
		rParams.addRule(RelativeLayout.ALIGN_LEFT,1);
		rParams.setMargins((int)(81 * scale), 0, 0, 0);
		iconDislike = new ImageView(context);
		iconDislike.setImageResource(R.drawable.icon24_dislike);
		addView(iconDislike, rParams);	
		
		//panel的dislike數量
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW,1);
		rParams.addRule(RelativeLayout.ALIGN_LEFT,1);
		rParams.setMargins((int)(105 * scale), 0, 0, 0);
		dislikeNum = new TextView(context);
		dislikeNum.setTextColor(Color.rgb(153, 153, 153));
		dislikeNum.setTextSize((int)(12 * fontScale));
		addView(dislikeNum, rParams);
		
		//panel的顯示時間
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW,1);
		rParams.addRule(RelativeLayout.ALIGN_RIGHT,1);
		rParams.setMargins(0, 0, (int)(3 * scale), 0);
		time = new TextView(context);
		time.setTextColor(Color.rgb(153, 153, 153));
		time.setTextSize((int)(12 * fontScale));
		addView(time, rParams);
		
		//panel的user大頭貼
		rParams = new LayoutParams((int)(49 * scale), (int)(49 * scale));
		rParams.addRule(RelativeLayout.BELOW,1);
		rParams.addRule(RelativeLayout.ALIGN_LEFT,1);
		rParams.setMargins((int)(7 * scale), (int)(33 * scale), 0, 0);
		userIcon = new ImageView(context);
		userIcon.setId(2);
		userIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
		addView(userIcon, rParams);	
		
		//panel的username
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.RIGHT_OF, 2);
		rParams.addRule(RelativeLayout.ALIGN_TOP, 2);
		rParams.setMargins((int)(7 * scale), 0, 0, 0);
		name = new TextView(context);
		name.setId(3);
		name.setTextColor(Color.rgb(103, 103, 103));
		name.setTextSize(12 * fontScale);
		name.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		addView(name, rParams);
			
		//panel的usercity
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, 3);
		rParams.addRule(RelativeLayout.BELOW, 3);
		city = new TextView(context);
		city.setTextColor(Color.rgb(153, 153, 153));
		city.setTextSize(10 * fontScale);
		city.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		addView(city, rParams);
		
		
		aq = new AQuery(context);
	}
	
	public void setEventFrame(){
		coverFrame.setImageResource(R.drawable.tnail_look);
	}
	
	/**
	 * Set Cover Image By URL
	 * @param url String
	 */
	public void setCoverUrl(String url) {
		aq.id(coverImage).image(url);
	}
	
	/**
	 * 設置like數
	 * @param num
	 */
	public void setLikeNum(int num) {
		likeNum.setText(String.valueOf(num));
	}
	
	/**
	 * 設置dislike數
	 * @param num
	 */
	public void setDislikeNum(int num) {
		dislikeNum.setText(String.valueOf(num));
	}
	
	/**
	 * 設置時間
	 * @param text
	 */
	public void setTime(String text) {
		time.setText(text);
	}
	
	/**
	 * set 上傳者大頭貼
	 * @param url
	 */
	public void setUserIcon(String url) {
		aq.id(userIcon).image(url);
	}
	
	/**
	 * 上傳者姓名
	 * @param text
	 */
	public void setName(String text) {
		if (name != null)
			name.setText(text);
	}
	
	/**
	 * Set Cover Bottom Text
	 * @param text String
	 */
	public void setCity(String text) {
		if (text != null)
			city.setText(text);
	}
	
	/**
	 * Set Cover Bottom Text Visibility
	 * @param visibility int
	 */
	public void setCityVisible(int visibility) {
		city.setVisibility(visibility);
	}
	
	public int getTotalHeight(){
		return totalHeight;
	}

}
