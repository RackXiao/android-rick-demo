package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

/**
 * Switch Button
 * @author Jeffrey.Yang
 *
 */
public class SwitchButton extends RelativeLayout {
	
	public interface OnSwitchChangedListener {
		void onSwitchChanged(boolean isSwitchOn, boolean isTouchMode);
	}
	
	private OnSwitchChangedListener onSwitchChangedListener;
	
	private Bitmap switchOnBitmap;
	private ImageView switchOnImageView;
	private Bitmap switchOffBitmap;
	private ImageView switchOffImageView;
	private boolean switchValue;
	
	public SwitchButton(Context context) {
		super(context);
		
		RelativeLayout.LayoutParams rParams = null;
		ImageView imageView = null;
		
		switchValue = false;
		
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		imageView = new ImageView(context);
		imageView.setScaleType(ScaleType.CENTER_CROP);
		imageView.setAdjustViewBounds(true);
		imageView.setVisibility(INVISIBLE);
		addView(imageView, rParams);
		switchOnImageView = imageView;
		
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		imageView = new ImageView(context);
		imageView.setScaleType(ScaleType.CENTER_CROP);
		imageView.setAdjustViewBounds(true);
		imageView.setVisibility(VISIBLE);
		addView(imageView, rParams);
		switchOffImageView = imageView;
	}
	
	/**
	 * Set Button OnTouchEvent
	 */
	@SuppressWarnings("deprecation")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_POINTER_1_DOWN:
		case MotionEvent.ACTION_POINTER_2_DOWN:
		case MotionEvent.ACTION_POINTER_3_DOWN:
		case MotionEvent.ACTION_DOWN:
			switchValue = !switchValue;
			OnSwitchChanged(switchValue, true);
			break;
		default:
			break;
		}
		return super.onTouchEvent(event);
	}
	
	/**
	 * Set OnSwitchListener
	 * @param listener
	 */
	public void setOnSwitchListener(OnSwitchChangedListener listener) {
		onSwitchChangedListener = listener;
	}

	/**
	 * Set SwitchButton Status
	 * @param isSwitchOn
	 */
	public void setSwitchValue(boolean isSwitchOn) {
		if (switchValue != isSwitchOn) {
			switchValue = isSwitchOn;
			OnSwitchChanged(switchValue, false);
		}
	}
	
	/**
	 * Get SwitchButton Status
	 * @return
	 */
	public boolean getSwitchValue() {
		return switchValue;
	}
	
	/**
	 * Set Switch On Image by Bitmap
	 * @param bm
	 */
	public void setSwitchOnImage(Bitmap bm) {
		if (switchOnBitmap != null) {
			switchOnBitmap.recycle();
			switchOnBitmap = null;
		}
		switchOnImageView.setImageBitmap(bm);
		switchOnBitmap = bm;
	}
	
	/**
	 * Set Switch Off Image by Bitmap
	 * @param bm
	 */
	public void setSwitchOffImage(Bitmap bm) {
		if (switchOffBitmap != null) {
			switchOffBitmap.recycle();
			switchOffBitmap = null;
		}
		switchOffImageView.setImageBitmap(bm);
		switchOffBitmap = bm;
	}
	
	private void OnSwitchChanged(boolean isSwitchOn, boolean isTouchMode) {
		switchOnImageView.setVisibility(isSwitchOn ? VISIBLE : INVISIBLE);
		switchOffImageView.setVisibility(isSwitchOn ? INVISIBLE : VISIBLE);
		if (onSwitchChangedListener != null) {
			onSwitchChangedListener.onSwitchChanged(isSwitchOn, isTouchMode);
		}
	}
	
}
