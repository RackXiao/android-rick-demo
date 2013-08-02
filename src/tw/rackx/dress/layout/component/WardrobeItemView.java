package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.androidquery.AQuery;
import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * Wardrobe & WishList Item Component
 * @author Jeffrey.Yang
 *
 */
public class WardrobeItemView extends RelativeLayout {

	private Bitmap itemBitmap;
	public ImageView itemImage;
	private ImageView selectedImage;
	public ImageView deleteImage;
	private AQuery aq;
	
	public WardrobeItemView(Context context) {
		super(context);
	}
	
	public WardrobeItemView(Context context, Point dimension) {
		super(context);
		
		float scale = LayoutManager.scale;
		
		aq = new AQuery(context);
		RelativeLayout.LayoutParams rParams = null;
		ImageView imageView = null;
		
		rParams = new LayoutParams((int)(100 * scale), LayoutParams.MATCH_PARENT);
		rParams.addRule(RelativeLayout.CENTER_VERTICAL);
		rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		imageView = new ImageView(context);
		imageView.setId(1);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		addView(imageView, rParams);
		itemImage = imageView;
		
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		rParams.setMargins(0, 0, (int)(10 * scale), 0);
		imageView = new ImageView(context);
		imageView.setId(2);
		imageView.setImageResource(R.drawable.u44_normal);
		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageView.setAdjustViewBounds(true);
		imageView.setVisibility(GONE);
		addView(imageView, rParams);
		selectedImage = imageView;
		
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		imageView = new ImageView(context);
		imageView.setId(3);
		imageView.setImageResource(R.drawable.delete);
		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageView.setAdjustViewBounds(true);
		imageView.setVisibility(GONE);
		addView(imageView, rParams);
		deleteImage = imageView;
		
	}
	
	/**
	 * Set Item Image by Bitmap
	 * @param bm
	 */
	public void setCover(Bitmap bm) {
		if (itemBitmap != null) {
			itemBitmap.recycle();
			itemBitmap = null;
		}
		itemImage.setImageBitmap(bm);
		itemBitmap = bm;
	}
	
	/**
	 * Set Item Image by URL
	 * @param url
	 */
	public void setCoverUrl(String url) {
		aq.id(itemImage).image(url);
	}
	
	/**
	 * Set Select Status and Show image
	 */
	public void setSelected(boolean selectedFlag) {
		if (selectedImage != null)
			selectedImage.setVisibility(selectedFlag ? VISIBLE : GONE);
	}
	
	/**
	 * set Item Select
	 */
	public boolean isSelected() {
		if (selectedImage != null)
			return (selectedImage.getVisibility() == VISIBLE);
		return false;
	}
	
	/**
	 * Show Delete icon Image
	 * @param isShowDelete
	 */
	public void setDeleteIcon(boolean isShowDelete) {
		if (deleteImage != null) {
			deleteImage.setVisibility(isShowDelete ? VISIBLE : GONE); 
		}
	}

}
