package com.otiga.dress.data;

import java.util.ArrayList;
import java.util.List;
import com.facebook.android.Facebook;
import com.otiga.dress.data.vo.CoverInfoData;
import com.otiga.dress.data.vo.DailyTipsInfoData;

import android.app.Application;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;

public class ConstantTerm extends Application {

	//Global cache
	public static List<CoverInfoData> edit_list;
	public static int edit_totalcount;
	public static List<CoverInfoData> hotlook_list;
	public static int hotlook_totalcount;
	public static DailyTipsInfoData dailyTipsInfo;
	//Global record API:getBroadcastMessage 's message id
	public static List<Integer> msgidList = new ArrayList<Integer>();
	// Global Values
	public static Point resolution;
	public static DisplayMetrics displayMetrics;

	public static boolean IS_TEST_ENV;
	public static String API_PATH;
	public static String IMAGE_SERVER_PATH;
	
	public static String act_user;
	public static String userId;
	public static String userName = null;
	public static String FBaccessToken = null;
	public static boolean isFBLogin = false;
	public static String insFormUser;

	public static Facebook facebook;
	//穿搭日曆中紀錄當前已選擇的View的data.id 與分類id
	public static List<Integer> selectItemList = new ArrayList<Integer>();
	public static List<Integer> selectItemCategoryList = new ArrayList<Integer>();
	// Constant Values
	public static final PointF targetResolution = new PointF(480, 800);
	public static final int NumPerPageMainList = 50;
	
	public static final String FILE_CATEGORY = "file_category";
	public static final String FILE_BRAND = "file_brand";
	
	public static final String USERID = "User_id";
	public static final String DailyDate = "DailyDate";
	public static final String CalendarInfo = "CalendarInfo";
	public static final String COVERID = "Cover_id";
	public static final String ItemID = "Item_id";
	public static final String CoverInfo = "CoverInfoData";
	public static final String CoverEditItem = "CoverEditItem";
	public static final String CoverImage = "CoverImage";
	public static final String CoverImagePath = "CoverImagePath";
	public static final String PhotoFilePath = "ExtraPhotoPath";
	public static final String ImagePath = "ImagePath";
	public static final String CoverItemData = "CoverItemData";
	public static final String WardrobeInfoData = "WardrobeInfoData";
	public static final String ItemDetailPhoto = "ItemDetailPhoto";
	public static final String AddItemWardrobe = "AddItemWardrobe";
	public static final String CaptureSuccess = "CaptureSuccess";
	public static final String EventLookURL = "EventLookURL";
	public static final String UserListMode = "UserListMode";
	public static final String ListCoverItemData = "ListCoverItemData";
	
	public static final String SETTING_PREF = "setting_pref";
	public static final String isTermAccept = "isTermAccept";
	public static final String UPDATE_PREF = "update_pref";
	public static final String UPDATE_TIME = "update_time";
	public static final String isPassNavigation = "isPassNavigation";

	public static final String FromPage = "FromPage";	//從哪頁而來(GA統計用)
	public static final String InsStatsFromPage = "InsStatsFromPage";	//從哪頁而來(自製統計用)
}
