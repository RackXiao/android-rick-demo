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
 * 封面照片小圖元件
 * @author Jeffrey.Yang
 *
 */
public class CoverView extends RelativeLayout {

	private Bitmap coverBitmap;
	private ImageView coverImage;
	private TextView favoriteCount;
	private AQuery aq;
	
	public CoverView(Context context) {
		super(context);
		
		final float scale = LayoutManager.scale;
		final float fontScale = LayoutManager.fontScale;
		
		aq = new AQuery(context);
		RelativeLayout layout = null;
		RelativeLayout.LayoutParams rParams = null;
		ImageView imageView = null;
		TextView textView = null;
		
		// 封面
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, (int)(225 * scale));
		imageView = new ImageView(context);
		imageView.setId(1);
		imageView.setBackgroundColor(Color.argb(200, 0, 0, 0));
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setAdjustViewBounds(true);
		addView(imageView, rParams);
		coverImage = imageView;
		
		// 遮罩
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, (int)(30 * scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		layout = new RelativeLayout(context);
		layout.setBackgroundResource(R.drawable.name_bar);
		addView(layout, rParams);
		
		// 愛心圖示
		rParams = new LayoutParams((int)(20 * scale), (int)(20 * scale));
		rParams.addRule(RelativeLayout.ALIGN_LEFT);
		rParams.addRule(RelativeLayout.CENTER_VERTICAL);
		imageView = new ImageView(context);
		imageView.setId(10);
		imageView.setImageResource(R.drawable.icon_heart20);
		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageView.setAdjustViewBounds(true);
		layout.addView(imageView, rParams);
		
		// 喜愛數量
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, (int)(30 * scale));
		rParams.addRule(RelativeLayout.RIGHT_OF, 10);
		rParams.addRule(RelativeLayout.CENTER_VERTICAL);
		textView = new TextView(context);
		textView.setText("");
		textView.setTextSize(16 * fontScale);
		textView.setGravity(Gravity.CENTER_VERTICAL);
		textView.setTextColor(Color.WHITE);
		layout.addView(textView, rParams);
		favoriteCount = textView;
	}
	
	/**
	 * 設定Cover圖By Bitmap
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
	 * 設定Cover圖By URL
	 * @param url String
	 */
	public void setCoverUrl(String url) {
		aq.id(coverImage).image(url);
	}
	
	/**
	 * 設定Favorite Count
	 * @param count int
	 */
	public void setFavoriteCount(int count) {
		favoriteCount.setText(String.valueOf(count));
	}
	
}
