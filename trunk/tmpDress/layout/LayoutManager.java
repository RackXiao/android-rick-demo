package com.otiga.dress.layout;


import kankan.wheel.widget.WheelView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.otiga.dress.data.ConstantTerm;
import com.otiga.dress.layout.component.ImageTextButton;
import com.otiga.dress.layout.component.StatusButton;
import com.otiga.dress.layout.component.SwitchButton;
import com.otiga.dress.layout.component.UserBanner;
import com.otiga.dressbook.R;

public class LayoutManager {
	
	public static float fontScale;
	public static float scale;
	
	public static int BaseId = 1000;

	public static int WelcomeBase = ++BaseId;
	public static int WelcomeFBButton = ++BaseId;
	public static int WelcomeEmailButton = ++BaseId;
	public static int WelcomeLawCheckBox = ++BaseId;
	public static int WelcomeLawText = ++BaseId;
	public static int WelcomeLawAcceptBtn = ++BaseId;
	public static int WelcomeCooperation = ++BaseId;
	
	public static int NavigationPagerView = ++BaseId;
	
	public static int Pager = ++BaseId;
	//ButtomMenu
	public static int BottomMenuButtonLayout = ++BaseId;
	public static int BottomMenuButton_Following = ++BaseId;
	public static int BottomMenuButton_Wardrobe = ++BaseId;
	public static int BottomMenuButton_Camera = ++BaseId;
	public static int BottomMenuButton_Calendar = ++BaseId;
	public static int BottomMenuButton_Profile = ++BaseId;
	
	public static int BottomMenuButton_Cancel = ++BaseId;
	public static int BottomMenuButton_Save = ++BaseId;
	public static int BottomMenuButton_Gallery = ++BaseId;
	public static int BottomMenuButton_Capture = ++BaseId;
	public static int BottomMenuButton_Cover = ++BaseId;
	public static int BottomMenuButton_Confirm = ++BaseId;
	
	public static int Cover = ++BaseId;
	public static int CoverStatusBar = ++BaseId;
	public static int CoverLike = ++BaseId;
	public static int CoverComments = ++BaseId;
	public static int CoverLikeCount = ++BaseId;
	public static int CoverCommentCount = ++BaseId;
	public static int CoverDislikeCount = ++BaseId;
	public static int CoverCommentCountIcon = ++BaseId;
	public static int BottomMenuButton_AddLike = ++BaseId;
	public static int BottomMenuButton_AddFavorite = ++BaseId;
	public static int BottomMenuButton_AddComment = ++BaseId;
	public static int BottomMenuButton_AddDislike = ++BaseId;
	
	public static int CoverDetailImage = ++BaseId;
	public static int CoverDetailContent = ++BaseId;
	
	public static int GalleryScrollView = ++BaseId;
	public static int FollowingScrollView = ++BaseId;
	public static int PersonalScrollView = ++BaseId;
	public static int PersonalBanner = ++BaseId;
	public static int PersonalTab1 = ++BaseId;
	public static int PersonalTab2 = ++BaseId;
	public static int PersonalTab3 = ++BaseId;
	public static int PersonalCategroy0 = ++BaseId;
	public static int PersonalCategroy1 = ++BaseId;
	public static int PersonalCategroy2 = ++BaseId;
	public static int PersonalCategroy3 = ++BaseId;
	public static int SubListItemView = ++BaseId;
	public static int SubListItemPhoto = ++BaseId;
	public static int SubListItemButton = ++BaseId;
	
	// getUserListLayout
	public static int UserListBanner = ++BaseId;
	public static int UserListPhoto = ++BaseId;
	public static int UserListTitle = ++BaseId;
	public static int UserListScrollView = ++BaseId;
	
	public static int MyCoverUserBanner = ++BaseId;
	public static int MyCoverPhoto = ++BaseId;
	public static int MyCoverUserName = ++BaseId;
	public static int MyCoverLocation = ++BaseId;

	public static int ItemPreviewDisplayDescription = ++BaseId;
	public static int ItemPreviewImage = ++BaseId;
	public static int ItemPreviewTitle = ++BaseId;
	public static int ItemPreviewBrand = ++BaseId;
	public static int ItemPreviewDescription = ++BaseId;
	public static int BottomMenuButton_AddWardrobe = ++BaseId;
	public static int BottomMenuButton_AddWishlist = ++BaseId;
	
	public static int ItemDetailbaseLayout = ++BaseId;
	public static int ItemDetailScrollView = ++BaseId;
	public static int ItemDetailPickerView = ++BaseId;
	public static int ItemDetailPickerSave = ++BaseId;
	public static int ItemDetailWheel1 = ++BaseId;
	public static int ItemDetailWheel2 = ++BaseId;
	public static int ItemDetailPhoto = ++BaseId;
	public static int ItemDetailCategory = ++BaseId;
	public static int ItemDetailBrandCategory = ++BaseId;
	public static int ItemDetailPutIntoWardrobe = ++BaseId;
	public static int ItemDetailPutIntoWishlist = ++BaseId;
	public static int ItemDetailWhereYouBuy = ++BaseId;
	public static int ItemDetailTitle = ++BaseId;
	public static int ItemLineDivid = ++BaseId;
	public static int ItemDetailDescription = ++BaseId;
	public static int ItemDetailLink = ++BaseId;
	
	public static int CameraView = ++BaseId;
	public static int EditPhotoImage = ++BaseId;
	public static int EditPhotoFrame = ++BaseId;
	public static int EditPhotoView = ++BaseId;
	
	public static int FacebookSwitch = ++BaseId;
	
	public static int CommentList = ++BaseId;
	public static int CommentContent = ++BaseId;
	
	public static int AddCommentContent = ++BaseId;
	public static int AddCommentButtonCancel = ++BaseId;
	public static int AddCommentButtonPost = ++BaseId;
	
	public static int OutfitSelectionTitle = ++BaseId;
	public static int OutfitSelectionList = ++BaseId;
	
	public static int CommunityFacebookFriendList = ++BaseId;
	public static int CommunityRecommendFriendList = ++BaseId;
	
	public static int DailyTipsWeatherToday = ++BaseId;
	public static int DailyTipsWeatherPhoto = ++BaseId;
	public static int DailyTipsWeatherImage = ++BaseId;
	public static int DailyTipsWeatherTemp = ++BaseId;
	public static int DailyTipsWeatherConditions = ++BaseId;
	public static int DailyTipsWeatherForecast = ++BaseId;
	public static int DailyTipsWeatherWearSuggestion = ++BaseId;
	public static int DailyTipsWeekWeather = ++BaseId;
	public static int DailyTipsWeek1 = ++BaseId;
	public static int DailyTipsWeek2= ++BaseId;
	public static int DailyTipsWeek3 = ++BaseId;
	public static int DailyTipsConstellationImage = ++BaseId;
	public static int DailyTipsConstellationTitle = ++BaseId;
	public static int DailyTipsConstellationContent = ++BaseId;
	
	public static int CoverItemScrollView = ++BaseId;
	public static int CoverItemBigItemPhoto = ++BaseId;
	
	public static int CalendarView = ++BaseId;
	public static int CalendarButtonPrevious = ++BaseId;
	public static int CalendarTextTitle = ++BaseId;
	public static int CalendarButtonNext = ++BaseId;
	public static int CalendarDateView = ++BaseId;
	public static int CalendarDateList = ++BaseId;
	
	public static int CoverEditPhoto = ++BaseId;
	public static int CoverEditView = ++BaseId;
	
	public static int DeleteViewPhoto = ++BaseId;
	public static int DeleteViewButtonCancel = ++BaseId;
	public static int DeleteViewButtonOK = ++BaseId;
	
	public static int CommunityAddFBFriendButton = ++BaseId;
	
	public static int EventWebView = ++BaseId;
	
	public static int SubListPrevious = ++BaseId;
	public static int SubListScrollView = ++BaseId;
	public static int SubListTitleText = ++BaseId;
		
	
	public static void loadScreenResolution(Context context) {
		Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
		if (ConstantTerm.resolution == null)
			ConstantTerm.resolution = new Point();
		if (ConstantTerm.displayMetrics == null)
			ConstantTerm.displayMetrics = new DisplayMetrics();
		display.getSize(ConstantTerm.resolution);
		display.getMetrics(ConstantTerm.displayMetrics);
		float scaleX = (ConstantTerm.resolution.x / ConstantTerm.targetResolution.x);
		//float scaleY = (float)resolution.y / 800.0f;
		//scale = scaleX < scaleY ? scaleX : scaleY;
		LayoutManager.scale = scaleX;
		LayoutManager.fontScale = LayoutManager.scale * (1.5f / ConstantTerm.displayMetrics.density);
	}
	
	/**
	 * 導覽的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getNavigationLayout(Context context) {
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;

		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		ViewPager viewPage = new ViewPager(context);
		viewPage.setId(NavigationPagerView);
		baseLayout.addView(viewPage, rParams);
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}

	/**
	 * WelcomeLayout的Layout UI
	 * 首頁  FB 登入
	 * @param context
	 * @return
	 */
	public static RelativeLayout getWelcomeLayout(Context context) {
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		LinearLayout.LayoutParams lParams = null;
		
		baseLayout.setId(WelcomeBase);
		baseLayout.setBackgroundResource(R.drawable.img_welcomebg);

		// Facebook login 按鈕
		rParams = new RelativeLayout.LayoutParams((int)(370 * LayoutManager.scale), (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins((int)(58 * LayoutManager.scale), 0, 0, (int)(207 * LayoutManager.scale));
		ImageView imageView = new ImageView(context);
		imageView.setId(WelcomeFBButton);
		imageView.setBackgroundResource(R.drawable.btn_loginfb);
		baseLayout.addView(imageView, rParams);
		
		// E-mail login 按鈕
		rParams = new RelativeLayout.LayoutParams((int)(370 * LayoutManager.scale), (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins((int)(58 * LayoutManager.scale), 0, 0, (int)(123 * LayoutManager.scale));
		imageView = new ImageView(context);
		imageView.setId(WelcomeEmailButton);
		imageView.setBackgroundResource(R.drawable.btn_loginemail);
		baseLayout.addView(imageView, rParams);
		
		// 隱私權政策和使用者條款
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins((int)(60 * LayoutManager.scale), 0, 0,(int)(67 * LayoutManager.scale));
		//rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		LinearLayout law = new LinearLayout(context);
		baseLayout.addView(law, rParams);
		
		//checkbox
		lParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		CheckBox checkbox = new CheckBox(context);
		checkbox.setId(WelcomeLawCheckBox);
		law.addView(checkbox, lParams);
		
		//隱私權文字
		lParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		TextView textView = new TextView(context);
		textView.setId(WelcomeLawText);
		textView.setText(R.string.agreeLaw);
		textView.setTextSize(11 * LayoutManager.fontScale);
		textView.getPaint().setFakeBoldText(true);
		law.addView(textView, lParams);
		
		//小花與合作提案
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins((int)(70 * LayoutManager.scale), 0, 0, (int)(37 * LayoutManager.scale));
		LinearLayout cooperation = new LinearLayout(context);
		cooperation.setId(WelcomeCooperation);
		baseLayout.addView(cooperation, rParams);
		
		//小花
		lParams = new LinearLayout.LayoutParams((int)(32 * LayoutManager.scale), (int)(32 * LayoutManager.scale));
		ImageView flower = new ImageView(context);
		flower.setImageResource(R.drawable.icon_flower);
		cooperation.addView(flower, lParams);
		
		//合作提案text
		lParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lParams.setMargins((int)(11 * LayoutManager.scale), (int)(5 * LayoutManager.scale), 0, 0);
		TextView coopertext = new TextView(context);
		coopertext.setText(R.string.cooper);
		coopertext.setTextSize(11 * LayoutManager.fontScale);
		coopertext.setTextColor(Color.WHITE);
		coopertext.getPaint().setFakeBoldText(true);
		cooperation.addView(coopertext, lParams);
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * TermLayout的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getTermLayout(Context context) {
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		ScrollView sv = new ScrollView(context);
		RelativeLayout svrl = new RelativeLayout(context);
		RelativeLayout rb = new RelativeLayout(context);
		ImageView iv = null;
		
		TextView textView = null;

		baseLayout.setBackgroundResource(R.drawable.img_welcomebg);
		
		svrl.setBackgroundColor(Color.argb(200, 0, 0, 0));
//		baseLayout.setBackgroundResource(R.drawable.img_welcomebg);

		int layoutID = 100;
		// 標題
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		rParams.setMargins((int)(30 * LayoutManager.scale), (int)(24 * LayoutManager.scale), (int)(30 * LayoutManager.scale), 0);
		textView = new TextView(context);
		textView.setId(++layoutID);
		textView.setText(R.string.agreeLawTitle);
		textView.setTextSize(18 * LayoutManager.fontScale);
		textView.setTypeface(null,Typeface.BOLD);
		textView.setTextColor(Color.rgb(255, 255, 255));
//		textView.setBackgroundColor(Color.argb(0, 0, 0, 0));
		svrl.addView(textView, rParams);
		
		// 內文
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW,layoutID);
		rParams.setMargins((int)(30 * LayoutManager.scale), (int)(24 * LayoutManager.scale), (int)(30 * LayoutManager.scale), 0);
		textView = new TextView(context);
		textView.setId(++layoutID);
		textView.setText(R.string.agreeLawContent);
		textView.setTextSize(12 * LayoutManager.fontScale);
		textView.setTextColor(Color.rgb(255, 255, 255));
//		textView.setBackgroundColor(Color.argb(0, 0, 0, 0));
		svrl.addView(textView, rParams);
		
		// 標題
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW,layoutID);
		rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		rParams.setMargins((int)(30 * LayoutManager.scale), (int)(24 * LayoutManager.scale), (int)(30 * LayoutManager.scale), 0);
		textView = new TextView(context);
		textView.setId(++layoutID);
		textView.setText(R.string.agreePrivacyTitle);
		textView.setTextSize(18 * LayoutManager.fontScale);
		textView.setTypeface(null,Typeface.BOLD);
		textView.setTextColor(Color.rgb(255, 255, 255));
//		textView.setBackgroundColor(Color.argb(0, 0, 0, 0));
		svrl.addView(textView, rParams);
		
		// 內文
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW,layoutID);
		rParams.setMargins((int)(30 * LayoutManager.scale), (int)(24 * LayoutManager.scale), (int)(30 * LayoutManager.scale), 0);
		textView = new TextView(context);
		textView.setId(++layoutID);
		textView.setText(R.string.agreePrivacyContent);
		textView.setTextSize(12 * LayoutManager.fontScale);
		textView.setTextColor(Color.rgb(255, 255, 255));
//		textView.setBackgroundColor(Color.argb(0, 0, 0, 0));
		svrl.addView(textView, rParams);
		
		// 按鈕
		rParams = new RelativeLayout.LayoutParams((int)(250 * LayoutManager.scale), (int)(60 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		rParams.setMargins(0, (int)(10 * LayoutManager.scale), 0, (int)(10 * LayoutManager.scale));
		iv = new ImageView(context);
		iv.setId(WelcomeLawAcceptBtn);
		iv.setBackgroundResource(R.drawable.btn_ok);
		rb.addView(iv, rParams);

		// 按鈕背景
		rb.setBackgroundColor(Color.rgb(52, 209, 209));
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW,layoutID);
		rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		svrl.addView(rb,rParams);
		

		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		sv.addView(svrl, rParams);
		baseLayout.addView(sv);
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		baseLayout.setAlpha(0.5f);
		return baseLayout;
	}
	
	/**
	 * MainActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getMainLayout(Context context) {
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;

		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		ViewPager pager = new ViewPager(context);
		pager.setId(Pager);
		pager.setPadding(0, 0, 0, 0);
		baseLayout.addView(pager, rParams);
		
		LayoutManagerHelper.generalButtomMenu(context, baseLayout);
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * CommunityActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getCommunityLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		RelativeLayout layout = null;
		RelativeLayout scrollViewLayout = null;
		RelativeLayout facebookFriendLayout = null;
		TextView textView = null;
		ImageView imageView = null;
		ScrollView scrollView = null;
		
		scrollViewLayout = new RelativeLayout(context);
		scrollViewLayout.setBackgroundColor(Color.WHITE);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		scrollView = new ScrollView(context);
		scrollView.addView(scrollViewLayout, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		baseLayout.addView(scrollView, rParams);
		
		// 使用Dressbook的朋友
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(64 * LayoutManager.scale));
		layout = new RelativeLayout(context);
		layout.setBackgroundColor(Color.rgb(99, 124, 181));
		scrollViewLayout.addView(layout, rParams);
		
		// 使用Dressbook的朋友標題
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		rParams.addRule(RelativeLayout.CENTER_VERTICAL);
		textView = new TextView(context);
		textView.setId(10);
		textView.setTextSize(15 * LayoutManager.fontScale);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.WHITE);
		textView.setText(context.getString(R.string.CommunityFacebookFriendList));
		layout.addView(textView, rParams);
		
		// Facebook圖示
		rParams = new RelativeLayout.LayoutParams((int)(34 * LayoutManager.scale), (int)(34 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.LEFT_OF, 10);
		rParams.addRule(RelativeLayout.CENTER_VERTICAL);
		rParams.setMargins(0, 0, (int)(8 * LayoutManager.scale), 0);
		imageView = new ImageView(context);
		imageView.setImageResource(R.drawable.icon_fb);
		imageView.setScaleType(ScaleType.CENTER_INSIDE);
		layout.addView(imageView, rParams);
		
		// 使用Dressbook的朋友清單
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, (int)(64 * LayoutManager.scale), 0, 0);
		facebookFriendLayout = new RelativeLayout(context);
		facebookFriendLayout.setId(CommunityFacebookFriendList);
		facebookFriendLayout.setBackgroundColor(Color.WHITE);
		facebookFriendLayout.setPadding((int)(8 * LayoutManager.scale), (int)(8 * LayoutManager.scale), (int)(8 * LayoutManager.scale), (int)(8 * LayoutManager.scale));
		scrollViewLayout.addView(facebookFriendLayout, rParams);

		// 推薦朋友的按鈕
		rParams = new RelativeLayout.LayoutParams((int)(370 * LayoutManager.scale), (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW, CommunityFacebookFriendList);
		rParams.setMargins((int)(57 * LayoutManager.scale), (int)(8 * LayoutManager.scale), 0, 0);
		imageView = new ImageView(context);
		imageView.setId(CommunityAddFBFriendButton);
		imageView.setBackgroundResource(R.drawable.btn_fbfriend);
		scrollViewLayout.addView(imageView, rParams);
		
//		// 推薦朋友
//		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(65 * scale));
//		rParams.addRule(RelativeLayout.BELOW, CommunityFacebookFriendList);
//		layout = new RelativeLayout(context);
//		layout.setId(10);
//		layout.setBackgroundColor(Color.rgb(102, 102, 102));
//		scrollViewLayout.addView(layout, rParams);
//		
//		// 推薦朋友標題
//		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//		rParams.addRule(RelativeLayout.CENTER_IN_PARENT);
//		textView = new TextView(context);
//		textView.setTextSize(15 * fontScale);
//		textView.setGravity(Gravity.CENTER);
//		textView.setTextColor(Color.WHITE);
//		textView.setText(context.getString(R.string.CommunityRecommendFriendList));
//		layout.addView(textView, rParams);
//		
//		// 推薦朋友清單
//		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//		rParams.addRule(RelativeLayout.BELOW, 10);
//		recommendFriendLayout = new RelativeLayout(context);
//		recommendFriendLayout.setId(CommunityRecommendFriendList);
//		recommendFriendLayout.setBackgroundColor(Color.WHITE);
//		recommendFriendLayout.setPadding((int)(8 * scale), (int)(8 * scale), (int)(8 * scale), (int)(8 * scale));
//		scrollViewLayout.addView(recommendFriendLayout, rParams);
		
		LayoutManagerHelper.generalButtomMenu(context, baseLayout);
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}

	/**
	 * DailyOutfitListActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getDailyOutfitSelectionLayout(Context context) {
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		
		TextView textView = null;
		ScrollView scrollView = null;
		
		// 標題
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		textView = new TextView(context);
		textView.setId(OutfitSelectionTitle);
		textView.setTextSize(15 * LayoutManager.fontScale);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.BLACK);
		textView.setBackgroundColor(Color.rgb(221, 221, 221));
		textView.setText(context.getString(R.string.DailyOutfitSelectionToday));
		baseLayout.addView(textView, rParams);
		
		// 項目捲動軸
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW, OutfitSelectionTitle);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		scrollView = new ScrollView(context);
		scrollView.setId(OutfitSelectionList);
		baseLayout.addView(scrollView, rParams);
		
		LayoutManagerHelper.generalButtomMenu(context, baseLayout);
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * OutfitSelectionActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getOutfitSelectionLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		baseLayout.setBackgroundColor(Color.WHITE);
		RelativeLayout.LayoutParams rParams = null;
		LinearLayout lLayout = null;
		LinearLayout.LayoutParams lParams = null;
		
		TextView textView = null;
		ScrollView scrollView = null;
		
		// 標題
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		textView = new TextView(context);
		textView.setId(OutfitSelectionTitle);
		textView.setTextSize(15 * LayoutManager.fontScale);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.BLACK);
		textView.setBackgroundColor(Color.rgb(221, 221, 221));
		textView.setText(context.getString(R.string.OutfitSelection));
		baseLayout.addView(textView, rParams);
		
		// 項目捲動軸
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW, OutfitSelectionTitle);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		scrollView = new ScrollView(context);
		scrollView.setId(OutfitSelectionList);
		baseLayout.addView(scrollView, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		lLayout = new LinearLayout(context);
		lLayout.setId(BottomMenuButtonLayout);
		lLayout.setBackgroundResource(R.drawable.menubar);
		lLayout.setOrientation(LinearLayout.HORIZONTAL);
		lLayout.setWeightSum(2);
		baseLayout.addView(lLayout, rParams);

		for (int i = 0; i < 2; ++i) {
			lParams = new LinearLayout.LayoutParams((int)(ConstantTerm.resolution.x / lLayout.getWeightSum()), (int)(72 * LayoutManager.scale), 1);
			lParams.gravity = Gravity.CENTER;
			StatusButton button = new StatusButton(context);
			button.setId(BottomMenuButton_Cancel + i);
			lLayout.addView(button, lParams);
		}

		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * AddCommentActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getAddCommentLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		baseLayout.setPadding((int)(4 * LayoutManager.scale), (int)(4 * LayoutManager.scale), (int)(4 * LayoutManager.scale), (int)(4 * LayoutManager.scale));
		RelativeLayout.LayoutParams rParams = null;
		EditText editText = null;
		ImageButton button = null;
		TextView textView = null;
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(57 * LayoutManager.scale));
		editText = new EditText(context);
		editText.setId(AddCommentContent);
		editText.setSingleLine(false);
		editText.setTextSize(16 * LayoutManager.fontScale);
		editText.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		editText.setTextColor(Color.rgb(152, 152, 152));
		editText.setHintTextColor(Color.rgb(152, 152, 152));
		editText.setHint(R.string.CommentHint);
		editText.setInputType(InputType.TYPE_CLASS_TEXT);
		baseLayout.addView(editText, rParams);
		
		// Cancel 按鈕
		rParams = new RelativeLayout.LayoutParams((int)(210 * LayoutManager.scale), (int)(50 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.addRule(RelativeLayout.BELOW, AddCommentContent);
		rParams.setMargins(0, (int)(23 * LayoutManager.scale), (int)(250 * LayoutManager.scale), 0);
		button = new ImageButton(context);
		button.setId(AddCommentButtonCancel);
		button.setBackgroundColor(Color.rgb(152, 152, 152));
		baseLayout.addView(button, rParams);
		
		rParams = new RelativeLayout.LayoutParams((int)(210 * LayoutManager.scale), (int)(50 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.addRule(RelativeLayout.BELOW, AddCommentContent);
		rParams.setMargins(0, (int)(23 * LayoutManager.scale), (int)(250 * LayoutManager.scale), 0);
		textView = new TextView(context);
		textView.setText(R.string.BtnCancel);
		textView.setTextSize(12 * LayoutManager.fontScale);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.WHITE);
		textView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return false;
			}
		});
		baseLayout.addView(textView, rParams);
		
		// Post 按鈕
		rParams = new RelativeLayout.LayoutParams((int)(210 * LayoutManager.scale), (int)(50 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.addRule(RelativeLayout.BELOW, AddCommentContent);
		rParams.setMargins(0, (int)(23 * LayoutManager.scale), (int)(10 * LayoutManager.scale), 0);
		button = new ImageButton(context);
		button.setId(AddCommentButtonPost);
		button.setBackgroundColor(Color.rgb(152, 152, 152));
		baseLayout.addView(button, rParams);
		
		rParams = new RelativeLayout.LayoutParams((int)(210 * LayoutManager.scale), (int)(50 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.addRule(RelativeLayout.BELOW, AddCommentContent);
		rParams.setMargins(0, (int)(23 * LayoutManager.scale), (int)(10 * LayoutManager.scale), 0);
		textView = new TextView(context);
		textView.setText(R.string.BtnPost);
		textView.setTextSize(12 * LayoutManager.fontScale);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.WHITE);
		textView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return false;
			}
		});
		baseLayout.addView(textView, rParams);
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		baseLayout.setBackgroundColor(Color.rgb(51, 51, 51));
		return baseLayout;
	}
	
	/**
	 * CommentActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getCommentLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		TextView textView = null;
		ScrollView scrollView = null;
		
		baseLayout.setBackgroundColor(Color.rgb(51, 51, 51));
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, 0, 0, (int)(100 * LayoutManager.scale));
		scrollView = new ScrollView(context);
		scrollView.setId(CommentList);
		scrollView.setPadding((int)(10 * LayoutManager.scale), (int)(10 * LayoutManager.scale), (int)(10 * LayoutManager.scale), (int)(10 * LayoutManager.scale));
		baseLayout.addView(scrollView, rParams);
		
		// Comments
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins((int)(10 * LayoutManager.scale), 0, (int)(10 * LayoutManager.scale), (int)(7 * LayoutManager.scale));
		textView = new TextView(context);
		textView.setId(CommentContent);
		textView.setTextSize(16 * LayoutManager.fontScale);
		textView.setGravity(Gravity.LEFT | Gravity.TOP);
		textView.setPadding((int)(17 * LayoutManager.scale), (int)(13 * LayoutManager.scale), 0, 0);
		textView.setTextColor(Color.WHITE);
		textView.setBackgroundColor(Color.rgb(45, 159, 201));
		textView.setText(R.string.CommentHint);
		baseLayout.addView(textView, rParams);
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * EditPhotoActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getEditPhotoLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout layout = null;
		RelativeLayout.LayoutParams rParams = null;
		LinearLayout lLayout = null;
		LinearLayout.LayoutParams lParams = null;
		ImageView imageView = null;
		
		baseLayout.setBackgroundColor(Color.rgb(52, 52, 52));
		
		//顯示縮放裁切的照片
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		imageView = new ImageView(context);
		imageView.setId(EditPhotoImage);
		baseLayout.addView(imageView, rParams);
		
		//要上傳圖的框框
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		rParams.setMargins(0, (int)(100 * LayoutManager.scale), 0, 0);
		imageView = new ImageView(context);
		imageView.setId(EditPhotoFrame);
		imageView.setImageResource(R.drawable.u18_normal);
		baseLayout.addView(imageView, rParams);
		
		//這裡要放【縮放照片尺寸及移動照片做裁切】的文字提示
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(60 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins(0, 0, 0, (int)(80* LayoutManager.scale));
		layout = new RelativeLayout(context);
		layout.setBackgroundColor(Color.argb(150, 167, 167, 167));
		baseLayout.addView(layout, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		TextView textView = new TextView(context);
		textView.setTextColor(Color.WHITE);
		textView.setTextSize(16 * LayoutManager.fontScale);
		textView.setText(R.string.EditPhotoHint);
		textView.setGravity(Gravity.CENTER);
		layout.addView(textView, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		layout = new RelativeLayout(context);
		layout.setId(EditPhotoView);
		baseLayout.addView(layout, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		lLayout = new LinearLayout(context);
		lLayout.setId(BottomMenuButtonLayout);
		lLayout.setBackgroundResource(R.drawable.menubar_line);
		lLayout.setOrientation(LinearLayout.HORIZONTAL);
		lLayout.setWeightSum(2);
		baseLayout.addView(lLayout, rParams);
		
		for (int i = 0; i < 2; ++i) {
			lParams = new LinearLayout.LayoutParams((int)(ConstantTerm.resolution.x / lLayout.getWeightSum()), (int)(72 * LayoutManager.scale), 1);
			lParams.gravity = Gravity.CENTER;
			ImageTextButton button = new ImageTextButton(context);
			button.setId(i == 0 ? BottomMenuButton_Cover : BottomMenuButton_Save);
			button.setText(i == 0 ? context.getString(R.string.SaveCover) : context.getString(R.string.SaveItem));
			button.setIcon(i == 0 ? R.drawable.icon_save : R.drawable.icon_cloth);
			lLayout.addView(button, lParams);
		}
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * PersonalInfoActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getPersonalInfoLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		
		UserBanner userBanner = null;
		ScrollView scrollView = null;
		
		// 使用者資料欄
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		userBanner = new UserBanner(context, true);
		userBanner.setId(PersonalBanner);
		baseLayout.addView(userBanner, rParams);
		
		//Looks
		rParams = new RelativeLayout.LayoutParams((int)(158 * LayoutManager.scale), (int)(65 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW,PersonalBanner);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		rParams.setMargins(0, (int)(3 * LayoutManager.scale), 0, 0);
		TextView textView = new TextView(context);
		textView.setText("Looks");
		textView.setGravity(Gravity.CENTER);
		textView.setTextSize(22 * LayoutManager.fontScale);
		textView.setTextColor(Color.WHITE);
		textView.setBackgroundResource(R.drawable.tab_blue);
		textView.setId(PersonalTab1);
		baseLayout.addView(textView, rParams);
		
		//衣櫃分享
		rParams = new RelativeLayout.LayoutParams((int)(158 * LayoutManager.scale), (int)(65 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW,PersonalBanner);
		rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		rParams.setMargins(0, (int)(3 * LayoutManager.scale), 0, 0);
		textView = new TextView(context);
		textView.setText("衣櫃分享");
		textView.setGravity(Gravity.CENTER);
		textView.setTextSize(22 * LayoutManager.fontScale);
		textView.setTextColor(Color.rgb(153, 153, 153));
		textView.setBackgroundResource(R.drawable.tab_grey);
		textView.setId(PersonalTab2);
		baseLayout.addView(textView, rParams);
		
		//慾望清單
		rParams = new RelativeLayout.LayoutParams((int)(158 * LayoutManager.scale), (int)(65 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW,PersonalBanner);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.setMargins(0, (int)(3 * LayoutManager.scale), 0, 0);
		textView = new TextView(context);
		textView.setText("慾望清單");
		textView.setGravity(Gravity.CENTER);
		textView.setTextSize(22 * LayoutManager.fontScale);
		textView.setTextColor(Color.rgb(153, 153, 153));
		textView.setBackgroundResource(R.drawable.tab_grey);
		textView.setId(PersonalTab3);
		baseLayout.addView(textView, rParams);
		
		//tab底下的bar
		rParams = new RelativeLayout.LayoutParams((int)(480 * LayoutManager.scale), (int)(5 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW,PersonalTab2);
		ImageView imageView= new ImageView(context);
		imageView.setImageResource(R.drawable.stripblue480_5);
		imageView.setScaleType(ScaleType.FIT_XY);
		imageView.setId(199);	
		baseLayout.addView(imageView, rParams);
		
		// 個人資料頁下方的 Scroll view
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW, 199);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		scrollView = new ScrollView(context);
		scrollView.setId(PersonalScrollView);
		scrollView.setBackgroundColor(Color.WHITE);
		baseLayout.addView(scrollView, rParams);
		
		
		LayoutManagerHelper.generalButtomMenu(context, baseLayout);
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * UserListActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getUserListLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);

		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;

		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(93 * LayoutManager.scale));
		// 查看使用者訊息底圖
		com.otiga.dress.layout.component.UserListBanner layout = 
				new com.otiga.dress.layout.component.UserListBanner(context);
		baseLayout.addView(layout, rParams);
		
		// 下方的 User Scroll view field
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		rParams.addRule(RelativeLayout.BELOW, UserListBanner);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		ScrollView scrollView = new ScrollView(context);
		scrollView.setId(UserListScrollView);
		scrollView.setBackgroundColor(Color.WHITE);
		baseLayout.addView(scrollView, rParams);

		LayoutManagerHelper.generalButtomMenu(context, baseLayout);
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * CaptureActivity的Layout UI
	 * @param context
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static RelativeLayout getCaptureLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		LinearLayout lLayout = null;
		LinearLayout.LayoutParams lParams = null;

		rParams = new RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		SurfaceView surfaceView = new SurfaceView(context);
		surfaceView.setId(CameraView);
		baseLayout.addView(surfaceView, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		lLayout = new LinearLayout(context);
		lLayout.setId(BottomMenuButtonLayout);
		lLayout.setBackgroundResource(R.drawable.menubar_line);
		lLayout.setOrientation(LinearLayout.HORIZONTAL);
		lLayout.setWeightSum(2);
		baseLayout.addView(lLayout, rParams);

		for (int i = 0; i < 2; ++i) {
			lParams = new LinearLayout.LayoutParams((int)(ConstantTerm.resolution.x / lLayout.getWeightSum()), (int)(72 * LayoutManager.scale), 1);
			lParams.gravity = Gravity.CENTER;
			StatusButton button = new StatusButton(context);
			button.setId(BottomMenuButton_Gallery + i);
			button.setIcon(i == 0 ? R.drawable.content_picture : R.drawable.device_access_camera);
			lLayout.addView(button, lParams);
		}

		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * 
	 * @param context
	 * @return
	 */
	public static RelativeLayout getCoverDetailLayout(final Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout rLayout = null;
		RelativeLayout.LayoutParams rParams = null;
		LinearLayout lLayout = null;
		LinearLayout.LayoutParams lParams = null;
		ImageView imageView = null;
		ScrollView scrollView = null;
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		scrollView = new ScrollView(context);
		scrollView.setBackgroundColor(Color.WHITE);
		baseLayout.addView(scrollView, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rLayout = new RelativeLayout(context);
		rLayout.setId(CoverDetailContent);
		rLayout.setBackgroundColor(Color.WHITE);
		scrollView.addView(rLayout, rParams);
		
		// Cover底圖
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(340 * LayoutManager.scale));
		imageView = new ImageView(context);
		imageView.setId(CoverDetailImage);
		imageView.setScaleType(ScaleType.FIT_CENTER);
		imageView.setAdjustViewBounds(true);
		rLayout.addView(imageView, rParams);
		
		// 分隔線
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW, CoverDetailImage);
		imageView = new ImageView(context);
		imageView.setId(ItemLineDivid);
		imageView.setImageResource(R.drawable.line_item_divid);
		rLayout.addView(imageView, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		lLayout = new LinearLayout(context);
		lLayout.setId(BottomMenuButtonLayout);
		lLayout.setBackgroundResource(R.drawable.menubar);
		lLayout.setOrientation(LinearLayout.HORIZONTAL);
		lLayout.setWeightSum(2);
		baseLayout.addView(lLayout, rParams);
		
		for (int i = 0; i < 2; ++i) {
			lParams = new LinearLayout.LayoutParams((int)(ConstantTerm.resolution.x / lLayout.getWeightSum()), (int)(72 * LayoutManager.scale), 1);
			lParams.gravity = Gravity.CENTER;
			StatusButton button = new StatusButton(context);
			button.setId(i == 0 ? BottomMenuButton_Cancel : BottomMenuButton_Save);
			button.setIcon(i == 0 ? R.drawable.icon_cancel : R.drawable.icon_save);
			lLayout.addView(button, lParams);
		}
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * CoverActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getCoverLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		baseLayout.setBackgroundColor(Color.BLACK);
		
		RelativeLayout.LayoutParams rParams = null;
		StatusButton statusButton = null;
		ImageView imageView = null;
		TextView textView = null;
		
		// Cover底圖
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		imageView = new ImageView(context);
		imageView.setId(Cover);
		//imageView.setImageResource(R.drawable.street_noback);
		imageView.setScaleType(ScaleType.CENTER_CROP);
		imageView.setAdjustViewBounds(true);
		baseLayout.addView(imageView, rParams);
		
		// 加入最愛按鈕
		rParams = new RelativeLayout.LayoutParams((int)(60 * LayoutManager.scale), (int)(75 * LayoutManager.scale));
		rParams.setMargins((int)(404 * LayoutManager.scale), 0, 0, 0);
		statusButton = new StatusButton(context);
		statusButton.setId(BottomMenuButton_AddFavorite);
		baseLayout.addView(statusButton, rParams);
		
		// 按讚按鈕
		rParams = new RelativeLayout.LayoutParams((int)(52 * LayoutManager.scale), (int)(73 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins( (int)(161 * LayoutManager.scale), 0, 0, (int)(17 * LayoutManager.scale));
		statusButton = new StatusButton(context);
		statusButton.setId(BottomMenuButton_AddLike);
		baseLayout.addView(statusButton, rParams);
		
		// 留言按鈕
		rParams = new RelativeLayout.LayoutParams((int)(52 * LayoutManager.scale), (int)(73 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins( (int)(268 * LayoutManager.scale), 0, 0, (int)(17 * LayoutManager.scale));
		statusButton = new StatusButton(context);
		statusButton.setId(BottomMenuButton_AddComment);
		baseLayout.addView(statusButton, rParams);
		
		// 按讚數量
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.RIGHT_OF, BottomMenuButton_AddLike);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins( 0, 0, 0, (int)(14 * LayoutManager.scale));
		textView = new TextView(context);
		textView.setId(CoverLikeCount);
		textView.setTextSize(12 * LayoutManager.fontScale);
		textView.setSingleLine();
		textView.setTextColor(Color.WHITE);
		textView.setText("302");
		baseLayout.addView(textView, rParams);
		
		// 留言數量
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.RIGHT_OF, BottomMenuButton_AddComment);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins( 0, 0, 0, (int)(14 * LayoutManager.scale));
		textView = new TextView(context);
		textView.setId(CoverCommentCount);
		textView.setTextSize(12 * LayoutManager.fontScale);
		textView.setSingleLine();
		textView.setTextColor(Color.WHITE);
		textView.setText("302");
		baseLayout.addView(textView, rParams);
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * CoverItemActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getCoverItemLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		ScrollView scrollview = null;
		
		baseLayout.setBackgroundColor(Color.rgb(255, 255, 255));
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		scrollview = new ScrollView(context);
		scrollview.setId(CoverItemScrollView);
		scrollview.setBackgroundColor(Color.WHITE);
		baseLayout.addView(scrollview, rParams);
		
		//點擊item photo顯示大圖用
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		ImageView imageView = new ImageView(context);
		imageView.setId(CoverItemBigItemPhoto);
		imageView.setBackgroundColor(Color.WHITE);
		imageView.setScaleType(ScaleType.FIT_CENTER);
		imageView.setVisibility(View.GONE);
		baseLayout.addView(imageView, rParams);
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}

	/**
	 * MyCoverActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getMyCoverLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout layout = null;
		RelativeLayout.LayoutParams rParams = null;
		StatusButton statusButton = null;
		ImageView imageView = null;
		TextView textView = null;
		
		// 個人訊息底圖
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		layout = new RelativeLayout(context);
		layout.setId(MyCoverUserBanner);
		layout.setBackgroundColor(Color.rgb(51, 51, 51));
		baseLayout.addView(layout, rParams);
		
		// 頭像圖示
		rParams = new RelativeLayout.LayoutParams((int)(74 * LayoutManager.scale), (int)(74 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.CENTER_VERTICAL);
		rParams.setMargins((int)(5 * LayoutManager.scale), 0, 0, 0);
		imageView = new ImageView(context);
		imageView.setId(MyCoverPhoto);
		imageView.setImageResource(R.drawable.icon_portrait);
		layout.addView(imageView, rParams);
		
		// 姓名
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins((int)(92 * LayoutManager.scale), 0, 0, (int)(40 * LayoutManager.scale));
		textView = new TextView(context);
		textView.setId(MyCoverUserName);
		textView.setTextSize(16 * LayoutManager.fontScale);
		textView.setTypeface(null, Typeface.BOLD);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.WHITE);
		layout.addView(textView, rParams);
		
		// 所在地
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins((int)(92 * LayoutManager.scale), 0, 0, (int)(12 * LayoutManager.scale));
		textView = new TextView(context);
		textView.setId(MyCoverLocation);
		textView.setTextSize(11 * LayoutManager.fontScale);
		textView.setTypeface(null, Typeface.BOLD);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.rgb(166, 166, 166));
		layout.addView(textView, rParams);
		
		// Cover底圖
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		rParams.setMargins(0, (int)(80 * LayoutManager.scale), 0, 0);
		imageView = new ImageView(context);
		imageView.setId(Cover);
		baseLayout.addView(imageView, rParams);
		
		// 加入最愛按鈕
		rParams = new RelativeLayout.LayoutParams((int)(60 * LayoutManager.scale), (int)(75 * LayoutManager.scale));
		rParams.setMargins((int)(404 * LayoutManager.scale), (int)(80 * LayoutManager.scale), 0, 0);
		statusButton = new StatusButton(context);
		statusButton.setId(BottomMenuButton_AddFavorite);
		baseLayout.addView(statusButton, rParams);
		
		// 按讚按鈕
		rParams = new RelativeLayout.LayoutParams((int)(52 * LayoutManager.scale), (int)(73 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins( (int)(115 * LayoutManager.scale), 0, 0, (int)(17 * LayoutManager.scale));
		statusButton = new StatusButton(context);
		statusButton.setId(BottomMenuButton_AddLike);
		baseLayout.addView(statusButton, rParams);
		
		// 留言按鈕
		rParams = new RelativeLayout.LayoutParams((int)(52 * LayoutManager.scale), (int)(73 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins( (int)(222 * LayoutManager.scale), 0, 0, (int)(17 * LayoutManager.scale));
		statusButton = new StatusButton(context);
		statusButton.setId(BottomMenuButton_AddComment);
		baseLayout.addView(statusButton, rParams);
		
		// 不愛按鈕
		rParams = new RelativeLayout.LayoutParams((int)(52 * LayoutManager.scale), (int)(73 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins( (int)(329 * LayoutManager.scale), 0, 0, (int)(17 * LayoutManager.scale));
		statusButton = new StatusButton(context);
		statusButton.setId(BottomMenuButton_AddDislike);
		baseLayout.addView(statusButton, rParams);
		
		// 按讚數量
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.RIGHT_OF, BottomMenuButton_AddLike);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins( 0, 0, 0, (int)(14 * LayoutManager.scale));
		textView = new TextView(context);
		textView.setId(CoverLikeCount);
		textView.setTextSize(12 * LayoutManager.fontScale);
		textView.setSingleLine();
		textView.setTextColor(Color.WHITE);
		textView.setText("302");
		baseLayout.addView(textView, rParams);
		
		// 留言數量
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.RIGHT_OF,BottomMenuButton_AddComment);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins( 0, 0, 0, (int)(14 * LayoutManager.scale));
		textView = new TextView(context);
		textView.setId(CoverCommentCount);
		textView.setTextSize(12 * LayoutManager.fontScale);
		textView.setSingleLine();
		textView.setTextColor(Color.WHITE);
		textView.setText("302");
		baseLayout.addView(textView, rParams);
		
		// 不愛數量
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.RIGHT_OF,BottomMenuButton_AddDislike);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins( 0, 0, 0, (int)(14 * LayoutManager.scale));
		textView = new TextView(context);
		textView.setId(CoverDislikeCount);
		textView.setTextSize(12 * LayoutManager.fontScale);
		textView.setSingleLine();
		textView.setTextColor(Color.WHITE);
		textView.setText("302");
		baseLayout.addView(textView, rParams);

		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * GalleryActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getGalleryLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		
		LinearLayout lLayout = null;
		LinearLayout.LayoutParams lParams = null;
		
		ScrollView scrollView = null;
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		scrollView = new ScrollView(context);
		scrollView.setId(GalleryScrollView);
		scrollView.setBackgroundColor(Color.rgb(51, 51, 51));
		baseLayout.addView(scrollView, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		lLayout = new LinearLayout(context);
		lLayout.setId(BottomMenuButtonLayout);
		lLayout.setBackgroundResource(R.drawable.menubar_line);
		lLayout.setOrientation(LinearLayout.HORIZONTAL);
		lLayout.setWeightSum(2);
		baseLayout.addView(lLayout, rParams);

		for (int i = 0; i < 2; ++i) {
			lParams = new LinearLayout.LayoutParams((int)(ConstantTerm.resolution.x / lLayout.getWeightSum()), (int)(72 * LayoutManager.scale), 1);
			lParams.gravity = Gravity.CENTER;
			StatusButton button = new StatusButton(context);
			button.setId(i == 0 ? BottomMenuButton_Cancel : BottomMenuButton_Confirm);
			button.setIcon(i == 0 ? R.drawable.navigation_cancel : R.drawable.navigation_accept);
			lLayout.addView(button, lParams);
		}

		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * FollowingActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getFollowingLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		
		ScrollView scrollView = null;
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, 0, 0, (int)(80.0f * LayoutManager.scale));
		scrollView = new ScrollView(context);
		scrollView.setId(FollowingScrollView);
		scrollView.setBackgroundColor(Color.rgb(51, 51, 51));
		baseLayout.addView(scrollView, rParams);
		
		LayoutManagerHelper.generalButtomMenu(context, baseLayout);
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * ItemPreviewLayout的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getItemPreviewLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout layout = null;
		RelativeLayout.LayoutParams rParams = null;
		LinearLayout lLayout = null;
		LinearLayout.LayoutParams lParams = null;
		ImageView imageView = null;
		TextView textView = null;
		
		baseLayout.setBackgroundColor(Color.WHITE);

		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		imageView = new ImageView(context);
		imageView.setId(ItemPreviewImage);
		baseLayout.addView(imageView, rParams);
		
		//這裡放物品的說明，且預設為不顯示
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(120 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins(0, 0, 0, (int)(80* LayoutManager.scale));
		ScrollView scrollView = new ScrollView(context);
		scrollView.setId(ItemPreviewDisplayDescription);
		baseLayout.addView(scrollView, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		layout = new RelativeLayout(context);
		layout.setPadding((int)(14* LayoutManager.scale), (int)(8* LayoutManager.scale), (int)(14* LayoutManager.scale), (int)(8* LayoutManager.scale));
		layout.setBackgroundResource(R.drawable.bg_product_contbar);
		scrollView.addView(layout, rParams);

		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		textView = new TextView(context);
		textView.setId(ItemPreviewTitle);
		textView.setTextColor(Color.rgb(53, 215, 215));
		textView.setTextSize(20 * LayoutManager.fontScale);
		textView.setText(R.string.EditPhotoHint);
		layout.addView(textView, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, (int)(38* LayoutManager.scale), 0, 0);
		textView = new TextView(context);
		textView.setId(ItemPreviewBrand);
		textView.setTextColor(Color.WHITE);
		textView.setTextSize(14 * LayoutManager.fontScale);
		textView.setText(R.string.EditPhotoHint);
		layout.addView(textView, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, (int)(66* LayoutManager.scale), 0, 0);
		textView = new TextView(context);
		textView.setId(ItemPreviewDescription);
		textView.setTextColor(Color.WHITE);
		textView.setTextSize(12 * LayoutManager.fontScale);
		textView.setText(R.string.EditPhotoHint);
		layout.addView(textView, rParams);
		
		scrollView.setVisibility(View.GONE);
		//==EOF 這裡放物品的說明，且預設為不顯示
		
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		lLayout = new LinearLayout(context);
		lLayout.setId(BottomMenuButtonLayout);
		lLayout.setBackgroundResource(R.drawable.menubar_line);
		lLayout.setOrientation(LinearLayout.HORIZONTAL);
		lLayout.setWeightSum(2);
		baseLayout.addView(lLayout, rParams);
		
		for (int i = 0; i < 2; ++i) {
			lParams = new LinearLayout.LayoutParams((int)(ConstantTerm.resolution.x / lLayout.getWeightSum()), (int)(72 * LayoutManager.scale), 1);
			lParams.gravity = Gravity.CENTER;
			imageView = new ImageView(context);
			imageView.setId(i == 0 ? BottomMenuButton_AddWardrobe : BottomMenuButton_AddWishlist);
			imageView.setImageResource(i == 0 ? R.drawable.icon_addwardrobe72 : R.drawable.icon_addlist72);
			lLayout.addView(imageView, lParams);
		}
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	//滾輪picker的view
	public static RelativeLayout getWheelView(Context context) {
		
		RelativeLayout pickerLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		LinearLayout wheelLayout = new LinearLayout(context);
		LinearLayout.LayoutParams lParams = null;
		pickerLayout.setId(LayoutManager.ItemDetailPickerView);
		pickerLayout.setBackgroundColor(Color.rgb(51, 51, 51));
		
		//選擇分類 text		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		rParams.setMargins((int)(20 * LayoutManager.scale), (int)(15 * LayoutManager.scale), 0, 0);
		TextView textView = new TextView(context);
		textView.setText("選擇分類");
		textView.setTextSize(23 * LayoutManager.fontScale);
		textView.setTextColor(Color.rgb(51, 210, 210));
		pickerLayout.addView(textView,rParams);
		
		//完成button
		rParams = new RelativeLayout.LayoutParams((int)(140 * LayoutManager.scale), (int)(50 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		rParams.setMargins(0, (int)(15 * LayoutManager.scale), (int)(20 * LayoutManager.scale), 0);
		textView = new TextView(context);
		textView.setText("完成");
		textView.setId(LayoutManager.ItemDetailPickerSave);
		textView.setTextSize(16 * LayoutManager.fontScale);
		textView.setTextColor(Color.WHITE);
		textView.setGravity(Gravity.CENTER);
		textView.setBackgroundResource(R.drawable.btn_done);
		pickerLayout.addView(textView,rParams);
		
		//滾輪picker
		lParams = new LinearLayout.LayoutParams((int)(220 * LayoutManager.scale), (int)(330 * LayoutManager.scale));
		WheelView wv = new WheelView(context);
		WheelView wv2 = new WheelView(context);
		wv.setId(LayoutManager.ItemDetailWheel1);
		wv2.setId(LayoutManager.ItemDetailWheel2);
		wheelLayout.addView(wv,lParams);
		wheelLayout.addView(wv2,lParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		rParams.addRule(RelativeLayout.BELOW,ItemDetailPickerSave);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		rParams.setMargins((int)(20 * LayoutManager.scale), (int)(15 * LayoutManager.scale), 0, (int)(20 * LayoutManager.scale));
		pickerLayout.addView(wheelLayout,rParams);		
		
		return pickerLayout;
	}
	
	/**
	 * ItemDetailActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getItemDetailLayout(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout rLayout = null;
		RelativeLayout.LayoutParams rParams = null;
		LinearLayout lLayout = null;
		LinearLayout.LayoutParams lParams = null;
		ScrollView scrollView = null;
		ImageView imageView = null;
		TextView textView = null;
		AutoCompleteTextView acTextView = null;
		EditText editText = null;
		SwitchButton switchButton = null;
		RadioGroup radioGroup = null;
		RadioButton radioButton = null;
		
		baseLayout.setFocusable(true);
		baseLayout.setFocusableInTouchMode(true);
		baseLayout.setBackgroundColor(Color.WHITE);
		baseLayout.setId(ItemDetailbaseLayout);	
		// 物件圖片
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(310 * LayoutManager.scale));
		imageView = new ImageView(context);
		imageView.setId(ItemDetailPhoto);
		imageView.setAdjustViewBounds(true);
		//imageView.setImageResource(R.drawable.dress_big);
		imageView.setScaleType(ScaleType.FIT_CENTER);
		baseLayout.addView(imageView, rParams);
		
		// 分隔線
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW, ItemDetailPhoto);
		imageView = new ImageView(context);
		imageView.setId(ItemLineDivid);
		imageView.setImageResource(R.drawable.line_item_divid);
		imageView.setScaleType(ScaleType.CENTER_CROP);
		baseLayout.addView(imageView, rParams);
		
		// 垂直捲動View
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW, ItemLineDivid);
		scrollView = new ScrollView(context);
		scrollView.setId(ItemDetailScrollView);
		baseLayout.addView(scrollView, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rLayout = new RelativeLayout(context);
		rLayout.setPadding((int)(23 * LayoutManager.scale), 0, (int)(18 * LayoutManager.scale), 0);
		scrollView.addView(rLayout, rParams);
		
		// 選擇分類標籤
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, (int)(60 * LayoutManager.scale));
		textView = new TextView(context);
		textView.setId(100);
		textView.setTextSize(18 * LayoutManager.fontScale);
		textView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		textView.setTextColor(Color.rgb(53, 214, 214));
		textView.setText("選擇分類");
		rLayout.addView(textView, rParams);
		
		//選擇分類TextView(點擊進入picker)
		rParams = new RelativeLayout.LayoutParams((int)(320 * LayoutManager.scale), (int)(36 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.RIGHT_OF, 100);
		rParams.addRule(RelativeLayout.ALIGN_TOP, 100);
		rParams.setMargins((int)(10 * LayoutManager.scale), (int)(12 * LayoutManager.scale), 0, 0);
		textView = new TextView(context);
		textView.setId(ItemDetailCategory);
		textView.setTextSize(17 * LayoutManager.fontScale);
		textView.setBackgroundResource(R.drawable.strip_underline);
		rLayout.addView(textView, rParams);
		
		// 品牌名稱標籤
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, (int)(60 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW, 100);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, 100);
		textView = new TextView(context);
		textView.setId(120);
		textView.setTextSize(18 * LayoutManager.fontScale);
		textView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		textView.setTextColor(Color.rgb(53, 214, 214));
		textView.setText("品牌名稱");
		rLayout.addView(textView, rParams);
		
		// 品牌名稱輸入框
		rParams = new RelativeLayout.LayoutParams((int)(320 * LayoutManager.scale), (int)(50 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.RIGHT_OF, 120);
		rParams.addRule(RelativeLayout.ALIGN_TOP, 120);
		rParams.setMargins(0, (int)(8 * LayoutManager.scale), 0, 0);
		acTextView = new AutoCompleteTextView(context);
		acTextView.setId(ItemDetailBrandCategory);
		acTextView.setSingleLine(true);
		acTextView.setTextSize(17 * LayoutManager.fontScale);		
		acTextView.setTextColor(Color.BLACK);
		acTextView.setBackgroundColor(Color.TRANSPARENT);
		acTextView.setHint("");
		rLayout.addView(acTextView, rParams);
		
		// 品牌名稱輸入的底線
		rParams = new RelativeLayout.LayoutParams((int)(320 * LayoutManager.scale), (int)(36 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_LEFT, ItemDetailCategory);
		rParams.addRule(RelativeLayout.ALIGN_BOTTOM, ItemDetailBrandCategory);
		rParams.setMargins(0, 0, 0, (int)(8 * LayoutManager.scale));
		imageView = new ImageView(context);
		imageView.setImageResource(R.drawable.strip_underline);
		rLayout.addView(imageView, rParams);
		
		
		// Facebook圖示
		/*
		rParams = new RelativeLayout.LayoutParams((int)(163 * scale), (int)(54 * scale));
		rParams.addRule(RelativeLayout.BELOW, 120);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, 120);
		imageView = new ImageView(context);
		imageView.setId(130);
		imageView.setImageResource(R.drawable.facebook);
		imageView.setAdjustViewBounds(true);
		imageView.setScaleType(ScaleType.CENTER_CROP);
		rLayout.addView(imageView, rParams);
		*/
		// 分享
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, (int)(60 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW, 120);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, 120);
		//rParams.addRule(RelativeLayout.ALIGN_TOP, 130);
		//rParams.addRule(RelativeLayout.RIGHT_OF, 130);
		//rParams.setMargins((int)(4 * scale), 0, 0, 0);
		textView = new TextView(context);
		textView.setId(140);
		textView.setTextSize(18 * LayoutManager.fontScale);
		textView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		//textView.setGravity(Gravity.LEFT | Gravity.BOTTOM);
		textView.setTextColor(Color.rgb(53, 214, 214));
		textView.setText("公開分享");
		rLayout.addView(textView, rParams);
		
		// Facebook開關
		rParams = new RelativeLayout.LayoutParams((int)(130 * LayoutManager.scale), (int)(35 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.addRule(RelativeLayout.ALIGN_TOP, 140);
		//rParams.addRule(RelativeLayout.ALIGN_TOP, 130);
		rParams.setMargins(0, (int)(13 * LayoutManager.scale), 0, 0);
		switchButton = new SwitchButton(context);
		switchButton.setId(FacebookSwitch);
		switchButton.setSwitchOnImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.on));
		switchButton.setSwitchOffImage(BitmapFactory.decodeResource(context.getResources(), R.drawable.off));
		rLayout.addView(switchButton, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.BELOW, 140);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, 140);
		//rParams.addRule(RelativeLayout.BELOW, 130);
		//rParams.addRule(RelativeLayout.ALIGN_LEFT, 130);
		radioGroup = new RadioGroup(context);
		radioGroup.setId(150);
		radioGroup.setOrientation(RadioGroup.HORIZONTAL);
		radioGroup.setWeightSum(2);
		rLayout.addView(radioGroup, rParams);
		
		// 放進我的衣櫃
		rParams = new RelativeLayout.LayoutParams((int)(217 * LayoutManager.scale), (int)(60 * LayoutManager.scale));
		radioButton = new RadioButton(context);
		radioButton.setId(ItemDetailPutIntoWardrobe);
		radioButton.setText(R.string.ItemPutInWardrobe);
		radioButton.setTextSize(18 * LayoutManager.fontScale);
		radioButton.setTextColor(Color.rgb(53, 214, 214));
		radioButton.setSelected(true);
		radioButton.setChecked(true);
		radioGroup.addView(radioButton, rParams);
		
		// 放進購物清單
		rParams = new RelativeLayout.LayoutParams((int)(217 * LayoutManager.scale), (int)(60 * LayoutManager.scale));
		radioButton = new RadioButton(context);
		radioButton.setId(ItemDetailPutIntoWishlist);
		radioButton.setText(R.string.ItemPutInWishlist);
		radioButton.setTextSize(18 * LayoutManager.fontScale);
		radioButton.setTextColor(Color.rgb(53, 214, 214));
		radioGroup.addView(radioButton, rParams);
		
		// 哪裡買的
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(60 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW, 150);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, 150);
		editText = new EditText(context);
		editText.setId(ItemDetailWhereYouBuy);
		editText.setSingleLine(false);
		editText.setTextSize(18 * LayoutManager.fontScale);
		editText.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
		editText.setTextColor(Color.BLACK);
		editText.setHint(R.string.ItemWhereBuy);
		editText.setInputType(InputType.TYPE_CLASS_TEXT);
		rLayout.addView(editText, rParams);
		
		// 連結標題
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(60 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW, ItemDetailWhereYouBuy);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, ItemDetailWhereYouBuy);
		editText = new EditText(context);
		editText.setId(ItemDetailTitle);
		editText.setTextSize(18 * LayoutManager.fontScale);
		editText.setGravity(Gravity.LEFT | Gravity.CENTER);
		editText.setTextColor(Color.BLACK);
		editText.setHint(R.string.ItemTitle);
		editText.setInputType(InputType.TYPE_CLASS_TEXT);
		rLayout.addView(editText, rParams);
		
		// 連結網址
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(60 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW, ItemDetailTitle);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, ItemDetailTitle);
		editText = new EditText(context);
		editText.setId(ItemDetailLink);
		editText.setTextSize(18 * LayoutManager.fontScale);
		editText.setGravity(Gravity.LEFT | Gravity.CENTER);
		editText.setTextColor(Color.BLACK);
		editText.setHint(context.getString(R.string.ItemLink) + " http://");
		editText.setInputType(InputType.TYPE_TEXT_VARIATION_URI);
		rLayout.addView(editText, rParams);
		
		// 物品說明
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(60 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.BELOW, ItemDetailLink);
		rParams.addRule(RelativeLayout.ALIGN_LEFT, ItemDetailLink);
		editText = new EditText(context);
		editText.setId(ItemDetailDescription);
		editText.setSingleLine(false);
		editText.setTextSize(18 * LayoutManager.fontScale);
		editText.setGravity(Gravity.LEFT | Gravity.CENTER);
		editText.setTextColor(Color.BLACK);
		editText.setHint(R.string.ItemDescript);
		editText.setInputType(InputType.TYPE_CLASS_TEXT);
		rLayout.addView(editText, rParams);
		
		// 按鈕選單底圖
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		rParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		lLayout = new LinearLayout(context);
		lLayout.setId(BottomMenuButtonLayout);
		//lLayout.setBackgroundColor(Color.argb(127, 0, 0, 0));
		lLayout.setBackgroundResource(R.drawable.menubar_line);
		lLayout.setOrientation(LinearLayout.HORIZONTAL);
		lLayout.setWeightSum(2);
		baseLayout.addView(lLayout, rParams);

		// 按鈕(儲存/取消)
		for (int i = 0; i < 2; ++i) {
			lParams = new LinearLayout.LayoutParams((int)(ConstantTerm.resolution.x / lLayout.getWeightSum()), (int)(72 * LayoutManager.scale), 1);
			lParams.gravity = Gravity.CENTER;
			StatusButton button = new StatusButton(context);
			button.setId(BottomMenuButton_Save - i);
			button.setIcon(i == 1 ? R.drawable.icon_cancel : R.drawable.icon_save);
			lLayout.addView(button, lParams);
		}

		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	/**
	 * CalendarActicity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getCalendarLayout(Context context){
		final float scaleY = ConstantTerm.resolution.y / ConstantTerm.targetResolution.y;
		
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout.LayoutParams rParams = null;
		RelativeLayout rLayout = null;
		TextView textview = null;
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(60 * scaleY));
		rLayout = new RelativeLayout(context);
		rLayout.setId(CalendarView);
		rLayout.setBackgroundColor(Color.rgb(52, 52, 52));
		baseLayout.addView(rLayout, rParams);
		
		//Previous Button
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		rParams.addRule(RelativeLayout.CENTER_VERTICAL);
		rParams.setMargins((int)(10 * LayoutManager.scale), 0, 0, 0);
		ImageView arrowbutton = new ImageView(context);
		arrowbutton = new ImageView(context);
		arrowbutton.setId(CalendarButtonPrevious);
		arrowbutton.setImageResource(R.drawable.icon_arrowleft);
		rLayout.addView(arrowbutton, rParams);
		
		//Calendar Show Year & Mouth Title
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		textview = new TextView(context);
		textview.setId(CalendarTextTitle);
		textview.setTextSize(26 * LayoutManager.fontScale);
		textview.setTextColor(Color.WHITE);
		textview.setGravity(Gravity.CENTER);
		rLayout.addView(textview, rParams);
		
		//Next Button
		rParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rParams.addRule(RelativeLayout.CENTER_VERTICAL);
		rParams.setMargins(0, 0, (int)(10 * LayoutManager.scale), 0);
		arrowbutton = new ImageView(context);
		arrowbutton.setId(CalendarButtonNext);
		arrowbutton.setScaleType(ScaleType.CENTER);
		arrowbutton.setImageResource(R.drawable.icon_arrowright);
		rLayout.addView(arrowbutton, rParams);
		
		rParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		rParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		rParams.addRule(RelativeLayout.BELOW, CalendarView);
		rLayout = new RelativeLayout(context);
		rLayout.setPadding((int)(3 * LayoutManager.scale), 0, (int)(3 * LayoutManager.scale), 0);
		rLayout.setId(CalendarDateView);
		baseLayout.addView(rLayout, rParams);
		
		LayoutManagerHelper.generalButtomMenu(context, baseLayout);
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		baseLayout.setBackgroundColor(Color.rgb(141, 141, 141));
		return baseLayout;
		
	}
	
	/**
	 * CoverEditItemActivity的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getCoverEditLayout(Context context) {
		RelativeLayout baseLayout = new RelativeLayout(context);
		RelativeLayout layout = null;
		RelativeLayout.LayoutParams params = null;
		ImageView imageView = null;
		
		params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(360 * LayoutManager.scale));
		layout = new RelativeLayout(context);
		layout.setBackgroundColor(Color.WHITE);
		layout.setId(1000);
		baseLayout.addView(layout, params);
		
		//Cover圖
		params = new RelativeLayout.LayoutParams((int)(225 * LayoutManager.scale), (int)(340 * LayoutManager.scale));
		params.setMargins(0, (int)(10 * LayoutManager.scale), 0, (int)(10 * LayoutManager.scale));
		params.addRule(RelativeLayout.ALIGN_TOP);
		params.addRule(RelativeLayout.CENTER_HORIZONTAL);
		imageView = new ImageView(context);
		imageView.setId(CoverEditPhoto);
		imageView.setScaleType(ScaleType.FIT_CENTER);
		//imageView.setImageResource(R.drawable.street_noback);
		layout.addView(imageView, params);
		
		//分格線
		params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(8 * LayoutManager.scale));
		params.addRule(RelativeLayout.BELOW, 1000);
		imageView = new ImageView(context);
		imageView.setId(ItemLineDivid);
		imageView.setImageResource(R.drawable.line_item_divid);
		baseLayout.addView(imageView, params);
		
		params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(69 * LayoutManager.scale));
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params.setMargins(0, 0, 0, (int)(9 * LayoutManager.scale));
		RelativeLayout rlayout = new RelativeLayout(context);
		rlayout.setBackgroundColor(Color.argb(150, 167, 167, 167));
		layout.addView(rlayout, params);
		
		params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		TextView textView = new TextView(context);
		textView.setTextColor(Color.WHITE);
		textView.setText(R.string.CoverDetailHint);
		textView.setGravity(Gravity.CENTER);
		rlayout.addView(textView, params);
		
		params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.BELOW, ItemLineDivid);
		params.setMargins(0, 0, 0, (int)(80 * LayoutManager.scale));
		ScrollView scrollView = new ScrollView(context);
		scrollView.setId(CoverEditView);
		baseLayout.addView(scrollView, params);
		
		// 按鈕選單底圖
		params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(80 * LayoutManager.scale));
		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		LinearLayout lLayout = new LinearLayout(context);
		lLayout.setId(BottomMenuButtonLayout);
		lLayout.setBackgroundResource(R.drawable.menubar_line);
		lLayout.setOrientation(LinearLayout.HORIZONTAL);
		lLayout.setWeightSum(2);
		baseLayout.addView(lLayout, params);

		// 按鈕(儲存/取消)
		for (int i = 0; i < 2; ++i) {
			LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams((int)(ConstantTerm.resolution.x / lLayout.getWeightSum()), (int)(72 * LayoutManager.scale), 1);
			lParams.gravity = Gravity.CENTER;
			StatusButton button = new StatusButton(context);
			button.setId(BottomMenuButton_Cancel + i);
			lLayout.addView(button, lParams);
		}
		
		return baseLayout;
	}
	
	/**
	 * Delete Popup Menu的Layout UI
	 * @param context
	 * @return
	 */
	public static RelativeLayout getDeleteDialogView(Context context) {
		RelativeLayout.LayoutParams params = null;
		RelativeLayout baseLayout = new RelativeLayout(context);
		baseLayout.setBackgroundColor(Color.rgb(35, 35, 35));
		baseLayout.setPadding((int)(15 * LayoutManager.scale), (int)(25 * LayoutManager.scale), (int)(15 * LayoutManager.scale), (int)(25 * LayoutManager.scale));
		
		params = new RelativeLayout.LayoutParams((int)(100 * LayoutManager.scale), (int)(150 * LayoutManager.scale));
		ImageView imageView = new ImageView(context);
		imageView.setId(DeleteViewPhoto);
		imageView.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.d01));
		baseLayout.addView(imageView, params);
		
		params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.RIGHT_OF, DeleteViewPhoto);
		params.setMargins((int)(15 * LayoutManager.scale), (int)(20 * LayoutManager.scale), 0, 0);
		TextView textView = new TextView(context);
		textView.setId(100002);
		textView.setTextSize(17 * LayoutManager.fontScale);
		textView.setTextColor(Color.rgb(52, 214, 214));
		textView.setText("您確定要刪除這項單品?");
		baseLayout.addView(textView, params);
		
		params = new RelativeLayout.LayoutParams((int)(130 * LayoutManager.scale), (int)(40 * LayoutManager.scale));
		params.addRule(RelativeLayout.RIGHT_OF, DeleteViewPhoto);
		params.setMargins((int)(15 * LayoutManager.scale), (int)(90 * LayoutManager.scale), 0, 0);
		Button button = new Button(context);
		button.setId(DeleteViewButtonCancel);
		button.setPadding(0, 0, 0, 0);
		button.setBackgroundResource(R.drawable.dialogue_btn_cancel);
		button.setTextSize(12 * LayoutManager.fontScale);
		button.setTextColor(Color.WHITE);
		button.setText("Cancel");
		baseLayout.addView(button, params);
		
		params = new RelativeLayout.LayoutParams((int)(130 * LayoutManager.scale), (int)(40 * LayoutManager.scale));
		params.addRule(RelativeLayout.RIGHT_OF, DeleteViewButtonCancel);
		params.setMargins((int)(15 * LayoutManager.scale), (int)(90 * LayoutManager.scale), 0, 0);
		button = new Button(context);
		button.setId(DeleteViewButtonOK);
		button.setPadding(0, 0, 0, 0);
		button.setTextSize(12 * LayoutManager.fontScale);
		button.setTextColor(Color.WHITE);
		button.setBackgroundResource(R.drawable.dialogue_btn_ok);
		button.setText("OK");
		baseLayout.addView(button, params);
		
		return baseLayout;
	}
	
	/**
	 * Event Look WEBview 的Layout UI
	 * @param context
	 * @return
	 */
	@SuppressLint("SetJavaScriptEnabled")
	public static RelativeLayout getEventLookView(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout.LayoutParams params = null;
		RelativeLayout baseLayout = new RelativeLayout(context);
		
		params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		params.setMargins(0, 0, 0, 0);
		
		WebView webView = new WebView(context);
	    WebSettings websettings = webView.getSettings();
	    websettings.setJavaScriptEnabled(true); 
	    websettings.setAllowFileAccess(true);
	    websettings.setPluginState(PluginState.ON);
	    webView.setWebViewClient(new WebViewClient());  	
	    webView.setWebChromeClient(new WebChromeClient());
		webView.setId(EventWebView);		
		baseLayout.addView(webView, params);
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
	
	
	/**
	 * SubListActivity的Layout
	 * 顯示子分類清單的頁面
	 */	
	public static RelativeLayout getSubListView(Context context) {
		LayoutManagerHelper.setupActionBar(context);
		
		RelativeLayout.LayoutParams params = null;
		RelativeLayout baseLayout = new RelativeLayout(context);
		
		//title bar
		params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(67 * LayoutManager.scale));		
		params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(R.drawable.strip_subtitle);	
		imageView.setScaleType(ScaleType.FIT_XY);
		imageView.setId(6666);
		baseLayout.addView(imageView, params);
		
		//返回箭頭				
		params = new RelativeLayout.LayoutParams((int)(42 * LayoutManager.scale), (int)(42 * LayoutManager.scale));		
		params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		params.setMargins((int)(20 * LayoutManager.scale), (int)(12 * LayoutManager.scale), 0, 0);
		imageView = new ImageView(context);
		imageView.setImageResource(R.drawable.previous_w42);
		imageView.setId(SubListPrevious);
		baseLayout.addView(imageView, params);
		
		//title text
		params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT ,LayoutParams.WRAP_CONTENT);		
		params.addRule(RelativeLayout.RIGHT_OF,SubListPrevious);
		params.addRule(RelativeLayout.ALIGN_TOP,SubListPrevious);
		params.addRule(RelativeLayout.CENTER_HORIZONTAL);
		params.setMargins((int)(110 * LayoutManager.scale), 0, 0, 0);
		TextView textView = new TextView(context);
		textView.setTextSize(23 * LayoutManager.fontScale);
		textView.setTextColor(Color.BLACK);
		textView.setId(SubListTitleText);
		baseLayout.addView(textView, params);
		
		//ScrollView
		params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);		
		params.addRule(RelativeLayout.BELOW,6666);
		ScrollView sView = new ScrollView(context);
		sView.setId(SubListScrollView);
		baseLayout.addView(sView, params);
		
		
		// 被加入衣櫃後的Layout畫面
		params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		RelativeLayout childLayout = new RelativeLayout(context);
		childLayout.setId(SubListItemView);
		childLayout.setBackgroundColor(Color.BLACK);
		childLayout.setClickable(true);
		childLayout.setVisibility(View.GONE);
		baseLayout.addView(childLayout, params);
		
		// item Photo
		params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		imageView = new ImageView(context);
		imageView.setId(SubListItemPhoto);
		//imageView.setImageResource(R.drawable.d01);
		imageView.setScaleType(ScaleType.FIT_CENTER);
		childLayout.addView(imageView, params);
		
		// 狀態條
		RelativeLayout rlayout = new RelativeLayout(context);
		rlayout.setBackgroundColor(Color.rgb(92, 92, 92));
		params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(100 * LayoutManager.scale));
		params.addRule(RelativeLayout.ALIGN_BOTTOM, SubListItemPhoto);
		childLayout.addView(rlayout, params);

		// 文字訊息
		params = new RelativeLayout.LayoutParams((int)(295 * LayoutManager.scale), (int)(42 * LayoutManager.scale));
		params.setMargins((int)(10 * LayoutManager.scale), (int)(30 * LayoutManager.scale), 0, 0);
		textView = new TextView(context);
		textView.setId(20000);
		textView.setTextColor(Color.rgb(50, 228, 232));
		textView.setTextSize(20 * LayoutManager.fontScale);
		textView.setText("此單品已經加入衣櫃");
		textView.setGravity(Gravity.CENTER);
		rlayout.addView(textView, params);
		
		// 確認按鈕
		params = new RelativeLayout.LayoutParams((int)(150 * LayoutManager.scale), (int)(42 * LayoutManager.scale));
		params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		params.setMargins(0, (int)(30 * LayoutManager.scale), (int)(10 * LayoutManager.scale), 0);
		Button itemButton = new Button(context);
		itemButton.setId(SubListItemButton);
		itemButton.setBackgroundResource(R.drawable.btn_01);
		itemButton.setText("OK");
		itemButton.setPadding(0, 0, 0, 0);
		itemButton.setTextColor(Color.WHITE);
		
		rlayout.addView(itemButton, params);
		// EOF 被加入衣櫃後的Layout畫面
		
		LayoutManagerHelper.baseLayoutSetting(baseLayout);
		return baseLayout;
	}
}
