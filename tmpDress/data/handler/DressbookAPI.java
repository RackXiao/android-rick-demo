package com.otiga.dress.data.handler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.otiga.dress.data.ConstantTerm;
import com.otiga.dress.data.vo.BrandData;
import com.otiga.dress.data.vo.CalendarInfoData;
import com.otiga.dress.data.vo.CategoryData;
import com.otiga.dress.data.vo.CategoryListItemData;
import com.otiga.dress.data.vo.CoverCommentData;
import com.otiga.dress.data.vo.CoverInfoData;
import com.otiga.dress.data.vo.CoverItemData;
import com.otiga.dress.data.vo.DailyTipsInfoData;
import com.otiga.dress.data.vo.FBFriendData;
import com.otiga.dress.data.vo.ProfileData;
import com.otiga.dress.data.vo.TrackingData;
import com.otiga.dress.data.vo.UserLoginData;
import com.otiga.dress.data.vo.UserProfileData;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;


public class DressbookAPI {

	public interface ElleApiCallback {
		
	};
	
	public interface GetBroadcastMessageCallback {
		void OnResult(Exception exception, int isShow, String Message , int Msgid);
	};
	
	public interface GetListElleGirlCallback {
		void OnGetData(Exception exception, List<CoverInfoData> list, int totalCount);
	};
	
	public interface GetListMyElleCallback {
		void OnGetData(Exception exception, List<CoverInfoData> list, int totalCount);
	};
	
	public interface GetCoverListMyTrackingNewCountCallback {
		void OnGetData(Exception exception, int newCount);
	};
	
	public interface GetCoverListMyTrackingCallback {
		void OnGetData(Exception exception, List<CoverInfoData> list, int totalCount);
	};
	
	public interface updateMyTrackingTimerCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface GetCoverItemCallback {
		void OnGetData(Exception exception, List<CoverItemData> list);
	};
	
	public interface GetCoverCommentCallback {
		void OnGetData(Exception exception, List<CoverCommentData> list);
	};

	public interface SaveCommentCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface DeleteCommentCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface LikeCoverCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface DislikeCoverCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface DeleteCoverCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface SpamCoverCallback {
		void OnResult(Exception exception, String spamNumber);
	};
	
	public interface SpamItemCallback {
		void OnResult(Exception exception, String spamNumber);
	};
	
	public interface FbDataRetrieverCallback {
		void OnResult(Exception exception, UserLoginData userLoginData);
	};
	
	public interface InsStatsViewCoverListCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface InsStatsViewCoverCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface InsStatsClickCoverListCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface InsStatsClickCoverCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface InsStatsClickItemCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface InsStatsClickItemLinkCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
//	public interface InsStatsClickTabCallback {
//		void OnResult(Exception exception, int returnCode);
//	};
	
	public interface SaveItemCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface GetDailyTipsCallback {
		void OnGetData(Exception exception, DailyTipsInfoData dailyTipsInfo);
	};
	
	public interface GetWardrobeCallback {
		void OnGetData(Exception exception, ConcurrentHashMap<String, List<CoverItemData>> map);
	};
	
	public interface GetWishListCallback {
		void OnGetData(Exception exception, ConcurrentHashMap<String, List<CoverItemData>> map);
	};
	
	public interface DeleteItemCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface SaveCalendarCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface GetCalendarCallback {
		void OnGetData(Exception exception, ConcurrentHashMap<String, ConcurrentHashMap<String, List<CalendarInfoData>>> calendarList);
	};
	
	public interface DeleteCalendarCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface GetListItemByCategoryCallback {
		void OnGetData(Exception exception, List<CategoryListItemData> listData);
	};
	
	public interface SaveCoverCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface SaveCoverItemCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface DeleteCoverItemCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface SaveProfileCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface GetProfileCallback {
		void OnGetData(Exception exception, UserProfileData profileData);
	};
	
	public interface EnableFbCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface SaveBookmarkCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface GetBookmarkCallback {
		void OnGetData(Exception exception, ConcurrentHashMap<String, List<CoverInfoData>> bookmarkMap);
	};
	
	public interface GetTrackingCallback {
		void OnGetData(Exception exception, TrackingData trackingData);
	};
	
	public interface GetFbFriendCallback {
		void OnGetData(Exception exception, FBFriendData fbFriendData);
	};
	
	public interface FollowUserCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface GetOneUserCallback {
		void OnGetData(Exception exception, ProfileData profileData);
	};
	
	public interface SetGCMInfoCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface SetBindGCMCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface SetPushCountCallback {
		void OnResult(Exception exception, int returnCode);
	};
	
	public interface GetCategoryCallback {
		void OnGetData(Exception exception, List<CategoryData> list);
	};
	
	public interface GetBrandCallback {
		void OnGetData(Exception exception, List<BrandData> list);
	};
	
	private static DressbookAPI sharedInstance;
	
	public static DressbookAPI singleton() {
		if (sharedInstance == null)
			sharedInstance = new DressbookAPI();
		return sharedInstance;
	}
	
	/**
	 * 取得伺服器狀態公告
	 * @param callback
	 */
	public void getBroadcastMessage(final GetBroadcastMessageCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getBroadcastMessage", ConstantTerm.API_PATH));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());					
						JSONObject jsonObject = new JSONObject(jsonString);
						
						if(jsonObject.has("isShow") && jsonObject.has("msg") && jsonObject.has("msgid") ){
							if (callback != null)
								callback.OnResult(null, Integer.valueOf(jsonObject.getString("isShow")),jsonObject.getString("msg"),Integer.valueOf(jsonObject.getString("msgid")));
						}
						
					} else {
						callback.OnResult(new Exception(), 1, "網路連線出現問題",0);
					}
				} catch (Exception e) {
					e.printStackTrace();
					if (callback != null)
						callback.OnResult(e, 0, "Catch Exception",0);
				}
			}
		},"getBroadcastMessageThread").start();
	}

	
	/**
	 * 由 accessToken 取得 User_id
	 * @param accessToken facebook登入後的accessToken
	 * @param callback -2 (後台ban掉), -1 (FB認證失敗), User.id
	 */
	public void fbDataRetriever(final String accessToken, final FbDataRetrieverCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/fbDataRetriever/%s", ConstantTerm.API_PATH, accessToken));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());

						JSONObject jsonObject = new JSONObject(jsonString);
						UserLoginData userLoginData = new UserLoginData();
						userLoginData.setParams(jsonObject);

						if (callback != null)
							callback.OnResult(null, userLoginData);
					} else {
						callback.OnResult(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, null);
				}
			}
		},"fbDataRetrieverThread").start();
	}
	
	/**
	 * 取得ELLEGirl頁所需的資料 
	 * @param act_user 使用app的人
	 * @param page 從第幾頁開始 -1(取全部)
	 * @param num 取得幾筆資料
	 * @param callback List{CoverInfoData}
	 */
	public void getListElleGirl(final String act_user, final int page, final int num, final GetListElleGirlCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getListElleGirl/%s/%d/%d", ConstantTerm.API_PATH, act_user, page, num));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						List<CoverInfoData> listData = new ArrayList<CoverInfoData>();
						List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) map.get("data");
						for (ConcurrentHashMap<String, Object> data : list) {
							CoverInfoData elleData = new CoverInfoData();
							elleData.setParams(data);
							listData.add(elleData);
						}
						
						if (callback != null)
							callback.OnGetData(null, listData, Integer.valueOf((String) map.get("total")));
					} else {
						callback.OnGetData(new Exception(), null, 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null, 0);
				}
			}
		},"getListElleGirlThread").start();
		
	}
	
	/**
	 * 取得MyELLE頁所需的資料
	 * @param act_user 使用app的人
	 * @param page 從第幾頁開始 -1(取全部)
	 * @param num 取得幾筆資料
	 * @param callback List{CoverInfoData}
	 */
	public void getListMyElle(final String act_user, final int page, final int num, final GetListMyElleCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getListMyElle/%s/%d/%d", ConstantTerm.API_PATH, act_user, page, num));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						List<CoverInfoData> listData = new ArrayList<CoverInfoData>();
						List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) map.get("data");
						for (ConcurrentHashMap<String, Object> data : list) {
							CoverInfoData elleData = new CoverInfoData();
							elleData.setParams(data);
							listData.add(elleData);
						}
						
						if (callback != null)
							callback.OnGetData(null, listData, Integer.valueOf((String) map.get("total")));
					} else {
						callback.OnGetData(new Exception(), null, 0);
					}
				} catch (Exception e) {
					e.printStackTrace();
					if (callback != null)
						callback.OnGetData(e, null, 0);
				}
			}
		},"getListMyElleThread").start();
	}
	
	/**
	 * 取得追?的好友的Cover數量
	 * @param act_user 使用app的人
	 * @param page 從第幾頁開始 -1(取全部)
	 * @param num 取得幾筆資料
	 * @param callback int
	 */
	public void getCoverListMyTrackingNewCount(final String act_user, final int page, final int num, final GetCoverListMyTrackingNewCountCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getCoverListMyTracking/%s/%d/%d", ConstantTerm.API_PATH, act_user, page, num));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						int newCount =  Integer.valueOf(map.get("new").toString());
						
						if (callback != null)
							callback.OnGetData(null, newCount);	
					} else {
						callback.OnGetData(new Exception(), -1);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, -1);
				}
			}
		},"getCoverListMyTrackingThread").start();
	}
	
	/**
	 * 取得追?的好友的Cover數量
	 * @param act_user 使用app的人
	 * @param page 從第幾頁開始 -1(取全部)
	 * @param num 取得幾筆資料
	 * @param callback List{CoverInfoData}
	 */
	public void getCoverListMyTracking(final String act_user, final int page, final int num, final GetCoverListMyTrackingCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getCoverListMyTracking/%s/%d/%d", ConstantTerm.API_PATH, act_user, page, num));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						List<CoverInfoData> listData = new ArrayList<CoverInfoData>();
						List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) map.get("data");
						for (ConcurrentHashMap<String, Object> data : list) {
							CoverInfoData elleData = new CoverInfoData();
							elleData.setParams(data);
							listData.add(elleData);
						}
						
						if (callback != null)
							callback.OnGetData(null, listData, Integer.valueOf((String) map.get("total")));	
					} else {
						callback.OnGetData(new Exception(), null, 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null, 0);
				}
			}
		},"getCoverListMyTrackingThread").start();
	}
	
	/**
	 * 更新追?好友的Cover的時間
	 * @param act_user 使用app的人
	 * @param callback 0(失敗) 1(成功)
	 */
	public void updateMyTrackingTimer(final String act_user, final updateMyTrackingTimerCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/updateMyTrackingTimer/%s", ConstantTerm.API_PATH, act_user));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						@SuppressWarnings("unchecked")
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						//掛掉沒關係 
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"deleteCoverThread").start();
	}
	
	/**
	 * 取得單一個Cover的Item list
	 * @param act_user 使用app的人
	 * @param coverId Cover的id
	 * @param callback List{CoverItemData}
	 */
	public void getCoverItem(final String act_user, final int coverId, final GetCoverItemCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getCoverItem/%s/%d", ConstantTerm.API_PATH, act_user, coverId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						if (!jsonString.equals("[]")) {
							List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) JsonHandler.parseJson(jsonString);
							
							List<CoverItemData> listData = new ArrayList<CoverItemData>();
							for (ConcurrentHashMap<String, Object> data : list) {
								CoverItemData coverItemData = new CoverItemData();
								coverItemData.setParams(data);
								listData.add(coverItemData);
							}
							if (callback != null)
								callback.OnGetData(null, listData);
						} else {
							if (callback != null)
								callback.OnGetData(null, null);
						}
						
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getCoverItemThread").start();
	}
	
	
	/**
	 * 取得單一個cover的Comment list
	 * @param act_user 使用app的人
	 * @param coverId Cover的id
	 * @param callback List{CoverCommentData}
	 */
	public void getCoverComment(final String act_user, final int coverId, final GetCoverCommentCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getCoverComment/%s/%d", ConstantTerm.API_PATH, act_user, coverId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						
						//KC 使用android jsonObject
						List<CoverCommentData> listData = new ArrayList<CoverCommentData>();
						JSONArray jArray = new JSONArray(jsonString);
						for(int i = 0;i < jArray.length();i++){
							JSONObject jsonObject = (JSONObject)jArray.get(i);
							CoverCommentData comment = new CoverCommentData();
							comment.setParams(jsonObject);
							listData.add(comment);
						}
						//方塊夫的code
						/*List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) JsonHandler.parseJson(jsonString);
						List<CoverCommentData> listData = new ArrayList<CoverCommentData>();
						
						for (ConcurrentHashMap<String, Object> data : list) {
							CoverCommentData comment = new CoverCommentData();
							comment.setParams(data);
							listData.add(comment);
						}*/
						
						if (callback != null)
							callback.OnGetData(null, listData);
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getCoverCommentThread").start();
	}
	
	/**
	 * 儲存使用者輸入的comment 
	 * @param act_user 使用app的人
	 * @param id 評論的id, 無值為新增, 有值為修改
	 * @param coverId Cover的id
	 * @param userId User的id
	 * @param message Comment內容
	 * @param callback int 1 (輸入格式錯誤) Comment_id
	 */
	public void saveComment(final String act_user, final int id, final int coverId, final String userId, final String message, final SaveCommentCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/saveComment", ConstantTerm.API_PATH));
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("act_user", String.valueOf(act_user)));
					if (id != -1) params.add(new BasicNameValuePair("id", String.valueOf(id)));
					params.add(new BasicNameValuePair("Cover_id", String.valueOf(coverId)));
					params.add(new BasicNameValuePair("User_id", String.valueOf(userId)));
					params.add(new BasicNameValuePair("message", String.valueOf(message)));
					httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"saveCommentThread").start();
	}
	
	/**
	 * 刪除comment
	 * @param act_user
	 * @param Comment_id
	 * @param callback
	 */
	public void deleteComment(final String act_user, final int Comment_id, final DeleteCommentCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/deleteComment/%s/%s" ,ConstantTerm.API_PATH,act_user,Comment_id));		
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"deleteCommentThread").start();
	}
	
	/**
	 * 保存/解除 LikeCover
	 * @param userId 使用app的人
	 * @param coverId Cover的id
	 * @param callback -1 (解除LikeCover) 1 (LikeCover)
	 */
	public void likeCover(final String userId, final int coverId, final LikeCoverCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/likeCover/%s/%d", ConstantTerm.API_PATH, userId, coverId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"likeCoverThread").start();
	}
	
	/**
	 * 保存/解除 DislikeCover
	 * @param userId 使用app的人
	 * @param coverId Cover的id
	 * @param callback -1 (解除DislikeCover) 1 (DislikeCover)
	 */
	public void dislikeCover(final String userId, final int coverId, final DislikeCoverCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/dislikeCover/%s/%d", ConstantTerm.API_PATH, userId, coverId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"dislikeCoverThread").start();
	}
	
	/**
	 * 刪除Cover 及其關聯item
	 * @param act_user int 使用app的人
	 * @param coverId int Cover的id
	 * @param callback int 0 (無資料可刪除或失敗)
						   1 (成功)
	 */
	public void deleteCover(final String act_user, final int coverId, final DeleteCoverCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/deleteCover/%s/%d", ConstantTerm.API_PATH, act_user, coverId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"deleteCoverThread").start();
	}
	
	/**
	 * 檢舉Cover
	 * @param userId 使用app的人
	 * @param coverId Cover的id
	 * @param callback String 回傳Spam單號
	 */
	public void spamCover(final String userId, final int coverId, final SpamCoverCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/spamCover/%s/%d", ConstantTerm.API_PATH, userId, coverId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, map.get("ret").toString());
					} else {
						callback.OnResult(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null) {
						callback.OnResult(e, null);
					}
				}
			}
		},"spamCoverThread").start();
	}
	
	/**
	 * 檢舉Item
	 * @param act_user 使用app的人
	 * @param coverId Cover的id
	 * @param callback String 回傳Spam單號
	 */
	public void spamItem(final String act_user, final int itemId, final SpamItemCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/spamItem/%s/%d", ConstantTerm.API_PATH, act_user, itemId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, map.get("ret").toString());
					} else {
						callback.OnResult(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null) {
						callback.OnResult(e, null);
					}
				}
			}
		},"spamCoverThread").start();
	}
	
	public void insStatsViewCoverList(final String userId, final List<Integer> coverIds, final String from, final InsStatsViewCoverListCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					JSONArray jsonArray = new JSONArray(coverIds);
					
					HttpPost httpRequest = new HttpPost(String.format("%s/insStatsViewCoverList", ConstantTerm.API_PATH));
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("User_id", String.valueOf(userId)));
					params.add(new BasicNameValuePair("Cover_id", jsonArray.toString()));
					params.add(new BasicNameValuePair("from", from));
					httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
					
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						//TODO 統計 API
						Log.i("insStats", "OK: ViewCoverList, userId: "+userId+", coverId: "+coverIds.toString()+", from: "+from);
					}
				} catch (Exception e) {
					Log.d("DEBUG", e.toString());
				}
			}
		},"insStatsViewCoverListThread").start();
	}
	
	public void insStatsViewCover(final String userId, final int coverId, final String from, final InsStatsViewCoverCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/insStatsViewCover/%s/%d/%s", ConstantTerm.API_PATH, userId, coverId, from));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						//TODO 統計 API
						Log.i("insStats", "OK: ViewCover, userId: "+userId+", coverId: "+coverId+", from: "+from);
					}
				} catch (Exception e) {
					Log.d("DEBUG", e.toString());
				}
			}
		},"insStatsViewCoverThread").start();
	}
	
	public void insStatsClickCoverList(final String userId, final int coverId, final String from, final InsStatsClickCoverListCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/insStatsClickCoverList/%s/%d/%s", ConstantTerm.API_PATH, userId, coverId, from));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						//TODO 統計 API
						Log.i("insStats", "OK: ClickCoverList, userId: "+userId+", coverId: "+coverId+", from: "+from);
					}
				} catch (Exception e) {
					Log.d("DEBUG", e.toString());
				}
			}
		},"insStatsClickCoverListThread").start();
	}
	
	public void insStatsClickCover(final String userId, final int coverId, final String from, final InsStatsClickCoverCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/insStatsClickCover/%s/%d/%s", ConstantTerm.API_PATH, userId, coverId, from));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						//TODO 統計 API
						Log.i("insStats", "OK: ClickCover, userId: "+userId+", coverId: "+coverId+", from: "+from);
					}
				} catch (Exception e) {
					Log.d("DEBUG", e.toString());
				}
			}
		},"insStatsClickCoverThread").start();
	}
	
	public void insStatsClickItem(final String userId, final int itemId, final String from, final InsStatsClickItemCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/insStatsClickItem/%s/%d/%s", ConstantTerm.API_PATH, userId, itemId, from));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						//TODO 統計 API
						Log.i("insStats", "OK: ClickItem, userId: "+userId+", itemId: "+itemId+", from: "+from);
					}
				} catch (Exception e) {
					Log.d("DEBUG", e.toString());
				}
			}
		},"insStatsClickItemThread").start();
	}
	
	public void insStatsClickItemLink(final String userId, final int itemId, final String from, final InsStatsClickItemLinkCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/insStatsClickItemLink/%s/%d/%s", ConstantTerm.API_PATH, userId, itemId, from));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						//TODO 統計 API
						Log.i("insStats", "OK: ClickItemLink, userId: "+userId+", itemId: "+itemId+", from: "+from);
					}
				} catch (Exception e) {
					Log.d("DEBUG", e.toString());
				}
			}
		},"insStatsClickItemLinkThread").start();
	}
	
//	public void insStatsClickTab(final String userId, final String tabName, final InsStatsClickTabCallback callback) {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					HttpPost httpRequest = new HttpPost(String.format("%s/insStatsClickTab/%s/%s", API_PATH, userId, tabName));
//					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
//					if (httpResponse.getStatusLine().getStatusCode() == 200) {
//						//TODO 統計 API
//					}
//				} catch (Exception e) {
//					Log.d("DEBUG", e.toString());
//				}
//			}
//		});
//		t.setName("insStatsClickTabThread");
//		t.start();
//	}
	
	
	/**
	 * 取得 Daily Tips 的資料
	 * @param act_user 使用app的人
	 * @param callback DailyTipsInfoData
	 */
	public void getDailyTips(final String act_user, final GetDailyTipsCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getDailyTips/%s", ConstantTerm.API_PATH, act_user));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						DailyTipsInfoData dailyTipsInfo = new DailyTipsInfoData();
						dailyTipsInfo.setParams(map);
						
						if (callback != null)
							callback.OnGetData(null, dailyTipsInfo);
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getDailyTipsThread").start();
	}
	
	/**
	 * 儲存單品
	 * @param id int 單品的id, -1為新增, 有值為修改
	 * @param type String 只填 "WishList" / "Wardrobe"
	 * @param userId String User的id
	 * @param brand String 品牌
	 * @param category int 分類的id，請查閱：常數一覽
	 * @param bitmap file(image:jpg) 圖片
	 * @param title String 標題
	 * @param link String Http連結
	 * @param whereYouBuy String 在哪裡買的
	 * @param description String 單品描述
	 * @param shared boolean 分享
	 * @param isOwner boolean 是否為擁有者
	 * @param copyFrom int 從哪個Item複製而來
	 * @param insFromUser String 追蹤第一個點擊到的User
	 * @param callback int -1(失敗),Item.id(成功)
	 */
	public void saveItem(final int id, final String type, final String userId, final String brand, final int category, final Bitmap bitmap, final String title, final String link, final String whereYouBuy, final String description, final boolean shared, final boolean isOwner, final int copyFrom, final String insFromUser, final SaveItemCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					ByteArrayOutputStream stream = new ByteArrayOutputStream();
					bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
					byte[] buffer = stream.toByteArray();
					
					String lineEnd = "\r\n";
					String twoHyphens = "--";
					String boundary = "RQdzAAihJq7Xp1kjraqf";
					
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					DataOutputStream dos = new DataOutputStream(baos);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"id\"" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes((id == -1 ? "" : String.valueOf(id)) + lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"type\"" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes(type + lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"User_id\"" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes(String.valueOf(userId) + lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"brand\"" + lineEnd);
					dos.writeBytes("Content-Type: application/octet-stream" + lineEnd);
					dos.writeBytes("Content-Transfer-Encoding: binary" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.write(brand.getBytes("UTF-8"));
					dos.writeBytes(lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"category\"" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes(String.valueOf(category) + lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"image\";filename=\"upload.jpg\"" + lineEnd);
					dos.writeBytes("Content-Type: application/octet-stream" + lineEnd);
					dos.writeBytes("Content-Transfer-Encoding: binary" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.write(buffer);
					dos.writeBytes(lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"title\"" + lineEnd);
					dos.writeBytes("Content-Type: application/octet-stream" + lineEnd);
					dos.writeBytes("Content-Transfer-Encoding: binary" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.write(title.getBytes("UTF-8"));
					dos.writeBytes(lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"link\"" + lineEnd);
					dos.writeBytes("Content-Type: application/octet-stream" + lineEnd);
					dos.writeBytes("Content-Transfer-Encoding: binary" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.write(link.getBytes("UTF-8"));
					dos.writeBytes(lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"where_u_buy\"" + lineEnd);
					dos.writeBytes("Content-Type: application/octet-stream" + lineEnd);
					dos.writeBytes("Content-Transfer-Encoding: binary" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.write(whereYouBuy.getBytes("UTF-8"));
					dos.writeBytes(lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"description\"" + lineEnd);
					dos.writeBytes("Content-Type: application/octet-stream" + lineEnd);
					dos.writeBytes("Content-Transfer-Encoding: binary" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.write(description.getBytes("UTF-8"));
					dos.writeBytes(lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"shared\"" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes((shared ? "1" : "0") + lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"is_owner\"" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes((isOwner ? "1" : "0") + lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"copy_from\"" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes((copyFrom == -1 ? "" : String.valueOf(copyFrom)) + lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"insFromUser\"" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes((insFromUser == null ? "" : String.valueOf(insFromUser)) + lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
					dos.flush();
					dos.close();
					
					ByteArrayInputStream content = new ByteArrayInputStream(baos.toByteArray());
					BasicHttpEntity entity = new BasicHttpEntity();
					entity.setContent(content);
					
					HttpPost httpRequest = new HttpPost(String.format("%s/saveItem", ConstantTerm.API_PATH));
					httpRequest.addHeader("Connection", "Keep-Alive");
					httpRequest.addHeader("Content-Type", "multipart/form-data; boundary="+boundary);
					httpRequest.setEntity(entity);
					
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"saveItemThread").start();
	}
	
	/**
	 * 取得使用者的 Wardrobe
	 * @param userId String 使用app的人
	 * @param type String "category"/"shared"，決定取出的資料組成方式
	 * @param callback List CoverItemData
	 */
	public void getWardrobe(final String userId, final String type, final GetWardrobeCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getWardrobe/%s/%s", ConstantTerm.API_PATH, userId, type));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						ConcurrentHashMap<String, List<CoverItemData>> categoryList = new ConcurrentHashMap<String, List<CoverItemData>>();
						for (String key : map.keySet()) {
							List<CoverItemData> wardrobeList = new ArrayList<CoverItemData>();
							ConcurrentHashMap<String, Object> category = (ConcurrentHashMap<String, Object>) map.get(key);
							List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) category.get("data");
							for (ConcurrentHashMap<String, Object> data : list) {
								CoverItemData wardrobeData = new CoverItemData();
								wardrobeData.setParams(data);
								wardrobeList.add(wardrobeData);
							}
							categoryList.put(key, wardrobeList);
						}
						
						if (callback != null)
							callback.OnGetData(null, categoryList);
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getWardrobeThread").start();
	}
	
	/**
	 * 取得使用者的 WishList
	 * @param userId String 使用app的人
	 * @param type String "category"/"shared"，決定取出的資料組成方式
	 * @param callback List CoverItemData
	 */
	public void getWishList(final String userId, final String type, final GetWishListCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getWishList/%s/%s", ConstantTerm.API_PATH, userId, type));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						ConcurrentHashMap<String, List<CoverItemData>> categoryList = new ConcurrentHashMap<String, List<CoverItemData>>();
						for (String key : map.keySet()) {
							List<CoverItemData> wardrobeList = new ArrayList<CoverItemData>();
							ConcurrentHashMap<String, Object> category = (ConcurrentHashMap<String, Object>) map.get(key);
							List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) category.get("data");
							for (ConcurrentHashMap<String, Object> data : list) {
								CoverItemData wardrobeData = new CoverItemData();
								wardrobeData.setParams(data);
								wardrobeList.add(wardrobeData);
							}
							categoryList.put(key, wardrobeList);
						}
						
						if (callback != null)
							callback.OnGetData(null, categoryList);
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getWishListThread").start();
	}
	
	/**
	 * 刪除 Item
	 * @param act_user String 使用app的人
	 * @param itemIds int Array 單品組成的array
	 * @param callback int -1(格式錯誤),0(刪除失敗或未刪除),n(刪除成功筆數)
	 */
	public void deleteItem(final String act_user, final List<Integer> itemIds, final DeleteItemCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					JSONArray jsonArray = new JSONArray(itemIds);
					
					HttpPost httpRequest = new HttpPost(String.format("%s/deleteItem", ConstantTerm.API_PATH));
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("act_user", String.valueOf(act_user)));
					params.add(new BasicNameValuePair("Item_id", jsonArray.toString()));
					httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
					
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"deleteItemThread").start();
	}
	
	/**
	 * 儲存 Calendar 單日的物品
	 * @param userId String 使用者的id
	 * @param date String 日期eg.2012-12-21
	 * @param itemIds List 單品id組成的List
	 * @param callback int -1 (輸入格式錯誤)
							0新增失敗或未新增(已有資料會新增失敗)
							n(新增成功筆數)
	 */
	public void saveCalendar(final String userId, final String date, final List<Integer> itemIds, final SaveCalendarCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					JSONArray jsonArray = new JSONArray(itemIds);
					
					HttpPost httpRequest = new HttpPost(String.format("%s/saveCalendar", ConstantTerm.API_PATH));
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("User_id", String.valueOf(userId)));
					params.add(new BasicNameValuePair("date", String.valueOf(date)));
					params.add(new BasicNameValuePair("Item_id", jsonArray.toString()));
					httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"saveCalendarThread").start();
	}
	
	/**
	 * 取得$yearmonth下，每一天的資料
	 * @param userId String 使用app的人
	 * @param yearmonth String 日期eg.201212
	 * @param callback CalendarInfoData
	 */
	public void getCalendar(final String userId, final String yearmonth, final GetCalendarCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getCalendar/%s/%s", ConstantTerm.API_PATH, userId, yearmonth));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						if (!jsonString.equals("[]")) {
							ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
							
							ConcurrentHashMap<String, ConcurrentHashMap<String, List<CalendarInfoData>>> calendarDatas = new ConcurrentHashMap<String, ConcurrentHashMap<String,List<CalendarInfoData>>>();
							for (String date : map.keySet()) {
								ConcurrentHashMap<String, List<CalendarInfoData>> dateInfo = new ConcurrentHashMap<String, List<CalendarInfoData>>();
								ConcurrentHashMap<String, Object> mapCategoryDetail = (ConcurrentHashMap<String, Object>)map.get(date);
								for (String category : mapCategoryDetail.keySet()) {
									List<CalendarInfoData> calendarList = new ArrayList<CalendarInfoData>();
									List<ConcurrentHashMap<String, Object>> mapCategoryList = (List<ConcurrentHashMap<String, Object>>) mapCategoryDetail.get(category);
									for (ConcurrentHashMap<String, Object> data : mapCategoryList) {
										CalendarInfoData calendarInfoData = new CalendarInfoData();
										calendarInfoData.setParams(data);
										calendarList.add(calendarInfoData);
									}
									dateInfo.put(category, calendarList);
								}
								calendarDatas.put(date, dateInfo);
							}
							if (callback != null)
								callback.OnGetData(null, calendarDatas);
						} else {
							if (callback != null)
								callback.OnGetData(null, null);
						}
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getCalendarThread").start();
	}
	
	
	/**
	 * 
	 * @param userId String 使用app的人
	 * @param itemIds List 單品id組成的List
	 * @param date String 日期eg.20121221
	 * @param callback int -1 (輸入格式錯誤)
							0刪除失敗或未刪除
							n(刪除成功筆數)
	 */
	public void deleteCalendar(final String userId, final List<Integer> itemIds, final String date, final DeleteCalendarCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					JSONArray jsonArray = new JSONArray(itemIds);
					
					HttpPost httpRequest = new HttpPost(String.format("%s/deleteCalendar", ConstantTerm.API_PATH));
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("act_user", String.valueOf(userId)));
					params.add(new BasicNameValuePair("Item_id", jsonArray.toString()));
					params.add(new BasicNameValuePair("date", String.valueOf(date)));

					httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"deleteCalendarThread").start();
	}
	
	/**
	 * 取得使用者某一分類的 Item
	 * @param userId String 使用app的人
	 * @param catePos int 請查閱 category：常數一覽
	 * @param callback List CategoryListItemData
	 */
	public void getListItemByCategory(final String userId, final int catePos, final GetListItemByCategoryCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getListItemByCategory/%s/%d", ConstantTerm.API_PATH, userId, catePos));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						List<ConcurrentHashMap<String, Object>> map = (List<ConcurrentHashMap<String, Object>>) JsonHandler.parseJson(jsonString);
						
						List<CategoryListItemData> categoryListItemData = new ArrayList<CategoryListItemData>();
						for (ConcurrentHashMap<String, Object> data : map) {
							CategoryListItemData itemData = new CategoryListItemData();
							itemData.setParams(data);
							categoryListItemData.add(itemData);
						}
						
						if (callback != null)
							callback.OnGetData(null, categoryListItemData);
					} else {
						//XXX no use?
//						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getListItemByCategoryThread").start();
	}
	
	
	/**
	 * 儲存Cover 
	 * @param id int Cover的id, -1為新增, 有值為修改
	 * @param userId String User的id
	 * @param bitmap file(image:jpg) 圖片
	 * @param priority int 優先權
	 * @param callback int -1 (輸入格式錯誤),Cover_id(成功)
	 */
	public void saveCover(final int id, final String userId, final Bitmap bitmap, final int priority, final SaveCoverCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					// Source from http://stackoverflow.com/questions/4989182/converting-java-bitmap-to-byte-array
					ByteArrayOutputStream stream = new ByteArrayOutputStream();
					bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
					byte[] buffer = stream.toByteArray();
					
					// Source from http://stackoverflow.com/questions/2938502/sending-post-data-in-android
					String lineEnd = "\r\n";
					String twoHyphens = "--";
					String boundary = "RQdzAAihJq7Xp1kjraqf";
					
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					DataOutputStream dos = new DataOutputStream(baos);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"id\"" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes((id == -1 ? "" : String.valueOf(id)) + lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"User_id\"" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes(String.valueOf(userId) + lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"image\";filename=\"upload.jpg\"" + lineEnd);
					dos.writeBytes("Content-Type: application/octet-stream" + lineEnd);
					dos.writeBytes("Content-Transfer-Encoding: binary" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.write(buffer);
					dos.writeBytes(lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"priority\"" + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes(String.valueOf(priority) + lineEnd);
					
					dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
					dos.flush();
					dos.close();
					
					ByteArrayInputStream content = new ByteArrayInputStream(baos.toByteArray());
					BasicHttpEntity entity = new BasicHttpEntity();
					entity.setContent(content);
					
					HttpPost httpRequest = new HttpPost(String.format("%s/saveCover", ConstantTerm.API_PATH));
					httpRequest.addHeader("Connection", "Keep-Alive");
					httpRequest.addHeader("Content-Type", "multipart/form-data; boundary="+boundary);
					httpRequest.setEntity(entity);
					
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"saveCoverThread").start();
	}
	
	/**
	 * 儲存CoverItem
	 * @param act_user String 使用app的人
	 * @param coverId int Cover的id
	 * @param itemIds List 單品id組成的List
	 * @param callback
	 */
	public void saveCoverItem(final String act_user, final int coverId, final List<Integer> itemIds, final SaveCoverItemCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					JSONArray jsonArray = new JSONArray(itemIds);
					
					HttpPost httpRequest = new HttpPost(String.format("%s/saveCoverItem", ConstantTerm.API_PATH));
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("act_user", String.valueOf(act_user)));
					params.add(new BasicNameValuePair("Cover_id", String.valueOf(coverId)));
					params.add(new BasicNameValuePair("Item_id", jsonArray.toString()));
					httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"saveCoverItemThread").start();
	}
	
	/**
	 * 刪除 $Cover_id 與 $Item_id 間的關聯
	 * @param act_user int 使用app的人
	 * @param coverId int Cover的id
	 * @param itemIds List 單品id組成的List
	 * @param callback int -1 (輸入格式錯誤)
							0刪除失敗或未刪除
							n(刪除成功筆數)
	 */
	public void deleteCoverItem(final String act_user, final int coverId, final List<Integer> itemIds, final DeleteCoverItemCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					JSONArray jsonArray = new JSONArray(itemIds);
					
					HttpPost httpRequest = new HttpPost(String.format("%s/deleteCoverItem", ConstantTerm.API_PATH));
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("act_user", String.valueOf(act_user)));
					params.add(new BasicNameValuePair("Cover_id", String.valueOf(coverId)));
					params.add(new BasicNameValuePair("Item_id", jsonArray.toString()));
					httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"deleteCoverItemThread").start();
	}
	
	/**
	 * 儲存 Profile
	 * @param id int User的id
	 * @param email String Email
	 * @param city String 城市
	 * @param horoscope String 星座
	 * @param isFbShare int FB 分享
	 * @param callback int -1 (輸入格式錯誤)
							0(失敗)
							User_id(成功)
	 */
	public void saveProfile(final int id, final String email, final String city, final String horoscope, final int isFbShare, final SaveProfileCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/saveProfile", ConstantTerm.API_PATH));
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("id", String.valueOf(id)));
					params.add(new BasicNameValuePair("email", String.valueOf(email)));
					params.add(new BasicNameValuePair("city", String.valueOf(city)));
					params.add(new BasicNameValuePair("horoscope", String.valueOf(horoscope)));
					params.add(new BasicNameValuePair("is_FB_share", String.valueOf(isFbShare)));
					httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));

					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"saveProfileThread").start();
	}
	
	/**
	 * 取得 Profile 資料 (個人資料、cover、wardrobe、wishlist、follower、tracking)
	 * @param act_user String 使用app的人
	 * @param userId String User的id
	 * @param callback UserProfileData
	 */
	public void getProfile(final String act_user, final String userId, final GetProfileCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getProfile/%s/%s", ConstantTerm.API_PATH, act_user, userId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						UserProfileData userProfile = new UserProfileData();
						userProfile.setParams(map);
						
						if (callback != null)
							callback.OnGetData(null, userProfile);
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getProfileThread").start();
	}
	
	/**
	 * 開啟/關閉 FB 發佈功能
	 * @param userId String 使用app的人
	 * @param callback int -1 (關閉 FB 發佈功能)
							1 (開啟 FB 發佈功能)
	 */
	public void enableFb(final String userId, final EnableFbCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/enableFB/%s", ConstantTerm.API_PATH, userId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"enableFbThread").start();
	}
	
	/**
	 * 保存/解除 Bookmark
	 * @param userId String 使用app的人
	 * @param coverId int Cover的id
	 * @param callback int -1 (解除Bookmark)
							1 (Bookmark)
	 */
	public void saveBookmark(final String userId, final int coverId, final SaveBookmarkCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/saveBookmark/%s/%d", ConstantTerm.API_PATH, userId, coverId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"saveBookmarkThread").start();
	}
	
	/**
	 * 取得 Profile 下 Bookmark 頁資料
	 * @param act_user String 使用app的人
	 * @param userId String User的id
	 * @param callback ConcurrentHashMap<String, List<CoverInfoData>>
	 */
	public void getBookmark(final String act_user, final String userId, final GetBookmarkCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getBookmark/%s/%s", ConstantTerm.API_PATH, act_user, userId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);	
						ConcurrentHashMap<String, List<CoverInfoData>> bookmarkMap = new ConcurrentHashMap<String, List<CoverInfoData>>();					
						
						for (String key : map.keySet()) {
							if (map.containsKey(key))
								if (map.get(key) != null) {
									List<CoverInfoData> bookmarkList = new ArrayList<CoverInfoData>();
									List<ConcurrentHashMap<String, Object>> list = (List<ConcurrentHashMap<String, Object>>) map.get(key);
									for (ConcurrentHashMap<String, Object> data : list) {
										CoverInfoData bookmarkData = new CoverInfoData();
										bookmarkData.setParams(data);
										bookmarkList.add(bookmarkData);
									}
									bookmarkMap.put(key, bookmarkList);
								}
						}
						
						if (callback != null)
							callback.OnGetData(null, bookmarkMap);
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getBookmarkThread").start();
	}
	
	/**
	 * 由 accessToken 取得 FB 好友列表
	 * @param act_user String 使用app的人
	 * @param accessToken String facebook登入後的accessToken
	 * @param callback FBFriendData
	 */
	public void getFBFriend(final String act_user, final String accessToken, final GetFbFriendCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					Log.d("getFBFriend", String.format("act_user : %s, AccessToken : %s", act_user, accessToken));
					Log.d("getFBFriend", String.format("%s/getFBFriend/%s/%s", ConstantTerm.API_PATH, act_user, accessToken));
					HttpPost httpRequest = new HttpPost(String.format("%s/getFBFriend/%s/%s", ConstantTerm.API_PATH, act_user, accessToken));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						FBFriendData fbFriendData = new FBFriendData();
						fbFriendData.setParams(map);
						
						if (callback != null)
							callback.OnGetData(null, fbFriendData);
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getTrackingThread").start();
	}
	
	/**
	 * 取得 Profile 下 Tracking 頁資料
	 * @param userId String 使用app的人
	 * @param callback TrackingData
	 */
	public void getTracking(final String userId, final GetTrackingCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getTracking/%s", ConstantTerm.API_PATH, userId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						TrackingData trackingData = new TrackingData();
						trackingData.setParams(map);
						
						if (callback != null)
							callback.OnGetData(null, trackingData);
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getTrackingThread").start();
	}
	
	/**
	 * 追蹤/解除追蹤 使用者
	 * @param userId String 使用app的人
	 * @param followByUser String 被追蹤的使用者
	 * @param callback
	 */
	public void followUser(final String userId, final String followByUser, final FollowUserCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/followUser/%s/%s", ConstantTerm.API_PATH, userId, followByUser));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 0);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 0);
				}
			}
		},"followUserThread").start();
	}
	
	/**
	 * 取得使用者 (個人資料)
	 * @param userId String 使用app的人
	 * @param callback ProfileData
	 */
	public void getOneUser(final String userId, final GetOneUserCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getOneUser/%s", ConstantTerm.API_PATH, userId));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						ProfileData profileData = new ProfileData();
						profileData.setParams(map);
						
						if (callback != null)
							callback.OnGetData(null, profileData);
					} else {
						//XXX no use?
//						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getOneUserThread").start();
	}
	
	/**
	 * 將用戶資料寫入GCM table
	 * @param params 用戶資料
	 */
	public void setGCMInfo(final List <NameValuePair> params,final SetGCMInfoCallback callback){
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost hp = new HttpPost(String.format("%s/setGCMInfo", ConstantTerm.API_PATH));
	                hp.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
	                HttpResponse hr = new DefaultHttpClient().execute(hp);
	                
	                if (hr.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(hr.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 2);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 3);
				}
			}
		},"setGCMInfoThread").start();
	}
	
	/**
	 * GCM regid綁定 User_id
	 * @param params(act_user,regid)
	 */
	public void setBindGCM(final List <NameValuePair> params,final SetBindGCMCallback callback){
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost hp = new HttpPost(String.format("%s/setBindGCM", ConstantTerm.API_PATH));
	                hp.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
	                HttpResponse hr = new DefaultHttpClient().execute(hp);
	                
	                if (hr.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(hr.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 2);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 3);
				}
			}
		},"setBindGCMThread").start();
	}
	
	/**
	 * GCM 推播計數
	 * @param params(act_user,regid)
	 */
	public void setPushCount(final List <NameValuePair> params,final SetPushCountCallback callback){
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost hp = new HttpPost(String.format("%s/setPushCount", ConstantTerm.API_PATH));
	                hp.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
	                HttpResponse hr = new DefaultHttpClient().execute(hp);
	                
	                if (hr.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(hr.getEntity());
						ConcurrentHashMap<String, Object> map = (ConcurrentHashMap<String, Object>) JsonHandler.parseJson(jsonString);
						
						if (map.containsKey("ret"))
							if (map.get("ret") != null)
								if (callback != null)
									callback.OnResult(null, Integer.valueOf(map.get("ret").toString()));
					} else {
						callback.OnResult(new Exception(), 2);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnResult(e, 3);
				}
			}
		},"setPushCountThread").start();
	}

	/**
	 * 取得 Category
	 * @param params(act_user)
	 */
	public void getCategory(final String act_user, final GetCategoryCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getCategory/%s", ConstantTerm.API_PATH, act_user));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						List<ConcurrentHashMap<String, Object>> map = (List<ConcurrentHashMap<String, Object>>) JsonHandler.parseJson(jsonString);
						
						List<CategoryData> categoryListItemData = new ArrayList<CategoryData>();
						for (ConcurrentHashMap<String, Object> data : map) {
							CategoryData cateData = new CategoryData();
							cateData.setParams(data);
							categoryListItemData.add(cateData);
						}
						if (callback != null)
							callback.OnGetData(null, categoryListItemData);
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getCategoryThread").start();
	}

	/**
	 * 取得 Brand
	 * @param params(act_user)
	 */
	public void getBrand(final String act_user, final GetBrandCallback callback) {
		new Thread(new Runnable() {
			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				try {
					HttpPost httpRequest = new HttpPost(String.format("%s/getBrand/%s", ConstantTerm.API_PATH, act_user));
					HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						String jsonString = EntityUtils.toString(httpResponse.getEntity());
						List<ConcurrentHashMap<String, Object>> map = (List<ConcurrentHashMap<String, Object>>) JsonHandler.parseJson(jsonString);
						
						List<BrandData> brandListItemData = new ArrayList<BrandData>();
						for (ConcurrentHashMap<String, Object> data : map) {
							BrandData brandData = new BrandData();
							brandData.setParams(data);
							brandListItemData.add(brandData);
						}
						if (callback != null)
							callback.OnGetData(null, brandListItemData);
					} else {
						callback.OnGetData(new Exception(), null);
					}
				} catch (Exception e) {
					if (callback != null)
						callback.OnGetData(e, null);
				}
			}
		},"getBrandThread").start();
	}
	
	/**
	 * 取Internet的圖轉為ByteArray
	 * @param src String http位置
	 * @return byte
	 */
	public byte[] getBitmapBufferFromURL(String src) {
		try {
	        URL url = new URL(src);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setDoInput(true);
	        connection.connect();
	        InputStream input = connection.getInputStream();
	        
	        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
	        int bufferSize = 1024;
	        byte[] buffer = new byte[bufferSize];
	        int len = 0;
	        while ((len = input.read(buffer)) != -1) {
	        	byteBuffer.write(buffer, 0, len);
	        }
	        
	        return byteBuffer.toByteArray();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	/**
	 * 取得Internet的圖轉為Bitmap
	 * @param src String http位置
	 * @return Bitmap
	 */
	public Bitmap getBitmapFromURL(String src) {
	    try {
	        URL url = new URL(src);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setDoInput(true);
	        connection.connect();
	        InputStream input = connection.getInputStream();
	        Bitmap myBitmap = BitmapFactory.decodeStream(input);
	        return myBitmap;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
}
