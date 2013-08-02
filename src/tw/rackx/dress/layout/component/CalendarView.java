package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * CalendarActivity的日期框架
 * @author Jeffrey.Yang
 *
 */
public class CalendarView extends RelativeLayout {
	
	private TextView dateView;
	private ImageView statusBackground;
	private TextView statusNumber;
	private RelativeLayout statusLayout = null;
	private ImageView icon;
	
	public CalendarView(Context context){
		super(context);
	}
	
	public CalendarView(Context context, boolean isShowWeek){
		super(context);
		
		final float scale = LayoutManager.scale;
		final float fontScale = LayoutManager.fontScale;
		
		RelativeLayout.LayoutParams params = null;
		params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		TextView textview = new TextView(context);
		if (isShowWeek) {
			textview.setGravity(Gravity.CENTER);
		} else {
			textview.setGravity(Gravity.TOP);
			textview.setGravity(Gravity.RIGHT);
		}
		textview.setId(1);
		textview.setTypeface(null, Typeface.BOLD);
		textview.setTextSize((int)(16 * fontScale));
		textview.setTextColor(Color.rgb(52, 52, 52));
		addView(textview, params);
		dateView = textview;
		
		//顯示衣服圖示
		params = new LayoutParams((int)(30 * scale), (int)(45 * scale));
		//params.addRule(RelativeLayout.ALIGN_BASELINE);
		params.setMargins((int)(8 * scale), (int)(26 * scale), 0, 0);
		ImageView imageview = new ImageView(context);
		imageview.setId(10);
		imageview.setScaleType(ScaleType.CENTER_INSIDE);
		addView(imageview, params);
		icon = imageview;

		// 未讀取狀態(背景+數量)
		statusLayout = new RelativeLayout(context);
		
		params = new LayoutParams(LayoutParams.WRAP_CONTENT, (int)(32 * scale));
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		imageview = new ImageView(context);
		imageview.setAdjustViewBounds(true);
		imageview.setScaleType(ScaleType.FIT_CENTER);
		imageview.setImageResource(R.drawable.number_cir);
		statusLayout.addView(imageview, params);
		statusBackground = imageview;
		
		params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		textview = new TextView(context);
		textview.setTextColor(Color.WHITE);
		textview.setTextSize((int)(9 * fontScale));
		textview.setGravity(Gravity.CENTER);
		//textview.setText(String.format("%d", statusCount));
		statusLayout.addView(textview, params);
		statusNumber = textview;
		
		params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		//params.addRule(RelativeLayout.ALIGN_BOTTOM, 1);
		//params.addRule(RelativeLayout.ALIGN_RIGHT, 1);
		params.setMargins((int)(31 * scale), (int)(42 * scale), 0, 0);
		statusLayout.setVisibility(GONE);
		addView(statusLayout, params);
	}
	
	/**
	 * 設定Calendar的日期
	 * @param date String
	 */
	public void setCalendarText(String date){
		dateView.setText(date);
	}
	
	/**
	 * 取得Calendar的日期
	 * @return
	 */
	public String getCalendarText() {
		return (String) dateView.getText();
	}
	/**
	 * Override 設定Calendar的日期，透過SpannableString
	 * @param date SpannableString
	 */
	public void setCalendarText(SpannableString date){
		dateView.setText(date);
	}
	
	/**
	 * 設定Calendar的背景色
	 * @param color int
	 */
	public void setCalendarBackgrand(int color){
		dateView.setBackgroundColor(color);
	}
	
	/**
	 * 設定Calendar的文字顏色
	 * @param color int
	 */
	public void setCalendarTextColor(int color){
		dateView.setTextColor(color);
	}
	
	/**
	 * 設定Calendar格子的高
	 * @param h
	 */
	public void setCalendarDateHeight(int h){
		RelativeLayout.LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, h);
		dateView.setLayoutParams(params);
	}
	
	/**
	 * 取得Calendar是否有記錄
	 * @return
	 */
	public boolean isDailyRecord() {
		return (Integer.parseInt((String) statusNumber.getText()) > 0 ? true : false );
	}
	
	/**
	 * 設定Calendar格子是否可以被點擊
	 * @param isClick
	 */
	public void setCalendarClickDisable(boolean isClick){
        	setClickable(isClick);
        	setFocusable(isClick);

	}
	
	/**
	 * 設定Calendar若有記錄的圖跟數量
	 * @param bm Bitmap
	 * @param count int
	 */
	public void setWardrobeTag(Bitmap bm, int count) {
		Drawable drawable = icon.getDrawable();
		if (drawable instanceof BitmapDrawable) {
			BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
			Bitmap bitmap = bitmapDrawable.getBitmap();
			bitmap.recycle();
		}
		icon.setImageBitmap(bm);
		
		statusNumber.setText(String.valueOf(count));
		if (count > 1) {
			statusLayout.setVisibility(VISIBLE);
			if (count > 99) {
				statusBackground.setImageResource(R.drawable.number_cir2);
			} else {
				statusBackground.setImageResource(R.drawable.number_cir);
			}
		} else
			statusLayout.setVisibility(GONE);
	};
}
