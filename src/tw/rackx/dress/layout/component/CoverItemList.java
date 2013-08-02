package com.otiga.dress.layout.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.otiga.dress.data.ConstantTerm;
import com.otiga.dress.data.handler.DressbookAPI;
import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * CoverItemActivity的Item列表
 * @author Jeffrey.Yang
 *
 */
public class CoverItemList extends RelativeLayout {
	
	private Bitmap coverBitmap;
	public ImageView imageItemCover;
	private TextView textItemTitle;
	private TextView textItemBrand;
	private TextView textItemDescription;
	public Button buttonAddWardrobe;
	public Button buttonAddList;
	private TextView showAddText;
	private boolean addwardrobe = false;
	private boolean addlist = false;
	private AQuery aq;
	
	public CoverItemList(final Context context){
		super(context);
		
		final float scale = LayoutManager.scale;
		final float fontScale = LayoutManager.fontScale;
		
		aq = new AQuery(context);
		LayoutParams rParams = null;
		ImageView imageview = null;
		TextView textview = null;
		Button button = null;
		
		
		// 物品圖片
		rParams = new LayoutParams((int)(165 * scale), (int)(220 * scale));
		rParams.setMargins((int)(10 * scale), (int)(10 * scale), 0, 0);
		imageview = new ImageView(context);
		imageview.setId(1);
		//imageview.setImageResource(R.drawable.item_01);
		imageview.setScaleType(ScaleType.CENTER_CROP);
		imageview.setAdjustViewBounds(true);
		addView(imageview, rParams);
		imageItemCover = imageview;
		
		// 物品Title
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, (int)(40 * scale));
		rParams.addRule(RelativeLayout.RIGHT_OF, 1);
		rParams.setMargins((int)(10 * scale), (int)(15 * scale), (int)(15 * scale), 0);
		textview = new TextView(context);
		textview.setId(2);
		textview.setGravity(Gravity.CLIP_HORIZONTAL);
		textview.setTextColor(Color.rgb(102, 102, 102));
		textview.setTextSize(20 * fontScale);
		textview.setTypeface(null, Typeface.BOLD);
		addView(textview, rParams);
		textItemTitle = textview;
		
		// 物品品牌
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, (int)(25 * scale));
		rParams.addRule(RelativeLayout.RIGHT_OF, 1);
		rParams.addRule(RelativeLayout.BELOW, 2);
		rParams.setMargins((int)(10 * scale), 0, (int)(15 * scale), 0);
		textview = new TextView(context);
		textview.setId(3);
		textview.setGravity(Gravity.CLIP_HORIZONTAL);
		textview.setTextColor(Color.rgb(102, 102, 102));
		textview.setTextSize(12 * fontScale);
		addView(textview, rParams);
		textItemBrand = textview;
		
		//物品介紹
		rParams = new LayoutParams((int)(275 * scale), (int)(93 * scale));
		rParams.addRule(RelativeLayout.RIGHT_OF, 1);
		rParams.addRule(RelativeLayout.BELOW, 3);
		rParams.setMargins((int)(10 * scale), 0, (int)(15 * scale), 0);
		textview = new TextView(context);
		textview.setId(4);
		textview.setTextColor(Color.rgb(102, 102, 102));
		textview.setTextSize(10 * fontScale);
		addView(textview, rParams);
		textItemDescription = textview;
		
		// 按鈕 - 加到衣櫃
		rParams = new LayoutParams((int)(120 * scale), (int)(40 * scale));
		rParams.addRule(RelativeLayout.RIGHT_OF, 1);
		rParams.addRule(RelativeLayout.BELOW, 4);
		rParams.setMargins((int)(15 * scale), 0, 0, 0);
		button = new Button(context);
		button.setId(5);
		button.setTextSize(12 * fontScale);
		button.setPadding(0, 0, 0, 0);
		button.setText(R.string.AddWardrobe);
		button.setTextColor(Color.rgb(255, 255, 255));
		button.setBackgroundResource(R.drawable.btn_01);button.setVisibility(GONE);
		/*
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!addwardrobe) {
					Toast.makeText(getContext(), textItemTitle.getText() + " 加到衣櫃", Toast.LENGTH_SHORT).show();
				}
				setSelectWardrobe(!addwardrobe);
			}
		});
		*/
		addView(button, rParams);
		buttonAddWardrobe = button;
		
		// 按鈕 - 加到清單
		rParams = new LayoutParams((int)(120 * scale), (int)(40 * scale));
		rParams.addRule(RelativeLayout.RIGHT_OF, 5);
		rParams.addRule(RelativeLayout.BELOW, 4);
		rParams.setMargins((int)(15 * scale), 0, 0, 0);
		button = new Button(context);
		button.setId(6);
		button.setTextSize(12 * fontScale);
		button.setPadding(0, 0, 0, 0);
		button.setText(R.string.AddList);
		button.setTextColor(Color.rgb(255, 255, 255));
		button.setBackgroundResource(R.drawable.btn_01);
		/*
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!addlist) {
					Toast.makeText(getContext(), textItemTitle.getText() + " 加到清單", Toast.LENGTH_SHORT).show();
				}
				setSelectList(!addlist);
			}
		});
		*/
		addView(button, rParams);
		buttonAddList = button;
		
		//已加入衣櫃/清單顯示文字
		rParams = new LayoutParams((int)(275 * scale), (int)(40 * scale));
		rParams.addRule(RelativeLayout.ALIGN_LEFT, 4);
		rParams.addRule(RelativeLayout.BELOW, 4);
		textview = new TextView(context);
		textview.setId(7);
		textview.setPadding(0, 0, 0, 0);
		//textview.setGravity(Gravity.CENTER);
		textview.setTextColor(Color.rgb(53, 214, 214));
		textview.setTextSize(16 * fontScale);
		textview.setVisibility(GONE);
		addView(textview, rParams);
		showAddText = textview;
		
		
		//分隔線
		rParams = new LayoutParams((int)(455 * scale), (int)(1 * scale));
		rParams.addRule(RelativeLayout.BELOW, 1);
		rParams.setMargins((int)(10 * scale), 0, 0, 0);
		RelativeLayout rLayout = new RelativeLayout(context);
		rLayout.setBackgroundColor(Color.rgb(102, 102, 102));
		addView(rLayout, rParams);
		
	}
	
	/**
	 * 設定Item 的Cover圖 By Bitmap
	 * @param bm Bitmap
	 */
	public void setCover(Bitmap bm) {
		if (coverBitmap != null) {
			coverBitmap.recycle();
			coverBitmap = null;
		}
		imageItemCover.setImageBitmap(bm);
		coverBitmap = bm;
	}
	
	/**
	 * 設定Item的Cover圖By URL
	 * @param url String
	 */
	public void setCoverUrl(String url) {
		aq.id(imageItemCover).image(url);
	}
	
	/**
	 * 設定Item的Title以及HyperLink
	 * @param title String
	 * @param url String
	 */
	public void setTitle(String title, String url, final int itemId, final String from) {
		SpannableString msp = null;
		if ( url==null || url.equals("") ) {
			textItemTitle.setText(title);
		} else {
			msp = new SpannableString(title);
			msp.setSpan(new URLSpan(url), 0, msp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			textItemTitle.setText(msp);
			textItemTitle.setMovementMethod(LinkMovementMethod.getInstance());
			
			textItemTitle.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					DressbookAPI.singleton().insStatsClickItemLink(ConstantTerm.act_user, itemId, from, null);
				}
			});
		}
	}
	
	/**
	 * 設定Item的說明文字
	 * @param description String
	 */
	public void setDescription(String description) {
		textItemDescription.setText(description);
	}
	
	/**
	 * 設定Wardrobe的按鈕是否被點擊
	 * @param isSelect boolean
	 */
	public void setSelectWardrobe(boolean isSelect) {
		
		buttonAddWardrobe.setBackgroundResource(isSelect ? R.drawable.btn_02 : R.drawable.btn_01);
		addwardrobe = isSelect;
		if (addlist) {
			buttonAddList.setBackgroundResource(!addlist ? R.drawable.btn_02 : R.drawable.btn_01);
			addlist = !addlist;
		}
	}
	
	/**
	 * 設定WishList的按鈕是否被點擊
	 * @param isSelect boolean
	 */
	public void setSelectList(boolean isSelect) {
		buttonAddList.setBackgroundResource(isSelect ? R.drawable.btn_02 : R.drawable.btn_01);
		addlist = isSelect;
		if (addwardrobe) {
			buttonAddWardrobe.setBackgroundResource(!addwardrobe ? R.drawable.btn_02 : R.drawable.btn_01);
			addwardrobe = !addwardrobe;
		}
	}
	
	/**
	 * 設定該Item是否已被加入清單或是衣櫃
	 * @param isHaveThis String "null"(沒有加入), "Wardrobe"(加入衣櫃), "WishList"(加入清單)
	 */
	public void setIsHaveThis(String isHaveThis) {
		if (isHaveThis != null) {
			if (isHaveThis.equals("null")) {
				showAddText.setVisibility(GONE);
				buttonAddList.setVisibility(VISIBLE);
				buttonAddWardrobe.setVisibility(VISIBLE);
			} else {
				if (isHaveThis.equals("WishList")) {
					showAddText.setText(R.string.HaveThisWishList);
				} else {
					showAddText.setText(R.string.HaveThisWardrobe);
				}
				showAddText.setVisibility(VISIBLE);
				buttonAddList.setVisibility(GONE);
				buttonAddWardrobe.setVisibility(GONE);
			}	
		}
	}
	
	/**
	 * Get WishList is Select 
	 * @return boolean
	 */
	public boolean getSelectList() {
		return addlist;
	}
	
	/**
	 * Get Wardrobe is Select
	 * @return boolean
	 */
	public boolean getSelectWardrobe() {
		return addwardrobe;
	}
	
	/**
	 * 設定Brand的文字
	 * @param brand String
	 */
	public void setBrand(String brand) {
		if(null == brand){
			textItemBrand.setVisibility(TextView.INVISIBLE);
		} else {
			textItemBrand.setVisibility(TextView.VISIBLE);
			textItemBrand.setText(String.format("Brand: %s", brand));
		}
	}

}
