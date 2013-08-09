package com.otiga.dress.layout.component;

import java.util.ArrayList;
import java.util.Timer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
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
public class CollapsePanel extends AbstractPanel {

	private Activity activity;
	private float scale;
	private float fontScale;
	private static int panelHeight;
	
	private TextView textTitle;
	private ImageView btnMode;
	private ArrayList<RelativeLayout> childViews;
	
	private int selectionCount = 0;
	private TextView textSelectionCount;

	private RelativeLayout categoryTitleLayout;
	private RelativeLayout childListLayout;
	private RelativeLayout layoutScrollViewContent;
	private boolean isLayoutSwitchOn = false;
	
	private Timer timerLayoutSwitch;
	protected int itemHeight = 0;
	protected int childWidth = 0;
	protected int childHeight = 0;
	protected int itemVerticalHeight = 0;
	protected int childPaddingLeft = 0;
	protected int childPaddingTop = 0;
	protected int childPaddingRight = 0;
	protected int childPaddingBottom = 0;
	
	private int item_count = 0;
	
	private int bannerBackground;
	private static int titleColor;
	private int resBtnModeOpen;
	private int resBtnModeClose;
	
	public CollapsePanel(Context Context) {
		super(Context);
	}

	public CollapsePanel(Activity activity) {
		super(activity);
		
		this.activity = activity;
		scale = LayoutManager.scale;
		fontScale = LayoutManager.fontScale;
		panelHeight = (int)(67 * scale);
				
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
				itemVerticalHeight = 0;
				reloadCategoryList();
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
		btnMode = new ImageView(activity);
		btnMode.setPadding((int)(20 * scale), (int)(20 * scale), (int)(20 * scale), (int)(20 * scale));
		btnMode.setImageResource(resBtnModeOpen);
		btnMode.setScaleType(ImageView.ScaleType.FIT_CENTER);
		categoryTitleLayout.addView(btnMode, rParams);
		
		// 將分類標題佈局加入父佈局中
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, panelHeight);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		addView(categoryTitleLayout, rParams);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		int baseline = (b - t) - panelHeight;
		if (baseline > itemVerticalHeight)
			itemVerticalHeight = baseline;
		itemHeight = itemVerticalHeight;
		super.onLayout(changed, l, t, r, b);
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
	public void setCategoryList(ArrayList<AbstractPanel> list) {
		childViews.clear();
		for (AbstractPanel view : list){
			childViews.add(view);
			item_count += view.getCategoryListCount();
		}
		
		// 更新 title 後面()中的數字
		String title = getCategoryTitle();
		if (title.length() > 0) {
			int indexOfNumber = title.indexOf("(");
			title = String.format("%s(%d)", (indexOfNumber >= 0) ? title.substring(0, indexOfNumber) : title, item_count/2);
			textTitle.setText(title);
		}
	}
	
	public void setCollapsePanel(AbstractPanel panel,int total){
		childViews.clear();
		childViews.add(panel);
		
		// 更新 title 後面()中的數字
		String title = getCategoryTitle();
		if (title.length() > 0) {
			int indexOfNumber = title.indexOf("(");
			title = String.format("%s(%d)", (indexOfNumber >= 0) ? title.substring(0, indexOfNumber) : title, total);
			textTitle.setText(title);
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

			scrollView = new ScrollView(activity);
			if(isLayoutSwitchOn){
				btnMode.setImageResource(resBtnModeClose);
			} else {
				btnMode.setImageResource(resBtnModeOpen);
			}
			scrollView.setBackgroundColor(Color.WHITE);
			childListLayout.addView(scrollView, rParams);
			
			// scrollView 下的物件
			layoutScrollViewContent = new RelativeLayout(activity);
			RelativeLayout childView = null;
			for (int i = 0; i < childViews.size(); ++i) {
				rParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				if (childView != null) {
					rParams.addRule(RelativeLayout.BELOW, childView.getId());
				}
				childView = childViews.get(i);
				childView.setId(CollapsePanel.this.getId() + i + 1);
				layoutScrollViewContent.addView(childView, rParams);
			}
			rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			layoutScrollViewContent.setPadding(childPaddingLeft, childPaddingTop, childPaddingRight, childPaddingBottom);
			scrollView.addView(layoutScrollViewContent, rParams);
		}
	}
	
	public void onCategoryTitleClick() {
		if (childListLayout != null) {
			if (timerLayoutSwitch != null) {
				timerLayoutSwitch.cancel();
				timerLayoutSwitch.purge();
				timerLayoutSwitch = null;
			}
			
			// 切換子項目開合
			isLayoutSwitchOn = !isLayoutSwitchOn;
			if (isLayoutSwitchOn) {
				/*activity.runOnUiThread(new Runnable() {
					public void run() {
						btnMode.setImageResource(resBtnModeClose);
						LayoutParams p = (LayoutParams) childListLayout.getLayoutParams();
						if (childListLayout.getHeight() != itemHeight) {
							p.height = itemHeight;
						}
						
						childListLayout.setLayoutParams(p);
					}});*/
				/*timerLayoutSwitch = new Timer("OpenCategoryList", true);
				timerLayoutSwitch.schedule(new TimerTask() {
					@Override
					public void run() {
						activity.runOnUiThread(new Runnable() {
							public void run() {
								LayoutParams p = (LayoutParams) childListLayout.getLayoutParams();
								if (childListLayout.getHeight() != itemHeight) {
									//Log.d("ddd", "childListLayout.getHeight():" + childListLayout.getHeight() + ", childListLayout:" + itemHeight + ", p.height:" + p.height);
									
									// 控制放速度
									int newHeight = childListLayout.getHeight() + ((itemHeight - childListLayout.getHeight() > 10) ? (itemHeight - childListLayout.getHeight()) / 3 : 1);
									p.height = newHeight == 0 ? itemHeight : newHeight;
									childListLayout.setLayoutParams(p);
								} else {
									cancel();
								}
							}
						});
					}
				}, 0, 20);*/
				
			} else {
				activity.runOnUiThread(new Runnable() {
					public void run() {
						btnMode.setImageResource(resBtnModeOpen);
						LayoutParams p = (LayoutParams) childListLayout.getLayoutParams();
						if (p.height != 0) {
							p.height = 0;
						}
						childListLayout.setLayoutParams(p);
					}});
				/*timerLayoutSwitch = new Timer("CloseCategoryList", true);
				timerLayoutSwitch.schedule(new TimerTask() {
					@Override
					public void run() {
						activity.runOnUiThread(new Runnable() {
							public void run() {
								LayoutParams p = (LayoutParams) childListLayout.getLayoutParams();
								if (p.height != 0) {
									// 控制縮速度
									int newHeight = childListLayout.getHeight() / 3;
									p.height = newHeight == 0 ? 0 : newHeight;
									childListLayout.setLayoutParams(p);
								} else {
									cancel();
								}
							}
						});
					}
				}, 0, 20);*/
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
		switch (theme) {
		case WHITE:
			bannerBackground = R.drawable.strip_white;
			titleColor = Color.rgb(102, 102, 102);
			resBtnModeOpen = R.drawable.icon_expand_grey;
			resBtnModeClose = R.drawable.icon_collapse_grey;
			break;
		default:
		case BLACK:
			bannerBackground = R.drawable.strip_background;
			titleColor = Color.WHITE;
			resBtnModeOpen = R.drawable.icon_expand_white;
			resBtnModeClose = R.drawable.icon_collapse_white;
			break;
		}
		
		if(null!=categoryTitleLayout){
			categoryTitleLayout.setBackgroundResource(bannerBackground);
			btnMode.setImageResource(resBtnModeOpen);

		}
		if(null!=textTitle)
			textTitle.setTextColor(titleColor);
	}

}
