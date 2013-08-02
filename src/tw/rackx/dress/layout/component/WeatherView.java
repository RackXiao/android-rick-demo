package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.otiga.dress.data.ConstantTerm;
import com.otiga.dress.layout.LayoutManager;

/**
 * DailyTips Weather View
 * @author Jeffrey.Yang
 *
 */
public class WeatherView extends RelativeLayout {

	private TextView DailyWeek;
	private TextView DailyDate;
	private TextView DailyWeatherCondition;
	private TextView DailyWeatherTemp;
	private ImageView DailyWeatherImage;
	private Bitmap coverBitmap;
	private AQuery aq;

	public WeatherView(Context context) {
		super(context);
		
		final float scaleX = LayoutManager.scale;
		final float scaleY = ConstantTerm.resolution.y / ConstantTerm.targetResolution.y;
		final float fontScale = LayoutManager.fontScale;
		
		aq = new AQuery(context);
		RelativeLayout.LayoutParams rParams = null;
		TextView textview = null;
		ImageView imageview = null;

		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, (int)(60 * scaleY));
		RelativeLayout layout = new RelativeLayout(context);
		layout.setId(6);
		layout.setPadding((int)(10 * scaleX), 0, 0, (int)(10 * scaleY));
		layout.setBackgroundColor(Color.rgb(51, 51, 51));
		addView(layout, rParams);

		// 顯示星期
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		textview = new TextView(context);
		textview.setId(1);
		textview.setTextColor(Color.rgb(255, 255, 255));
		textview.setTextSize(17 * fontScale);
		textview.setGravity(Gravity.LEFT);
		//textview.setText("星期一");
		layout.addView(textview, rParams);
		DailyWeek = textview;

		// 顯示日期
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW, 1);
		textview = new TextView(context);
		textview.setId(2);
		textview.setTextColor(Color.rgb(52, 213, 213));
		textview.setTextSize(10 * fontScale);
		textview.setGravity(Gravity.LEFT);
		//textview.setText("10/21");
		layout.addView(textview, rParams);
		DailyDate = textview;

		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, (int)(60 * scaleY));
		rParams.addRule(RelativeLayout.BELOW, 6);
		layout = new RelativeLayout(context);
		layout.setId(7);
		layout.setBackgroundColor(Color.rgb(255, 255, 255));
		addView(layout, rParams);

		// 顯示天氣圖
		rParams = new LayoutParams((int)(67 * scaleX), (int)(67 * scaleY));
		imageview = new ImageView(context);
		imageview.setId(3);
		imageview.setPadding((int)(8 * scaleX), (int)(8 * scaleY), (int)(8 * scaleX), (int)(8 * scaleY));
		imageview.setScaleType(ScaleType.CENTER_CROP);
		//imageview.setImageResource(R.drawable.wicon_01);
		layout.addView(imageview, rParams);
		DailyWeatherImage = imageview;

		// 顯示溫度
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, (int)(30 * scaleY));
		rParams.addRule(RelativeLayout.RIGHT_OF, 3);
		textview = new TextView(context);
		textview.setId(4);
		textview.setTextColor(Color.rgb(102, 102, 102));
		textview.setTextSize(14 * fontScale);
		textview.setGravity(Gravity.LEFT | Gravity.BOTTOM);
		//textview.setText("22-18");
		layout.addView(textview, rParams);
		DailyWeatherTemp = textview;

		// 顯示天氣狀況
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, (int)(30 * scaleY));
		rParams.addRule(RelativeLayout.RIGHT_OF, 3);
		rParams.addRule(RelativeLayout.BELOW, 4);
		textview = new TextView(context);
		textview.setId(5);
		textview.setTextColor(Color.rgb(102, 102, 102));
		textview.setTextSize(12 * fontScale);
		textview.setGravity(Gravity.LEFT | Gravity.TOP);
		//textview.setText("晴時多雲");
		layout.addView(textview, rParams);
		DailyWeatherCondition = textview;

	}

	/**
	 * Set Weather Image by Bitmap
	 * @param bm
	 */
	public void setWeatherImage(Bitmap bm) {
		if (coverBitmap != null) {
			coverBitmap.recycle();
			coverBitmap = null;
		}
		DailyWeatherImage.setImageBitmap(bm);
		coverBitmap = bm;
	}
	
	/**
	 * Set Weather Image by URL
	 * @param url
	 */
	public void setWeatherImageUrl(String url) {
		aq.id(DailyWeatherImage).image(url);
	}

	/**
	 * Set Week Text
	 * @param week
	 */
	public void setWeatherWeek(String week) {
		DailyWeek.setText(week);
	}

	/**
	 * Set Date Text
	 * @param date
	 */
	public void setWeatherDate(String date) {
		DailyDate.setText(date);
	}

	/**
	 * Set Weather Condition Text
	 * @param condition
	 */
	public void setWeatherCondition(String condition) {
		DailyWeatherCondition.setText(condition);
	}

	/**
	 * Set Weather Temperteure Text
	 * @param temp
	 */
	public void setWeatherTemp(String temp) {
		DailyWeatherTemp.setText(temp);
	}
}
