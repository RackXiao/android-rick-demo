package com.otiga.dress.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.facebook.Session;
import com.otiga.dress.data.ConstantTerm;
import com.otiga.dress.data.handler.DressbookAPI;
import com.otiga.dress.layout.LayoutManager;
import com.otiga.dress.layout.LayoutManagerHelper;
import com.otiga.dress.layout.component.StatusButton;
import com.otiga.dressbook.CalendarActivity;
import com.otiga.dressbook.CaptureActivity;
import com.otiga.dressbook.FollowingActivity;
import com.otiga.dressbook.MainActivity;
import com.otiga.dressbook.ProfileActivity;
import com.otiga.dressbook.R;
import com.otiga.dressbook.WardrobeActivity;
import com.otiga.dressbook.WelcomeActivity;

/**
 * 重覆使用及重覆設定的功能都會集中在此
 * @author Rick
 *
 */
public class UtilsCommonInit {
	
	/**
	 * 通用下方按鈕的功能設定
	 * @param activity
	 */
	public static void initButtonEvents(final Activity activity) {
		StatusButton button = null;

		button = (StatusButton) activity.findViewById(LayoutManager.BottomMenuButton_Following);
		button.setIcon((activity.getClass()!=FollowingActivity.class) ? R.drawable.icon_1_following : R.drawable.icon_1_following_bk);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(activity.getClass()!=FollowingActivity.class)
					moveActivityFromAtoB(activity,FollowingActivity.class);
			}
		});
		if(activity.getClass()!=FollowingActivity.class){
			DressbookAPI.singleton().getCoverListMyTrackingNewCount(ConstantTerm.act_user, -1, 100, new DressbookAPI.GetCoverListMyTrackingNewCountCallback() {
				@Override
				public void OnGetData(Exception exception, final int newCount) {
					activity.runOnUiThread(new Runnable() {
						@Override
						public void run() {
							StatusButton button = (StatusButton) activity.findViewById(LayoutManager.BottomMenuButton_Following);
							button.setStatusCount(newCount);
						}
					});
				}
			});
		}

		button = (StatusButton) activity.findViewById(LayoutManager.BottomMenuButton_Wardrobe);
		button.setIcon((activity.getClass()!=WardrobeActivity.class) ? R.drawable.icon_2_wardrobe : R.drawable.icon_2_wardrobe_bk);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(activity.getClass()!=WardrobeActivity.class)
					moveActivityFromAtoB(activity,WardrobeActivity.class);
			}
		});

		button = (StatusButton) activity.findViewById(LayoutManager.BottomMenuButton_Camera);
		button.setIcon((activity.getClass()!=CaptureActivity.class) ? R.drawable.icon_3_camera : R.drawable.icon_3_camera_bk);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(activity.getClass()!=CaptureActivity.class){
					Intent intent = new Intent(activity, CaptureActivity.class);
					activity.startActivityForResult(intent, CaptureActivity.REQUEST_CAPTURE);
				}
			}
		});

		button = (StatusButton) activity.findViewById(LayoutManager.BottomMenuButton_Calendar);
		button.setIcon((activity.getClass()!=CalendarActivity.class) ? R.drawable.icon_4_calendar : R.drawable.icon_4_calendar_bk);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(activity.getClass()!=CalendarActivity.class)
					moveActivityFromAtoB(activity,CalendarActivity.class);
			}
		});

		button = (StatusButton) activity.findViewById(LayoutManager.BottomMenuButton_Profile);
		button.setIcon((activity.getClass()!=ProfileActivity.class) ? R.drawable.icon_5_profile : R.drawable.icon_5_profile_bk);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(activity.getClass()!=ProfileActivity.class)
					moveActivityFromAtoB(activity,ProfileActivity.class);
			}
		});
	}
	
	private static void moveActivityFromAtoB(Activity A,Class<?> B){
		Intent intent = new Intent(A, B);
		A.startActivity(intent);
		A.finish();
	}

	/**
	 * 通用的 ActionBar Menu 功能設定
	 * @param activity
	 * @param item
	 */
	public static void getMenu(final Activity activity, MenuItem item){
		Intent intent = null;
		switch (item.getItemId()) {
			case android.R.id.home:
				intent = new Intent(activity, MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				activity.startActivity(intent);
				activity.finish();
				break;
				
			case R.id.main_menu_1:
				Intent i = new Intent(android.content.Intent.ACTION_SEND);
				i.setType("text/plain");
				String[] address = {activity.getString(R.string.email)};
				i.putExtra(android.content.Intent.EXTRA_EMAIL, address);
				i.putExtra(android.content.Intent.EXTRA_SUBJECT, activity.getString(R.string.feedbackTitle));
				i.putExtra(android.content.Intent.EXTRA_TEXT, activity.getString(R.string.feedbackContent));
				activity.startActivityForResult((Intent.createChooser(i,"Email")),1);
				break;
				
			case R.id.main_menu_2:
				ConstantTerm.isFBLogin = false;
				
				if (Session.getActiveSession() != null) {
					Session.getActiveSession().closeAndClearTokenInformation();
				}
				
				intent = new Intent(activity, WelcomeActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				activity.startActivity(intent);
				activity.finish();
				break;
				
			case R.id.main_menu_3:
				ActivityStackControlUtil.finishProgram();
				break;
		}
	}
	
	/**
	 * 取得帶有 Tab 功能的 ActionBar
	 * @param activity
	 * @return
	 */
	public static ActionBar getTabActionBar(Activity activity){
		ActionBar actionBar = activity.getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		if(activity.getClass()!=MainActivity.class)
			actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(LayoutManagerHelper.getActionBarLayout(activity));
		return actionBar;
	}
}
