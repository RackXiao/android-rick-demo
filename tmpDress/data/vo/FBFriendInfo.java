package com.otiga.dress.data.vo;

import java.util.concurrent.ConcurrentHashMap;

public class FBFriendInfo {

	public String userId;
	public String fbId;
	public String name;
	public String fbImage;
	
	public void setParams(ConcurrentHashMap<String, Object> data) {
		String key = "";
		
		key = "User_id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				userId = data.get(key).toString();
		
		key = "FB_id";
		if (data.containsKey(key))
			if (data.get(key) != null)
				fbId = data.get(key).toString();
		
		key = "name";
		if (data.containsKey(key))
			if (data.get(key) != null)
				name = data.get(key).toString();
				
		key = "image";
		if (data.containsKey(key))
			if (data.get(key) != null)
				fbImage = data.get(key).toString();
	}
	
}
