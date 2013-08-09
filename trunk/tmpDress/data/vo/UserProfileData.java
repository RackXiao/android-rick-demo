package com.otiga.dress.data.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class UserProfileData {
	public ProfileData profile;
	public List<CoverInfoData> myCover;
	public ConcurrentHashMap<String, List<CoverItemData>> wardrobe;
	public ConcurrentHashMap<String, List<CoverItemData>> wishlist;
	public FollowerData follower;
	public FollowerData tracking;
	
	public UserProfileData() {
		profile = new ProfileData();
		myCover = new ArrayList<CoverInfoData>();
		wardrobe = new ConcurrentHashMap<String, List<CoverItemData>>();
		wishlist = new ConcurrentHashMap<String, List<CoverItemData>>();
		follower = new FollowerData();
		tracking = new FollowerData();
	}
	
	@SuppressWarnings("unchecked")
	public void setParams(ConcurrentHashMap<String, Object> map) {
		String key = "";
		
		key = "profile";
		if (map.containsKey(key))
			if (map.get(key) != null) {
				ConcurrentHashMap<String, Object> data = (ConcurrentHashMap<String, Object>) map.get(key);
				profile.setParams(data);
			}
		
		key = "mycover";
		if (map.containsKey(key))
			if (map.get(key) != null) {
				ConcurrentHashMap<String, Object> mycover = (ConcurrentHashMap<String, Object>) map.get(key);
				
				key = "data";
				if (mycover.containsKey(key))
					if (mycover.get(key) != null) {
						List<ConcurrentHashMap<String, Object>> dataList = (List<ConcurrentHashMap<String, Object>>) mycover.get(key);
						
						for (ConcurrentHashMap<String, Object> data : dataList) {
							CoverInfoData coverInfoData = new CoverInfoData();
							coverInfoData.setParams(data);
							myCover.add(coverInfoData);
						}
					}
			}
		
		key = "wardrobe";
		if (map.containsKey(key))
			if (map.get(key) != null && !map.get(key).toString().equals("[]")) {
				ConcurrentHashMap<String, Object> wardrobeInfoData = (ConcurrentHashMap<String, Object>) map.get(key);
				for (String wardrobeKey : wardrobeInfoData.keySet()) {
					ConcurrentHashMap<String, Object> wardrobeCategory = (ConcurrentHashMap<String, Object>) wardrobeInfoData.get(wardrobeKey);
					
					List<CoverItemData> wardrobeList = new ArrayList<CoverItemData>();
					
					key = "data";
					if (wardrobeCategory.containsKey(key))
						if (wardrobeCategory.get(key) != null) {
							List<ConcurrentHashMap<String, Object>> listData = (List<ConcurrentHashMap<String, Object>>) wardrobeCategory.get(key);
							for (ConcurrentHashMap<String, Object> data : listData) {
								CoverItemData wardrobeData = new CoverItemData();
								wardrobeData.setParams(data);
								wardrobeList.add(wardrobeData);
							}
						}
					
					wardrobe.put(wardrobeKey, wardrobeList);
				}
			}
		
		key = "wishlist";
		if (map.containsKey(key))
			if (map.get(key) != null && !map.get(key).toString().equals("[]")) {
				ConcurrentHashMap<String, Object> wishlistInfoData = (ConcurrentHashMap<String, Object>) map.get(key);
				for (String wardrobeKey : wishlistInfoData.keySet()) {
					ConcurrentHashMap<String, Object> wishlistCategory = (ConcurrentHashMap<String, Object>) wishlistInfoData.get(wardrobeKey);
					
					List<CoverItemData> wishLists = new ArrayList<CoverItemData>();
					
					key = "data";
					if (wishlistCategory.containsKey(key))
						if (wishlistCategory.get(key) != null) {
							List<ConcurrentHashMap<String, Object>> listData = (List<ConcurrentHashMap<String, Object>>) wishlistCategory.get(key);
							for (ConcurrentHashMap<String, Object> data : listData) {
								CoverItemData wardrobeData = new CoverItemData();
								wardrobeData.setParams(data);
								wishLists.add(wardrobeData);
							}
						}
					
					wishlist.put(wardrobeKey, wishLists);
				}
			}
		
		key = "follower";
		if (map.containsKey(key))
			if (map.get(key) != null) {
				ConcurrentHashMap<String, Object> data = (ConcurrentHashMap<String, Object>) map.get(key);
				follower.setParams(data);
			}
		
		key = "tracking";
		if (map.containsKey(key))
			if (map.get(key) != null) {
				ConcurrentHashMap<String, Object> data = (ConcurrentHashMap<String, Object>) map.get(key);
				tracking.setParams(data);
			}
	}
}
