package com.otiga.dress.layout.component;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.otiga.dress.data.vo.CoverItemData;
import com.otiga.dress.layout.LayoutManager;
import com.otiga.dressbook.R;

/**
 * 沒有開合功能,進入子分類清單頁的Panel
 *
 */
@SuppressLint("DefaultLocale")
public class NewExpandPanel extends AbstractPanel {

	private Activity activity;
	private float scale;
	private float fontScale;
	private static int panelHeight;

	private String mainCategory ;
	private TextView textTitle;
	private ImageView btnSubList;
	private ArrayList<RelativeLayout> childViews;
	
	private int selectionCount = 0;
	private TextView textSelectionCount;
	
	private RelativeLayout categoryTitleLayout;
	
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
	protected int childViewsSize = 0;


	private int bannerBackground;
	private static int titleColor;
	
	public NewExpandPanel(Context Context) {
		super(Context);
	}

	public NewExpandPanel(Activity activity) {
		super(activity);
		
		this.activity = activity;
		scale = LayoutManager.scale;
		fontScale = LayoutManager.fontScale;
		panelHeight = (int)(67 * scale);
		mainCategory = "";	
		childViews = new ArrayList<RelativeLayout>();
		
		setTheme(Theme.BLACK);
		
		initTitleLayout();
	}

	private void initTitleLayout() {
		RelativeLayout.LayoutParams rParams = null;
		
		// 分類標題佈局
		categoryTitleLayout = new RelativeLayout(activity);
		categoryTitleLayout.setBackgroundResource(bannerBackground);
		
		
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
		textSelectionCount.setTextColor(Color.WHITE);
		textSelectionCount.setTextSize(13 * fontScale);
		textSelectionCount.setVisibility(VISIBLE);
		categoryTitleLayout.addView(textSelectionCount, rParams);

		//進入子分類清單頁面
		rParams = new LayoutParams((int)(75 * scale), panelHeight);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		btnSubList = new ImageView(activity);
		btnSubList.setPadding((int)(20 * scale), (int)(20 * scale), (int)(20 * scale), (int)(20 * scale));
		btnSubList.setImageResource(R.drawable.next_w42);
		btnSubList.setScaleType(ImageView.ScaleType.FIT_CENTER);
		
		categoryTitleLayout.addView(btnSubList, rParams);
		
		//將分類標題佈局加入父佈局中
		rParams = new LayoutParams(LayoutParams.MATCH_PARENT, panelHeight);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		addView(categoryTitleLayout, rParams);
	}
	
	
	//XXX no use?
	public void addTitleSelectCount(boolean isAdd) {
		int selectCount = (textSelectionCount.getText().toString() != null ? Integer.valueOf(textSelectionCount.getText().toString()) : 0);
		textSelectionCount.setText(String.valueOf((isAdd ? selectCount++ : selectCount--)));
	}
	
	/**
	 * 設定顯示的RelativeLayout的清單
	 * @param activity Activity
	 * @param list ArrayList RelativeLayout
	 */
	public void setCategoryList(List<CoverItemData> list) {
		if(list != null){
			childViewsSize = list.size();
		}
							
		// 更新 title 後面()中的數字
		String title = getCategoryTitle();
		if (title.length() > 0) {
			int indexOfNumber = title.indexOf("(");
			title = String.format("%s(%d)", (indexOfNumber >= 0) ? title.substring(0, indexOfNumber) : title, childViewsSize);
			textTitle.setText(title);
		}

	}
	
	/**
	 * 設置此子類項目的父類名稱
	 * @param category
	 */
	public void setMainCategory(String category){
		mainCategory = category;
	}
	
	/**
	 * 取得此子類項目的父類名稱
	 * @return
	 */
	public String getMainCategory(){
		return mainCategory;
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
	 * 取得顯示的RelativeLayout中的資料
	 * @return ArrayList RelativeLayout
	 */
	@Override
	public ArrayList<RelativeLayout> getCategoryList() {
		return childViews;
	}
	

	public int getCategoryListCount() {
		return childViewsSize;
	}
	
	public void setTitleBackground(int res){
		categoryTitleLayout.setBackgroundResource(res);
	}
	
	@Override
	public void setTheme(Theme theme){
		switch (theme) {
		
		case GREEN:
			bannerBackground = R.drawable.strip_green;
			titleColor = Color.BLACK;
			break;
		
		case BLACK:
			bannerBackground = R.drawable.strip_background;
			titleColor = Color.WHITE;
			break;
			
		default:
		}

		if(null!=categoryTitleLayout)
			categoryTitleLayout.setBackgroundResource(bannerBackground);
		if(null!=textTitle)
			textTitle.setTextColor(titleColor);
	}
}
