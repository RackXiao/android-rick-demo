package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * 留言清單的List元件
 * @author Jeffrey.Yang
 *
 */
public class CommentView extends RelativeLayout {

	private TextView userName;
	private TextView commentTime;
	private TextView comment;
	private ImageView userImage;
	private ImageView menu;
	private AQuery aq;
	
	private String User_id;
	private String message;
	
	public CommentView(Context context) {
		super(context);
		
		final float scale = LayoutManager.scale;
		final float fontScale = LayoutManager.fontScale;
		
		RelativeLayout.LayoutParams rParams = null;
		TextView textView = null;
		ImageView imageView = null;
		setPadding(0, 0, 0, (int)(10 * scale));
		//大頭貼
		rParams = new LayoutParams((int)(60 * scale), (int)(60 * scale));
		rParams.setMargins((int)(5 * scale), (int)(5 * scale), 0, 0);
		imageView = new ImageView(context);
		imageView.setId(50);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		addView(imageView, rParams);
		userImage = imageView;
		
		// 姓名
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RIGHT_OF, 50);
		rParams.setMargins((int)(15 * scale), 0, 0, 0);
		textView = new TextView(context);
		textView.setId(100);
		textView.setTextSize(18 * fontScale);
		textView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		textView.setTextColor(Color.WHITE);
		addView(textView, rParams);
		userName = textView;
		
		// 時間
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, (int)(34 * scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.setMargins(0, 0, (int)(15 * scale), 0);
		textView = new TextView(context);
		textView.setId(110);
		textView.setTextSize(12 * fontScale);
		textView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		textView.setTextColor(Color.rgb(49, 182, 230));
		textView.setEnabled(false);
		addView(textView, rParams);
		commentTime = textView;
		
		// 留言內容
		rParams = new LayoutParams((int)(332 * scale), LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW, 100);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, 100);
		rParams.setMargins(0, (int)(5 * scale), (int)(20 * scale), 0);
		textView = new TextView(context);
		textView.setId(120);
		textView.setSingleLine(false);
		textView.setTextSize(14 * fontScale);
		textView.setGravity(Gravity.LEFT | Gravity.TOP);
		textView.setTextColor(Color.rgb(204, 204, 204));
		addView(textView, rParams);
		comment = textView;
		
		//menu
		rParams = new LayoutParams((int)(42 * scale), (int)(42 * scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.addRule(RelativeLayout.ALIGN_TOP,120);
		rParams.setMargins(0, 0, (int)(15 * scale), 0);
		menu = new ImageView(context);
		menu.setImageResource(R.drawable.icon_more42);
		addView(menu, rParams);
		
		
		aq = new AQuery(context);
	}
	
	/**
	 * 設定UserName
	 * @param name String
	 */
	public void setUserName(String name) {
		userName.setText(name);
	}
	
	/**
	 * 設置此留言view留言者id
	 * @param id
	 */
	public void setUserid(String id){
		User_id = id;
	}
	
	/**
	 * 取得此留言view留言者id
	 * @return
	 */
	public String getUserid(){
		return User_id;
	}
	
	/**
	 * 設定Comment Time
	 * @param time String
	 */
	public void setCommentTime(String time) {
		commentTime.setText(time);
	}
	
	/**
	 * 設定Comment內容
	 * @param text String
	 */
	public void setComment(String text) {
		message = text;
		comment.setText(message);
	}
	
	/**
	 * 取得Comment內容
	 * @return message
	 */
	public String getComment(){
		return message;
	}
	
	/**
	 * 設定Comment 大頭貼
	 * @param url String
	 */
	public void setUserImageURL(String url) {
		aq.id(userImage).image(url, true, false);
	}
	
	/**
	 * 設定時間顏色
	 * @param url String
	 */
	public void setTimeColor() {
		commentTime.setTextColor(Color.WHITE);
	}
	
	public ImageView getMenu(){
		return menu;
		
	}

}
