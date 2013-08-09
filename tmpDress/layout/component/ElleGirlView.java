package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * 編輯嚴選的封面元件
 * @author Jeffrey.Yang
 *
 */
public class ElleGirlView extends RelativeLayout {

	//private Bitmap coverBitmap;
	private ImageView coverImage;
	private ImageView coverFrame;
	private TextView city;
	private AQuery aq;
	
	public ElleGirlView(Context context) {
		super(context);
		
		final float scale = LayoutManager.scale;
		
		RelativeLayout.LayoutParams rParams = null;
		
		//Cover Image
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		ImageView imageView = new ImageView(context);
		imageView.setBackgroundColor(Color.argb(200, 0, 0, 0));
		imageView.setScaleType(ScaleType.CENTER_CROP);
		imageView.setId(1);
		addView(imageView, rParams);
		coverImage = imageView;
		
		//Event frame
		rParams = new LayoutParams((int)(72 * scale), (int)(72 * scale));
		rParams.addRule(RelativeLayout.ALIGN_TOP,1);
		rParams.addRule(RelativeLayout.ALIGN_LEFT,1);
		ImageView imageView2 = new ImageView(context);
		imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
		addView(imageView2, rParams);
		coverFrame = imageView2;
		
		//Bottom Text 
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, (int)(35 * scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		TextView textView = new TextView(context);
		textView.setGravity(Gravity.CENTER_VERTICAL);
		textView.setPadding((int)(10 * scale), 0, 0, 0);
		textView.setTextColor(Color.WHITE);
		textView.setBackgroundColor(Color.argb(150, 0, 0, 0));
		addView(textView, rParams);
		city = textView;
		
		aq = new AQuery(context);
	}
	
	public void setEventFrame(){
		coverFrame.setImageResource(R.drawable.tnail_look);
	}
	
	/**
	 * Set Cover Image By Bitmap
	 * @param bm Bitmap
	 */
	public void setCover(Bitmap bm) {
		Drawable drawable = coverImage.getDrawable();
		if (drawable instanceof BitmapDrawable) {
			BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
			Bitmap bitmap = bitmapDrawable.getBitmap();
			bitmap.recycle();
		}
		coverImage.setImageBitmap(bm);
	}
	
	/**
	 * Set Cover Image By URL
	 * @param url String
	 */
	public void setCoverUrl(String url) {
		aq.id(coverImage).image(url);
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

}
