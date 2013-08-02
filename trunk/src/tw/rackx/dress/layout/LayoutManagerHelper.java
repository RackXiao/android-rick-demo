package com.otiga.dress.layout;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.otiga.dress.data.ConstantTerm;
import com.otiga.dress.layout.component.StatusButton;
import com.otiga.dressbook.R;

public class LayoutManagerHelper {

	/**
	 * 計算縮圖的InSampleSize值
	 * @param options BitmapFactory.Options
	 * @param reqWidth int 預計縮圖的寬
	 * @param reqHeight int 預計縮圖的高
	 * @return
	 */
	public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;
		if (height > reqHeight || width > reqWidth) {
			final int heightRatio = Math.round((float) height / (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}
		return inSampleSize;
	}

	/**
	 * 將JPEG File Path縮圖用
	 * @param path String FilePath
	 * @param reqWidth int 預計縮圖的寬
	 * @param reqHeight int 預計縮圖的高
	 * @return
	 */
	public static Bitmap decodeSampledBitmap(String path, int reqWidth, int reqHeight) {
	    final BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inPurgeable = true;
	    options.inJustDecodeBounds = true;
	    //BitmapFactory.decodeFile(path, options);
	    
	    try {
			BitmapFactory.Options.class.getField("inNativeAlloc").setBoolean(options,true);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
	    options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
	    options.inJustDecodeBounds = false;
	    return BitmapFactory.decodeFile(path, options);
	}

	public static void baseLayoutSetting(RelativeLayout baseLayout) {
		RelativeLayout.LayoutParams rParams = new RelativeLayout.LayoutParams((int)(ConstantTerm.targetResolution.x * LayoutManager.scale), (int)(ConstantTerm.targetResolution.y * LayoutManager.scale));
		rParams.setMargins((int)(((float)ConstantTerm.resolution.x - (ConstantTerm.targetResolution.x * LayoutManager.scale)) / 2.0f), (int)(((float)ConstantTerm.resolution.y - (ConstantTerm.targetResolution.y * LayoutManager.scale)) / 2.0f), 0, 0);
		baseLayout.setLayoutParams(rParams);
	}

	public static void generalButtomMenu(Context context, RelativeLayout baseLayout) {
		RelativeLayout.LayoutParams rParams;
		LinearLayout lLayout;
		LinearLayout.LayoutParams lParams;
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		
		lLayout = new LinearLayout(context);
		lLayout.setId(LayoutManager.BottomMenuButtonLayout);
		lLayout.setBackgroundResource(R.drawable.menubar);
		lLayout.setOrientation(LinearLayout.HORIZONTAL);
		lLayout.setWeightSum(5);
		baseLayout.addView(lLayout, rParams);
	
		for (int i = 0; i < 5; ++i) {
			lParams = new LinearLayout.LayoutParams((int)(ConstantTerm.resolution.x / lLayout.getWeightSum()), (int)(72 * LayoutManager.scale), 1);
			lParams.gravity = Gravity.CENTER;
			StatusButton button = new StatusButton(context);
			button.setId(LayoutManager.BottomMenuButton_Following + i);
			lLayout.addView(button, lParams);
		}
	}

	/**
	 * 定義 Action Bar
	 * @param context
	 */
	public static void setupActionBar(Context context) {
		ActionBar actionBar = ((Activity)context).getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(LayoutManagerHelper.getActionBarLayout(context));
	}

	/**
	 * 客製化的 Action Bar Layout
	 * @param context
	 * @return
	 */
	public static LinearLayout getActionBarLayout(Context context){
		LinearLayout.LayoutParams params = null;
		LinearLayout baseLayout = new LinearLayout(context);
		ImageView imageView = null;
		
		params = new LinearLayout.LayoutParams((int)(55 * LayoutManager.scale), LayoutParams.WRAP_CONTENT);
		imageView = new ImageView(context);
		imageView.setBackgroundColor(Color.argb(0, 255, 255, 255));
		baseLayout.addView(imageView,params);
		
		params = new LinearLayout.LayoutParams((int)(244 * LayoutManager.scale), (int)(50 * LayoutManager.scale));
		params.setMargins(0, (int)(7 * LayoutManager.scale), 0, 0);
		imageView = new ImageView(context);
		imageView.setBackgroundResource(R.drawable.logo_dressbook);
		baseLayout.addView(imageView,params);
		
		return baseLayout;
	}

}
