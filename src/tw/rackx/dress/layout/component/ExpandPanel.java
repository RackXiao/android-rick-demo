package com.otiga.dress.layout.component;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * 可切換開合及水平瀏覽的 Panel
 *
 */
@SuppressLint("DefaultLocale")
public class ExpandPanel extends AbstractPanel{

	private Activity activity;
	private float scale;
	private float fontScale;
	private static int panelHeight;
	
	public enum ViewMode {
		HORIZONTAL, 
		VERTICAL,
	};
	
	private TextView textTitle;
	private ViewMode viewMode;
	private ImageView btnViewMode;
	private ArrayList<RelativeLayout> childViews;
	
	private int selectionCount = 0;
	private TextView textSelectionCount;
	
	private RelativeLayout categoryTitleLayout;
	private RelativeLayout childListLayout;
	private RelativeLayout layoutScrollViewContent;
	private boolean isLayoutSwitchOn = true;
	
	private ImageView imageArrowLeft;
	private ImageView imageArrowRight;
	
	private Timer timerLayoutSwitch;
	protected int itemHeight = 0;
	protected int childWidth = 0;
	protected int childHeight = 0;
	protected int itemHorizontalHeight = 0;
	protected int itemVerticalHeight = 0;
	protected int childPaddingLeft = 0;
	protected int childPaddingTop = 0;
	protected int childPaddingRight = 0;
	protected int childPaddingBottom = 0;
	protected int childSinglelinePreviewCount = 3;	// how many item in one row
	
	protected int childRowGap = 0;
	protected int childColumnGap = 0;
	
	private Theme theme;
	private int bannerBackground;
	private static int titleColor;
	
	public ExpandPanel(Context Context) {
		super(Context);
	}

	public ExpandPanel(Activity activity) {
		super(activity);
		
		this.activity = activity;
		scale = LayoutManager.scale;
		fontScale = LayoutManager.fontScale;
		panelHeight = (int)(67 * scale);
				
		viewMode = ViewMode.HORIZONTAL;
		childViews = new ArrayList<RelativeLayout>();
		
		setTheme(Theme.BLACK);
		
		initTitleLayout();
	}

	private void initTitleLayout() {
		RelativeLayout.LayoutParams rParams = null;
		
		// 分類標題佈局
		categoryTitleLayout = new RelativeLayout(activity);
		categoryTitleLayout.setBackgroundResource(bannerBackground);
		categoryTitleLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (childListLayout == null)
					reloadCategoryList();
				else
					onCategoryTitleClick();
			}
		});
		
		// 分類標題
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, panelHeight);
		textTitle = new TextView(activity);
		textTitle.setId(250);
		textTitle.setGravity(Gravity.CENTER_VERTICAL);
		textTitle.setPadding((int)(20 * scale), 0, 0, 0);
		textTitle.setTextColor(titleColor);
		textTitle.setTextSize(16 * fontScale);
		categoryTitleLayout.addView(textTitle, rParams);
		
		// 已選擇數量
		rParams = new LayoutParams(LayoutParams.WRAP_CONTENT, panelHeight);
		rParams.addRule(RelativeLayout.RIGHT_OF, 250);
		rParams.addRule(RelativeLayout.ALIGN_BOTTOM, 200);
		textSelectionCount = new TextView(activity);
		textSelectionCount.setGravity(Gravity.CENTER_VERTICAL);
		textSelectionCount.setTextColor(Color.rgb(47, 211, 221));
		textSelectionCount.setTextSize(13 * fontScale);
		textSelectionCount.setVisibility(VISIBLE);
		categoryTitleLayout.addView(textSelectionCount, rParams);

		// 檢視模式
		rParams = new LayoutParams((int)(75 * scale), panelHeight);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		btnViewMode = new ImageView(activity);
		btnViewMode.setPadding((int)(20 * scale), (int)(20 * scale), (int)(20 * scale), (int)(20 * scale));
		btnViewMode.setImageResource(R.drawable.icon_3box_grey);
		btnViewMode.setScaleType(ImageView.ScaleType.FIT_CENTER);
		btnViewMode.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				isLayoutSwitchOn = false;
				if (childListLayout != null) {
					if (childListLayout.getChildCount() > 0) {
						switch (viewMode) {
						case HORIZONTAL:
							viewMode = ViewMode.VERTICAL;
							break;
						case VERTICAL:
							viewMode = ViewMode.HORIZONTAL;
							break;
						}
						isLayoutSwitchOn = false;
					}
				}
				reloadCategoryList();
				onCategoryTitleClick();
			}
		});
		categoryTitleLayout.addView(btnViewMode, rParams);
		
		// 將分類標題佈局加入父佈局中
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, panelHeight);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		addView(categoryTitleLayout, rParams);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// 雖然算式一樣，但兩種模式展開後的高是不同的
		int baseline = (b - t) - panelHeight;
		switch (viewMode) {
		case HORIZONTAL:
			if (baseline > itemHorizontalHeight)
				itemHorizontalHeight = baseline;
			itemHeight = itemHorizontalHeight;
			break;
		case VERTICAL:
			if (baseline > itemVerticalHeight)
				itemVerticalHeight = baseline;
			itemHeight = itemVerticalHeight;
			break;
		}
		super.onLayout(changed, l, t, r, b);
	}
	
	public void setChildGap(float rowGap, float columnGap) {
		childRowGap = (int)rowGap;
		childColumnGap = (int)columnGap;
	}
	
	public void setChildSize(float w, float h) {
		childWidth = (int)w;
		childHeight = (int)h;
	}
	
	public void setChildPadding(float l, float t, float r, float b) {
		childPaddingLeft = (int)l;
		childPaddingTop = (int)t;
		childPaddingRight = (int)r;
		childPaddingBottom = (int)b;
	}
	
	/**
	 * set how many item in one row
	 * @param count
	 */
	public void setChildSinglelinePreviewCount(int count) {
		childSinglelinePreviewCount = count;
	}
	
	//XXX no use?
	public void addTitleSelectCount(boolean isAdd) {
		int selectCount = (textSelectionCount.getText().toString() != null ? Integer.valueOf(textSelectionCount.getText().toString()) : 0);
		textSelectionCount.setText(String.valueOf((isAdd ? selectCount++ : selectCount--)));
	}
	
	/**
	 * 設定CategoryTitle的文字
	 * @param title String
	 */
	@Override
	public void setCategoryTitle(String title) {
		textTitle.setText(title);
	}
	
	/**
	 * 取得CategoryTitle的文字
	 * @return String
	 */
	public String getCategoryTitle() {
		return textTitle.getText().toString();
	}
	
	/**
	 * 設定已選擇的數目
	 * @param count int
	 */
	public void setSelectionCount(int count) {
		selectionCount = count;
		textSelectionCount.setText(String.format("%s%d%s", activity.getString(R.string.OutfitSelectionCountPrefix), count, activity.getString(R.string.OutfitSelectionCountSuffix)));
		textSelectionCount.setVisibility(count > 0 ? VISIBLE : GONE);
	}
	
	/**
	 * 取得已選擇的數目
	 * @return int 
	 */
	public int getSelectionCount() {
		return selectionCount;
	}
	
	/**
	 * 設定顯示的RelativeLayout的清單
	 * @param activity Activity
	 * @param list ArrayList RelativeLayout
	 */
	public void setCategoryList(ArrayList<RelativeLayout> list) {
		childViews.clear();
		for (RelativeLayout view : list)
			childViews.add(view);
		
		// 更新 title 後面()中的數字
		String title = getCategoryTitle();
		if (title.length() > 0) {
			int indexOfNumber = title.indexOf("(");
			title = String.format("%s(%d)", (indexOfNumber >= 0) ? title.substring(0, indexOfNumber) : title, childViews.size());
			textTitle.setText(title);
		}
		
		if(childViews.size()>0){
			btnViewMode.setImageResource(R.drawable.icon_3box_blue);
			if(theme.equals(Theme.WHITE)){
				btnViewMode.setImageResource(R.drawable.icon_expand_grey);
			}
		}
	}

	private void reloadCategoryList() {
		if (layoutScrollViewContent != null) {
			layoutScrollViewContent.removeAllViews();
		}
		
		// 檢查若是原本就有清單資料，先移除掉在重新建立
		if (childListLayout != null) {
			removeView(childListLayout);
		}
		
		// 如果有資料，則建立childListLayout
		if (childViews.size() > 0) {
			childListLayout = new RelativeLayout(activity);
			RelativeLayout.LayoutParams rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			rParams.setMargins(0, panelHeight, 0, 0);
			addView(childListLayout, rParams);
			
			// 建立childListLayout下的scrollView
			FrameLayout scrollView = null;
			rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			switch (viewMode) {
			case VERTICAL:
				scrollView = new ScrollView(activity);
				btnViewMode.setImageResource(R.drawable.icon_4box_blue);
				break;
			case HORIZONTAL:
				scrollView = new HorizontalScrollView(activity) {
					//Set ArrowLeft&ArrowRight scroll to the end INVISIBLE
					@SuppressWarnings("deprecation")
					@Override
					protected void onScrollChanged(int l, int t, int oldl, int oldt) {
						int lastLeft = getChildAt(0).getMeasuredWidth() - activity.getWindowManager().getDefaultDisplay().getWidth();
						imageArrowLeft.setVisibility((l <= 30) ? INVISIBLE : (childViews.size() > childSinglelinePreviewCount) ? VISIBLE : INVISIBLE);
						imageArrowRight.setVisibility((l >= lastLeft - 30) ? INVISIBLE : (childViews.size() > childSinglelinePreviewCount) ? VISIBLE : INVISIBLE);
						super.onScrollChanged(l, t, oldl, oldt);
					}
				};
				//Set ArrowLeft&ArrowRight ACTION_MOVE Alpha 
				scrollView.setOnTouchListener(new OnTouchListener() {
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						switch (event.getAction()) {
						case MotionEvent.ACTION_MOVE:
							imageArrowLeft.setAlpha(1.0f);
							imageArrowRight.setAlpha(1.0f);
							break;
						case MotionEvent.ACTION_UP:
							imageArrowLeft.setAlpha(0.5f);
							imageArrowRight.setAlpha(0.5f);
							break;
						}
						return false;
					}
				});
				
				btnViewMode.setImageResource(R.drawable.icon_3box_blue);
				break;
			}
			if(theme.equals(Theme.WHITE)){
				if(isLayoutSwitchOn){
					btnViewMode.setImageResource(R.drawable.icon_collapse_grey);
				} else {
					btnViewMode.setImageResource(R.drawable.icon_expand_grey);
				}
			}
			scrollView.setBackgroundColor(Color.WHITE);
			childListLayout.addView(scrollView, rParams);
			
			// scrollView 下的物件
			layoutScrollViewContent = new RelativeLayout(activity);
			RelativeLayout childView = null;
			switch (viewMode) {
			case VERTICAL:
				for (int i = 0; i < childViews.size(); ++i) {
					rParams = new RelativeLayout.LayoutParams(childWidth, childHeight);
					if (childView != null) {
						rParams.setMargins(
								(i % childSinglelinePreviewCount) * (childWidth + childColumnGap),
								(i / childSinglelinePreviewCount) * (childHeight + childRowGap),
								0,
								0);
					}
					childView = childViews.get(i);
					childView.setId(ExpandPanel.this.getId() + i + 1);
					layoutScrollViewContent.addView(childView, rParams);
				}
				rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				layoutScrollViewContent.setPadding(childPaddingLeft, childPaddingTop, childPaddingRight, childPaddingBottom);
				scrollView.addView(layoutScrollViewContent, rParams);
				break;
			case HORIZONTAL:
				for (int i = 0; i < childViews.size(); ++i) {
					rParams = new RelativeLayout.LayoutParams(childWidth, childHeight);
					if (childView != null) {
						rParams.setMargins(
								i * (childWidth + childColumnGap),
								0,
								0,
								0);
					}
					childView = childViews.get(i);
					childView.setId(ExpandPanel.this.getId() + i + 1);
					layoutScrollViewContent.addView(childView, rParams);
				}
				
				rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				layoutScrollViewContent.setPadding(childPaddingLeft, childPaddingTop, childPaddingRight, childPaddingBottom);
				scrollView.addView(layoutScrollViewContent, rParams);
				
				// 左箭頭
				rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				rParams.addRule(RelativeLayout.CENTER_VERTICAL);
				rParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
				imageArrowLeft = new ImageView(activity);
				imageArrowLeft.setImageResource(R.drawable.icon_arrow_left);
				imageArrowLeft.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageArrowLeft.setAlpha(0.5f);
				childListLayout.addView(imageArrowLeft, rParams);
				imageArrowLeft.setVisibility(childViews.size() > childSinglelinePreviewCount ? VISIBLE : INVISIBLE);
				
				// 右箭頭
				rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				rParams.addRule(RelativeLayout.CENTER_VERTICAL);
				rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
				imageArrowRight = new ImageView(activity);
				imageArrowRight.setImageResource(R.drawable.icon_arrow_right);
				imageArrowRight.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageArrowRight.setAlpha(0.5f);
				childListLayout.addView(imageArrowRight, rParams);
				imageArrowRight.setVisibility(childViews.size() > childSinglelinePreviewCount ? VISIBLE : INVISIBLE);
				break;
			}
		}
	}
	
	private void onCategoryTitleClick() {
		if (childListLayout != null) {
			if (timerLayoutSwitch != null) {
				timerLayoutSwitch.cancel();
				timerLayoutSwitch.purge();
				timerLayoutSwitch = null;
			}
			
			// 切換子項目開合
			isLayoutSwitchOn = !isLayoutSwitchOn;
			if (isLayoutSwitchOn) {
				if(theme.equals(Theme.WHITE)) btnViewMode.setImageResource(R.drawable.icon_collapse_grey);
				timerLayoutSwitch = new Timer("OpenCategoryList", true);
				timerLayoutSwitch.schedule(new TimerTask() {
					@Override
					public void run() {
						activity.runOnUiThread(new Runnable() {
							public void run() {
								LayoutParams p = (LayoutParams) childListLayout.getLayoutParams();
								if (childListLayout.getHeight() != itemHeight) {
									Log.d("ddd", "childListLayout.getHeight():" + childListLayout.getHeight() + ", childListLayout:" + itemHeight + ", p.height:" + p.height);
									int newHeight = childListLayout.getHeight() + ((itemHeight - childListLayout.getHeight() > 1) ? (itemHeight - childListLayout.getHeight()) / 2 : 1);
									p.height = newHeight == 0 ? itemHeight : newHeight;
									childListLayout.setLayoutParams(p);
								} else {
									cancel();
								}
							}
						});
					}
				}, 0, 50);
			} else {
				if(theme.equals(Theme.WHITE)) btnViewMode.setImageResource(R.drawable.icon_expand_grey);
				timerLayoutSwitch = new Timer("CloseCategoryList", true);
				timerLayoutSwitch.schedule(new TimerTask() {
					@Override
					public void run() {
						activity.runOnUiThread(new Runnable() {
							public void run() {
								LayoutParams p = (LayoutParams) childListLayout.getLayoutParams();
								if (p.height != 0) {
									int newHeight = childListLayout.getHeight() / 2;
									p.height = newHeight == 0 ? 0 : newHeight;
									childListLayout.setLayoutParams(p);
								} else {
									cancel();
								}
							}
						});
					}
				}, 0, 50);
			}
		}
	}
	
	/**
	 * 取得顯示的RelativeLayout中的資料
	 * @return ArrayList RelativeLayout
	 */
	@Override
	public ArrayList<RelativeLayout> getCategoryList() {
		return childViews;
	}
	
	@Override
	public int getCategoryListCount(){
		return childViews.size();
	}
	
	public void setTitleBackground(int res){
		categoryTitleLayout.setBackgroundResource(res);
	}
	@Override
	public void setTheme(Theme theme){
		this.theme = theme;
		switch (theme) {
		case WHITE:
			viewMode = ViewMode.VERTICAL;
			btnViewMode.setImageResource(R.drawable.icon_expand_white);
			btnViewMode.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					if (childListLayout == null)
						reloadCategoryList();
					else
						onCategoryTitleClick();
				}
			});
			bannerBackground = R.drawable.strip_white;
			titleColor = Color.rgb(102, 102, 102);
			break;
		case GREEN:
			bannerBackground = R.drawable.strip_green;
			titleColor = Color.BLACK;
			break;
		default:
		case BLACK:
			bannerBackground = R.drawable.strip_background;
			titleColor = Color.WHITE;
			break;
		}

		if(null!=categoryTitleLayout)
			categoryTitleLayout.setBackgroundResource(bannerBackground);
		if(null!=textTitle)
			textTitle.setTextColor(titleColor);
	}
}
